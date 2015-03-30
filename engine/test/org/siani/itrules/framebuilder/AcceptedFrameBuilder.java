package org.siani.itrules.framebuilder;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.cases.object2frame.*;
import org.siani.itrules.engine.FrameBuilder;
import org.siani.itrules.engine.framebuilder.Adapter;
import org.siani.itrules.engine.framebuilder.BuilderContext;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

import java.util.Arrays;
import java.util.Iterator;


public class AcceptedFrameBuilder {

    @Test
    public void should_throw_an_exception_with() throws Exception {
        try {
            new FrameBuilder().build(1.0);
            Assert.assertFalse(true);
        } catch (RuntimeException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_a_single_attribute() throws Exception {
        Frame frame = new FrameBuilder().build(new SingleAttributeObject(1));
        Assert.assertEquals(1, frame.getFrames("field1").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_attributes() throws Exception {
        Frame frame = new FrameBuilder().build(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.getFrames("field1").next().value());
        Assert.assertEquals(1.0, frame.getFrames("field2").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_array_attributes() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}));

        Iterator<AbstractFrame> field1 = frame.getFrames("field1");
        Assert.assertEquals("test1", field1.next().value());
        Assert.assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        Assert.assertEquals(1.0, field2.next().value());
        Assert.assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void testSimpleObjectWithListsToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0)));

        Iterator<AbstractFrame> field1 = frame.getFrames("field1");
        Assert.assertEquals("test1", field1.next().value());
        Assert.assertEquals("test2", field1.next().value());
        Assert.assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        Assert.assertEquals(1.0, field2.next().value());
        Assert.assertEquals(2.0, field2.next().value());
        Assert.assertTrue(!field2.hasNext());
    }

    @Test
    public void testSimpleObjectWithComplexListsToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new TwoAttributesObject("t", 1.0)})));
        Assert.assertEquals("t", frame.getFrames("field1").next().getFrames("field1").next().value());
        Assert.assertEquals(1.0, frame.getFrames("field1").next().getFrames("field2").next().value());
    }

    @Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
	        Arrays.asList(new Object[]{1.0, 2.0})));
        AbstractFrame doubleMap = frame.getFrames("map").next();
        Assert.assertEquals(1.0, doubleMap.getFrames("test1").next().value());
        Assert.assertEquals(2.0, doubleMap.getFrames("test2").next().value());
    }

    @Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        TwoAttributesObject object = new TwoAttributesObject("t", 1.0);
        Frame frame = new FrameBuilder().build(new SimpleObjectWithMap(Arrays.asList(new Object[]{object}),
	        Arrays.asList(new Object[]{new TwoAttributesObject("t", 1.0)})));
        AbstractFrame map = frame.getFrames("map").next();
        Assert.assertEquals("t", map.getFrames(object.toString()).next().getFrames("field1").next().value());
        Assert.assertEquals(1.0, map.getFrames(object.toString()).next().getFrames("field2").next().value());
    }

    @Test
    public void testComplexObjectToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new ComplexObject(new TwoAttributesObject("test", 1.0)));

        AbstractFrame field1 = frame.getFrames("field1").next();
        Assert.assertEquals("test", field1.getFrames("field1").next().value());
        Assert.assertEquals(1.0, field1.getFrames("field2").next().value());
    }

    @Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
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
        frameBuilder.exclude("TwoAttributesObject", "field2");
        Frame frame = frameBuilder.build(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.getFrames("field1").next().value());
        Assert.assertFalse(frame.getFrames("field2").hasNext());
    }

    @Test
    public void testRetrieveFieldsFromParentClasses() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
        Assert.assertEquals(0.0, frame.getFrames("field1").next().value());
    }

    @Test
    public void testRetrieveSameFieldsInCurrentAndParentClasses() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        Assert.assertEquals(0.0, field2.next().value());
        Assert.assertEquals(1.0, field2.next().value());
    }

    @Test
    public void testStaticFieldsShouldNotBeRendered() throws Exception {
        Frame frame = new FrameBuilder().build(new SimpleObjectWithStaticField());
        Assert.assertFalse(frame.getFrames("staticField").hasNext());
    }

	@Test
	public void testSimpleAdapter() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(TwoAttributesObject.class, new Adapter<TwoAttributesObject>() {

			@Override
			public void adapt(Frame frame, TwoAttributesObject object, BuilderContext context) {
				frame.addFrame("field1", object.getField1());
			}
		});
		Frame frame = builder.build(new TwoAttributesObject("test", 1.0));
		Assert.assertEquals("test", frame.getFrames("field1").next().value());
		Assert.assertFalse(frame.getFrames("field2").hasNext());
	}

	@Test
	public void testAdaptersWithComplexFields() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void adapt(Frame frame, SimpleObjectWithComplexList object, BuilderContext context) {
					frame.addFrame("object2", context.build(object.get(1)));
				}
			});
		Frame frame = builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
			new TwoAttributesObject("test1", 1.0),
			new TwoAttributesObject("test2", 2.0),
			new TwoAttributesObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		Assert.assertEquals("test2", next.getFrames("field1").next().value());
		Assert.assertEquals(2.0, next.getFrames("field2").next().value());
		Assert.assertFalse(frames.hasNext());
	}

	@Test
	public void testChainedAdapters() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void adapt(Frame frame, SimpleObjectWithComplexList object, BuilderContext context) {
					context.register(TwoAttributesObject.class, new Adapter<TwoAttributesObject>() {
						@Override
						public void adapt(Frame frame, TwoAttributesObject object, BuilderContext context) {
							frame.addFrame("field1", object.getField1());
						}
					});
					frame.addFrame("object2", context.build(object.get(1)));
				}
			});
		Frame frame = builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
			new TwoAttributesObject("test1", 1.0),
			new TwoAttributesObject("test2", 2.0),
			new TwoAttributesObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		Assert.assertEquals("test2", next.getFrames("field1").next().value());
		Assert.assertFalse(next.getFrames("field2").hasNext());
		Assert.assertFalse(frames.hasNext());
	}

	@Test
	public void testAdapterWithExclusionInside() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void adapt(Frame frame, SimpleObjectWithComplexList object, BuilderContext context) {
					context.exclude("TwoAttributesObject", "field2");
					frame.addFrame("object2", context.build(object.get(1)));
				}
			});
		Frame frame = builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
			new TwoAttributesObject("test1", 1.0),
			new TwoAttributesObject("test2", 2.0),
			new TwoAttributesObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		Assert.assertEquals("test2", next.getFrames("field1").next().value());
		Assert.assertFalse(next.getFrames("field2").hasNext());
		Assert.assertFalse(frames.hasNext());
	}


}
