package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.engine.functions.TypeFunction;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.marks.Mark;

import static org.hamcrest.CoreMatchers.is;

public class AcceptedTypeFunction {

    @Test
    public void should_check_types_in_frame() throws Exception {
        TypeFunction function = new TypeFunction();
        Assert.assertThat("Matching a single type exists", function.match(trigger(), "Y"), is(true));
        Assert.assertThat("Matching a single type does not exist", function.match(trigger(), "T"), is(false));
        Assert.assertThat("Matching all types without spaces exists", function.match(trigger(), "X&Y&Z"), is(true));
        Assert.assertThat("Matching all types with blank spaces exists", function.match(trigger(), "X & Y & Z"), is(true));
        Assert.assertThat("Matching all types with blank spaces does not exist", function.match(trigger(), "X & Y & T"), is(false));
        Assert.assertThat("Matching any type exists", function.match(trigger(), "A|Y|T"), is(true));
        Assert.assertThat("Matching any type with blank spaces exists", function.match(trigger(), "A | Y | T"), is(true));
        Assert.assertThat("Matching any type does not exist", function.match(trigger(), "A|S|T"), is(false));
        Assert.assertThat("Matching any type with blank spaces does not exist", function.match(trigger(), "A | S | T"), is(false));

    }

    private Trigger trigger() {
        Frame frame = new Frame();
        frame.addTypes("X", "Y", "Z");
        return new Trigger(frame, new Mark("f"));
    }
}
