# What is ITrules? #
ITrules is a rule-based template engine. ITrules can generate HTML, XML, SQL, JSON or any other documents from templates. Documents are generated from a structured data source (frames) and a set of production rules that define the template. It can be used either as a library for JAVA or as a command-line tool. 

# How it works? #
It defines a programming language that allows to define production rules and frames. The engine is able to interpret this language for document generation.

Frames are the elementary representations to define the data source. It might be understood as facts that represent the document. A frame can be represented as simple type (String, Integer, Float, Date) or as a complex type, that is, a set of attributes. Attributes can be just a single frame or multiple frames (list). Any data source contains a Root frame.

```
Root:String="Hello world!"
Root:Person
  Name:String="Pau Gasol"
  Birthday:Date=06/07/1980
  Country:String="Spain"
  Team:String="Barcelona","Lakers"

Root:Roster
  HeadCoach:Person
    Name:String="Juan Antonio Orenga"
    Birthday:Date=29/07/1966
    Country:String="Spain"
  Players:List
    :Person
       Name:String="Pau Gasol"
       Birthday:Date=06/07/1980
       Country:String="Spain"
       Team:String="Barcelona","Lakers"
    :Person
       Name:String="Rudy Fernandez"
       Birthday:Date=04/04/1985
       Country:String="Spain"
       Club="Real Madrid"
    :Person
       Name:String="Juan Carlos Navarro"
       Birthday:Date=17/06/1980
       Country:String="Spain"
       Club="Lakers"
```

Rules are the elementary representations to define the template. It might be seen as the knowledge for generating documents. Thus, the engine is like an expert system that provides the reasoning mechanism to execute rules in order to achieve the document generation. Rules are defined for a data type and consist of two parts: a sensory precondition and an action, the desired output for the data type and preconditions defined in the rule. If a rule's precondition matches the data source, the production is triggered and its action is executed. The precondition is optional, so the rule is triggered whenever the data type is present


Since, only one action can be taken, the engine provides a mechanism for prioritizing rules when more than one is triggered. 

```
Rule type(Person)
$Name was born in $Country on $Birthday.
His birthday is on $Birthday(DayMonth).
^

Rule type(Date) id(Birthday) format(yyyy)
$Value
^

Rule type(Date) case(DayMonth) format(dd/mm)
$Value
^


# Download #
All the stable releases are available at [downloads](http://bitbucket.org/siani/itrules/downloads)

# License #
ITrules is licensed under the [LGPL](http://www.gnu.org/licenses/lgpl.html) v2.1. The LGPL guarantees that this library will stay open source, protecting your work.

# Getting help #
Do you have a question, a problem, some feedback, or suggestions for javaFMI?
Do it through our [Issue Tracker](http://bitbucket.org/siani/itrules/issues)

# Team #
* José Juan Hernández-Cabrera (SIANI. University of Las Palmas. SPAIN)
* José Évora-Gómez (SIANI. University of Las Palmas. SPAIN)
* Mario Caballero Ramírez (SIANI. University of Las Palmas. SPAIN)
* Octavio Roncal Andrés (SIANI. University of Las Palmas. SPAIN)

# Usage #
The next code shows an example of usage:

A typical rule-based template has a set of rules and a fixed data source. A rule is defined by conditions that data source