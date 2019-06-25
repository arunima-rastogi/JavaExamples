# JavaExamples
basic java concepts and examples

# Liskov substitution principle
Before JDK 5, When we override a parent class method, the name, argument types and return type of the overriding method in child class has to be exactly same as that of parent class method.

Java 5.0 onwards it is possible to have different return type for a overriding method in child class, but child’s return type should be sub-type of parent’s return type.

Overriding method becomes co-variant with respect to return type.  Such Co-variant return type is based on # Liskov substitution principle.



