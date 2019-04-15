package io.intino.itrules;

import io.intino.itrules.cases.framebuilder.*;
import org.junit.Assert;
import org.junit.Test;
import io.intino.itrules.engine.FrameBuilder;
import io.intino.itrules.engine.SlotSet;
import io.intino.itrules.model.AbstractFrame;
import io.intino.itrules.model.Frame;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class FrameBuilder_ {

    @Test
    public void should_create_frames_of_objects_with_a_single_attribute() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new SingleAttributeObject(1));
        assertEquals(1, frame.frames("field1").next().value());
    }

    @Test
    public void should_create_frames_of_objects_with_two_attributes() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new TwoAttributesObject("test", 1.0));
        assertEquals("test", frame.frames("field1").next().value());
        assertEquals(1.0, frame.frames("field2").next().value());
    }

    @Test
    public void should_create_frames_of_objects_with_two_array_attributes() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new ObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}));

        Iterator<AbstractFrame> field1 = frame.frames("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.frames("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void should_create_frames_of_objects_with_two_lists() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new ObjectWithTwoList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0)));

        Iterator<AbstractFrame> field1 = frame.frames("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.frames("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void should_create_frames_of_objects_with_list_of_objects() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new ObjectWithList(new TwoAttributesObject("t", 1.0)));
        assertEquals("t", frame.frames("field1").next().frames("field1").next().value());
        assertEquals(1.0, frame.frames("field1").next().frames("field2").next().value());
    }

    @Test
    public void should_create_frames_of_objects_with_maps() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new ObjectWithMap().add("test1", 1.0).add("test2",2.0));
        Iterator<AbstractFrame> map = frame.frames("map");
        AbstractFrame firstItem = map.next();
        assertEquals("test1", firstItem.frames("key").next().value());
        assertEquals(1.0, firstItem.frames("value").next().value());
        AbstractFrame secondItem = map.next();
        assertEquals("test2", secondItem.frames("key").next().value());
        assertEquals(2.0, secondItem.frames("value").next().value());
    }

    @Test
    public void should_create_frames_of_objects_with_maps_of_objects() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new ObjectWithMap().add(new TwoAttributesObject("t", 1.0),new TwoAttributesObject("t2", 2.0)));
        AbstractFrame item = frame.frames("map").next();
        assertEquals("t", item.frames("key").next().frames("field1").next().value());
        assertEquals(1.0, item.frames("key").next().frames("field2").next().value());
        assertEquals("t2", item.frames("value").next().frames("field1").next().value());
        assertEquals(2.0, item.frames("value").next().frames("field2").next().value());
    }

    @Test
    public void should_create_frames_of_complex_objects() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new ComplexObject(new TwoAttributesObject("test", 1.0)));
        AbstractFrame field1 = frame.frames("field1").next();
        assertEquals("test", field1.frames("field1").next().value());
        assertEquals(1.0, field1.frames("field2").next().value());
    }

    @Test
    public void should_create_frames_of_polymorphic_objects() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new PolymorphicClass());
        Assert.assertTrue(frame.is("PolymorphicClass"));
        Assert.assertTrue(frame.is("ClassA"));
        Assert.assertTrue(frame.is("ClassB"));
        Assert.assertTrue(frame.is("Object"));
        Assert.assertTrue(frame.is("InterfaceA"));
        Assert.assertTrue(frame.is("InterfaceB"));
        Assert.assertTrue(frame.is("InterfaceC"));
    }

    @Test
    public void testExcludeMap() throws Exception {
        FrameBuilder frameBuilder = new FrameBuilder();
        Frame frame = (Frame) frameBuilder.build(new TransientAttributeObject("test", 1.0));
        assertEquals("test", frame.frames("field1").next().value());
        assertFalse(frame.frames("field2").hasNext());
    }

    @Test
    public void testRetrieveFieldsFromParentClasses() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new PolymorphicClass());
        assertEquals(0.0, frame.frames("field1").next().value());
    }

    @Test
    public void testRetrieveSameFieldsInCurrentAndParentClasses() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new PolymorphicClass());
        Iterator<AbstractFrame> field2 = frame.frames("field2");
        assertEquals(0.0, field2.next().value());
        assertEquals(1.0, field2.next().value());
    }

    @Test
    public void should_exclude_static_fields() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new SimpleObjectWithStaticField());
        assertFalse(frame.frames("staticField").hasNext());
    }

    @Test
    public void should_render_with_custom_adapter() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(TwoAttributesObject.class, (source, context) -> context.frame().addSlots(SlotSet.create().add("field1", context.build(source.getField1()))));
        Frame frame = (Frame) builder.build(new TwoAttributesObject("test", 1.0));
        assertEquals("test", frame.frames("field1").next().value());
        assertFalse(frame.frames("field2").hasNext());
    }

    @Test
    public void testAdaptersWithComplexFields() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(
                ObjectWithList.class,
                (source, context) -> context.frame().addSlots(SlotSet.create().add("object2", context.build(source.get(1)))));


        Frame frame = (Frame) builder.build(new ObjectWithList(
                new TwoAttributesObject("test1", 1.0),
                new TwoAttributesObject("test2", 2.0),
                new TwoAttributesObject("test3", 3.0)
            ));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        assertEquals("test2", next.frames("field1").next().value());
        assertEquals(2.0, next.frames("field2").next().value());
        assertFalse(frames.hasNext());
    }


    @Test
    public void should_allow_register_custom_adapters() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(ObjectWithList.class, (source, context) -> context.frame().addSlots(SlotSet.create().add("object2", context.build(source.get(1)))));
        builder.register(TwoAttributesObject.class, (source, context) -> context.frame().addSlots(SlotSet.create().add("field1", context.build(source.getField1()))));

        Frame frame = (Frame) builder.build(new ObjectWithList(
                new TwoAttributesObject("test1", 1.0),
                new TwoAttributesObject("test2", 2.0),
                new TwoAttributesObject("test3", 3.0)
            ));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        assertEquals("test2", next.frames("field1").next().value());
        assertFalse(next.frames("field2").hasNext());
        assertFalse(frames.hasNext());
    }

    @Test
    public void testAdapterWithExclusionInside() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(ObjectWithList.class, (source, context) -> context.frame().addSlots(SlotSet.create().add("object2", context.build(source.get(1)))));

        Frame frame = (Frame) builder.build(new ObjectWithList(
                new TransientAttributeObject("test1", 1.0),
                new TransientAttributeObject("test2", 2.0),
                new TransientAttributeObject("test3", 3.0)
            ));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        assertEquals("test2", next.frames("field1").next().value());
        assertFalse(next.frames("field2").hasNext());
        assertFalse(frames.hasNext());
    }


}
