
# Algorithms

_Big O notation._ 
Es una anotacion que nos dice que tan rapido un algoritmo es.
Es el tiempo de ejecución de un programa.
Big O no te dice la velocidad en segundos. _La notación Big O te permite comparar el número de operaciones_ . Eso te dice qué tan rápido crece el algoritmo.
La notacion "Big O" nos dice el número de operaciones que un algoritmo hará. 
En Big O notation es acerca del peor escenario osea O(n).

Notacion de Big O  --> O(n)
Donde:
O = "Big O"
n = Numero de operaciones


Log = Log
		 2
		 
Ejemplo:
	log	   8 = 3
		2
		
		

Aquí hay cinco tiempos de ejecución de Big O que encontrarás mucho, ordenados de más rápido a más lento:

• O(log n), also known as log time. Example: Binary search.
• O(n), also known as linear time. Example: Simple search.
• O(n * log n). Example: A fast sorting algorithm, like quicksort
(coming up in chapter 4).
• O(n 2 ). Example: A slow sorting algorithm, like selection sort
(coming up in chapter 2).
Nota: es O(n al cuadrado)
• O(n!). Example: A really slow algorithm, like the traveling
salesperson (coming up next!).


La velocidad del algoritmo no se mide en segundos, sino en el crecimiento del Número de operaciones.
• En su lugar, hablamos de la rapidez con que se ejecuta el algoritmo.
Aumenta a medida que aumenta el tamaño de la entrada.
• El tiempo de ejecución de los algoritmos se expresa en notación Big O.
• O (log n) es más rápido que O (n), pero se vuelve mucho más rápido a medida que la lista de elementos de tu búsqueda crece.


_Resumen Big O_ 
• La búsqueda binaria es mucho más rápida que la búsqueda simple.
• O (log n) es más rápido que O (n), pero se vuelve mucho más rápido una vez que la lista de Los artículos que estás buscando crecen.
• La velocidad del algoritmo no se mide en segundos.
• Los tiempos de los algoritmos se miden en términos de crecimiento de un algoritmo.
• Los tiempos de los algoritmos están escritos en notación Big O.
		
		 
**Busqueda binaria** 
Esta busqueda solo funciona cuando la lista esta ordenada.
Usa el logaritmo base 2, por ejemplo si tenemos un conjunto de 8 elemntos y queremos buscar uno, en el peor de los casos tenemos que hacer n busquedas(8 para ser precisos), en la busqueda bianria esto se reduce a 3, que es el resulado de el logaritmo base 2 de 8 igual a 3. Esto se puede comprobar porque 2 elevado a la 3 potencia da como resultado 8.

Busqueda simple tiene un logaritmo:
Linel Time (Big O notation) = O(n)

Busqueda binaria liene un logaritmo:
Logarithmic Time (Big O noration)= O(Log n)

Tiempo lineal = O(n) 
Es el maximo numero de adivinansas para encontrar el elemnto en una lista ordenada de elementos.
Por ejemplo:
   List[256] = Tiempo lineal es 256  --> O(256)

Con el algoritmo binario seria:  O(8)
O(Log 256) = 8
     2   
   
   







