package org.siani.itrules.object2frame;

public class PolymorphicProvider {

    private interface InterfaceA {
    }

    interface InterfaceB extends InterfaceA {
    }

    public interface InterfaceC {
    }

    public static class ClassA {
    }

    public static class ClassB extends ClassA {
    }

}
