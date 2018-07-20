package com.softland.example.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class ArrayToCollection {
	
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

		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };   //inicializa array
		
		//=========== Array to List =================
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
		// 1. Java 8  List to array
		int[] newArr = list2.stream().mapToInt(i->i).toArray(); 
		System.out.println("List<Integer> to int[] :" + Arrays.toString(newArr) );
		
		int [] ints = list2.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("List<Integer> to int[]   IntStream :" + Arrays.toString(ints));

		
		//=========== Array to Set =================
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
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");
        
        Set<String> set = new HashSet<String>(list);   //elimina valores repetidos
        System.out.println("Set values : " + set);
        
        
      //=========== Set To List =================
        Set<String> set2 = new HashSet<String>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("4");
        set2.add("1");
        
        List<String> list3 = new ArrayList<String>(set2);
        System.out.println("List values : " + list3);
        
        
        //=========== Eliminar valores duplicados de un Array =================
        String[] nriAccounts = {"NRE", "NRO", "FCNR", "RFC", "NRE"};

	     // let's convert this array to HashSet in Java
	     // if array contains any duplicate than that would be lost
	     HashSet<String> setOfAccounts = new HashSet<>(Arrays.asList(nriAccounts));
	     System.out.println("Array contains: " + Arrays.toString(nriAccounts));
	     System.out.println("HashSet contains: " + setOfAccounts);

	     
	     int[] arr10 = { 64, 34, 25, 12, 22, 11, 90, 12, 25 };   //inicializa array
	     System.out.println("Array contains: " + Arrays.toString(arr10));
	     Set<Integer> list11 = Arrays.stream(arr10).boxed().collect(Collectors.toSet());    //elimina duplicados de Array int[]
	     int[] newArr10 = new int[ list11.size() ];
	     int i = 0;
	     for (Integer value : list11) {
	    	 newArr10[i++] = value;
	     }
	     System.out.println("1. simple, Elimina duplicados de array int[]: " + Arrays.toString(newArr10) );
	     
	     
	     List<Integer> list12 = Arrays.stream(arr10).boxed().collect(Collectors.toList());
	     Set<Integer> set12 = new TreeSet<Integer>(list12);
	     int[] newList12 = set12.stream().mapToInt(j->j).toArray(); 
		 System.out.println("1. Java 8, Elimina duplicados de array int[]: " + Arrays.toString(newList12) );
	     
		 
		 //====== busca numero dentro de array
		 System.out.println("findNumber([64, 34, 25, 12, 22, 11, 90], 12) : " + findNumber(arr, 12));
		 
		 
		//====== Regresa un array con los números impares contenidos dentro de un intervalo de numeros
		 int[] primos = oddNumbers(2, 11);
		 System.out.println("Array numeros primos, oddNumbers(2, 11) : " + Arrays.toString(primos));
		 
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
	
	/*
     * Regresa YES si el numero buscado se encuentra en el Array 
     */
    static String findNumber(int[] arr, int k) {
        /*
         * Write your code here.
         */
       List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

       if(list.contains(k)) {
            return "YES";
        }
        return "NO";
    }
    
    /*
     * Regresa un array con los números impares contenidos dentro de un intervalo de numeros
     */
    static int[] oddNumbers(int l, int r) {
        /*
         * Write your code here.
         */
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
    

}
