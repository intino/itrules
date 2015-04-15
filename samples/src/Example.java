import org.siani.itrules.TemplateEngine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Example {

    public static class Person {
        private String name;
        private Date birthday;
        private String country;

        public Person(String name, Date birthday, String country) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "spain");

        TemplateEngine engine = new TemplateEngine().use("samples/templates/Person.itr");
        System.out.println(engine.render(person));
    }

    private static Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }


}