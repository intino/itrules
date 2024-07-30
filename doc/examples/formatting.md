---
title: "Formatting data"
date: 2024-07-18T15:00:00Z
draft: false
---

itrules provides many data formatters. Have a look on the full list of [formatters](../reference#formatters)
## Template ##
```
#!Dylan
rule type(Person)
    Name: $Name+Uppercase
    BirthYear: $Birthday+Year

    Height: $Height ($Height+Words) cm
    Salary: $$$Salary+Separators

```

## Code ##
```
#!java
import io.intino.itrules.TemplateEngine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Formatting {

    public static final String Template = "path_to_template/Formatting.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template).render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), 213, 19285850);
    }

    private static Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    public static class Person {
        private String name;
        private Date birthday;
        private int height;
        private Double salary;

        public Person(String name, Date birthday, int height, double salary) {
            this.name = name;
            this.birthday = birthday;
            this.height = height;
            this.salary = salary;
        }
    }
    
}
```

## Output ##
```
#!text
Name: PAU GASOL
BirthYear: 1990

Height: 213 (two hundred and thirteen) cm
Salary: $19,285,850
```
