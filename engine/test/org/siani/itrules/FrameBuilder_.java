package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.cases.framebuilder.*;
import org.siani.itrules.engine.FrameBuilder;
import org.siani.itrules.engine.adapters.ExcludeAdapter;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

import java.util.Arrays;
import java.util.Iterator;


public class FrameBuilder_ {

    @Test
    public void should_create_a_frame_when_building_an_object_with_a_single_attribute() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new SingleAttributeObject(1));
        Assert.assertEquals(1, frame.frames("field1").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_attributes() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.frames("field1").next().value());
        Assert.assertEquals(1.0, frame.frames("field2").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_array_attributes() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new SimpleObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}));

        Iterator<AbstractFrame> field1 = frame.frames("field1");
        Assert.assertEquals("test1", field1.next().value());
        Assert.assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.frames("field2");
        Assert.assertEquals(1.0, field2.next().value());
        Assert.assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void testSimpleObjectWithListsToFrame() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new SimpleObjectWithList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0)));

        Iterator<AbstractFrame> field1 = frame.frames("field1");
        Assert.assertEquals("test1", field1.next().value());
        Assert.assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.frames("field2");
        Assert.assertEquals(1.0, field2.next().value());
        Assert.assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void testSimpleObjectWithComplexListsToFrame() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(
                new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new TwoAttributesObject("t", 1.0)})));
        Assert.assertEquals("t", frame.frames("field1").next().frames("field1").next().value());
        Assert.assertEquals(1.0, frame.frames("field1").next().frames("field2").next().value());
    }

    @Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
                Arrays.asList(new Object[]{1.0, 2.0})));
        Iterator<AbstractFrame> map = frame.frames("map");
        AbstractFrame firstItem = map.next();
        Assert.assertEquals("test1", firstItem.frames("key").next().value());
        Assert.assertEquals(1.0, firstItem.frames("value").next().value());
        AbstractFrame secondItem = map.next();
        Assert.assertEquals("test2", secondItem.frames("key").next().value());
        Assert.assertEquals(2.0, secondItem.frames("value").next().value());
    }

    @Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        TwoAttributesObject object = new TwoAttributesObject("t", 1.0);
        Frame frame = (Frame) new FrameBuilder().build(
                new SimpleObjectWithMap(
                        Arrays.asList(new Object[]{object}),
                        Arrays.asList(new Object[]{new TwoAttributesObject("t2", 2.0)})));
        AbstractFrame item = frame.frames("map").next();
        Assert.assertEquals("t", item.frames("key").next().frames("field1").next().value());
        Assert.assertEquals(1.0, item.frames("key").next().frames("field2").next().value());
        Assert.assertEquals("t2", item.frames("value").next().frames("field1").next().value());
        Assert.assertEquals(2.0, item.frames("value").next().frames("field2").next().value());
    }

    @Test
    public void testComplexObjectToFrame() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new ComplexObject(new TwoAttributesObject("test", 1.0)));
        AbstractFrame field1 = frame.frames("field1").next();
        Assert.assertEquals("test", field1.frames("field1").next().value());
        Assert.assertEquals(1.0, field1.frames("field2").next().value());
    }

    @Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
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
        frameBuilder.register(TwoAttributesObject.class, new ExcludeAdapter<TwoAttributesObject>("field2"));
        Frame frame = (Frame) frameBuilder.build(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.frames("field1").next().value());
        Assert.assertFalse(frame.frames("field2").hasNext());
    }

    @Test
    public void testRetrieveFieldsFromParentClasses() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new PolymorphicClass());
        Assert.assertEquals(0.0, frame.frames("field1").next().value());
    }

    @Test
    public void testRetrieveSameFieldsInCurrentAndParentClasses() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new PolymorphicClass());
        Iterator<AbstractFrame> field2 = frame.frames("field2");
        Assert.assertEquals(0.0, field2.next().value());
        Assert.assertEquals(1.0, field2.next().value());
    }

    @Test
    public void testStaticFieldsShouldNotBeRendered() throws Exception {
        Frame frame = (Frame) new FrameBuilder().build(new SimpleObjectWithStaticField());
        Assert.assertFalse(frame.frames("staticField").hasNext());
    }

    @Test
    public void testSimpleAdapter() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(
                TwoAttributesObject.class,
                new Adapter<TwoAttributesObject>() {
                    @Override
                    public void execute(Frame frame, TwoAttributesObject source, FrameContext<TwoAttributesObject> context) {
                        context.frame().addFrame("field1", context.build(context.source().getField1()));
                    }
                });
        Frame frame = (Frame) builder.build(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.frames("field1").next().value());
        Assert.assertFalse(frame.frames("field2").hasNext());
    }

    @Test
    public void testAdaptersWithComplexFields() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(
                SimpleObjectWithComplexList.class,
                new Adapter<SimpleObjectWithComplexList>() {
                    @Override
                    public void execute(Frame frame, SimpleObjectWithComplexList source, FrameContext<SimpleObjectWithComplexList> context) {
                        context.frame().addFrame("object2", context.build(context.source().get(1)));
                    }
                });


        Frame frame = (Frame) builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
                new TwoAttributesObject("test1", 1.0),
                new TwoAttributesObject("test2", 2.0),
                new TwoAttributesObject("test3", 3.0)
        )));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        Assert.assertEquals("test2", next.frames("field1").next().value());
        Assert.assertEquals(2.0, next.frames("field2").next().value());
        Assert.assertFalse(frames.hasNext());
    }

    @Test
    public void testChainedAdapters() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(
                SimpleObjectWithComplexList.class,
                new Adapter<SimpleObjectWithComplexList>() {
                    @Override
                    public void execute(Frame frame, SimpleObjectWithComplexList source, FrameContext<SimpleObjectWithComplexList> context) {
                        context.register(TwoAttributesObject.class, new Adapter<TwoAttributesObject>() {
                            @Override
                            public void execute(Frame frame, TwoAttributesObject source, FrameContext<TwoAttributesObject> context) {
                                context.frame().addFrame("field1", context.build(context.source().getField1()));
                            }
                        });
                        context.frame().addFrame("object2", context.build(context.source().get(1)));
                    }
                });

        Frame frame = (Frame) builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
                new TwoAttributesObject("test1", 1.0),
                new TwoAttributesObject("test2", 2.0),
                new TwoAttributesObject("test3", 3.0)
        )));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        Assert.assertEquals("test2", next.frames("field1").next().value());
        Assert.assertFalse(next.frames("field2").hasNext());
        Assert.assertFalse(frames.hasNext());
    }

    @Test
    public void testAdapterWithExclusionInside() throws Exception {
        FrameBuilder builder = new FrameBuilder();
        builder.register(
                SimpleObjectWithComplexList.class,
                new Adapter<SimpleObjectWithComplexList>() {
                    @Override
                    public void execute(Frame frame, SimpleObjectWithComplexList source, FrameContext<SimpleObjectWithComplexList> context) {
                        context.register(TwoAttributesObject.class, new ExcludeAdapter<TwoAttributesObject>("field2"));
                        context.frame().addFrame("object2", context.build(context.source().get(1)));
                    }
                });
        Frame frame = (Frame) builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
                new TwoAttributesObject("test1", 1.0),
                new TwoAttributesObject("test2", 2.0),
                new TwoAttributesObject("test3", 3.0)
        )));
        Iterator<AbstractFrame> frames = frame.frames("object2");
        AbstractFrame next = frames.next();
        Assert.assertEquals("test2", next.frames("field1").next().value());
        Assert.assertFalse(next.frames("field2").hasNext());
        Assert.assertFalse(frames.hasNext());
    }


}
