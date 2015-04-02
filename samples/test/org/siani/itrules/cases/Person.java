package org.siani.itrules.cases;

import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    public static final String Template = "samples/res/engine/templates/Person.itr";

    private String name;
    private String country;
    private String club;
    private Date birthday;

    public Person(String name, String country, Date birthday) {
        this.name = name;
        this.country = country;
        this.club = null;
        this.birthday = birthday;
    }

    public Person(String name, String country, String club, Date birthday) {
        this.name = name;
        this.country = country;
        this.club = club;
        this.birthday = birthday;
    }

    public static final Date birthday(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

}
