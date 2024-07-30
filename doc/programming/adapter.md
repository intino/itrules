---
title: "Programming an Adapter"
date: 2024-07-18T15:00:00Z
draft: false
---

## Template ##
```
#!Dylan
def type(Person)
    $Name is from $Continent
end

```

## Code ##
```
#!java
import org.siani.itrules.Adapter;
import org.siani.itrules.TemplateEngine;
import org.siani.itrules.engine.SlotSet;

import java.util.HashMap;
import java.util.Map;

public class ProgrammingAdapter {

    public static final String Template = "path_to_template/ProgrammingAdapter.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template)
                .add(Person.class, personAdapter())
                .render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol", "Spain");
    }

    private static Adapter<Person> personAdapter() {
        return (source, context) -> SlotSet.create().add("name", context.build(source.name)).add("country", context.build(source.country)).add("continent", context.build(continentOf(source.country)));
    }

    private static String continentOf(String country) {
        Map<String, String> continents = new HashMap<>();
        continents.put("spain", "Europe");
        continents.put("italy", "Europe");
        continents.put("usa", "America");
        continents.put("canada", "America");
        return continents.get(country.toLowerCase());
    }

    public static class Person {
        private final String name;
        private final String country;

        public Person(String name, String country) {
            this.name = name;
            this.country = country;
        }

    }

}
```

## Output ##
```
#!text
Pau Gasol is from Europe
```
