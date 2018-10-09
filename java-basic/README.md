
# Java - Basic

**This example show you how to use java basic concepts. ** 
  

*   collections
*   mutable VS inmmutable objects
*	overloading, overriding, polymorphism
*	theads

  

------------------------------------------------------------


# TIPOS DE DATOS (VARIABLES) EN JAVA.

![altText](src/main/resources/java_types.jpg "Tipos de datos en Java") 

  

# Modificadores de acceso en Java


*   **private** 

> El modificador private en Java es el más restrictivo de todos, básicamente cualquier elemento de una clase que sea privado puede ser accedido únicamente por la misma clase por nada más. Es decir, si por ejemplo, un atributo es privado solo puede ser accedido por lo métodos o constructores de la misma clase. 


*   **default**

> Java nos da la opción de no usar un modificador de acceso y al no hacerlo, el elemento tendrá un acceso conocido como defaulto acceso por defecto que permite que tanto la propia clase como las clases del mismo paquete accedan a dichos componentes
 
*	**protected** 

> El modificador de acceso protected nos permite acceso a los componentes con dicho modificador desde la misma clase, clases del mismo paquete y clases que hereden de ella (incluso en diferentes paquetes).

*	**public**

> El modificador de acceso public es el más permisivo de todos, básicamente public es lo contrario a private en todos los aspectos (lógicamente), esto quiere decir que si un componente de una clase es public, tendremos acceso a él desde cualquier clase o instancia sin importar el paquete o procedencia de ésta.
 


![Modificadores de acceso en java](src/main/resources/modificadores_acceso.png "Modificadores de acceso en java") 

------------------------------------------------------------


_

**Herencia**  

La idea de la herencia es permitir la creación de  nuevas clases basadas en clases existentes.
Cuando heredamos de una clase existente, reusamos  (o heredamos) métodos y campos, y agregamos nuevos campos y métodos para cumplir con la situación nueva.
Cada vez que encontremos la relación "es-un" entre dos clases, estamos ante la presencia de herencia.

La clase ya existente es llamada superclass, o clase base, o clase padre.
La clase nueva es llamada subclase, clase derivada, o clase hija.

A través de la herencia podemos agregar nuevos campos, y podemos agregar o sobre montar métodos (override). Sobre montar un método es redefinirlo en la case heredada.


**Polimorfismo**  
 
En Java una variable o nombre usado para referirse a un objeto de una clase X puede usarse para referirse a cualquier objeto de cualquier subclase de la clase X.


**Clases Abstractas (abstract classes)**   

Llevando la idea de herencia a un extremo podemos pensar en buenas clases para representar un grupo pero que no tienen instancias propias. Por ejemplo Forma como clase base de Triangulo, Circulo, Cuadrado. Forma puede indicar todo el comportamiento válido para una forma pero no puede instanciarse por si mismo. En ente caso Forma debe declararse como clase abstracta por tener al menos un método declarado pero no implementado.

_ 

  

## Difference between an Interface and an Abstract class.  
  
*   Methods of a Java interface are implicitly abstract and cannot have implementations.  
	A Java abstract class can have instance methods that implements a default behaviour.
*   Variables declared in a Java interface are by default final. 
	An abstract class may contain non-final variables.
*	Members of a Java interface are public by default. 
	A Java abstract class can have the usual flavours(Access modifiers) of class members like private, protected, etc.
*	A Java interface should be implemented using keyword “implements”; 
	A Java abstract class should be extended using keyword “extends”.
*	An interface can extend another Java interface only. 
	An abstract class can extend another Java class and implement multiple Java interfaces.
*	A Java class can implement multiple interfaces but it can extend only one abstract class.



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

**interface: ** To implement a contract by multiple unrelated objects

**abstract class: **  To implement the same or different behaviour among multiple related objects
_ 




