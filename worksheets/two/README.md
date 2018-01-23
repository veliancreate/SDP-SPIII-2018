# Worksheet Two on Reflection

The Reflection API allows a JVM based program to inspect and manipulate itself; 
it comprises the `KClass` and `Class` classes together with the `kotlin.reflect` and 
`kotlin.reflect.jvm` packages; the latter is for interoperability with Java.

1. Write a Kotlin program that reads the name of a class from the command line and 
emits the interface of the class (interface or class, modifiers, constructors, methods, fields; no method bodies). 
  
    Hint: You can load a class whose name you know with `Class.forName()`. 
 The `Class` class offers a rich interface that enables you to inspect the 
 interface of any class.

    Apply this program to a set of classes and interfaces as test input. 
 You may also use the program on itself. 
 You should see how a Java program behaves when provided as an argument to this program.

2. Write a program that reads a class name and a list of arguments, 
and creates an object of that class where the arguments are passed to the constructor.

	Hint: Treat arguments as strings. 
	A `Class` can enumerate its constructors. 
    Choose a constructor with the appropriate parameter count. 
    Then, find the parameter types. 
    To create typed argument objects, call the appropriate constructors that take a 
    string as their only argument. 
    
3. Write a `JUnit` test to help grade the internal correctness of a student's submitted 
program for a hypothetical assignment.

    Make the tests fail if the class under test has any of the following:
    + more than four fields,
    + any non-private fields,
    + any fields of type `MutableList` ([https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)),
    + fewer than two `private` helper methods,
    + any method that has a `throws` clause,
    + any method that returns an `Int`, or
    + missing a zero-argument constructor.	

4. Normally it is up to the programmer to write a *tailored* `toString()` method for each class one creates. 
As part of the reflection API, it is possible to find out which fields exist for a given object, 
and to get their values. 

    The purpose of this exercise is to make a `toString` method 
that gives a printed representation of any object, in such a manner that 
all fields are printed, 
and references to other objects are handled as well. 
To solve this exercise, you will need to examine the reflection API in detail. 
