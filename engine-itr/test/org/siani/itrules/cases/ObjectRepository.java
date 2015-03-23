package org.siani.itrules.cases;

import org.siani.itrules.model.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJ on 22/03/15.
 */
public class ObjectRepository {
    public static Map<String, Object> objects = createObjects();


    private static Map<String, Object> createObjects() {
        HashMap<String, Object> objects = new HashMap<>();
        objects.put("PauGasol", new Person("Pau Gasol", new DateTime("06/07/1980"), "Spain") );
        return objects;
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
