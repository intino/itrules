---
title: "Multivalued and optional attributes"
date: 2024-07-18T15:00:00Z
draft: false
---

## Template
```
#!text
rule type(Roster)
    <roster>
      $Coach
      <players>
         $Players...[$NL]
      </players>
    </roster>

rule type(Person) trigger(Coach)
    <coach name="$Name" year="$Birthday+Year" country="$Country" />

rule type(Person)
    <player name="$Name" year="$Birthday+Year" country="$Country" [club="$Club" ]/>
```

## Code
```
#!java
import io.intino.itrules.TemplateEngine;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OptionalAttributes {

    public static final String Template = "path_to_template/OptionalAttributes.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template).render(roster());
        System.out.println(result);
    }

    private static Roster roster() {
        return new Roster(
                new Person("Juan Antonio Orenga", date(1966, Calendar.JULY, 29), "Spain"),
                new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "Spain", "L.A. Lakers"),
                new Person("Rudy Fernandez", date(1985, Calendar.APRIL, 4), "Spain"),
                new Person("Juan Carlos Navarro", date(1980, Calendar.JUNE, 17), "Spain")
        );
    }

    private static Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    public static class Roster {
        private Person coach;
        private Person[] players;

        public Roster(Person coach, Person... players) {
            this.coach = coach;
            this.players = players;
        }
    }

    public static class Person {
        private String name;
        private Date birthday;
        private String country;
        private String club;

        public Person(String name, Date birthday, String country) {
            this(name, birthday, country, null);
        }

        public Person(String name, Date birthday, String country, String club) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
            this.club = club;
        }

    }
}

```

## Output
```
#!XML
<roster>
  <coach name="Juan Antonio Orenga" year="1966" country="Spain" />
  <players>
    <player name="Pau Gasol" year="1980" country="Spain" club="L.A. Lakers" /> 
    <player name="Rudy Fernandez" year="1985" country="Spain" /> 
    <player name="Juan Carlos Navarro" year="1980" country="Spain" /> 
  </players>
</roster>
```
