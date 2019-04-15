import io.intino.itrules.TemplateEngine;

public class ProgrammingFormatter {

    public static final String Template = "samples/templates/ProgrammingFormatter.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template)
                .add("reverse", value -> new StringBuilder(value.toString()).reverse().toString())
                .render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol");
    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

    }

}