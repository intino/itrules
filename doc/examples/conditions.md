---
title: "Conditions on triggers and attributes"
date: 2024-07-18T15:00:00Z
draft: false
---

itrules provides many condition functions. Have a look on the full list of [condition functions](/../reference#functions)

## Template ##
```
#!Dylan
rule type(Person)
    $Name has $PetsCount+Words pets:
      $Pets...[$NL]

rule type(Dog) attribute(Name)
    $Name, a $Age dog

rule type(Dog)
    A $Age dog

rule type(Cat)
    $Name, a $Age+Age kitty

rule trigger(Age) attribute(value:1)
    one year old

rule trigger(Age)
    $value+Words years old
```

## Code ##
```
#!java
import io.intino.itrules.TemplateEngine;

public class Conditions {

    public static final String Template = "path_to_template/ExampleConditions.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template).render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol",
                new Person.Dog("Ruffo", 5),
                new Person.Cat("Missy", 1),
                new Person.Dog(3)
        );
    }

    public static class Person {
        private String name;
        private Pet[] pets;

        public Person(String name, Pet... pets) {
            this.name = name;
            this.pets = pets;
        }

        public static abstract class Pet {
            private String name;
            private int age;

            public Pet(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        public static class Dog extends Pet {
            public Dog(int age) {
                this(null, age);
            }
            public Dog(String name, int age) {
                super(name, age);
            }
        }

        public static class Cat extends Pet {
            public Cat(String name, int age) {
                super(name, age);
            }
        }
    }
}
```

## Output ##
```
#!text
Pau Gasol has three pets:
  Ruffo, a five years old dog
  Missy, a one years old kitty
  A three years old dog
```
