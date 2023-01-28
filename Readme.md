# Intro to Java


## Overview

This Readme is a series of notes on the fundamentals of Java programming that
I've taken while watching the [freeCodeCamp](https://www.freeCodeCamp.org)
tutorial below.

[Java Programming for Beginners](https://youtu.be/A74TOX803D0)

They're using some silly web-IDE to write code in the tutorial. I am not about
that life. My tools are vim, terminal, jdk-17, java, javac, and jshell.


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

So for example 

#### More about "main" Method

The JVM looks for a main method that meets the following criteria.

`public static void main(String[] args)`

* Static Method (static)
* Named main
* Has public access (public)
* Takes a string array arg (String[])
* And doesn't return any value (void)

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

However, the variable weight is considered globally scoped, meaning any other
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

Technically you can start a variable name with a $ or a _. However, that is
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


There are some other things worth noting due to java's typing.

### Integer Division

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
    +=  Plus Equals
    -=  Minus Equals
    *=  Multiply Equals
    /=  Divide Equals
    %=  Mod Equals
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
    ==  Equality Operator
    !=  Inequality Operator
    >   Greater Than Operator
    <   Less Than Operator
    >=  Greater Than or Equal To Operator
    <=  Less Than or Equal To Operator
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

jshell> System.out.println(num++);
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

jshell> System.out.println(++num);
8
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



