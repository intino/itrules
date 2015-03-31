package org.siani.itrules.framebuilder.engine;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.cases.object2frame.*;
import org.siani.itrules.engine.FrameBuilder;
import org.siani.itrules.engine.framebuilder.AdapterContext;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

import java.util.Arrays;
import java.util.Iterator;


public class AcceptedFrameBuilder {

    @Test
    public void should_throw_an_exception_with() throws Exception {
        try {
            new FrameBuilder().execute(1.0);
            Assert.assertFalse(true);
        } catch (RuntimeException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_a_single_attribute() throws Exception {
        Frame frame = new FrameBuilder().execute(new SingleAttributeObject(1));
        Assert.assertEquals(1, frame.frames("field1").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_attributes() throws Exception {
        Frame frame = new FrameBuilder().execute(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.frames("field1").next().value());
        Assert.assertEquals(1.0, frame.frames("field2").next().value());
    }

    @Test
    public void should_create_a_frame_when_building_an_object_with_two_array_attributes() throws Exception {
        Frame frame = new FrameBuilder().execute(
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
        Frame frame = new FrameBuilder().execute(
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
        Frame frame = new FrameBuilder().execute(
                new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new TwoAttributesObject("t", 1.0)})));
        Assert.assertEquals("t", frame.frames("field1").next().frames("field1").next().value());
        Assert.assertEquals(1.0, frame.frames("field1").next().frames("field2").next().value());
    }

    @Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        Frame frame = new FrameBuilder().execute(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
                Arrays.asList(new Object[]{1.0, 2.0})));
        AbstractFrame doubleMap = frame.frames("map").next();
        Assert.assertEquals(1.0, doubleMap.frames("test1").next().value());
        Assert.assertEquals(2.0, doubleMap.frames("test2").next().value());
    }

    @Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        TwoAttributesObject object = new TwoAttributesObject("t", 1.0);
        Frame frame = new FrameBuilder().execute(new SimpleObjectWithMap(Arrays.asList(new Object[]{object}),
                Arrays.asList(new Object[]{new TwoAttributesObject("t", 1.0)})));
        AbstractFrame map = frame.frames("map").next();
        Assert.assertEquals("t", map.frames(object.toString()).next().frames("field1").next().value());
        Assert.assertEquals(1.0, map.frames(object.toString()).next().frames("field2").next().value());
    }

    @Test
    public void testComplexObjectToFrame() throws Exception {
        Frame frame = new FrameBuilder().execute(new ComplexObject(new TwoAttributesObject("test", 1.0)));

        AbstractFrame field1 = frame.frames("field1").next();
        Assert.assertEquals("test", field1.frames("field1").next().value());
        Assert.assertEquals(1.0, field1.frames("field2").next().value());
    }

    @Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
        Frame frame = new FrameBuilder().execute(new PolymorphicClass());
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
        Frame frame = frameBuilder.execute(new TwoAttributesObject("test", 1.0));
        Assert.assertEquals("test", frame.frames("field1").next().value());
        Assert.assertFalse(frame.frames("field2").hasNext());
    }

    @Test
    public void testRetrieveFieldsFromParentClasses() throws Exception {
        Frame frame = new FrameBuilder().execute(new PolymorphicClass());
        Assert.assertEquals(0.0, frame.frames("field1").next().value());
    }

    @Test
    public void testRetrieveSameFieldsInCurrentAndParentClasses() throws Exception {
        Frame frame = new FrameBuilder().execute(new PolymorphicClass());
        Iterator<AbstractFrame> field2 = frame.frames("field2");
        Assert.assertEquals(0.0, field2.next().value());
        Assert.assertEquals(1.0, field2.next().value());
    }

    @Test
    public void testStaticFieldsShouldNotBeRendered() throws Exception {
        Frame frame = new FrameBuilder().execute(new SimpleObjectWithStaticField());
        Assert.assertFalse(frame.frames("staticField").hasNext());
    }

	@Test
	public void testSimpleAdapter() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(TwoAttributesObject.class, new FrameBuilder.Adapter<TwoAttributesObject>() {

			@Override
			public void execute(Frame frame, TwoAttributesObject object, AdapterContext context) {
				frame.addFrame("field1", object.getField1());
                context.build(object.X);
			}
		});
		Frame frame = builder.execute(new TwoAttributesObject("test", 1.0));
		Assert.assertEquals("test", frame.frames("field1").next().value());
		Assert.assertFalse(frame.frames("field2").hasNext());
	}

	@Test
	public void testAdaptersWithComplexFields() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new FrameBuilder.Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void execute(Frame frame, SimpleObjectWithComplexList object, AdapterContext context) {
					frame.addFrame("object2", context.execute(object.get(1)));
				}
			});
		Frame frame = builder.execute(new SimpleObjectWithComplexList(Arrays.<Object>asList(
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
		builder.register(SimpleObjectWithComplexList.class, new FrameBuilder.Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void execute(Frame frame, SimpleObjectWithComplexList object, AdapterContext context) {
					context.register(TwoAttributesObject.class, new FrameBuilder.Adapter<TwoAttributesObject>() {
						@Override
						public void execute(Frame frame, TwoAttributesObject object, AdapterContext context) {
							frame.addFrame("field1", object.getField1());
						}
					});
					frame.addFrame("object2", context.execute(object.get(1)));
				}
			});
		Frame frame = builder.execute(new SimpleObjectWithComplexList(Arrays.<Object>asList(
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
		builder.register(SimpleObjectWithComplexList.class, new FrameBuilder.Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void execute(Frame frame, SimpleObjectWithComplexList object, AdapterContext context) {
					context.exclude("TwoAttributesObject", "field2");
					frame.addFrame("object2", context.execute(object.get(1)));
				}
			});
		Frame frame = builder.execute(new SimpleObjectWithComplexList(Arrays.<Object>asList(
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
