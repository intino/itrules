# What is ITrules? #
ITrules is a rule-based template engine. ITrules can generate HTML, XML, SQL, JSON or any other documents from templates. Documents are generated from a structured data source (frames) and a set of production rules that define the template. It can be used either as a library for JAVA or as a command-line tool. 

# How it works? #
ITrules defines a programming language that allows to define frames and production rules. The engine is able to interpret this language and generate a document.

## Frame and rules ##
Frames are the elementary representations to define the data source. It might be understood as facts that represent the document. A frame can be represented as simple type (String, Integer, Float, Date) or as a complex type, that is, a set of attributes. Attributes can be just a single frame or multiple frames (list). Any data source contains a *Root Frame*.

```
#!python
Root:Person
  Name:String="Pau Gasol"
  Birthday:Date=06/07/1980
  Country:String="Spain"
```

Rules are the elementary representations to define the template. It might be seen as the knowledge for generating documents. Thus, the engine is like an expert system that provides the reasoning mechanism to execute rules in order to generate the document. 

Rules consist of two parts: a condition and an output. Conditions are expressed as a set of boolean functions. Output can contain marks($) and expressions.

```
#!powershell
When is(Person) #condition
$Name was born in $Country on $Birthday  #output
```

## Triggering rules ##

The *Root Frame* is the initial trigger. When a trigger matches the condition of a rule, the rule output is rendered. In the above example, the rule condition is satisfied, since *Root Frame Type* is `Person`

Since, only one action can be taken, the engine provides a mechanism for prioritizing rules when more than one can be triggered. 

Rule output marks create new triggers from the corresponding attributes in the current frame. `Name`, `Country` and `Birthday` marks in this output will create triggers for the corresponding attributes in the *Person Frame*. 

Default rules for primitive types rendered these triggers, producing the following output:

```
Pau Gasol was born in Spain on 06/07/1980.
```

## Java API ##
Once frames and rules have been defined, the document can be generated
```
#!java
Document document = new Document();
Frame data = new Frame(*source*);
RuleEngine ruleEngine = new RuleEngine(*source*);
ruleEngine.render(data, document);

```
