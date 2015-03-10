package org.siani.itrules;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class TestApi {

    private static final File TEST = new File("res_test");
    private static final String RULE = "" +
            "defrule type(Person)\n" +
            "\t$name nació el $birthday en $country\n" +
            "endrule";
    private static final String EXPECTED = "Pau Gasol nació el 06/07/1980 en Spain";

    @Test
    public void renderingDirectlyAPerson() throws Exception {
        Document document = new Document();
        RuleEngine ruleEngine = new RuleEngine(RuleSetReader.read(RULE));
        ruleEngine.render(new Person("Pau Gasol", "06/07/1980", "Spain"), document);
        assertEquals(EXPECTED, document.content());
    }

    private class Person {
        private String name;
        private String birthday;
        private String country;

        public Person(String name, String birthday, String country) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
        }
    }
}
