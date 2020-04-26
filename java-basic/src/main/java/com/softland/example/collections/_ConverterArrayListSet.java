package com.softland.example.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author cylixx
 *
 *  //---------  Arithmetic Operators  --------------------
      / 	Division 	Divides one value by another 	x / y 	 Example:  12 / 3 = 4
      % 	Modulus 	Returns the division remainder 	x % y    Example:  5 % 2 = 1
 *
 *
 */
public class _ConverterArrayListSet {

	public static void main(String[] args) {
		util();
		System.out.println("Hello world!");
	}
	
	static void util() {
		//---------------------- convertion between Array, List and Set ------------------------------
		List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");   // initialize a List  (more common)
		List<String> stooges2 = Arrays.asList(new String[] {"Larry", "Moe", "Curly"});   // initialize a List

		String[] stringArray = {"NRE", "NRO", "FCNR", "RFC", "NRE"};
		List<String> list = Arrays.asList(stringArray);  // String[] Array  to  List<String>
		String[] s1 = list.toArray(new String[0]);       // List<String>  to  String[] Array
		Set<String> set = new HashSet<String>(list);     // List<String> to  Set<String>
		List<String> list3 = new ArrayList<String>(set); // Set<String>  to  List<String>
		HashSet<String> setOfAccounts = new HashSet<>(Arrays.asList(stringArray));   // String[] to HashSet<String>  (remove duplicates), more common
		Set<String> items = Arrays.stream(stringArray).collect(Collectors.toSet());  // String[] to HashSet<String>
		String arr3[] = items.toArray( new String[items.size()] );   // Set<String>  to  String[]
		long upper = Arrays.stream(stringArray).filter( wo -> wo.equals(wo.toUpperCase()) ).count(); // para recorrer un String[]  Array

		String cad = "La CASA del lago";
		long upper2 = cad.chars().filter(c -> Character.isUpperCase(c)).count();  // para recorrer los caracteres de un String


		int[] a = { 1, 5, 12, 3, -15, 52 };
		Arrays.toString(a); // return a String representation of the Array  --- para imprimir un array
		Arrays.stream(a);   // Returns a sequential DoubleStream with the specified array as its source. --- Para recorrer un array
		Arrays.sort(a);     // sorts the array in ascending order

		Set<Integer> setA = Arrays.stream( a ).boxed().collect(Collectors.toSet());  // int[] Array  to  Set<Integer>
		int[] intArray = setA.stream().mapToInt(i->i).toArray();       // Set<Integer>  to  int[] Array (more common)
		Integer[] intArray2 = setA.toArray(new Integer[setA.size()]);  // Set<Integer>  to  Integer[] Array
		List<Integer> listInteger = Arrays.stream( a ).boxed().collect(Collectors.toList());  // int[] Array  to  List<Integer>
		Set<Integer> setInteger = new TreeSet<Integer>(listInteger);   //  List<Integer>  to  Set<Integer>
		int[] newArr = listInteger.stream().mapToInt(i->i).toArray();  //  List<Integer>  to  int[] Array  (more common)
		int [] ints = listInteger.stream().mapToInt(Integer::intValue).toArray();   //  List<Integer>  to  int[] Array
	}

}
