import org.siani.itrules.TemplateEngine;

public class ExampleRecursive {
    public static void main(String[] args) {
        Module module = new Module("X",
                new Module("1",
                        new Module("1.1"),
                        new Module("1.2",
                                new Module("1.2.1"),
                                new Module("1.2.2"),
                                new Module("1.2.3")
                        ),
                        new Module("1.3"),
                        new Module("1.4")
                ),
                new Module("2",
                        new Module("2.1"),
                        new Module("2.2"),
                        new Module("2.3"),
                        new Module("2.4"),
                        new Module("2.5"),
                        new Module("2.6")

                ),
                new Module("3",
                        new Module("3.1"),
                        new Module("3.2"),
                        new Module("3.3")
                ),
                new Module("4",
                        new Module("4.1"),
                        new Module("4.2")
                ),
                new Module("5")
        );

        TemplateEngine engine = new TemplateEngine().use("samples/templates/Recursive.itr");
        System.out.println(engine.render(module));
    }

    public static class Module {
        private String name;
        private Module[] modules;

        public Module(String name, Module... modules) {
            this.name = name;
            this.modules = modules;
        }
    }

}
