# Intro to Java


## Overview

This Readme is a series of notes on the fundamentals of Java programming that
I've taken while watching the [freeCodeCamp](https://www.freeCodeCamp.org)
tutorial below.

[Java Programming for Beginners](https://youtu.be/A74TOX803D0)

They're using some silly web-IDE to write code in the tutorial. I am not about
that live. My tools are vim, terminal, jdk-17, java, javac.


## Hello World

Below is the code for the hello world program in java.

```
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Java has a more "boiler-plate" code as compared to other programming languages.


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

For example, with the code below the conversion from an into a double is
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

However, if we were to try that conversion the other way, from double to int,
we would get an error like the following at compile time.

```
> javac TypeConversion.java
error: incompatible types: possible lossy conversion from double to int
```

That's because the Java compiler would have to snip off the info after the
decimals place in order to cram it into an int.

Now java can do this conversion, however it has to be told to it explicitly. We
can do so in java using a cast operator like so

* `TypeConversion.java`

```
class TypeConversion {
    public static void main(String[] args){
        int num1 = 5;
        double num2 = num1;

        double num3 = 1.234;
        int num4 = (int)num3;

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























