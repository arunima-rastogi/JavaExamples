﻿# JavaExamples
basic java concepts and examples

# Solid Principles
    1. Single responsibility
    2. Open–closed
    3. Liskov substitution
    4. Interface segregation
    5. Dependency inversion

# Liskov substitution principle
Before JDK 5, When we override a parent class method, the name, argument types and return type of the overriding method in child class has to be exactly same as that of parent class method.

Java 5.0 onwards it is possible to have different return type for a overriding method in child class, but child’s return type should be sub-type of parent’s return type.

Overriding method becomes co-variant with respect to return type.  Such Co-variant return type is based on # Liskov substitution principle.






# Reflection API
Java Reflection provides ability to inspect and modify the runtime behavior of application. Using java reflection one can inspect a class, interface, enum, get their structure, methods and fields information at runtime even though class is not accessible at compile time. We can also use reflection to instantiate an object, invoke it’s methods, change field values.
