package org.siani.itrules.object2frame;

import org.junit.Test;
import org.siani.itrules.AbstractFrame;
import org.siani.itrules.Frame;
import org.siani.itrules.framebuilder.Adapter;
import org.siani.itrules.framebuilder.BuilderContext;
import org.siani.itrules.framebuilder.FrameBuilder;

import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Tests {

    @org.junit.Test
    public void testPrimitiveToFrame() throws Exception {
        try {
            new FrameBuilder().build(1.0);
            assertFalse(true);
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void testPrimitiveObjectToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new PrimitiveObject(1));
        assertEquals(1, frame.getFrames("field1").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new SimpleObject("test", 1.0));
        assertEquals("test", frame.getFrames("field1").next().value());
        assertEquals(1.0, frame.getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithArraysToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}));

        Iterator<AbstractFrame> field1 = frame.getFrames("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        assertTrue(!field2.hasNext());
    }

    @org.junit.Test
    public void testSimpleObjectWithListsToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0)));

        Iterator<AbstractFrame> field1 = frame.getFrames("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        assertTrue(!field2.hasNext());
    }

    @org.junit.Test
    public void testSimpleObjectWithComplexListsToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(
	        new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new SimpleObject("t", 1.0)})));
        assertEquals("t", frame.getFrames("field1").next().getFrames("field1").next().value());
        assertEquals(1.0, frame.getFrames("field1").next().getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
	        Arrays.asList(new Object[]{1.0, 2.0})));
        AbstractFrame doubleMap = frame.getFrames("map").next();
        assertEquals(1.0, doubleMap.getFrames("test1").next().value());
        assertEquals(2.0, doubleMap.getFrames("test2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        SimpleObject object = new SimpleObject("t", 1.0);
        Frame frame = new FrameBuilder().build(new SimpleObjectWithMap(Arrays.asList(new Object[]{object}),
	        Arrays.asList(new Object[]{new SimpleObject("t", 1.0)})));
        AbstractFrame map = frame.getFrames("map").next();
        assertEquals("t", map.getFrames(object.toString()).next().getFrames("field1").next().value());
        assertEquals(1.0, map.getFrames(object.toString()).next().getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testComplexObjectToFrame() throws Exception {
        Frame frame = new FrameBuilder().build(new ComplexObject(new SimpleObject("test", 1.0)));

        AbstractFrame field1 = frame.getFrames("field1").next();
        assertEquals("test", field1.getFrames("field1").next().value());
        assertEquals(1.0, field1.getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
        assertTrue(frame.is("PolymorphicClass"));
        assertTrue(frame.is("ClassA"));
        assertTrue(frame.is("ClassB"));
        assertTrue(frame.is("Object"));
        assertTrue(frame.is("InterfaceA"));
        assertTrue(frame.is("InterfaceB"));
        assertTrue(frame.is("InterfaceC"));
    }

    @org.junit.Test
    public void testExcludeMap() throws Exception {
        FrameBuilder frameBuilder = new FrameBuilder();
        frameBuilder.exclude("SimpleObject", "field2");
        Frame frame = frameBuilder.build(new SimpleObject("test", 1.0));
        assertEquals("test", frame.getFrames("field1").next().value());
        assertFalse(frame.getFrames("field2").hasNext());
    }

    @Test
    public void testRetrieveFieldsFromParentClasses() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
        assertEquals(0.0, frame.getFrames("field1").next().value());
    }

    @Test
    public void testRetrieveSameFieldsInCurrentAndParentClasses() throws Exception {
        Frame frame = new FrameBuilder().build(new PolymorphicClass());
        Iterator<AbstractFrame> field2 = frame.getFrames("field2");
        assertEquals(0.0, field2.next().value());
        assertEquals(1.0, field2.next().value());
    }

    @Test
    public void testStaticFieldsShouldNotBeRendered() throws Exception {
        Frame frame = new FrameBuilder().build(new SimpleObjectWithStaticField());
        assertFalse(frame.getFrames("staticField").hasNext());
    }

	@Test
	public void testSimpleAdapter() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObject.class, new Adapter<SimpleObject>() {

			@Override
			public void adapt(Frame frame, SimpleObject object, BuilderContext context) {
				frame.addFrame("field1", object.getField1());
			}
		});
		Frame frame = builder.build(new SimpleObject("test", 1.0));
		assertEquals("test", frame.getFrames("field1").next().value());
		assertFalse(frame.getFrames("field2").hasNext());
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
			new SimpleObject("test1", 1.0),
			new SimpleObject("test2", 2.0),
			new SimpleObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		assertEquals("test2", next.getFrames("field1").next().value());
		assertEquals(2.0, next.getFrames("field2").next().value());
		assertFalse(frames.hasNext());
	}

	@Test
	public void testChainedAdapters() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void adapt(Frame frame, SimpleObjectWithComplexList object, BuilderContext context) {
					context.register(SimpleObject.class, new Adapter<SimpleObject>() {
						@Override
						public void adapt(Frame frame, SimpleObject object, BuilderContext context) {
							frame.addFrame("field1", object.getField1());
						}
					});
					frame.addFrame("object2", context.build(object.get(1)));
				}
			});
		Frame frame = builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
			new SimpleObject("test1", 1.0),
			new SimpleObject("test2", 2.0),
			new SimpleObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		assertEquals("test2", next.getFrames("field1").next().value());
		assertFalse(next.getFrames("field2").hasNext());
		assertFalse(frames.hasNext());
	}

	@Test
	public void testAdapterWithExclusionInside() throws Exception {
		FrameBuilder builder = new FrameBuilder();
		builder.register(SimpleObjectWithComplexList.class, new Adapter<SimpleObjectWithComplexList>() {
				@Override
				public void adapt(Frame frame, SimpleObjectWithComplexList object, BuilderContext context) {
					context.exclude("SimpleObject", "field2");
					frame.addFrame("object2", context.build(object.get(1)));
				}
			});
		Frame frame = builder.build(new SimpleObjectWithComplexList(Arrays.<Object>asList(
			new SimpleObject("test1", 1.0),
			new SimpleObject("test2", 2.0),
			new SimpleObject("test3", 3.0)
		)));
		Iterator<AbstractFrame> frames = frame.getFrames("object2");
		AbstractFrame next = frames.next();
		assertEquals("test2", next.getFrames("field1").next().value());
		assertFalse(next.getFrames("field2").hasNext());
		assertFalse(frames.hasNext());
	}


}
