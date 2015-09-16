import org.siani.itrules.Formatter;
import org.siani.itrules.TemplateEngine;

public class ExampleCustomFormatter {

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public static void main(String[] args) {
            Person person = new Person("Pau Gasol");

            TemplateEngine engine = new TemplateEngine().use("samples/templates/CustomFormatter.itr");
            engine.add("reverse", new Formatter() {
                @Override
                public Object format(Object value) {
                    return new StringBuilder(value.toString()).reverse().toString();
                }
            });
            System.out.println(engine.render(person));
        }
    }

}