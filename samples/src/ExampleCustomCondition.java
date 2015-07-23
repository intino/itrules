import org.siani.itrules.Function;
import org.siani.itrules.TemplateEngine;
import org.siani.itrules.engine.Trigger;

import java.io.File;

public class ExampleCustomCondition {

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
            public Dog(String name, int age) {
                super(name, age);
            }
        }

        public static class Cat extends Pet {
            public Cat(String name, int age) {
                super(name, age);
            }
        }

        public static void main(String[] args) {
            Person person = new Person("Roger Dickens",
                    new Dog("Ruffo", 5),
                    new Cat("Missy", 1),
                    new Dog("Toby", 3)
            );

            TemplateEngine engine = new TemplateEngine().use("samples/templates/CustomCondition.itr");
            engine.add("one", new Function() {
                @Override
                public boolean match(Trigger trigger, String parameter) {
                    return trigger.frame().isPrimitive() && trigger.frame().value().equals(1);
                }

            });
            System.out.println(engine.render(person));
        }
    }

}