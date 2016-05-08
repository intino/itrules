import org.siani.itrules.Function;
import org.siani.itrules.TemplateEngine;
import org.siani.itrules.engine.Trigger;

import java.util.Locale;

public class ExampleSlotFunctions {

    public static final String Template = "samples/templates/SlotFunction.itr";

    public static void main(String[] args) {
        String result = new TemplateEngine(Locale.ENGLISH).use(Template)
                .add("one", oneFunction())
                .render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Roger Dickens",
                new Person.Dog("Ruffo", 5),
                new Person.Cat("Missy", 1),
                new Person.Dog(3)
        );
    }

    private static Function oneFunction() {
        return (trigger, parameter) -> trigger.frame().isPrimitive() && trigger.frame().value().equals(1);
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