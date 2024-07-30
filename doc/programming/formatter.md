---
title: "Programming a Formatter"
date: 2024-07-18T15:00:00Z
draft: false
---


## Template ##
```
#!Dylan
def type(Person)
    $Name+lowercase+reverse
end
```

## Code ##
```
import org.siani.itrules.TemplateEngine;

public class ProgrammingFormatter {

    public static final String Template = "path_to_template/ProgrammingFormatter.itr";

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
```

## Output ##
```
#!text
losag uap
```
