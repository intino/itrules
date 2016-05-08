import org.siani.itrules.TemplateEngine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExampleOptionalAttributes {

    public static final String Template = "samples/templates/OptionalAttributes.itr";

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
