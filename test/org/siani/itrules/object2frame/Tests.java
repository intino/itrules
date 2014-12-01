package org.siani.itrules.object2frame;

import org.siani.itrules.AbstractFrame;
import org.siani.itrules.Frame;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;


public class Tests {

    @org.junit.Test
    public void testPrimitiveToFrame() throws Exception {
        try {
            new Frame(1.0);
            assertFalse(true);
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void testPrimitiveObjectToFrame() throws Exception {
        AbstractFrame frame = new Frame(new PrimitiveObject(1));
        assertEquals(1, frame.getSlots("field1").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectToFrame() throws Exception {
        AbstractFrame frame = new Frame(new SimpleObject("test", 1.0));
        assertEquals("test", frame.getSlots("field1").next().value());
        assertEquals(1.0, frame.getSlots("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithArraysToFrame() throws Exception {
        AbstractFrame frame = new Frame(new SimpleObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}));

        Iterator<AbstractFrame> field1 = frame.getSlots("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getSlots("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        assertTrue(!field2.hasNext());
    }

    @org.junit.Test
    public void testSimpleObjectWithListsToFrame() throws Exception {
        AbstractFrame frame = new Frame(new SimpleObjectWithList(Arrays.asList("test1", "test2"), Arrays.asList(1.0, 2.0)));

        Iterator<AbstractFrame> field1 = frame.getSlots("field1");
        assertEquals("test1", field1.next().value());
        assertEquals("test2", field1.next().value());
        assertTrue(!field1.hasNext());

        Iterator<AbstractFrame> field2 = frame.getSlots("field2");
        assertEquals(1.0, field2.next().value());
        assertEquals(2.0, field2.next().value());
        assertTrue(!field2.hasNext());
    }

    @org.junit.Test
    public void testSimpleObjectWithComplexListsToFrame() throws Exception {
        AbstractFrame frame = new Frame(new SimpleObjectWithComplexList(Arrays.asList(new Object[]{new SimpleObject("t", 1.0)})));
        assertEquals("t", frame.getSlots("field1").next().getSlots("field1").next().value());
        assertEquals(1.0, frame.getSlots("field1").next().getSlots("field2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithMapToFrame() throws Exception {
        AbstractFrame frame = new Frame(new SimpleObjectWithMap(Arrays.asList(new Object[]{"test1", "test2"}),
                Arrays.asList(new Object[]{1.0, 2.0})));
        AbstractFrame doubleMap = frame.getSlots("map").next();
        assertEquals(1.0, doubleMap.getSlots("test1").next().value());
        assertEquals(2.0, doubleMap.getSlots("test2").next().value());
    }

    @org.junit.Test
    public void testSimpleObjectWithComplexMapToFrame() throws Exception {
        SimpleObject object = new SimpleObject("t", 1.0);
        AbstractFrame frame = new Frame(new SimpleObjectWithMap(Arrays.asList(new Object[]{object}),
                Arrays.asList(new Object[]{new SimpleObject("t", 1.0)})));
        AbstractFrame map = frame.getSlots("map").next();
        assertEquals("t", map.getSlots(object.toString()).next().getSlots("field1").next().value());
        assertEquals(1.0, map.getSlots(object.toString()).next().getSlots("field2").next().value());
    }

    @org.junit.Test
    public void testComplexObjectToFrame() throws Exception {
        AbstractFrame frame = new Frame(new ComplexObject(new SimpleObject("test", 1.0)));

        AbstractFrame field1 = frame.getSlots("field1").next();
        assertEquals("test", field1.getSlots("field1").next().value());
        assertEquals(1.0, field1.getSlots("field2").next().value());
    }

    @org.junit.Test
    public void testGetAllSuperClassesAndInterfaces() throws Exception {
        AbstractFrame frame = new Frame(new PolymorphicClass());
        assertTrue(frame.is("PolymorphicClass"));
        assertTrue(frame.is("ClassA"));
        assertTrue(frame.is("ClassB"));
        assertTrue(frame.is("Object"));
        assertTrue(frame.is("InterfaceA"));
        assertTrue(frame.is("InterfaceB"));
        assertTrue(frame.is("InterfaceC"));
    }
}
