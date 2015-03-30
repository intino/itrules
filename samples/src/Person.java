import org.siani.itrules.Document;
import org.siani.itrules.reader.itr.RuleSetReader;
import org.siani.itrules.RuleEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private String name;
    private Date birthday;
    private String country;

    public Person(String name, Date birthday, String country) {
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }


    public static void main(String[] args) throws FileNotFoundException {
        RuleEngine ruleEngine = new RuleEngine(RuleSetReader.read(new FileInputStream("rules.itr")));
        Person pau = new Person(
                "Pau Gasol",
                new GregorianCalendar(1980, Calendar.JULY, 6).getTime(),
                "Spain");
        Document document = ruleEngine.render(pau);
        System.out.println(document.content());
    }
}
