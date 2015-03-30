package org.siani.itrules.cases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ObjectRepository {
    public static Map<String, Object> objects = createObjects();


    private static Map<String, Object> createObjects() {
        HashMap<String, Object> objects = new HashMap<>();
        objects.put("PauGasol", new Person("Pau Gasol", date("06/07/1980"), "Spain") );
        return objects;
    }

    private static Date date(String date) {
        try {
            return new SimpleDateFormat("dd/mm/yyyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    private static class Person {
        private String name;
        private Date birthday;
        private String country;

        public Person(String name, Date birthday, String country) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
        }
    }



}
