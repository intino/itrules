package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.engine.functions.SlotFunction;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.marks.Mark;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SlotFunction_ {

    @Test
    public void should_check_exists_slot_in_frame() throws Exception {
        SlotFunction function = new SlotFunction();
        assertThat("Matching a single slot exists", function.match(trigger(), "Y"), is(true));
        assertThat("Matching a single slot does not exist", function.match(trigger(), "T"), is(false));
        assertThat("Matching all slots without blank spaces exists", function.match(trigger(), "X&Y&Z"), is(true));
        assertThat("Matching all slots with blank spaces exists", function.match(trigger(), "X & Y & Z"), is(true));
        assertThat("Matching all slots with blank spaces does not exist", function.match(trigger(), "X & Y & T"), is(false));
        assertThat("Matching any slot exists", function.match(trigger(), "A|Y|T"), is(true));
        assertThat("Matching any slot with blank spaces exists", function.match(trigger(), "A | Y | T"), is(true));
        assertThat("Matching any slot does not exist", function.match(trigger(), "A|S|T"), is(false));
        assertThat("Matching any slot with blank spaces does not exist", function.match(trigger(), "A | S | T"), is(false));
    }

    @Test
    public void should_check_slot_has_value_in_frame() throws Exception {
        SlotFunction function = new SlotFunction();
        assertThat("Matching a single slot has value", function.match(trigger(), "Y:b"), is(true));
        assertThat("Matching a single slot has value", function.match(trigger(), "Y:a"), is(false));
        assertThat("Matching all slots without blank spaces exists", function.match(trigger(), "X:a&Y:b&Z:c"), is(true));
        assertThat("Matching all slots with blank spaces exists", function.match(trigger(), "X:a & Y:b & Z:c"), is(true));
        assertThat("Matching all slots with blank spaces does not exist", function.match(trigger(), "X:a & Y:b & T:1"), is(false));
        assertThat("Matching any slot exists", function.match(trigger(), "A:1|Y:b|T:2"), is(true));
        assertThat("Matching any slot with blank spaces exists", function.match(trigger(), "A:1 | Y:b | T:2"), is(true));
        assertThat("Matching any slot does not exist", function.match(trigger(), "A:1|S:2|T:3"), is(false));
        assertThat("Matching any slot with blank spaces does not exist", function.match(trigger(), "A:1 | S:2 | T:3"), is(false));
    }


    private Trigger trigger() {
        Frame frame = new Frame().addSlot("X","a").addSlot("Y","b").addSlot("Z","c");
        return new Trigger(frame, new Mark("f"));
    }
}
