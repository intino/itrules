[Home](../README.md)

# Roster. XML #

## Frame ##
```
#!python
Root:Roster
  Coach:Person
    Name:String="Juan Antonio Orenga"
    Birthday:Date=29/07/1966
    Country:String="Spain"
  Team:
    Player
    :Person
       Name:String="Pau Gasol"
       Birthday:Date=06/07/1980
       Country:String="Spain"
       Club:String="Lakers"
    :Person
       Name:String="Rudy Fernandez"
       Birthday:Date=04/04/1985
       Country:String="Spain"
       Club="Real Madrid"
    :Person
       Name:String="Juan Carlos Navarro"
       Birthday:Date=17/06/1980
       Country:String="Spain"
       Club="FC Barcelona"
```

## Rules ##
```
#!Dylan
defrule type(Roster)
<roster>
  $Coach
  <players>
    $Player
  </players>
</roster>
endrule

defrule type(Person) trigger(Coach)
<coach name="$Name" year="$Birthday+format(yyyy)" country="$Country" />
endrule

defrule type(Person) trigger(Player)
<player "$Name" year="$Birthday+format(yyyy)" country="$Country" club="$Club"/>
  $Club
</player>
endrule

defrule trigger(Club)
<club name="$value" />
endrule

## Output ##
```
#!XML
<roster>
  <coach name="Juan Antonio Orenga" year="1966" country="Spain" />
  <players>
    <player name="Pau Gasol" year="1980" country="Spain" club="Lakers" /> 
    <player name="Rudy Fernandez" year="1985" country="Spain" club="Real Madrid" /> 
    <player name="Juan Carlos Navarro" year="1980" country="Spain" club="FC Barcelona" /> 
  </players>
</roster>
```
