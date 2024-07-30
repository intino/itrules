---
title: "Hello World"
date: 2024-07-18T15:00:00Z
draft: false
---
## Code
```
#!java
import io.intino.itrules.TemplateEngine;

public class HelloWorld {
    public static void main(String[] args) {
        TemplateEngine engine = new TemplateEngine();
        System.out.println(engine.render("Hello world!"));
    }

}
```

## Output
```
#!text
Hello world!
```

