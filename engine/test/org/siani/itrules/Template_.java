package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.cases.templates.RosterTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class Template_ {

    private static Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    @Test
    public void should_render_roster() throws Exception {
        Assert.assertEquals(expected("roster.txt"), RosterTemplate.create().format(createRoster()));
    }

    private Roster createRoster() {
        Person orenga = new Person("Juan Antonio Orenga", "Spain", date(1966, JULY, 29));
        Person gasol = new Player("Pau Gasol", "Spain", "L.A. Lakers", date(1980, JULY, 6));
        Person rudy = new Person("Rudy Fernandez", "Spain", date(1985, APRIL, 4));
        Person navarro = new Person("Juan Carlos Navarro", "Spain", date(1980, JUNE, 17));
        return new Roster(orenga, gasol, rudy, navarro);
    }

    private String expected(String name) throws IOException {
        return read("test.res/" + name);
    }

    private String read(String filename) throws IOException {
        return read(new BufferedReader(new FileReader(filename)));
    }

    private String read(BufferedReader reader) throws IOException {
        try {
            return readLines(reader, "");
        } finally {
            reader.close();
        }
    }

    private String readLines(BufferedReader reader, String text) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) text += line + "\n";
        return text.trim();
    }

    private static class Person {
        private String name;
        private String country;
        private Date birthday;

        public Person(String name, String country, Date birthday) {
            this.name = name;
            this.country = country;
            this.birthday = birthday;
        }
    }

    public static class Player extends Person {

        private String club;

        public Player(String name, String country, String club, Date birthday) {
            super(name, country, birthday);
            this.club = club;
        }
    }

    private static class Roster {
        private final Person[] player;
        private Person coach;

        public Roster(Person coach, Person... player) {
            this.coach = coach;
            this.player = player;
        }

    }

}
