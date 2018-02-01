
# Java - Basic

**This example show you how to use java basic concepts. ** 
  

*   collections
*   mutable VS inmmutable objects
*	overloading, overriding, polymorphism
*	theads

  
  
  

------------------------------------------------------------

## Difference between an Interface and an Abstract class.

  
>   
	Methods of a Java interface are implicitly abstract and cannot have implementations. 
	A Java abstract class can have instance methods that implements a default behaviour.

    Variables declared in a Java interface are by default final. An abstract class may contain non-final variables.

    Members of a Java interface are public by default. A Java abstract class can have the usual flavours of class members like private, protected, etc.

    A Java interface should be implemented using keyword “implements”; A Java abstract class should be extended using keyword “extends”.

    An interface can extend another Java interface only, an abstract class can extend another Java class and implement multiple Java interfaces.

    A Java class can implement multiple interfaces but it can extend only one abstract class.



_
> Oracle website provides key differences between interface and abstract class.

Consider using abstract classes if :

    You want to share code among several closely related classes.
    You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
    You want to declare non-static or non-final fields.

Consider using interfaces if :

    You expect that unrelated classes would implement your interface. For example,many unrelated objects can implement Serializable interface.
    You want to specify the behaviour of a particular data type, but not concerned about who implements its behaviour.
    You want to take advantage of multiple inheritance of type.

In simple terms, I would like to use

**interface: To implement a contract by multiple unrelated objects** 

**abstract class: To implement the same or different behaviour among multiple related objects**  
_ 




