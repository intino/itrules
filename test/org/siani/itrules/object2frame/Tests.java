package org.siani.itrules.object2frame;

import org.siani.itrules.AbstractFrame;
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
            new FrameBuilder(1.0).build();
            assertFalse(true);
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void testPrimitiveObjectToFrame() throws Exception {
        AbstractFrame frame = new FrameBuilder(new PrimitiveObject(1)).build();
        assertEquals(1, frame.getFrames("field1").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectToFrame() throws Exception {
        AbstractFrame frame = new FrameBuilder(new SimpleObject("test", 1.0)).build();
        assertEquals("test", frame.getFrames("field1").next().value());
        assertEquals(1.0, frame.getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithArraysToFrame() throws Exception {
        AbstractFrame frame = new FrameBuilder(
                new SimpleObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0})).build();

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
        AbstractFrame frame = new FrameBuilder(
                new SimpleObjectWithList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0))).build();

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
        AbstractFrame frame = new FrameBuilder(
                new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new SimpleObject("t", 1.0)}))).build();
        assertEquals("t", frame.getFrames("field1").next().getFrames("field1").next().value());
        assertEquals(1.0, frame.getFrames("field1").next().getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        AbstractFrame frame = new FrameBuilder(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
                Arrays.asList(new Object[]{1.0, 2.0}))).build();
        AbstractFrame doubleMap = frame.getFrames("map").next();
        assertEquals(1.0, doubleMap.getFrames("test1").next().value());
        assertEquals(2.0, doubleMap.getFrames("test2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        SimpleObject object = new SimpleObject("t", 1.0);
        AbstractFrame frame = new FrameBuilder(new SimpleObjectWithMap(Arrays.asList(new Object[]{object}),
                Arrays.asList(new Object[]{new SimpleObject("t", 1.0)}))).build();
        AbstractFrame map = frame.getFrames("map").next();
        assertEquals("t", map.getFrames(object.toString()).next().getFrames("field1").next().value());
        assertEquals(1.0, map.getFrames(object.toString()).next().getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testComplexObjectToFrame() throws Exception {
        AbstractFrame frame = new FrameBuilder(new ComplexObject(new SimpleObject("test", 1.0))).build();

        AbstractFrame field1 = frame.getFrames("field1").next();
        assertEquals("test", field1.getFrames("field1").next().value());
        assertEquals(1.0, field1.getFrames("field2").next().value());
    }

    @org.junit.Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
        AbstractFrame frame = new FrameBuilder(new PolymorphicClass()).build();
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
        FrameBuilder frameBuilder = new FrameBuilder(new SimpleObject("test", 1.0));
        frameBuilder.exclude("SimpleObject", "field2");
        AbstractFrame frame = frameBuilder.build();
        assertEquals("test", frame.getFrames("field1").next().value());
        assertFalse(frame.getFrames("field2").hasNext());
    }
}
