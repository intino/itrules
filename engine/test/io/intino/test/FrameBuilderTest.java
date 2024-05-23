/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.test;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.test.classes.*;
import org.junit.Test;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


public class FrameBuilderTest {

	@Test
	public void should_create_frame_with_empty_strings() {
		Frame frame = new FrameBuilder("t")
				.add("s", "")
				.add("s", "")
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(78690808);
		assertThat(frame.contains("s")).isTrue();
		assertThat(frame.frames("s").hasNext()).isTrue();
		assertThat(frame.frames("s").next().value()).isEqualTo("");
	}

	@Test
	public void should_create_frame_from_object_with_a_single_attribute() {
		Frame frame = new FrameBuilder()
				.append(new SingleAttributeObject(1))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(166005152);
		assertThat((frame.frames("field1").next().value())).isEqualTo(1);
	}

	@Test
	public void should_create_frame_from_object_with_two_attributes() {
		Frame frame = new FrameBuilder()
				.append(new TwoAttributesObject("test", 1.0))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1703147686);
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frame_from_object_with_list_attribute() {
		Frame frame = new FrameBuilder().append(
				new ObjectWithList(new TwoAttributesObject("t", 1.0))
		).toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1480727744);
		assertThat(frame.frames("field1").next().frames("field1").next().value()).isEqualTo("t");
		assertThat(frame.frames("field1").next().frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frame_from_object_with_two_array_attributes() {
		Frame frame = new FrameBuilder()
				.append(new ObjectWithArrays(new String[]{"test1", "test2"}, new Double[]{1.0, 2.0}))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1054753488);

		Iterator<Frame> field1 = frame.frames("field1");
		assertThat(field1.next().value()).isEqualTo("test1");
		assertThat(field1.next().value()).isEqualTo("test2");
		assertThat(field1.hasNext()).isFalse();
		assertThat(frame.frames("field1").next().hashCode()).isEqualTo(-1769157102);

		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(1.0);
		assertThat(field2.next().value()).isEqualTo(2.0);
		assertThat(field2.hasNext()).isFalse();
		assertThat(frame.frames("field2").next().hashCode()).isEqualTo(1862761425);
	}

	@Test
	public void should_create_frame_from_object_with_two_lists() {
		Frame frame = new FrameBuilder()
				.append(new ObjectWithTwoList(asList("test1", "test2"), asList(1.0, 2.0)))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(658667891);

		Iterator<Frame> field1 = frame.frames("field1");
		assertThat(field1.next().value()).isEqualTo("test1");
		assertThat(field1.next().value()).isEqualTo("test2");
		assertThat(field1.hasNext()).isFalse();
		assertThat(frame.frames("field1").next().hashCode()).isEqualTo(-1769157102);

		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(1.0);
		assertThat(field2.next().value()).isEqualTo(2.0);
		assertThat(field2.hasNext()).isFalse();

	}

	@Test
	public void should_create_frame_from_object_with_maps() {
		Frame frame = new FrameBuilder()
				.append(new ObjectWithMap().add("test1", 1.0).add("test2", 2.0))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1533117955);
		Iterator<Frame> map = frame.frames("map");
		Frame firstItem = map.next();
		//assertThat(firstItem.hashCode()).isEqualTo(1398242329);
		assertThat(firstItem.frames("key").next().value()).isEqualTo("test1");
		assertThat(firstItem.frames("value").next().value()).isEqualTo(1.0);
		Frame secondItem = map.next();
		//assertThat(secondItem.hashCode()).isEqualTo(1406368917);
		assertThat(secondItem.frames("key").next().value()).isEqualTo("test2");
		assertThat(secondItem.frames("value").next().value()).isEqualTo(2.0);
	}

	@Test
	public void should_create_frame_from_object_with_maps_of_objects() {
		Frame frame = new FrameBuilder()
				.append(new ObjectWithMap().add(
						new TwoAttributesObject("t", 1.0),
						new TwoAttributesObject("t2", 2.0)))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(9459889);
		Frame item = frame.frames("map").next();
		//assertThat(item.hashCode()).isEqualTo(705383778);
		assertThat(item.frames("key").next().frames("field1").next().value()).isEqualTo("t");
		assertThat(item.frames("key").next().frames("field2").next().value()).isEqualTo(1.0);
		assertThat(item.frames("value").next().frames("field1").next().value()).isEqualTo("t2");
		assertThat(item.frames("value").next().frames("field2").next().value()).isEqualTo(2.0);
	}

	@Test
	public void should_create_frame_from_complex_object() {
		Frame frame = new FrameBuilder()
				.append(new ComplexObject(new TwoAttributesObject("test", 1.0)))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1281169440);
		Frame field1 = frame.frames("field1").next();
		//assertThat(field1.hashCode()).isEqualTo(1703147686);
		assertThat(field1.frames("field1").next().value()).isEqualTo("test");
		assertThat(field1.frames("field2").next().value()).isEqualTo(1.0);
	}

	@Test
	public void should_create_frame_from_polymorphic_object() {
		Frame frame = new FrameBuilder()
				.append(new PolymorphicClass())
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1989487528);
		assertThat(frame.is("PolymorphicClass".toLowerCase())).isTrue();
		assertThat(frame.is("ClassA".toLowerCase())).isTrue();
		assertThat(frame.is("ClassB".toLowerCase())).isTrue();
		assertThat(frame.is("Object".toLowerCase())).isTrue();
		assertThat(frame.is("InterfaceA".toLowerCase())).isTrue();
		assertThat(frame.is("InterfaceB".toLowerCase())).isTrue();
		assertThat(frame.is("InterfaceC".toLowerCase())).isTrue();
		assertThat(frame.frames("field1").next().value()).isEqualTo(0.0);

		Iterator<Frame> field2 = frame.frames("field2");
		assertThat(field2.next().value()).isEqualTo(0.0);
		assertThat(field2.next().value()).isEqualTo(1.0);

	}

	@Test
	public void should_create_frame_excluding_transient_field() {
		Frame frame = new FrameBuilder()
				.append(new TransientAttributeObject("test", 1.0))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1770942643);
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").hasNext()).isFalse();
	}

	@Test
	public void should_create_frame_excluding_static_field() {
		Frame frame = new FrameBuilder()
				.append(new SimpleObjectWithStaticField()).toFrame();
		//assertThat(frame.hashCode()).isEqualTo(-720662592);
		assertThat(frame.frames("staticField").hasNext()).isFalse();
	}

	@Test
	public void should_create_frame_with_custom_adapter() {
		Frame frame = new FrameBuilder()
				.put(TwoAttributesObject.class, (source, context) -> context.add("field1", source.getField1()))
				.append(new TwoAttributesObject("test", 1.0)).toFrame();
		//assertThat(frame.hashCode()).isEqualTo(2033389792);
		assertThat(frame.frames("field1").next().value()).isEqualTo("test");
		assertThat(frame.frames("field2").hasNext()).isFalse();
	}

	@Test
	public void should_create_frame_with_custom_adapter_on_complex_object() {
		Frame frame = new FrameBuilder()
				.put(ObjectWithList.class, (source, context) -> context.add("object2", source.get(1)))
				.append(new ObjectWithList(
						new TransientAttributeObject("test1", 1.0),
						new TransientAttributeObject("test2", 2.0),
						new TransientAttributeObject("test3", 3.0)))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1440989545);
		Iterator<Frame> frames = frame.frames("object2");
		Frame next = frames.next();
		assertThat(next.frames("field1").next().value()).isEqualTo("test2");
		assertThat(next.frames("field2").hasNext()).isFalse();
		assertThat(frames.hasNext()).isFalse();
	}

	@Test
	public void should_create_frame_with_custom_several_adapters() {
		Frame frame = new FrameBuilder()
				.put(ObjectWithList.class, (source, context) -> context.add("object2", source.get(1)))
				.put(TwoAttributesObject.class, (source, context) -> context.add("field1", source.getField1()))
				.append(
						new ObjectWithList(
								new TwoAttributesObject("test1", 1.0),
								new TwoAttributesObject("test2", 2.0),
								new TwoAttributesObject("test3", 3.0)))
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(1506601332);
		Iterator<Frame> frames = frame.frames("object2");
		Frame next = frames.next();
		assertThat(next.frames("field1").next().value()).isEqualTo("test2");
		assertThat(next.frames("field2").hasNext()).isFalse();
		assertThat(frames.hasNext()).isFalse();
	}

	@Test
	public void should_create_frame_adding_manually_slots() {
		Frame frame = new FrameBuilder("TypeA", "TypeB")
				.add("simple", 5.4)
				.add("array", new String[]{"A", "B"})
				.add("composite",
						new FrameBuilder("SubtypeA", "SubtypeB")
								.add("power", 500)
								.toFrame()
				)
				.toFrame();
		//assertThat(frame.hashCode()).isEqualTo(334346729);
		assertThat(frame.is("TypeA".toLowerCase())).isTrue();
		assertThat(frame.is("typeB".toLowerCase())).isTrue();
		assertThat(frame.contains("simple".toLowerCase())).isTrue();
		Iterator<Frame> array = frame.frames("array");
		assertThat(array.next().value()).isEqualTo("A");
		assertThat(array.next().value()).isEqualTo("B");
		assertThat(array.hasNext()).isFalse();

		assertThat(frame.contains("composite")).isTrue();
		Iterator<Frame> composite = frame.frames("composite");
		assertThat(composite.hasNext()).isTrue();
		assertThat(composite.next().is("subtypeA".toLowerCase())).isTrue();
		assertThat(composite.hasNext()).isFalse();

		assertThat(frame.is("not_exists")).isFalse();
	}
}
