# What is it-rules? #
it-rules is a rule-based template engine. it-rules can generate HTML, XML, SQL, JSON or any other documents from templates. Documents are generated from a structured data source (frames) and a set of production rules that define the template. It can be used either as a library for JAVA or as a command-line tool. 

# How it works? #
The it-rules engine is like an expert system that provides the reasoning mechanism to execute rules in order to generate the document. It provides a programming language that allows to define frames and production rules. The engine is able to interpret this language and generate a document.

## Frame and rules ##
Frames are the elementary representations to define the data source. It might be understood as facts that represent the document. A frame can be represented as simple type (String, Integer, Float, Date) or as a complex type, that is, a set of attributes. Any data source contains a *Root Frame*.

```
#!python
Root:Person
  Name:String="Pau Gasol"
  Birthday:Date=06/07/1980
  Country:String="Spain"
```

Rules are the elementary representations to define the template. It might be seen as the knowledge for generating documents. Rules consist of two parts: a condition and an output. Conditions are expressed as a set of boolean functions. Output can contain marks($) and expressions.

```
#!Dylan
defrule type(Person)
$Name was born in $Country on $Birthday
~
```

* `type(Person)` is the condition. It checks that a frame type is `Person`. 
* `$Name was born in $Country on $Birthday` is the output
* `~` mark indicates the end of the output. 

In the [reference guide](referenceguide) you can learn more about rule definition.


## Triggering rules ##

The *Root Frame* is the initial trigger. When a trigger matches the condition of a rule, the rule output is rendered. In the above example, the rule condition is satisfied, since *Root Frame Type* is `Person`

Since, only one action can be taken, the engine provides a mechanism for prioritizing rules when more than one can be triggered. 

Output marks create new triggers. In this case `Name`, `Country` and `Birthday` marks create triggers using the corresponding attributes from the triggering frame. 

Default rules for primitive types rendered these triggers, producing the following output:

```
Pau Gasol was born in Spain on 06/07/1980.
```

## Java API ##
Once frames and rules have been defined, the document can be generated
```
#!java
Document document = new Document();
Frame data = new Frame(dataSource);
RuleEngine ruleEngine = new RuleEngine(rules);
ruleEngine.render(data, document);
```

# Download #
All the stable releases are available at [downloads](http://bitbucket.org/siani/it-rules/downloads)

# License #
it-rules is licensed under the [LGPL](http://www.gnu.org/licenses/lgpl.html) v2.1. The LGPL guarantees that this library will stay open source, protecting your work.

# Getting help #
Do you have a question, a problem, some feedback, or suggestions for it-rules?
Do it through our [Issue Tracker](http://bitbucket.org/siani/it-rules/issues)

# Team #
* José Juan Hernández-Cabrera (SIANI. University of Las Palmas. SPAIN)
* José Évora-Gómez (SIANI. University of Las Palmas. SPAIN)
* Mario Caballero Ramírez (SIANI. University of Las Palmas. SPAIN)
* Octavio Roncal Andrés (SIANI. University of Las Palmas. SPAIN)