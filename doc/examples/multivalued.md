---
title: "Multivalued attributes"
date: 2024-07-18T15:00:00Z
draft: false
---


## Template
```
#!Dylan
rule type(Message)
    From: $From
    To: $To...[, ]
    $Subject

    $Body...[$NL]
```

## Code
```
#!java
import io.intino.itrules.TemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultivaluedAttributes {

    public static final String Template = "path_to_template/Multivalue.itr";

    public static void main(String[] args) {
        String result = TemplateEngine.with(Template).render(message());
        System.out.println(result);
    }

    private static Message message() {
        return new Message("frodo@hobbiton.me", "gandalf@elrond.me", "bilbo@hobbiton.me")
            .subject("The ring")
            .addLine("I wish the Ring had never come to me.")
            .addLine("I wish none of this had happened.");
    }

    public static class Message {
        private String from;
        private String[] to;
        private String subject;
        private List<String> body = new ArrayList<>();

        public Message(String from, String... to) {
            this.from = from;
            this.to = to;
        }

        public Message subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Message addLine(String line) {
            body.add(line);
            return this;
        }

    }

}

```

## Output
```
#!text
From: frodo@hobbiton.me
To: gandalf@elrond.me, bilbo@hobbiton.me
The ring

I wish the Ring had never come to me.
I wish none of this had happened.
```
