import org.siani.itrules.TemplateEngine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExampleFormatting {
    public static void main(String[] args) {
        Person person = new Person("Pau Gasol", date(1980, Calendar.JULY, 6), 213, 19285850);

        TemplateEngine engine = new TemplateEngine().use("samples/templates/Formatting.itr");
        System.out.println(engine.render(person));
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
