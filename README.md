---
title: "ItRules engine"
date: 2024-07-30T15:00:00Z
draft: false
---
# What is itrules? #
`itrules` is a Template Based Code Generator (TBCG). It can generate HTML, XML, SQL, JSON or any other documents from templates. Java code can be separated from the View, allowing to develop applications according to the Model View Controller (MVC).

# How it works? #
`itrules` works as a production rule system, that is, documents are generated using a set of rules. A "reasoning algorithm" is able to interpret these rules to generate documents. Java objects are used to trigger rules. 

## Rules ##
Rules are the basic mechanism to define how a document is generated. It might be said that a template is made of rules. 

Rules are in the form *if x then y*, that is, rules consist of two parts: a condition and an action. Condition are expressed as a set of boolean functions. Action contain the text that will be rendered.

When conditions of rules are matched, it is said that the rule has been fired, and its action will be executed.

This is a basic example of a rule

```
#!Dylan
rule type(Person)
    $Name was born in $Country+Capitalize in $Birthday+Year
```

* `rule` keyword indicates that a new rule is defined
* `type(Person)` is the condition that is evaluated. In this case, this rule is executed if the trigger object type is `Person`. 
* `$Name was born in $Country on $Birthday` is the action that will be executed by the template engine
* `$Name`, `$Country` and `$Birthday` are marks. Marks are used to take the objects that will trigger other rules
* `+Capitalize`and `+Year` are formatters that define how objects are transformed


It is available a full list of [condition functions](doc/reference/_index.md#condition-functions) and [formatters](doc/reference/_index.md#formatters) that can be used for defining rules.

To escape characters, [system marks](doc/reference/_index.md#escaped-characters) are also available.

In addition, new functions, formatters and class adapters can be programatically created. You can read about it in the [programming guide](doc/programming/_index.md).

## How it works ##

The Template Engine takes an object to trigger the rules. A rule is fired when this trigger makes all the functions in its conditions to be `true`.

When several rules can be fired, since rules are ordered, it is executed the first rule that matches the current trigger.


## How it is used ##
```
#!java
import io.intino.itrules.TemplateEngine;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Example {
    
    public static void main(String[] args) {
        String result = TemplateEngine.with("path_to_template.itr").render(pau());
        System.out.println(result);
    }

    private static Person pau() {
        return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "spain");
    }

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

    private static Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }    

}
```

The resulting text is ``Pau Gasol was born in Spain in 1980``

The Template Engine takes the person object as the initial trigger. Rules are sequentially evaluated matching the conditions. Once all conditions of a rule are satisfied, the rule is fired. In the above example, the rule condition "type(person)" is matched, since the object class is *Person*. 

Rule marks in the action side are used to take new triggers. In this case `Name`, `Country` and `Birthday` marks create triggers for the corresponding attributes of the `Person` object. 

These triggers fire a default rule for primitive types that render its value.
 
Optionally, it can be added trigger options to the marks. In the above example `$Country+Capitalize` and `$Birthday+Year`. These trigger options can transform the object or be used in the condition functions.


Have a look to the following examples to learn more

1. [Hello world!](doc/examples/hello.md)
2. [Formatting data](doc/examples/formatting.md)
3. [Multivalued attributes](doc/examples/multivalued.md)
4. [Multivalued and optional attributes](doc/examples/optional.md)
5. [Conditions on triggers and attributes](doc/examples/conditions.md)
6. [Recursive](doc/examples/recursive.md)


## Download and use itrules ##

itrules is available both on [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Citrules) and [GitHub](https://github.com/intino/itrules/releases). The last stable version is 2.0.1

If you are using Maven, just add the following snippet to your POM:
```
#!xml
<dependency>
    <groupId>io.intino.itrules</groupId>
    <artifactId>dsl</artifactId>
    <version>1.1.0/version>
</dependency>
```


# License #
`itrules` is licensed under the [LGPL](http://www.gnu.org/licenses/lgpl.html) v2.1. The LGPL guarantees that this library will stay open source, protecting your work.

# Getting help #
Do you have a question, a problem, some feedback, or suggestions for `itrules`?
Do it through our [Issue Tracker](https://github.com/intino/itrules/issues)

# Team #
* Octavio Roncal-Andrés (SIANI. University of Las Palmas. SPAIN)
* José Juan Hernández-Cabrera (SIANI. University of Las Palmas. SPAIN)
* José Évora-Gómez (SIANI. University of Las Palmas. SPAIN)
* Mario Caballero-Ramirez (SIANI. University of Las Palmas. SPAIN)

 