---
title: "Recursive template"
date: 2024-07-18T15:00:00Z
draft: false
---

## Template ##
```
#!text
rule type(Module) attribute(modules)
    <module name="$name">
        $modules...[$NL]
    </module>

rule type(Module)
    <module name="$name"/>
```

## Code ##
```
#!java
import io.intino.itrules.TemplateEngine;

public class Recursive {

    public static final String Template = "path_to_template/Recursive.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template).render(module());
        System.out.println(result);
    }

    private static Module module() {
        return new Module("X",
                new Module("1",
                        new Module("1.1"),
                        new Module("1.2",
                                new Module("1.2.1"),
                                new Module("1.2.2"),
                                new Module("1.2.3")
                        ),
                        new Module("1.3"),
                        new Module("1.4")
                ),
                new Module("2",
                        new Module("2.1"),
                        new Module("2.2"),
                        new Module("2.3"),
                        new Module("2.4"),
                        new Module("2.5"),
                        new Module("2.6")

                ),
                new Module("3",
                        new Module("3.1"),
                        new Module("3.2"),
                        new Module("3.3")
                ),
                new Module("4",
                        new Module("4.1"),
                        new Module("4.2")
                ),
                new Module("5")
        );
    }

    public static class Module {
        private String name;
        private Module[] modules;

        public Module(String name, Module... modules) {
            this.name = name;
            this.modules = modules;
        }
    }

}

```

## Output ##
```
#!XML
<module name="X">
    <module name="1">
        <module name="1.1"/>
        <module name="1.2">
            <module name="1.2.1"/>
            <module name="1.2.2"/>
            <module name="1.2.3"/>
        </module>
        <module name="1.3"/>
        <module name="1.4"/>
    </module>
    <module name="2">
        <module name="2.1"/>
        <module name="2.2"/>
        <module name="2.3"/>
        <module name="2.4"/>
        <module name="2.5"/>
        <module name="2.6"/>
    </module>
    <module name="3">
        <module name="3.1"/>
        <module name="3.2"/>
        <module name="3.3"/>
    </module>
    <module name="4">
        <module name="4.1"/>
        <module name="4.2"/>
    </module>
    <module name="5"/>
</module>
```
