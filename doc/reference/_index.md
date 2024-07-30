---
title: "Reference"
date: 2024-07-18T15:00:00Z
draft: false
---

## Escaped Characters ##
`$NL`. New Line (CR Char)

`$~`. Null Char

`$$`. $ Char

`$[`. [ Char

`$]`. ] Char


## Formatters ##
### String formatters ###
`+Uppercase`
Transform a string into a new string in uppercase

`+FirstUpperCase`
Transform a string into a new string with the first letter in uppercase

`+LowerCase`
Transform a string into a new string in lowercase

`+FirstLowerCase`
Transform a string into a new string with the first letter in lowercase

`+CamelCase`
Transform a string into a new string witout spaces and the first letter of eachword in uppercase

`+LowerCamelCase`
Transform a string into a new string witout spaces and the first letter of eachword in uppercase, but the first letter in lowercase.

`+SnakeCase`
Transform a string into a new string in lowercase with hyphens instead of blank spaces.

`+Capitalize`
Transform a string into a new string with the first letter in uppercase and the rest in lowercase

`+Length`
Transform a string into a number with the string length

`+Length`
Transform a string into a new string in plural. It uses the engine locale to identify the language.

### Number formatters ###
`+Words`
Transform a number into a string with the spelling number. It uses the engine locale to identify the language.

`+Separators`
Transform a number into a string with thousand separators

`+TwoDecimals`
Transform a number into a string with two decimals

### Date formatters ###
`+Year`
Transform a date into a string with the year

`+MonthYear`
Transform a date into a string with month and year (example: April 2002). It uses the engine locale to identify the language.

`+ShortDate`
Transform a date into a string with a short date format (example: 01/04/2002)

`+FullDate`
Transform a date into a string with a full date format (example April,1 2002). It uses the engine locale to identify the language.

`+DayOfWeek`
Transform a date into a string with the day of week (Monday to Sunday)

`+Time`
Transform a date into a string with the time (14:28)

### Custom formatters ###
New formatters can be programatically created. Have a look on the [programming section](../programming)


## Condition Functions ##

### Type conditions ###

`type(name)`
Returns true when the current object has the specified type.

`type(name & other & another)`
Returns true when the current object has all the specified types.

`type(name | other | another)`
Returns true when the current object has any of the specified types.

### Trigger conditions ###

`trigger(mark)`
Returns true when the current object was triggered with the specified mark 

`trigger(option)`
Returns true when the current object was triggered with the specified option 

### Attribute conditions ###

`attribute(name)`
Returns true when the current object has the specified attribute.

`attribute(name & other & another)`
Returns true when the current object has all the specified attributes.

`attribute(name | other | another)`
Returns true when the current object has any of the specified attributes.

`attribute(name:value)`
Returns true when the current object has the specified attribute and value.

`attribute(name:value & name:othervalue & othername:anothervalue )`
Returns true when the current object has all the specified attributes and values.

`attribute(name:value | name:othervalue | othername:anothervalue )`
Returns true when the current object has any of the specified attributes and values.

`attribute(value)`
Returns true when the current object is primitive and has the specified value.

`attribute(value & othervalue & anothervalue)`
Returns true when the current object is primitive and has all the specified values.

`attribute(value | othervalue | anothervalue)`
Returns true when the current object is primitive and has any the specified values.

### Custom functions ###
New condition functions can be programatically created. Have a look on the [programming section](../programming)
