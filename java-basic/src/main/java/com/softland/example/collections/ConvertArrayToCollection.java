package com.softland.example.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
 */
public class ConvertArrayToCollection {
	
//	private static void example1(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
//	      System.out.println("How many elements you want to add to the array: ");
//	      int n = Integer.parseInt(in.readLine());
//	      String[] name = new String[n];
//	      
//	      for(int i = 0; i < n; i++) {
//	         name[i] = in.readLine();
//	      }
//	      List<String> list = Arrays.asList(name); 
//	      System.out.println();
//	      
//	      for(String li: list) {
//	         String str = li;
//	         System.out.print(str + " ");
//	      }
//	}
	

	public static void main(String[] args) throws IOException {

		System.out.println("=========== Array to List (String)=================");
		
		//String sArray[] = new String[] { "A", "B", "C", "D" };
		String[] sArray = new String[] { "A", "B", "C", "D" };

		// convert array to list #1
		List<String> listStr0 = Arrays.asList(sArray);
		System.out.println("convert array to list #1: " + listStr0);

		// convert array to list #2
		List<String> listStr2 = new ArrayList<String>(Arrays.asList(sArray));
		System.out.println("convert array to list #2" + listStr2);

		int iArray[] = new int[] { 1, 2, 3 };
		// Java 8, convert array to List, primitive int[] to List<Integer>
		List<Integer> listInt = Arrays.stream(iArray).boxed().collect(Collectors.toList());
		System.out.println("Java 8, convert array to List, primitive int[] to List<Integer>: " + listInt);
		
		
		
		
		
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };   //inicializa array
//		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		
		//=========== Array to List (int)=================
		System.out.println("=========== Array to List (Int)=================");
		
		// 1. Naive form
		List<Integer> list1 = new ArrayList<>(arr.length);
		for (int i : arr) {
			list1.add(Integer.valueOf(i));
		}
		System.out.println("Iterando array: " + list1);
		
		
		// 2. with Java 8
		List<Integer> list2 = Arrays.stream(arr)	// IntStream
									.boxed()  		// Stream<Integer>
									.collect(Collectors.toList());
		System.out.println("Java 8 stream" + list2);

		
		//=========== List to Array =================
		System.out.println("=========== List to Array =================");
		List<String> listStr = Arrays.asList(new String[] {"This", "is", "a", "goog", "program."});
		
	    String[] s1 = listStr.toArray(new String[0]);  // Convert list<String> to array  String[]
	    System.out.println("List<String> to String[] :" + Arrays.toString(s1) );
	    printArray(s1);
	    System.out.println("");
	      
		// 1. Java 8  List to array
		int[] newArr = list2.stream().mapToInt(i->i).toArray(); 
		System.out.println("List<Integer> to int[] :" + Arrays.toString(newArr) );
		
		int [] ints = list2.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("List<Integer> to int[]   IntStream :" + Arrays.toString(ints));

		
		//=========== Array to Set =================
		System.out.println("=========== Array to Set =================");
		// input array containing all distinct elements
		String str[] = { "A", "B", "C", "D" };
		
		// 1. Nave
		// convert Array to a Set
		Set<String> items = convertToSet(str);
		System.out.println("convert Array to a Set: " + items);
		
		// 2. Arrays.asList()
		// convert Array to a Set using Arrays.asList() method
		Set<String> items2 = new HashSet<>(Arrays.asList(str));
		System.out.println("Convert Array to a Set using Arrays.asList() method: " + items2);
		
		// 3. Java 8
		Set<String> items3 = Arrays.stream(str).collect(Collectors.toSet());
		System.out.println("Java 8: " + items3);
		//otra forma con toCollection
		items3 = Arrays.stream(str).collect(Collectors.toCollection(HashSet::new));
		System.out.println("Java 8 Collectors.toCollection: " + items3);
		
		
		//=========== Set to Array =================
		System.out.println("=========== Set to Array =================");
		// Creating a hash set of strings
        Set<String> s = new HashSet<String>();
        s.add("Geeks");
        s.add("for");
        
        // 1. Method 1 (Simple)
        String[] arr2 = toArray(s);
        System.out.println("Set to Array, Method 1 (Simple) :" + Arrays.toString(arr2) );
        
        // 2 . Method 2 (Using toArray())
        String arr3[] = s.toArray( new String[s.size()] );
        System.out.println("Method 2 (Using toArray()) :" + Arrays.toString(arr3) );
        
        // 1. Method 3 (Using stream in Java 8)
        String[] arr4 = s.stream().toArray(String[] ::new);
        System.out.println("Method 3 (Using stream in Java 8) :" + Arrays.toString(arr4) );
     
        
        //=========== List To Set =================
        System.out.println("=========== List To Set =================");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");
        
        Set<String> set = new HashSet<String>(list);   //elimina valores repetidos
        System.out.println("Set values : " + set);
        
        
      //=========== Set To List =================
        System.out.println("=========== Set To List =================");
        Set<String> set2 = new HashSet<String>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("4");
        set2.add("1");
        
        List<String> list3 = new ArrayList<String>(set2);
        System.out.println("List values : " + list3);

	}
	
	
	// Generic function to convert an array to an HashSet
	public static <T> Set<T> convertToSet(T arr[]) {
		// create an empty set
		Set<T> items = new HashSet<>();

		// push each element in the array into the set
		for (T i : arr)
			items.add(i);

		// return the set
		return items;
	}
	
	static int[] toArray(List<Integer> list) {
	    int[] ret = new int[ list.size() ];
	    int i = 0;
	    for( Iterator<Integer> it = list.iterator(); 
	         it.hasNext(); 
	         ret[i++] = it.next() );
	    return ret;
	}
	
	
	static String[] toArray(Set<String> s) {
		int n = s.size();
        String arr[] = new String[n];
 
        int i = 0;
        for (String x : s)
            arr[i++] = x;
        return arr;
	}
	
    
    //imprime el contenido de un array de objects
    static void printArray(Object[] s1) {
    	for(int i = 0; i< s1.length; ++i) {
	         Object contents = s1[i];
	         System.out.print(contents);
	    } 
    }
    
}
