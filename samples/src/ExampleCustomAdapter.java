import org.siani.itrules.Adapter;
import org.siani.itrules.TemplateEngine;
import org.siani.itrules.model.Frame;

import java.util.HashMap;
import java.util.Map;

public class ExampleCustomAdapter {

    public static class Person {
        private final String name;
        private final String country;

        public Person(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public static void main(String[] args) {
            Person person = new Person("Pau Gasol", "Spain");
            TemplateEngine engine = new TemplateEngine().use("samples/templates/CustomAdapter.itr");
            engine.add(Person.class, new Adapter<Person>() {
                @Override
                public void execute(Frame frame, Person source, FrameContext context) {
                    frame.addFrame("name", context.build(source.name));
                    frame.addFrame("country", context.build(source.country));
                    frame.addFrame("continent", context.build(continentOf(source.country)));
                }

            });
            System.out.println(engine.render(person));
        }

        private static String continentOf(String country) {
            Map<String, String> continents = new HashMap<>();
            continents.put("spain", "Europe");
            continents.put("italy", "Europe");
            continents.put("usa", "America");
            continents.put("canada", "America");
            return continents.get(country.toLowerCase());
        }
    }

}