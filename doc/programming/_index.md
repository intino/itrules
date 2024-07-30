---
title: "Programming Guide"
date: 2024-07-18T15:00:00Z
draft: false
weigth: 1
---
## Condition Functions
New condition functions can be easily added to the template engine:

`TemplateEngine.with("template.itr").add(function)`

A condition function must implement the following interface

```
#!java
public interface Function {

    boolean match(Trigger trigger, String parameter);

}
```

[Example](function)


## Formaters
New data formatters can be easily added to the template engine:

`TemplateEngine.with("template.itr").add(formatter)`

A formatter must implement the following interface

```
#!java
public interface Formatter {

    Object format(Object value);

}
```

[Example](formatter)


## Adapters
Adapters are intented to transform java objects into a data structure (frames & slots) that the template engine use to render the template.

Adapters can be easily added to the template engine:

`TemplateEngine.with("template.itr").add(class, adapter)`

An adapter must implement the following interface

```
#!java
public interface Adapter<T> {

    SlotSet slotsOf(T source, Context context);

}
```

[Example](adapter)
