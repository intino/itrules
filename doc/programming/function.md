---
title: "Programming a Condition Function"
date: 2024-07-18T15:00:00Z
draft: false
---

## Template ##
```
#!Dylan
def type(Person) first-pet-is(Dog)
    $Name loves dogs and has $PetsCount+Words pets:
      $Pets...[$NL]
end

def type(Person)
    $Name has $PetsCount+Words pets:
      $Pets...[$NL]
end

def type(Dog) attribute(Name)
    $Name, a $Age dog
end

def type(Dog)
    A $Age dog
end

def type(Cat)
    $Name, a $Age+Age kitty
end

def trigger(Age) attribute(value:1)
    one year old
end

def trigger(Age)
    $value+Words years old
end
```

## Code ##
```
#!java
import org.siani.itrules.Function;
import org.siani.itrules.TemplateEngine;

import java.util.Locale;

public class ProgrammingCondition {

    public static final String Template = "path_to_template/ProgrammingCondition.itr";

    public static void main(String[] args) {
        String result = new TemplateEngine(Locale.ENGLISH).use(Template)
                .add("first-pet-is", firstPet())
                .render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol",
                new Person.Dog("Ruffo", 5),
                new Person.Cat("Missy", 1),
                new Person.Dog(3)
        );
    }

    private static Function firstPet() {
        return (trigger, parameter) -> trigger.frame().frames("pets").next().is(parameter);
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
Pau Gasol loves dogs and has three pets:
  Ruffo, a five years old dog
  Missy, a one years old kitty
  A three years old dog
```
