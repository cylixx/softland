package com.softland.example.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//import org.apache.commons.lang3.ArrayUtils;

/**
 * @author cylixx
 *
 *
//---------  Arithmetic Operators  --------------------
/ 	Division 	Divides one value by another 	x / y 	 Example:  12 / 3 = 4
% 	Modulus 	Returns the division remainder 	x % y    Example:  5 % 2 = 1


//---------------------- convertion between Array, List and Set ------------------------------

String[] stringArray = {"NRE", "NRO", "FCNR", "RFC", "NRE"};
List<String> list = Arrays.asList(stringArray);  //convert Array to List
HashSet<String> setOfAccounts = new HashSet<>(Arrays.asList(stringArray));  // String[] to HashSet<String>  (remove duplicates)
long upper = Arrays.stream(stringArray).filter( wo -> wo.equals(wo.toUpperCase()) ).count(); // para recorrer un String[]  Array

String cad = "La CASA del lago";
long upper = cad.chars().filter(c -> Character.isUpperCase(c)).count();  // para recorrer los caracteres de un String


int[] a = { 1, 5, 12, 3, -15, 52 };
Arrays.toString(a);   //return a String representation of the Array
Arrays.stream(a);  //Returns a sequential DoubleStream with the specified array as its source. --- Para recorrer un array
Arrays.sort(a);  // sorts the array in ascending order

Set<Integer> setA = Arrays.stream( a ).boxed().collect(Collectors.toSet());  // int[] Array  to  Set<Integer>
int[] intArray = setA.stream().mapToInt(i->i).toArray();   // Set<Integer>  to  int[] Array
int[] intArray2 = setA.toArray(new Integer[setA.size()]);  // Set<Integer>  to  int[] Array
List<Integer> listInteger = Arrays.stream( a ).boxed().collect(Collectors.toList());  // int[] Array  to  List<Integer>
Set<Integer> setInteger = new TreeSet<Integer>(listInteger);   //  List<Integer>  to  Set<Integer>
int[] newArr = listInteger.stream().mapToInt(i->i).toArray();  //  List<Integer>  to  int[] Array

 *
 *
 */
public class ArraysAndCollectionUtils {

	public static void main(String[] args) {
		operators();  // Java program to illustrate arithmetic operators 
		ArrayToList();  //Conver Array to List
		ListToArray();  //Convert List to Array
		sortArray();  // Sort array, min and max element
		reverseArray(); // Reverse array
		rotate();   //rota array dercha e izquierda
		isCommonElemets();   // Elementos comunes en array 
		deleteDuplicatedElements();   // Borra elementos duplicados en array
		findNumberInArray();  // Busca elemento en array
		getOddNumbers();  // Obtiene numeros primos en intervalo
		countUppercaseAndLowercase(); //Ceunta mayusculas y minusculas
		duplicateValuesInArray(); // Busca valores repetidos en Array
	}

	// Java program to illustrate arithmetic operators 
	static void operators() {
        int a = 20, b = 10, c = 0, d = 20, e = 40, f = 30; 
        String x = "Thank", y = "You"; 
  
        // + and - operator 
        System.out.println("a + b = " + (a + b)); 
        System.out.println("a - b = " + (a - b)); 
  
        // + operator if used with strings 
        // concatenates the given strings. 
        System.out.println("x + y = " + x + y); 
  
        // * and / operator 
        System.out.println("a * b = " + (a * b)); 
        System.out.println("a / b = " + (a / b)); 
  
        // modulo operator gives remainder 
        // on dividing first operand with second 
        System.out.println("20 % 10 = " + (a % b)); 
        System.out.println("10 % 1 = " + (10 % 1)); 
        System.out.println("10 % 3 = " + (10 % 3)); 
        System.out.println("10 % 4 = " + (10 % 4)); 
        System.out.println("1 % 10 = " + (1 % 10)); 
        System.out.println("2 % 10 = " + (2 % 10)); 
        System.out.println("9 % 10 = " + (9 % 10));
        System.out.println("-2 % 5 = " + (-2 % 5));
        System.out.println("0 % 5 = " + (0 % 5));
  
        // if denominator is 0 in division 
        // then Arithmetic exception is thrown. 
        // uncommenting below line would throw 
        // an exception 
        // System.out.println(a/c); 
    } 
	
	static void ArrayToList() {
		System.out.println("\n-------------- Array String[] to List<String> (String) -------------");
		//String sArray[] = new String[] { "A", "B", "C", "D" };  otra forma de definir array
		String[] sArray = new String[] { "A", "B", "C", "D" };

		// convert String array to list #1
		//List<String> listStr0 = Arrays.asList(sArray);
		List<String> listStr0 = Arrays.asList("A", "B", "C", "D");  //common way to initialize an array
		System.out.println("convert array to list #1: " + listStr0);

		// convert String array to list #2
		List<String> listStr2 = new ArrayList<String>(Arrays.asList(sArray));
		System.out.println("convert array to list #2" + listStr2);

		
		System.out.println("\n---------------[Conver int[] array to List<Integer>]-------------");
		int[] iArray = new int[] { 1, 2, 3, 12, 7 };
		
		// Java 8, convert array to List, primitive int[] to List<Integer>
		List<Integer> listInt1 = Arrays.stream(iArray).boxed().collect(Collectors.toList());
		System.out.println("Java 8 - Collectors, convert array int[] to List<Integer>: " + listInt1);
		
		
		List<Integer> listInt2 = new ArrayList<Integer>();
		Collections.addAll(listInt2, Arrays.stream(iArray).boxed().toArray(Integer[]::new));
		System.out.println("Java 8 - Stream, convert array int[] to List<Integer>: " + listInt2);
		
		// easy way
		//int[] ints = {1, 2, 3};
		List<Integer> intList = new ArrayList<Integer>(iArray.length);
		for (int i : iArray)	{
		    intList.add(i);
		}
		System.out.println("Java basic form, convert array int[] to List<Integer>: " + intList);
		
	}
	
	// Convert List to Array
	static void ListToArray() {
		System.out.println("\n=========== List<String> to Array String[] =================");
		List<String> listStr = Arrays.asList("This ", "is ", "a ", "good ", "program.");  //Inicializa lista con valores
	    String[] s1 = listStr.toArray(new String[0]);  // Convert list<String> to array  String[]
	    System.out.println("List<String> to String[] : " + Arrays.toString(s1) );
	      
	    
	    System.out.println("\n---------------[Conver List<Integer> to int[] array ]-------------");
	    int[] arr = { 64, 34, 25, 12, 22, 11, 90 };   
	    List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());  //int[] to List<Integer>
		// 1. Java 8  List to array
	    //list2.set(0, 100);   <--- Replaces the element at the specified position in this list with the specified element 
		int[] newArr = list2.stream().mapToInt(i->i).toArray();  //List<Integer> to int[]
		System.out.println("List<Integer> to int[] : " + Arrays.toString(newArr) );
		
		int [] ints = list2.stream().mapToInt(Integer::intValue).toArray();  //List to Array
		System.out.println("List<Integer> to int[]   IntStream : " + Arrays.toString(ints));

		// Otra forma con ArrayUtils
		//int[] obj = new int[] { 1, 2, 3 };
		//Integer[] newObj = ArrayUtils.toObject(obj);
		//Integer[] obj2 = new Integer[] { 4, 5, 6 };
		//int[] newObj2 =	ArrayUtils.toPrimitive(obj2);
	}
	
	// Sort Array, min and max element in array
	static void sortArray() {
		System.out.println("\n==== Sort Array (Sorts the specified array of objects into ascending order, according to the natural ordering of its elements.) ================");
		String[] coins = { "dollar", "dime", "Quarter", "Rupia", "nickel"};
		System.out.println("Array contains: " + Arrays.toString(coins));
		Arrays.sort(coins);   // ordena array
		System.out.println("Sort Array: " + Arrays.toString(coins));
		
		Set <String> set = new TreeSet<String>( Arrays.asList(coins) );
		System.out.println("\n----------------------------");
		System.out.println("min = " + Collections.min(set) );
		System.out.println("min CASE_INSENSITIVE_ORDER = " + Collections.min(set, String.CASE_INSENSITIVE_ORDER) );
		
		System.out.println("\n----------------------------"); 
		System.out.println("max = " + Collections.max(set) );
		System.out.println("max CASE_INSENSITIVE_ORDER = " + Collections.max(set, String.CASE_INSENSITIVE_ORDER) );
		
	}
	
	
	//Reverse Array
	static void reverseArray() {
		System.out.println("\n============== Reverse Array ================");
		String[] coins = { "A", "B", "C", "D", "E" };
		System.out.println("Array contains: " + Arrays.toString(coins));
		List<String> list = Arrays.asList(coins);  //Array to List
		Collections.reverse(list);   //reverse array
		String[] Array = list.toArray(new String[0]);  //List to Array
		System.out.println("Reverse array: " + Arrays.toString(Array));
		System.out.println("Reverse array: " + list.toString());
		
	}
	
	// Rota los elementos del array
	static void rotate() {
		System.out.println("\n============== Rota array a la derecha #1 ================");
		String[] arrayStr = { "a", "b", "c", "d", "e" };
		int rotation = 2;
		
		List<String> list1 = Arrays.asList(arrayStr);  //convierte Array a List
		System.out.println("Array: " + list1);
		Collections.rotate(list1, rotation);    //rota List una posición
		System.out.println("Rotate array "+rotation+" posición a la derecha: " + list1);
		
		System.out.println("\n============== Rota array a la derecha #2 ================");
		String[] arrayStr2 = { "a", "b", "c", "d", "e" };
		List<String> list2 = Arrays.asList(arrayStr2);  //convierte Array a List
		System.out.println("Array: " + list2);
		List<String> list3 = Arrays.asList( rotateRight(arrayStr2, rotation) );  //convierte Array a List
		System.out.println("Rotate array "+rotation+" posición a la derecha: " + list3);
	
	
		System.out.println("\n============== Rota array a la izquierda #1 ================");
		String[] arrayStr3 = { "a", "b", "c", "d", "e" };
		List<String> list4 = Arrays.asList(arrayStr3);  //convierte Array a List
		System.out.println("Array: " + list4);
		Collections.rotate(list4, rotation * -1);
		System.out.println("Rotate array "+rotation+" posición a la izquierda: " + list4);
		
		System.out.println("\n============== Rota array a la izquierda #2 ================");
		String[] arrayStr4 = { "a", "b", "c", "d", "e" };
		List<String> list5 = Arrays.asList(arrayStr4);  //convierte Array a List
		System.out.println("Array: " + list5);
		List<String> list6 = Arrays.asList( rotateRight(arrayStr4, rotation * (-1)) );  //convierte Array a List
		System.out.println("Rotate array "+rotation+" posición a la derecha: " + list6);
	
	}
	
	
	/**
	 * Rota areglo a la derecha N posiciones.
	 * <br>NOTA: Para rotar a la izquierda, poner el número de posiciones en negativo
	 * @param data Array of elements
	 * @param d número de posiones a rotar a la derecha 
	 * @return Array con elementos rotados a la derecha N veces
	 */
	static String[] rotateRight(String[] data, int d) {
		int size = data.length;
		String[] result = new String[size];
		
		// Nos aseguramso que no se desborde el array por la distancia a rotar
		// Por eso tenemos que ajustar la rotacion a la derecha que este drentro del
		// tamaño del array
		d = d % size;    //% Modulus Returns the division remainder, 	example: 2 % 5 = 2
		if (d < 0) 
			d += size;
		if (d == 0)
			return data;
		
		for (int i=0, index=0; i < size; i++) {
			index = i + d;
			// si la rotacion a la derecha es mayor al tamaño entonces ajustamos restando el tamaño
			if (index >= size) {
				index -= size;  
			}
			System.out.println("Distancia = " + d + ", index = " + i + "+" + d + " ==> " + index);
			result[index] = data[i];
		}
		return result;
	}
	
	
	//Para saber si 2 arrays tienen elementos en comun
	static void isCommonElemets() {
		System.out.println("\n============== it have NO elements in common the array? ================");
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = { "d", "a", "f" };
		
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = Arrays.asList(arr2);
		System.out.println("Array1: " + list1);
		System.out.println("Array2: " + list2);
		boolean res = Collections.disjoint(list1, list2); //Returns true if the two specified collections have no elements in common.
		System.out.println("it have NO elements in common the array? " + res);
		
		System.out.println("\n------------ Elementos en comun en 2 arrays (Interseccion de Arrays) ---------------------");
		int[] a = { 1, 5, 12, 3, -15, 52 };
		int[] b = { 3, 1, 6, 5, 57, 13, 17 };
		System.out.println("Array A: " + Arrays.toString(a));
		System.out.println("Array B: " + Arrays.toString(b));
		Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
		Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
		setA.retainAll( setB );
		System.out.println("Elementos en común: " + setA.toString());
		
	}
		
	
	//Elimina elentos duplicados en Array de  String[]  y int[]
	static void deleteDuplicatedElements() {
		System.out.println("\n=========== Eliminar elementos duplicados de un array String[] =================");
        String[] nriAccounts = {"NRE", "NRO", "FCNR", "RFC", "NRE"};

	     // let's convert this array to HashSet in Java
	     // if array contains any duplicate than that would be lost
	     HashSet<String> setOfAccounts = new HashSet<>(Arrays.asList(nriAccounts));
	     System.out.println("Array contains: " + Arrays.toString(nriAccounts));
	     System.out.println("HashSet contains: " + setOfAccounts);

	     
	     System.out.println("\n=========== Eliminar elementos duplicados de un array int[] =================");
	     int[] arr10 = { 64, 34, 25, 12, 22, 11, 90, 12, 25 };   //inicializa array
	     System.out.println("Array contains: " + Arrays.toString(arr10));
	     Set<Integer> list11 = Arrays.stream(arr10).boxed().collect(Collectors.toSet());    //elimina duplicados de Array int[]
	     int[] newArr10 = list11.stream().mapToInt(i->i).toArray();   //set to array
//	     int[] newArr10 = new int[ list11.size() ];
//	     int i = 0;
//	     for (Integer value : list11) {
//	    	 newArr10[i++] = value;
//	     }
	     System.out.println("1. simple, Elimina duplicados de array int[]: " + Arrays.toString(newArr10) );
	     
	     
	     List<Integer> list12 = Arrays.stream(arr10).boxed().collect(Collectors.toList());
	     Set<Integer> set12 = new TreeSet<Integer>(list12);
	     int[] newList12 = set12.stream().mapToInt(j->j).toArray(); 
		 System.out.println("1. Java 8, Elimina duplicados de array int[]: " + Arrays.toString(newList12) );
	}
	
	
	//Busca elemento en un array int[]
	static void findNumberInArray() {
		System.out.println("\n=========== Busca numero dentro de array");
		int[] arr = { 64, 34, 25, 12, 22, 11, 90, 12 };   //inicializa array
		System.out.println("Array contains: " + Arrays.toString(arr));
		int numberToFind = 12;
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("Número " + numberToFind + " encontrado: " + list.contains(numberToFind));
	}
	
	
	//Obtiene números primos en un intervalo
	static void getOddNumbers() {
		System.out.println("\n=========== Busca números impares (números primos) en un intervalo de numeros");
		int ini = 2;
		int fin = 11;
		int[] primos = oddNumbers(ini, fin);
		 System.out.println("Array numeros primos, oddNumbers("+ini+", "+fin+") : " + Arrays.toString(primos));
	}
	
	// (Numeros primos) Obtiene números impares dado un intervalo de números
    static int[] oddNumbers(int l, int r) {
        List<Integer> rs = new ArrayList<Integer>();
        
        for (int i=l; i<=r; i++) {
            if ( (i%2) == 0 ) {
                //even (par)
            } else {
                //odd (impar)
                rs.add(i);
            }
        }
        
        int[] newArr = rs.stream().mapToInt(i->i).toArray();
        return newArr;
    }
	
  //Cuenta mayusculas y minusculas
    static void countUppercaseAndLowercase() {
    	System.out.println("\n=========== Cuenta mayusculas y minusculas =================");
    	String cad = "La CASA del lago";
    	System.out.println("String de entrada: " + cad);
    	System.out.println("------------ Cuenta letras ---------------------");
    	long upper = cad.chars().filter(c -> Character.isUpperCase(c)).count();
    	long lower = cad.chars().filter(c -> Character.isLowerCase(c)).count();
    	System.out.println("Uppercase Letters=" + upper);
		System.out.println("Lowercase Letters=" + lower);
		
		System.out.println("------------ Cuenta palabras ---------------------");
		String[] words = cad.split(" ");
		System.out.println("Cortamos frase en palabras: " + Arrays.toString(words));
		lower = Arrays.stream(words).filter( wo -> wo.equals(wo.toLowerCase()) ).count();
		upper = Arrays.stream(words).filter( wo -> wo.equals(wo.toUpperCase()) ).count();
		System.out.println("Word UpperCase=" + upper);
		System.out.println("Word LowerCase=" + lower);
    }
    
    // Busca valores repetidos en Array
    static void duplicateValuesInArray() {
    	System.out.println("\n=========== Busca valores repetidos en Array =================");
    	int[] numbers = { 1, 5, 23, 2, 1, 6, 3, 1, 8, 12, 3 };
    	System.out.println("Array values: " + Arrays.toString(numbers));
		
		System.out.println("1. Ordenando los valores del areglo y comparando el primero con el segundo");
		int first = getFirstDuplicate(numbers);
		System.out.println("First repeated number = " + first);
    	
		
		Integer[] repeats = getDuplicates(numbers);
		System.out.println("2. Areglo de numeros repetidos: " + Arrays.toString(repeats));
//		for(int i=0; i<repeats.length; i++) {
//			System.out.printf(repeats[i] + " ");
//		}
		
		//Java 8
		System.out.println("3. Java 8 - Numeros repetidos: ");
		List<Integer> listInteger = Arrays.stream(numbers).boxed().collect(Collectors.toList()); //Convierte Array to List
		listInteger.stream().filter(i -> Collections.frequency(listInteger, i) >1).collect(Collectors.toSet()).forEach(System.out::println);
		
    }
  //1. Ordenando los valores del areglo y comparando el segundo con el primero
  	public static int getFirstDuplicate(int[] array) {
  		Arrays.sort(array);
  		
  		for(int i=1; i < array.length; i++) {
  			if (array[i] == array[i-1]) {
  				return array[i]; 
  			}
  		}
  		return 0;
  	}
 // Obtiene todos los repetidos 
 	public static Integer[] getDuplicates(int[] array) {
 		Set<Integer> temp = new HashSet<Integer>();
 		Arrays.sort(array);
 		System.out.println("Ordenamos array: " + Arrays.toString(array));
 		
 		for(int i=1; i < array.length; i++) {
 			if (array[i] == array[i-1]) {
 				temp.add( array[i] ); 
 			}
 		}
 		return temp.toArray(new Integer[temp.size()]);
 	}
    
	
	//imprime el contenido de un array de objects
    static void printArray(Object[] s1) {
    	for(int i = 0; i< s1.length; ++i) {
	         System.out.printf("%s  ", s1[i]);
	    } 
    }
	
}
