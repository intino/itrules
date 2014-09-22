# What is ITrules? #
ITrules is a rule-based template engine. ITrules can generate HTML, XML, SQL, JSON or any other documents from templates. Documents are generated from a structured data source (frames) and a set of production rules that define the template. It can be used either as a library for JAVA or as a command-line tool. 

# How it works? #
It defines a programming language that allows to define production rules and frames. The engine is able to interpret this language for document generation.

Rules are the elementary representations to define the template. It might be seen as the knowledge for generating documents. Thus, the engine is like an expert system that provides the reasoning mechanism to execute rules in order to achieve the document generation. Rules consist of sensory precondition and an action. If a rule's precondition matches the data source, the production is triggered and its action is executed. Since, only one action can be taken, the engine provides a mechanism for prioritizing rules when more than one is triggered. 

Frames are the elementary representations to define the data source. It might be understood as facts that represent the document. A frame can be represented as simple type (String, Integer, Float, Date) or as a complex type, that is, a set of attributes. Attributes can be just a single frame or multiple frames (list). Any data source contains a root frame






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