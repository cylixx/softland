
# Java - Basic

**This example show you how to use java basic concepts. ** 
  

*   collections
*   mutable VS inmmutable objects
*	overloading, overriding, polymorphism
*	theads

  

------------------------------------------------------------


# TIPOS DE DATOS (VARIABLES) EN JAVA.

![Optional Text](/java_types.jpg)
![alt text](https://lh3.googleusercontent.com/hRueCaz5s9g02I5e6Mem856vbwJVHToZSkTCTcIoe5zHRFl2L9Pty_ukgQMpz0gY3zFqI2XSz44mmka21aLNn4F6hCMIYbP9JGyoHjGD-MloF67goRJXBxL0q425gtAsGJVKo_Vc9zWaOKJVTCqIW7rpNkef-a3K6-nnMKuQ3SXavksl16AYMCr8k5D39jLtqvY-4t9i8plbfvEtzwmYj-rBekuWlDiUg1hWUzKVTMMsqIVFF16AibEAF5TUOnvV1mgoz7IownisxBYzJSHAzsKflse7-pPlVjgRy6hpUXeHerUmEXQA9doua7sg8r0NjAEEEa4FIwiHGZRzhNJzNlUkgt5a1eMssM9wgyER7o4UVsMW7IhHhB_IxxbtgKMj2lgRfNgQ7KUmUxb_J7kr1qf6OkbVDFK-W9B884-YlFnG7N0h4YbVDaUZWZLeWyUg8W8JwJPxG_B1oCDcRcujEGm1gkP7vYVBdfS9RkwU6s_P8wQdHNaLvWxWATPgYLxxhj7Ts1YHkxkW48k87gff3ms0hYe3Z3atKHy-x_SSOm0QrNXLgr-t_lOFfnk0tTwPCKNbM5BN14rKPgYuhm-fiFSSTcZMHisRzDULb_Tr3h7ADlu_FufB=w607-h882-no)

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




