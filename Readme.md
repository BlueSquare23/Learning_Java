# Intro to Java


## Overview

This Readme is a series of notes on the fundamentals of Java programming that
I've taken while watching the [freeCodeCamp](https://www.freeCodeCamp.org)
tutorial below.

[Java Programming for Beginners](https://youtu.be/A74TOX803D0)

They're using some silly web-IDE to write code in the tutorial. As the kids
say, I'm not about that life. My tools are vim, terminal, jdk-17, java, javac,
and jshell.


## Hello World!

Below is the code for the hello world program in java.

```
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

A classic criticism is that java has more "boiler-plate" code as compared to
other programming languages meaning it takes alot more code to do something
simple like print a string to the console.

### Classes, Objects, & Methods

A class is an abstract datatype that can be used as a template to create
objects. For example, we may have a class named `Dogs` which has certain
attributes (breed, size, age, color). An object is then an instance of that
class. So for example with our Dogs class, an object would be a specific dog.
We can name him Harry. He's an instance of the Dogs class with breed => corgi,
size => medium, age => old, color => orange ect..

Likewise, we can give Dogs class some internal functions called methods. We can
think of these as things our Dogs might be able to do for example, eat, sleep,
sit, fetch, ect.. In the case of Harry, since his age is old, he might not be
able to fetch so fast any more, but he's very good at sleep!

For our hello world program above, the `HelloWorld` code block defines the
class and the indented `main` code block defines a method for that class.

### Compiled to Byte-Code

Java runs on the Java Virtual Machine (JVM). The JVM runs what's called
compiled `byte-code`. When you go to run a java app from the command line you
have to first compile the source to java byte-code.

You can use the command below to compile our simple Hello World program.

```
> javac HelloWorld.java
```

You'll notice that generates a .class file.

```
> file HelloWorld.class
HelloWorld.class: compiled Java class data, version 61.0
```

Now we can run our hello world program by invoking the HelloWorld class.

```
> java HelloWorld
Hello World!
```

#### Multiple Classes

If you have a java program with multiple classes (which you will have, java is
an OOP language) then when you go to compile you'll see it generates a class
file for every class defined.

For example, if we add another class to our hello world program and then
compile we can see it generates multiple class files.

* `HelloWorld.java`

```
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class AnotherClass {
    public static void main(String[] args) {
        System.out.println("Another Class");
    }
}
```

```
> javac HelloWorld.java
> ls
AnotherClass.class  HelloWorld.class	HelloWorld.java
```

Traditionally, the main source file / class of a java application is just named
Main.java and java application are invoked `java Main`.

Note: There wont be any .class file in this repo on GH because I've exempted
them via the .gitignore.

#### Determining Program Entry Point

The JVM will look for the main method to start executing the program within the
Class that matches the name of the source file.

So for example with our `HelloWorld.java` program, the JVM will look for the
main method within the class called `HelloWorld`.

We're explicitly compiling then envoking the class we want to run here, so the
above doesn't exaclty make sense in our context. However, java can be started
and run in a number of different more automated environments.

#### More about "main" Method

The JVM looks for a main method that meets the following criteria.

`public static void main(String[] args)`

* Static Method `static`
* Named `main`
* Has public access `public`
* Takes a string array arg `String[]`
* And doesn't return any value `void`

Don't worry too much about what that all means right now. The course will
elaborate on each as it goes on.


## Variables

A variable is an entity that can take on different values.

Variables have types such as integers, strings, arrays, ect.. 

When declaring a variable in Java we have to specify a type. Java is a
statically-typed language, so it expects its variables to be declared before
they can be assigned values (as opposed to a dynamically-typed language where
the variables type is determined after the fact by the type of data assigned to
it).

In Java, as in many languages, the equal sign `=` is the assignment operator.

* `Variables.java`

```
class Main {
    static int weight = 10000;

    public static void main(String[] args) {
        int age;
        age = 1000; 

        System.out.println("You are " + age + " years old!");
        System.out.println("You are " + weight + " lbs!");
    }
}
```

### Variable Scope

Scope is a property of variables that determines the context in which the
variable is valid. For example, in the above code the variable `age` is defined
within the main method and so it is considered locally scoped (relative to the
print line statement).

However, the variable `weight` is considered globally scoped, meaning any other
method within the Main class could make use of that value.

Lastly, the local scope of a variable supersedes a higher level scope. So for
example, if the `weight` variable is redeclared & redefined within the scope of
the `main` method then that new value will be used in place of the value
defined at the Class level.

#### Static Typing

The course will cover this subject later in more detail. But for now just take
note and be aware. See how the `weight` variable has to be defined as static.
This is because static methods can only work with static variables.

#### Default Values

If the `weight` variable is declared but never defined then the java compiler
will assign a default value to it. In the case of an int it will be assigned
the default value of 0. Note, this is only the case for vars defined at the
class level. If the age variable is not ever assigned a value then the program
will error at compile time with the following error.

```
> javac Variables.java 
Variables.java:8: error: variable age might not have been initialized
        System.out.println("You are " + age + " years old!");
                                        ^
1 error
```

### Naming Variables

Variables can be named anything except for they're not allowed to start with a
number or contain a space. Likewise, java has a reserved list of about ~50
words which are reserved and cannot be used as the names of variables, classes,
methods, ect..

[Java Reserved Keywords](https://www.w3schools.com/java/java_ref_keywords.asp)

Technically you can start a variable name with a $ or a \_. However, that is
frowned upon because it can hurt code readability.

As convention, camelCase is used when naming variables in java.


## Data Types

At a high level there are two types of data in java. There are the primitive
types and the non-primitive or reference types. Primitive types store values,
for example `int` is a primitive type. A reference on the other hand stores the
memory address where a dynamic object is being stored. The course will discuss 
reference types later.

There are Eight primitive data types in java.

* `DataTypes.java`

```
class DataTypes {
    public static void main(String[] args) {
        // Integer Types
        byte aSingleByte = 100; // -128 to 127
        short aSmallNumber = 20000; // -32,768 to 32,767
        int anInteger = 2147483647; // -2147483648 to 2147483647
        long aLargeNumber = 9223372036854775807L; // -9223372036854775808 to 9223372036854775807

        // Decimal Types
        double aDouble = 1.79769313; // 4.9E-324 to 1.7976931348623157E308
        float aFloat = 3.4028F; // 1.4E-45 to 3.4028235E38

        // Booleans
        boolean isWeekend = false;
        boolean isWordday = true;

        // Characters
        char copyrightSymbol = '\u00A9';
    }
}
```

There are a few important caveat's about the above to go over.

For `long`s, they have to be appended with a capital L to be considered valid.

Similarly for `float`s, they have to be appended with a capital F. Otherwise,
any number with a dot in it will be treated as a double by default.

Lastly, the `char` type is used to store a single character. In the above
example were using a unicode escape sequence for the copyright symbol as the
single character that is being stored in the char.

### Type Conversion

There are two types of type conversion, implicit and explicit. An implicit type
conversion is when the compiler can translate from one type to another without
needing to be told what to do.

For example, with the code below the conversion from an `int` to a `double` is
implicit because the compiler can add that information without needing to be
told how to from us.

* `TypeConversion.java`

```
class TypeConversion {
    public static void main(String[] args){
        int num1 = 5;
        double num2 = num1;

        System.out.println(num2);
    }
}
```

* Output

```
> javac TypeConversion.java
> java TypeConversion 
5.0
```

However, if we were to try that conversion the other way, from `double` to
`int`, we would get an error like the following at compile time.

```
> javac TypeConversion.java
error: incompatible types: possible lossy conversion from double to int
```

That's because the Java compiler would have to snip off the info after the
decimal place in order to cram it into an int.

Now java can do this conversion, however it has to be told to it explicitly. We
can do so in java using a type-cast operator like so

* `TypeConversion.java`

```
class TypeConversion {
    public static void main(String[] args){
        int num1 = 5;
        double num2 = num1;  // Implicit

        double num3 = 1.234;
        int num4 = (int)num3;  // Explicit 

        System.out.println(num2);
        System.out.println(num4);
    }
}
```

* Output

```
> javac TypeConversion.java
> java TypeConversion 
5.0
1
```

## Jshell

To demonstrate simple things in java I'm not going to write a whole program and
compile it every time. Instead, I'm just going to use the java repl known as
[`jshell`](https://docs.oracle.com/javase/10/jshell/introduction-jshell.htm#JSHEL-GUID-465BA4F5-E77D-456F-BCB7-D826AC1E18AE).

If you have the [JDK](https://www.oracle.com/java/technologies/downloads/)
installed you can run jshell from a command line by just typing `jshell`.

```
> jshell
|  Welcome to JShell -- Version 17.0.1
|  For an introduction type: /help intro

jshell> 
```

Then you can run java interactively on from the CLI without having to save and
compiler and write so much boiler plate ect..

```
jshell> int num = 1;
num ==> 1

jshell> System.out.println(num);
1
```

Exit with /exit.

## Operators

There are several kinds of operations in java. Roughly speaking an operator is
a mathematical or logical symbol which can be used to manipulate the values
passed to it as operands.

### Arithmetic Operators

This course will cover the 5 arithmetic operators in java. There are other
bitwise operators that java also has but they're beyond the scope of this intro
course.

```
class Operators {
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 6;

        System.out.println("First Number: " + num1);
        System.out.println("Second Number: " + num2);
        System.out.println("---------------");

        // Addition
        System.out.print("Addition: ");
        System.out.println(num1 + num2);

        // Subtraction
        System.out.print("Subtraction: ");
        System.out.println(num1 - num2);

        // Multiplication
        System.out.print("Multiplication: ");
        System.out.println(num1 * num2);

        // Division
        System.out.print("Division: ");
        System.out.println(num1 / num2);

        // Modulus (Remainder)
        System.out.print("Modulus: ");
        System.out.println(num1 % num2);

    }
}
```

These operators exist in most modern languages.

Modulus is the only that might be confusing to newer programmers. Its just the
value that's left after doing a division. So 3 goes into 2 once with 1 left
over so that means 3 % 2 -> 1.

There are some other things worth noting due to java's typing that we'll
discuss in the next section.

#### Integer Division

For integer division (division of an integer by another integer) the result
will always be an integer. For example,

```
jshell>  System.out.println(12 / 5);
2
```

Of course we know the real answer is 2.4 but since both vars are ints the
result is also of type int.

If we make any of the values in a division a double the result will be a
double. For example,

```
jshell> System.out.println(12.0 / 5);
2.4

jshell> System.out.println(12 / 5.0);
2.4

jshell> System.out.println(12.0 / 5.0);
2.4
```

However, if both are of type int, the result will be type int.

### Arithmetic Assignment Operators

It is possible to do both assignment and arithmetic at the same time in java
using the arithmetic assignment operators. For example,

```
jshell> int number = 5;
number ==> 5

jshell> number += 5;
$6 ==> 10

jshell> System.out.println(number);
10
```

* All Arithmetic Assignment Operators

```
    +=    Plus Equals
    -=    Minus Equals
    *=    Multiply Equals
    /=    Divide Equals
    %=    Mod Equals
```

Here's another example with divide equals.

```
jshell> double number = 12.0;
number ==> 12.0

jshell> number /= 5;
$9 ==> 2.4

jshell> System.out.println(number);
2.4
```

And another one with mod equals.

```
jshell> int number = 3;
number ==> 3

jshell> number %= 2;
$17 ==> 1

jshell> System.out.println(number);
1
```

### Relational Operators

In java there are six types of relational operators.

```
    ==    Equality Operator
    !=    Inequality Operator
    >     Greater Than Operator
    <     Less Than Operator
    >=    Greater Than or Equal To Operator
    <=    Less Than or Equal To Operator
```

These operators return type Boolean (aka true or false).

Below are some examples of the operators in action using jshell.

```
jshell> System.out.println(10 == 5);
false

jshell> System.out.println(10 != 5);
true

jshell> System.out.println(10 > 5);
true

jshell> System.out.println(10 < 5);
false

jshell> System.out.println(10 >= 5);
true

jshell> System.out.println(10 <= 5);
false
```

### Increment / Decrement Operators

The increment / decrement operators are used to increase the values of or
decrease the value of a variable by 1. For example,

```
jshell> int num = 5;
num ==> 5

jshell> num--;
$60 ==> 5

jshell> System.out.println(num);
4
```

That's all well and good. However, note java is weird. If we try to increment
and print at the same time the print operation will happen before the increment
operation. The value is still incremented in memory. But its printed first.

The simple explanation of this is that that compiler reads from left to right.
So it reads `println(value` before reading the `++` part.

```
jshell> int num = 5;
num ==> 5

jshell> System.out.println(num++);
5

jshell> System.out.println(num++);
6

jshell> System.out.println(num++);
7

jshell> System.out.println(num);
8
```

However, if we reverse where the increment or decrement operators goes so that
its before the value then print will handle things as we're expecting.

```
jshell> int num = 5;
num ==> 5

jshell> System.out.println(++num);
6

jshell> System.out.println(++num);
7

jshell> System.out.println(num);
7
```

### Logical And & Logical Or Operators

Lastly, java provides three basic logical operators.

#### Logical And - &&

The `&&` logical and operator returns true if both sides of the expression are
true. For example,

```
jshell> System.out.println(true && true);
true

jshell> System.out.println(true && false);
false

jshell> System.out.println(false && true);
false

jshell> System.out.println(false && false);
false
```

We can change the `true` and `false` keywords out for other arithmetic
expressions as well. For example,

```
jshell> System.out.println(5 > 3 && 10 < 100);
true

jshell> System.out.println(5 > 3 && 100 < 1);
false

jshell> System.out.println(3 > 5 && 10 < 100);
false
```

#### Logical Or - ||

The logical Or operator is represented by the double pipe `||` symbols.

Logical Or returns true if either side of the expression are true and only
returns false if both sides are false.

```
jshell> System.out.println(true || true);
true

jshell> System.out.println(true || false);
true

jshell> System.out.println(false || true);
true

jshell> System.out.println(false || false);
false
```

#### Logic Not - !

Logical not is represented by the bang (exclamation mark) `!` and inverts the
value of a boolean. For example,

```
jshell> System.out.println(!false);
true

jshell> System.out.println(! (1 < 100));
false
```


## Strings

Strings in java are not primative types, they are object types. They are one of
the most powerful types in java!

There are multiple ways to initialize a string in Java. 

The first is just by using the `String` keyword.

The next way is to use the `new` keyword. The `new` keyword can be used in java
to create new objects from classes.

```
class Strings {
    public static void main(String[] args) {
        String name = "John";

        String favColor = new String("Blue");

        System.out.println(name);
        System.out.println(favColor);
    }
}
```

### Literal vs Object Strings

What's the difference? Well the JVM will take all of the strings in a given
program and store them in a section of memory called the "string pool." If a
string exists in the string pool, and you try to initialize another identical
string with a different name, then java will secretly point to two strings as
the same portion of memory in the string pool. Whereas, if you initialize a
string with the `new` keyword the string is assigned a whole new region of
memory.

* `Strings.java`

```
class Strings {
    public static void main(String[] args) {
        String literalSting1 = "abc";
        String literalSting2 = "abc";

        String objectSting1 = new String("xyz");
        String objectSting2 = new String("xyz");

        System.out.println(literalSting1 == literalSting2);
        System.out.println(objectSting1 == objectSting2);
    }
}
```

* Output

```
> javac Strings.java
> java Strings 
true
false
```

So we can see the first two literal strings are identical, whereas the object
strings are not!

### String Methods

Because strings are object types they have certain builtin methods. We can take
advantage of these methods in order to manipulate strings (a vital exercise in
programming, plain text is king).

#### .format() Method

The first method we'll look at is the `.format()` method. This can be use to
fill a preformatted string with data from some variables.

```
jshell> String name = "John R.";
name ==> "John R."

jshell> String country = "US";
country ==> "US"

jshell> int age = 28;
age ==> 28

jshell> String formattedString = String.format("My name is %s. I am from %s. I am %d years old.", name, country, age);
formattedString ==> "My name is John R.. I am from US. I am 28 years old."
```

The `%s` and `%d` are called string format specifiers. Here's a list of all the
ones for java.

##### Format Specifiers

```
    %%       Inserts a % sign
    %x %X    Integer hexadecimal
    %t %T    Time and Date
    %s %S    String
    %n       Inserts a newline character
    %o       Octal integer
    %f       Decimal floating-point
    %e %E    Scientific notation
    %g       Causes Formatter to use either %f or %e, whichever is shorter
    %h %H    Hash code of the argument
    %d       Decimal integer
    %c       Character
    %b %B    Boolean
    %a %A    Floating-point hexadecimal
```

#### .length() Method

The next method we'll look at is the `.lenght()` method which gives you the
length of a string.

```
jshell> String blah = "Blah blah blah";
blah ==> "Blah blah blah"

jshell> System.out.println(blah.length());
14
```

The `.length()` method returns an int.

#### .isEmpty() Method

Next we'll look at the `isEmpty()` method. This method tells us if the string
is or isn't empty. This method returns a bool (true or false).

```
jshell> String blah = "Blah blah blah";
blah ==> "Blah blah blah"

jshell> System.out.println(blah.isEmpty());
false

jshell> String fart = "";
fart ==> ""

jshell> System.out.println(fart.isEmpty());
true
```

But notice if we fail to define `fart` entirely then we'll get an exception
using the `isEmpty()` method.

```
jshell> String fart;
fart ==> null

jshell> System.out.println(fart.isEmpty());
|  Exception java.lang.NullPointerException: Cannot invoke "String.isEmpty()" because "REPL.$JShell$18.fart" is null
|        at (#9:1)
```

#### .toUpperCase() Method

Just as it sounds, this method converts a string to all upper case.

```
jshell> String blah = "Blah blah blah";
blah ==> "Blah blah blah"

jshell> System.out.println(blah.toUpperCase());
BLAH BLAH BLAH
```

#### .toLowerCase() Method

Likewise, there is a `.toLowerCase()` method as well that converts a string to
all lowercase.

```
jshell> String blah = "Blah BLAH Blah";
blah ==> "Blah BLAH Blah"

jshell> System.out.println(blah.toLowerCase());
blah blah blah
```

#### .equals() Method

Previously, we discussed the difference between the string literal and the
object string. And we showed how if you compare the two using the `==` operator
we'll get false. However, if we want to just compare the value of the strings
to see if they match we can use the `.equals()` method for string comparison.

```
jshell> String string1 = new String("abc");
string1 ==> "abc"

jshell> String string2 = new String("abc");
string2 ==> "abc"

jshell> System.out.println(string1 == string2);
false

jshell> System.out.println(string1.equals(string2));
true
```

#### .equalsIgnoreCase() Method

If you want to do the same as above but ignoring the case of the variables,
well you're in luck because there's a method for you.

```
jshell> String string1 = new String("abc");
string1 ==> "abc"

jshell> String string2 = new String("ABC");
string2 ==> "ABC"

jshell> System.out.println(string1.equalsIgnoreCase(string2));
true
```

#### .replace() Method

The `.replace()` method is useful for replacing a substring within a larger
string.

```
jshell> String string = "The sky is blue.";
string ==> "The sky is blue."

jshell> System.out.println(string.replace("blue", "red"));
The sky is red.

jshell> System.out.println(string);
The sky is blue.
```

But notice `.replace()` doesn't affect the value of the original string.

#### .contains() Method

The `.contains()` returns a bool and tells you whether or not a string contains
a certain substring.

```
jshell> String string = "The sky is blue.";
string ==> "The sky is blue."

jshell> System.out.println(string.contains("blue"));
true

jshell> System.out.println(string.contains("fart"));
false

jshell> System.out.println(string.contains(""));
true
```

Notice to java, all strings contain an empty string. So that is NOT a
sufficient test for telling whether or not a string is empty in java! Instead,
use the `.isEmpty()` method discussed above.

#### More Methods

You can find a list of more java sting methods linked below!

[Java String Methods](https://www.w3schools.com/java/java_ref_string.asp)


## User Input

The ability to take user submitted input is an instrumental part of
programming. Unlike other simpler languages, taking user input in java once
again requires more boiler plate code than you might be used to.

* `UserInput.java`

```
import java.util.Scanner;

class UserInput {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        System.out.printf("Hello, %s!\n", name);

        System.out.print("How old are you? ");
        int age = scanner.nextInt();

        // Clears input buffer
        scanner.nextLine();

        System.out.printf("%d is an excellent age to start programming!\n", age);

        scanner.close();
    }
}
```

To take user input in java we can use something called a scanner object. The
`Scanner` is a pre-written java class so we have to first import it at the top
of our program. We can use the `new` keyword to create a new scanner object
from the `Scanner` class.

Then to actually take user input we run the scanner over whatever was supplied
via stdin using the `.nextLine()` method and save it to the `name` variable.
Same when taking in an integer, we use the `.nextInt()` method of the scanner
object.

One other thing worth noting about the above code is we're using the
`.printf()` string method for the first time here to format our output sting.

Lastly, we have to close the scanner object when we're done using it.

### .nextInt() Method Caveat

You'll notice in the above there is a line after we call the `.nextInt()`
method where we just call `.nextLine()` without saving the results to a
variable or doing anything with them.

This is because the `.nextInt()` method leaves a newline carriage return in the
input buffer after taking an int. If we fail to properly flush this floating
newline it will mess up any additional calls we might make to `.nextLine()` to
take user input by feeding an enter char before the user inputs anything.

One way to avoid this is to just take all user input using `.nextLine()` and
then explicitly cast any ints or bools or floats to their required types.


## Conditional Statements

Conditional statements are a fundamental part of computer programming.
Conditional statements allows us to make branching programs which take
advantage of some of the operators we learned earlier.

### If, Else If, & Else

In the example below we'll use what's known as an if statement in conjunction
with the user input code we learned about previously.

* `IfElseStatements.java`

```
import java.util.Scanner;

class IfElseStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example Simple Calculator

        System.out.print("Enter first number: ");
        Double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        Double num2 = scanner.nextDouble();

        // Cleanup input buffer
        scanner.nextLine();

        System.out.print("What operation would you like to preform? (+,-,*,/): ");
        String opt = scanner.nextLine();

        if (opt.equals("+")) {
            System.out.printf("%f + %f = %f\n", num1, num2, num1 + num2);
        } else if (opt.equals("-")) {
            System.out.printf("%f - %f = %f\n", num1, num2, num1 - num2);
        } else if (opt.equals("*")) {
            System.out.printf("%f * %f = %f\n", num1, num2, num1 * num2);
        } else if (opt.equals("/")) {
            System.out.printf("%f / %f = %f\n", num1, num2, num1 / num2);
        } else {
            System.out.println("Invalid Operation!");
        }

        scanner.close();
    }
}
```

The main conditional keywords are `if`, `else if`, and `else`. They work pretty
much the same as in other programming languages; the lines inside of the if
statement's code block are only execute if the conditional statement evaluates
to true.

So in the above example we take some user input. If the string entered by the
user is one of the accepted operators then that corresponding arithmetic
operation will be preformed on the supplied numbers.


### Switch Statement

Similar to `if` statements, `switch` statements (sometimes called case
statements) are long chains of conditionals. You could represent any switch
statement as a long chain of if else statements. However, switch statements are
optimized for this exact case and are treated differently by the JVM.

* `SwitchStatments.java`

```
import java.util.Scanner;

class SwitchStatments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example Simple Calculator

        System.out.print("Enter first number: ");
        Double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        Double num2 = scanner.nextDouble();

        // Cleanup input buffer
        scanner.nextLine();

        System.out.print("What operation would you like to preform? (+,-,*,/): ");
        String opt = scanner.nextLine();

        switch (opt) {
            case "+":
                System.out.printf("%f + %f = %f\n", num1, num2, num1 + num2);
                break;
            case "-":
                System.out.printf("%f - %f = %f\n", num1, num2, num1 - num2);
                break;
            case "*":
                System.out.printf("%f * %f = %f\n", num1, num2, num1 * num2);
                break;
            case "/":
                System.out.printf("%f / %f = %f\n", num1, num2, num1 / num2);
                break;
            default:
                System.out.println("Invalid Operation!");
        }

        scanner.close();
    }
}
```

You can see, similar to our if else ladder, the switch statement allows us to
consider a number of different options for the operator value as well as a
`default` option if no other options are met.

In my humble opinion the above switch statement implementation of the basic
calculator is easier/nicer to read than the if else version. The if else
version might look a little more compact. However, that is harder on the eyes
and can obscure the actual conditional operation being considered. Also as
discussed above, the switch statement is faster!


## Arrays

Arrays are a powerful data-structure in Java! They allow the programmer to
store an ordered collection of things. Just like every over variable in Java
arrays have to be declared before they can be used. When declaring an array in
Java you must specify its type and size. Then when inserting values into the
array you must specify an index.

* `Vowels.java`

```
import java.util.Arrays;

class Vowels {
    public static void main(String[] args) {
        char vowels[] = new char[5];

        vowels[0] = 'a';
        vowels[1] = 'e';
        vowels[2] = 'i';
        vowels[3] = 'o';
        vowels[4] = 'u';

        System.out.println(Arrays.toString(vowels));
    }
}
```

In the above code we're using the builtin Java `Arrays` library in order to
print out our character array as a string.

In Java arrays have an index starting at zero. So the above `vowels[]` array
can store five chars and we can reference their position in the array as 0-4.

Alternatively, you can also assign the values / width of the array on the same
line where you initialize the array.

```
jshell> import java.util.Arrays;

jshell> char vowels[] = {'a', 'e', 'i', 'o', 'u'};
vowels ==> char[5] { 'a', 'e', 'i', 'o', 'u' }

jshell> System.out.println(Arrays.toString(vowels));
[a, e, i, o, u]
```

We can see the length of an array using the `.length` property.

```
jshell> System.out.println(vowels.length);
5
```

Don't get this confused with the `.length()` string method we discussed
earlier. In the case of arrays, length is just a property (aka no need for the
() after length for an array).

### Arrays.sort() Method

One of the builtin methods of the arrays library we imported is the `.sort()`
method. In the case of our character array this will be sorted alphabetically.
For example,

```
jshell> import java.util.Arrays;

jshell> char vowels[] = {'u', 'o', 'i', 'e', 'a'};
vowels ==> char[5] { 'u', 'o', 'i', 'e', 'a' }

jshell> Arrays.sort(vowels);

jshell> System.out.println(Arrays.toString(vowels));
[a, e, i, o, u]
```

The `.sort()` also accepts two additional optional position arguments, if
you're interested in sorting just a sub section of the array.

### Arrays.binarySearch() Method

If we want to find a value within our array we can take advantage of the
`Arrays.binarySearch()` method to find our value using a binary search
algorithm.

```
jshell> import java.util.Arrays;

jshell> char vowels[] = {'u', 'o', 'i', 'e', 'a'};
vowels ==> char[5] { 'u', 'o', 'i', 'e', 'a' }

jshell> Arrays.sort(vowels);

jshell> System.out.println(Arrays.toString(vowels));
[a, e, i, o, u]

jshell> int characterPosition = Arrays.binarySearch(vowels, 'o');
characterPosition ==> 3
```

An important thing to note is that binary search only works on a sorted array!
So in the sorted array the `o` character is at position 3.

If the `.binarySearch()` method ever returns a negative number you know that
the value you're searching for is not within your array, or your array is not
sorted.

### Arrays.fill() Method

Say we have an array and we want to populate all of the positions in it with
the same value. In Java, we can accomplish this using the `Arrays.fill()`
method.

```
jshell> import java.util.Arrays;

jshell> char xes[] = new char[5];
xes ==> char[5] { '\000', '\000', '\000', '\000', '\000' }

jshell> Arrays.fill(xes, 'x');

jshell> System.out.println(Arrays.toString(xes));
[x, x, x, x, x]
```

Like the `.sort()` method, the `.fill()` method also accepts two additional
optional positional arguments if you're interested in filling just a sub
section of the array.

```
jshell> import java.util.Arrays;

jshell> char oes[] = new char[5];
oes ==> char[5] { '\000', '\000', '\000', '\000', '\000' }

jshell> Arrays.fill(oes, 2, 4, 'o');

jshell> System.out.println(Arrays.toString(oes));
[, , o, o, ]
```

### Arrays.copyOf() Method

In Java you can assign multiple names to the same array. That is, if you
initialize an array, populate it, and then assign that array to another array
name, you've essentially just created two labels for the same underlying array.

For example,

```
jshell> import java.util.Arrays;

jshell> int nums[] = {1, 2, 3, 4, 5};
nums ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int numsAgain[] = nums;
numsAgain ==> int[5] { 1, 2, 3, 4, 5 }

jshell> nums[2] = 77;
$19 ==> 77

jshell> System.out.println(Arrays.toString(nums))
[1, 2, 77, 4, 5]

jshell> System.out.println(Arrays.toString(numsAgain))
[1, 2, 77, 4, 5]
```

You can see instead of copying `nums` to `numsAgain` all we've really done is
created two variable names for the same underlying array.

To actually take the values in one array and reassign them to a completely new
and separate array in Java you have to use the `.copyOf()` Arrays method.

```
jshell> import java.util.Arrays;

jshell> int nums[] = {1, 2, 3, 4, 5};
nums ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int numsAgain[] = Arrays.copyOf(nums, nums.length);
numsAgain ==> int[5] { 1, 2, 3, 4, 5 }

jshell> nums[2] = 77;
$24 ==> 77

jshell> System.out.println(Arrays.toString(nums))
[1, 2, 77, 4, 5]

jshell> System.out.println(Arrays.toString(numsAgain))
[1, 2, 3, 4, 5]
```

You can now see the changes made to the `nums[]` array did not affect the
values stored in the `numsAgain[]` array.

One thing worth nothing about the above code is that the `.copyOf()` method is
initializing a new array an so you must specify an array length as well. In
this case since we're just making a 1 to 1 copy we can just use the
`num.length` or the original array.

### Arrays.copyOfRange() Method

Similar to the `.copyOf()` method, there is a `.copyOfRange()` range method as
well for copying a sub section of an array to a new separate array.

```
jshell> import java.util.Arrays;

jshell> int nums[] = {1, 2, 3, 4, 5};
nums ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int someNums[] = Arrays.copyOfRange(nums, 1, 3);
someNums ==> int[2] { 2, 3 }

jshell> System.out.println(Arrays.toString(nums))
[1, 2, 3, 4, 5]

jshell> System.out.println(Arrays.toString(someNums))
[2, 3]
```

### Arrays.equals() Method

The last array method we'll cover is the `.equals()` method. If we try to
compare two arrays that are copies of each other but occupy different memory
space then we'll have to use the `.equals()` method. The normal java equality
operator `==` will only work if the two array names are references to the same
underlying array. But for a true comparison of array values you must use the
`.equals()` method.

```
jshell> int nums[] = {1, 2, 3, 4, 5};
nums ==> int[5] { 1, 2, 3, 4, 5 }

jshell> int copyOfNums[] = Arrays.copyOf(nums, nums.length);
copyOfNums ==> int[5] { 1, 2, 3, 4, 5 }

jshell> System.out.println(Arrays.equals(nums, copyOfNums));
true

jshell> System.out.println(nums == copyOfNums);
false
```


## Loops

I've said it before and I'll say it again, loops are a fun-damental part of
programming! 

### For Loops

Forloops are used to run over every value in a list and do something
accordingly. Java has a similar forloop syntax to C. 

There are a few basic parts to a forloop. First, there is the loop
initialization (below `int i = 1;`). That sets the loop variable to its initial
condition. Next there is the condition itself (below `i <= 10;`). This part is
evaluated at the start of every loop. If it is true, the code within the loop
body is triggered. And finally, there is the loop update (below `i++`). This
part is triggered after every loop and adjusts the loop variable as needed.

* `ForLoops.java`

```
class ForLoops {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
```

* `Output`

```
> javac ForLoops.java
> java ForLoops 
1
2
3
4
5
6
7
8
9
10
```

#### Forloops and Iterables

We can use our forloop in conjunction with the arrays we learned about
previously to automatically loop over the values in an array with some
conditional imposed.

For example,

```
jshell> int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}
nums ==> int[9] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }

jshell> for (int i = 3; i < nums.length; i++){
   ...>     System.out.println(nums[i]);
   ...> }
4
5
6
7
8
9
```

In the above example we loop over the array `nums[]` but only for the values
above our index `i`, which we initialize at position 3. So only numbers after
position 3 in our array are printed.

### While loops

Less common than the forloop, but still very powerful, is the while loop. While
loops are loops that run ad\-infinitum until some ultimate condition is met.

* `WhileLoops.java`

```
class WhileLoops {
    public static void main(String[] args) {
        int num = 5;
        int multiplier = 1;

        while(multiplier <= 10) {
            System.out.printf("%d X %d = %d\n", num, multiplier, num * multiplier);
            multiplier++;
        }
    }
}
```

As you can see, the while loop only allows the programmer to specify a
condition to be checked. The update statement and initialization must be done
outside of the while loop statement.

### Do While Loops

Similar to the while loop, there is something called the do while loop. The
difference between the while loop and the do while loop is that with the do
while loop the condition is not checked until after the loop body is run.

* `DoWhileLoops.java`

```
class DoWhileLoops {
    public static void main(String[] args) {
        int num = 5;
        int multiplier = 1;

        do {
            System.out.printf("%d X %d = %d\n", num, multiplier, num * multiplier);
            multiplier++;
        } while(multiplier <= 10);
    }
}
```

In the case above the output is the same. However, the order the code is
executed in is not.


## Array Lists

We have already gone over arrays. When we did we saw how they are of fixed
length and the only real way to resize them is to copy them to a new larger /
smaller array. Java also has another similar data structure called an array
list. Array lists are like dynamically sized arrays, that also have some other 
nice features.

* `ArrayLists.java`

```
import java.util.ArrayList;

class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        System.out.println(nums.toString());
    }
}
```

To use array lists we have to first import the `ArrayList` library. From there
we can initialize a new array list using the `<Integer>` wrapper class. The
`<Integer>` wrapper class is just the reference type form of the primitive
`int` type. 

Once we have our array list we can use the `.add()` method to put values in the
list.

Finally, the `num` array list can be printed using the builtin `.toString()`
method.

### Array Lists .get() Method

We can use the `.get()` method of an array list to fetch values from our list
by index. For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Character> alpha = new ArrayList<Character>();
alpha ==> []

jshell> alpha.add('a');
$3 ==> true

jshell> alpha.add('b');
$4 ==> true

jshell> alpha.add('c');
$5 ==> true

jshell> alpha.add('d');
$6 ==> true

jshell> alpha.add('e');
$7 ==> true

jshell> System.out.println(alpha.get(2));
c
```

### Array Lists .remove() Method

We can use the `.remove()` method to take values out of our array list. If
called with a primitive type like int the `.remove()` method will delete the
value at the specified index.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Character> alpha = new ArrayList<Character>();
alpha ==> []

jshell> alpha.add('a');
$3 ==> true

jshell> alpha.add('b');
$4 => true

jshell> alpha.add('c');
$5 ==> true

jshell> alpha.add('d');
$6 ==> true

jshell> alpha.add('e');
$7 ==> true

jshell> alpha.remove(1);
$8 ==> 'b'

jshell> System.out.println(alpha.toString());
[a, c, d, e]
```

However, you can also pass a reference type to the `.remove()` method, in which
case it will delete by value instead of index.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Character> alpha = new ArrayList<Character>();
alpha ==> []

jshell> alpha.add('a');
$3 ==> true

jshell> alpha.add('b');
$4 ==> true

jshell> alpha.add('c');
$5 ==> true

jshell> alpha.add('d');
$6 ==> true

jshell> alpha.add('e');
$7 ==> true

jshell> alpha.remove(Character.valueOf('c'));
$8 ==> true

jshell> System.out.println(alpha.toString());
[a, b, d, e]
```

### Array Lists .set() Method

If we would like to update the value at a particular position within the array
list we can use the `.set()` method.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Character> alpha = new ArrayList<Character>();
alpha ==> []

jshell> alpha.add('a');
$3 ==> true

jshell> alpha.add('b');
$4 ==> true

jshell> alpha.add('c');
$5 ==> true

jshell> alpha.add('d');
$6 ==> true

jshell> alpha.add('e');
$7 ==> true

jshell> alpha.set(2, 'x');
$8 ==> 'c'

jshell> System.out.println(alpha.toString());
[a, b, x, d, e]
```

### Array Lists .sort() Method

We can use the `.sort()` method to sort array lists.

For example,

```
jshell> import java.util.ArrayList;

jshell> import java.util.Comparator;

jshell> ArrayList<Integer> nums = new ArrayList<Integer>();
nums ==> []

jshell> nums.add(5);
$3 ==> true

jshell> nums.add(77);
$4 ==> true

jshell> nums.add(9);
$5 ==> true

jshell> nums.add(1000);
$6 ==> true

jshell> nums.add(13);
$7 ==> true

jshell> nums.sort(Comparator.naturalOrder());

jshell> System.out.println(nums.toString());
[5, 9, 13, 77, 1000]

jshell> nums.sort(Comparator.reverseOrder());

jshell> System.out.println(nums.toString());
[1000, 77, 13, 9, 5]
```

You'll notice in the above we have to first import the `Comparator` class. This
allows us to pass a comparator object that's been invoked with the
`naturalOrder()` method to the `.sort()` array list method. The `.sort()` array
needs to know how to sort the array list. The comparator object tells it that.

Likewise, off of this comparator object we can also call other methods. If we
don't want to sort by natural order we can sort by `.reverseOrder()`. I leave
it up to you to guess what that one does.

### Array Lists .size() Method

This ones very simple, it just spits out the number of elements in the array
list.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Integer> nums = new ArrayList<Integer>();
nums ==> []

jshell> nums.add(1);
$3 ==> true

jshell> nums.add(2);
$4 ==> true

jshell> nums.add(3);
$5 ==> true

jshell> nums.add(4);
$6 ==> true

jshell> System.out.println(nums.size());
4
```

### Array Lists .contains() Method

This method will return true or false if a value is contained within the array
list.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Integer> nums = new ArrayList<Integer>();
nums ==> []

jshell> nums.add(1);
$3 ==> true

jshell> nums.add(2);
$4 ==> true

jshell> nums.add(3);
$5 ==> true

jshell> nums.add(4);
$6 ==> true

jshell> System.out.println(nums.contains(3));
true

jshell> System.out.println(nums.contains(77));
false
```

### Array Lists .isEmpty() Method

Just like with the string methods, you cannot reliably use `.contains()` to
tell if an array list is empty. Instead for that purpose there is a specific
`.isEmpty()` method.

For example,

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Integer> nums = new ArrayList<Integer>();
nums ==> []

jshell> System.out.println(nums.isEmpty());
true

jshell> nums.add(77);
$4 ==> true

jshell> System.out.println(nums.isEmpty());
false
```

### Array Lists .forEach() Method

If you want to do a forloop over everything inside of an array list, there's a
method for that. The `.forEach()` method works as follows.

```
jshell> import java.util.ArrayList;

jshell> ArrayList<Integer> nums = new ArrayList<Integer>();
nums ==> []

jshell> nums.add(1);
$3 ==> true

jshell> nums.add(2);
$4 ==> true

jshell> nums.add(3);
$5 ==> true

jshell> nums.add(4);
$6 ==> true

jshell> nums.forEach(num -> {
   ...>     System.out.println(num * 2);
   ...> });
2
4
6
8
```












