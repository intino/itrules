package io.intino.test;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.test.classes.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;


public class FrameBuilder_ {

	@Test
	public void should_create_frames_manually() {
		Frame frame = new FrameBuilder("Ship", "Vessel")
				.add("age", 5.4)
				.add("Engine",
						new FrameBuilder("Engine", "Diesel")
								.add("power", 500)
								.toFrame()
				)
				.toFrame();
		assertThat(frame.is("Ship")).isTrue();
		assertThat(frame.is("vessel")).isTrue();
		assertThat(frame.is("animal")).isFalse();
		assertThat(frame.contains("Age")).isTrue();
		assertThat(frame.contains("engine")).isTrue();
		assertThat(frame.frames("engine").hasNext()).isTrue();
		assertThat(frame.frames("engine").next().is("engine")).isTrue();
	}

	@Test
	public void should_create_frames_of_objects_with_a_single_attribute() {
		Frame frame = new FrameBuilder().add(new SingleAttributeObject(1)).toFrame();
		assertThat((frame.frames("field1").next().value())).isEqualTo(1);
	}

	@Test
	public void should_create_frames_of_objects_with_two_attributes() {
		Frame frame = new FrameBuilder().add(new TwoAttributesObject("test", 1.0)).toFrame();
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frames_of_objects_with_two_array_attributes() {
		Frame frame = new FrameBuilder().add(
				new ObjectWithArrays(
						new String[]{"test1", "test2"},
						new Double[]{1.0, 2.0})
		).toFrame();

		Iterator<Frame> field1 = frame.frames("field1");
		assertThat(field1.next().value()).isEqualTo("test1");
		assertThat(field1.next().value()).isEqualTo("test2");
		assertThat(field1.hasNext()).isFalse();

		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(1.0);
		assertThat(field2.next().value()).isEqualTo(2.0);
		assertThat(field2.hasNext()).isFalse();
	}

	@Test
	public void should_create_frames_of_objects_with_two_lists() {
		Frame frame = new FrameBuilder().add(
				new ObjectWithTwoList(
						Arrays.asList("test1", "test2"),
						Arrays.asList(1.0, 2.0))
		).toFrame();

		Iterator<Frame> field1 = frame.frames("field1");
		assertThat(field1.next().value()).isEqualTo("test1");
		assertThat(field1.next().value()).isEqualTo("test2");
		assertThat(field1.hasNext()).isFalse();

		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(1.0);
		assertThat(field2.next().value()).isEqualTo(2.0);
		assertThat(field2.hasNext()).isFalse();

	}

	@Test
	public void should_create_frames_of_objects_with_list_of_objects() {
		Frame frame = new FrameBuilder().add(
				new ObjectWithList(new TwoAttributesObject("t", 1.0))
		).toFrame();
		assertThat(frame.frames("field1").next().frames("field1").next().value()).isEqualTo("t");
		assertThat(frame.frames("field1").next().frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frames_of_objects_with_maps() {
		Frame frame = new FrameBuilder().add(
				new ObjectWithMap().add("test1", 1.0).add("test2", 2.0)
		).toFrame();
		Iterator<Frame> map = frame.frames("map");
		Frame firstItem = map.next();
		assertThat(firstItem.frames("key").next().value()).isEqualTo("test1");
		assertThat(firstItem.frames("value").next().value()).isEqualTo(1.0);
		Frame secondItem = map.next();
		assertThat(secondItem.frames("key").next().value()).isEqualTo("test2");
		assertThat(secondItem.frames("value").next().value()).isEqualTo(2.0);
	}


	@Test
	public void should_create_frames_of_objects_with_maps_of_objects() {
		Frame frame = new FrameBuilder().add(
				new ObjectWithMap().add(
						new TwoAttributesObject("t", 1.0),
						new TwoAttributesObject("t2", 2.0))
		).toFrame();
		Frame item = frame.frames("map").next();
		assertThat(item.frames("key").next().frames("field1").next().value()).isEqualTo("t");
		assertThat(item.frames("key").next().frames("field2").next().value()).isEqualTo(1.0);
		assertThat(item.frames("value").next().frames("field1").next().value()).isEqualTo("t2");
		assertThat(item.frames("value").next().frames("field2").next().value()).isEqualTo(2.0);
	}

	@Test
	public void should_create_frames_of_complex_objects() {
		Frame frame = new FrameBuilder().add(
				new ComplexObject(new TwoAttributesObject("test", 1.0))
		).toFrame();
		Frame field1 = frame.frames("field1").next();
		assertThat(field1.frames("field1").next().value()).isEqualTo("test");
		assertThat(field1.frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frames_of_polymorphic_objects() {
		Frame frame = new FrameBuilder().add(new PolymorphicClass()).toFrame();
		assertThat(frame.is("PolymorphicClass")).isTrue();
		assertThat(frame.is("ClassA")).isTrue();
		assertThat(frame.is("ClassB")).isTrue();
		assertThat(frame.is("Object")).isTrue();
		assertThat(frame.is("InterfaceA")).isTrue();
		assertThat(frame.is("InterfaceB")).isTrue();
		assertThat(frame.is("InterfaceC")).isTrue();
	}


	@Test
	public void testExcludeMap() {
		Frame frame = new FrameBuilder().add(new TransientAttributeObject("test", 1.0)).toFrame();
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").hasNext()).isFalse();
	}

	@Test
	public void testRetrieveFieldsFromParentClasses() {
		Frame frame = new FrameBuilder().add(new PolymorphicClass()).toFrame();
		assertThat(frame.frames("field1").next().value()).isEqualTo(0.0);
	}

	@Test
	public void testRetrieveSameFieldsInCurrentAndParentClasses() {
		Frame frame = new FrameBuilder()
				.add(new PolymorphicClass()).toFrame();
		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(0.0);
		assertThat(field2.next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_exclude_static_fields() {
		Frame frame = new FrameBuilder()
				.add(new SimpleObjectWithStaticField()).toFrame();
		assertThat(frame.frames("staticField").hasNext()).isFalse();
	}

	@Test
	public void should_render_with_custom_adapter() {
		Frame frame = new FrameBuilder()
				.put(TwoAttributesObject.class, (source, context) -> context.add("field1", source.getField1()))
				.add(new TwoAttributesObject("test", 1.0)).toFrame();
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").hasNext()).isFalse();
	}


	@Test
	public void testAdaptersWithComplexFields() {
		Frame frame = new FrameBuilder()
				.put(ObjectWithList.class, (source, context) -> context.add("object2", source.get(1)))
				.add(
						new ObjectWithList(
								new TwoAttributesObject("test1", 1.0),
								new TwoAttributesObject("test2", 2.0),
								new TwoAttributesObject("test3", 3.0)))
				.toFrame();
		Iterator<Frame> frames = frame.frames("object2");
		Frame next = frames.next();
		assertThat(next.frames("field1").next().value()).isEqualTo("test2");
		assertThat(next.frames("field2").next().value()).isEqualTo(2.0);
		assertThat(frames.hasNext()).isFalse();
	}


	@Test
	public void should_allow_register_custom_adapters() {
		Frame frame = new FrameBuilder()
				.put(ObjectWithList.class, (source, context) -> context.add("object2", source.get(1)))
				.put(TwoAttributesObject.class, (source, context) -> context.add("field1", source.getField1()))
				.add(
						new ObjectWithList(
								new TwoAttributesObject("test1", 1.0),
								new TwoAttributesObject("test2", 2.0),
								new TwoAttributesObject("test3", 3.0)))
				.toFrame();
		Iterator<Frame> frames = frame.frames("object2");
		Frame next = frames.next();
		assertThat(next.frames("field1").next().value()).isEqualTo("test2");
		assertThat(next.frames("field2").hasNext()).isFalse();
		assertThat(frames.hasNext()).isFalse();
	}

	@Test
	public void testAdapterWithExclusionInside() {
		Frame frame = new FrameBuilder()
				.put(ObjectWithList.class, (source, context) -> context.add("object2", source.get(1)))
				.add(new ObjectWithList(
						new TransientAttributeObject("test1", 1.0),
						new TransientAttributeObject("test2", 2.0),
						new TransientAttributeObject("test3", 3.0)))
				.toFrame();
		Iterator<Frame> frames = frame.frames("object2");
		Frame next = frames.next();
		assertThat(next.frames("field1").next().value()).isEqualTo("test2");
		assertThat(next.frames("field2").hasNext()).isFalse();
		assertThat(frames.hasNext()).isFalse();
	}


}
