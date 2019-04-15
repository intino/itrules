package io.intino.itrules.model.marks;

public class DelegateMark extends AbstractMark {

    protected final AbstractMark mark;

    public DelegateMark(AbstractMark mark) {
        this.mark = mark;
    }

    @Override
    public String fullName() {
        return mark.fullName();
    }

    @Override
    public String name() {
        return mark.name();
    }

    @Override
    public String separator() {
        return mark.separator();
    }

    @Override
    public boolean isMultiple() {
        return mark.isMultiple();
    }

    @Override
    public String[] options() {
        return mark.options();
    }

    @Override
    public String indentation() {
        return mark.indentation();
    }

}
