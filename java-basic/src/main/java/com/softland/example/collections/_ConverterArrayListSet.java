package com.softland.example.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
		char[] c =  cad.toCharArray();  // String to char array
		List<Character> chl = cad.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());  // String to List<Character>
		List<Character> cadtolist = cad.chars().sorted().mapToObj(ch -> (char)ch).collect(Collectors.toList()); // ordena los caracteres de una cadena
		System.out.println("Sorted characters in string: " + cadtolist.toString());  
		
		
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
	
		int[] distance = new int[5];
		Arrays.fill(distance, -1);  // inicializa Array con -1 en todas las posiciones
		System.out.println(Arrays.toString(distance));
		
		
		// reverse collection, list, array 
		Collections.reverse(listInteger);  //reverse List<Integer>
		Collections.reverse(Arrays.asList(ints)); //reverse int[]
		
		
		int[] aa = { 1, 5, 12, 3, -15, 52 };
		int[] bb = { 3, 1, 6, 5, 57, 13, 17 };
		System.out.println("common elements: " + findCommon3(aa, bb));
		
		validString();
		
		//define a matrix of adjacents (up, down, left and right)
		int[][] adjacents = {{1,0}, {-1, 0}, {0, -1}, {0, 1} };
		
		
		//order array by frequency
		int[] cc =  {4, 3, 1, 6, 4, 3, 6, 4};
		System.out.println("-------------[Order by frequency]---------------");
		System.out.println(Arrays.toString(cc));
		System.out.println(Arrays.toString( sortByFreq(cc) ));
	
		
		StringBuffer st = new StringBuffer(cad);
		st.toString().toLowerCase().equals(null);

		
		String s = "9001 discuss.leetcode.com";
		int visits = Integer.valueOf(s.substring(0, s.indexOf(" ") ));
        StringBuilder domain = new StringBuilder( s.substring(s.indexOf(" ") +1) );
        System.out.println(String.format("visits=%s, domain='%s'", visits, domain));
        
        String[] aDomains = {"9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"};
        List<String> lDomains = subdomainVisits(aDomains);
        System.out.println(lDomains.toString());
        
        int num = Integer.MAX_VALUE;  //max value int
	}
	
	/*
	 * Collections1.retainAll(Collections2)
	
	This method keeps only the common elements
	of both Collection in Collection1.
	 */
	static List<Integer> findCommon3(int[] a, int[] b) {
		List<Integer> la =  Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> lb = Arrays.stream(b).boxed().collect(Collectors.toList());
		
		la.retainAll(lb);
		
		return la;
	}
	
	
	static public void validString() {
		String str = "{hola(param1, param2) {var1;var2,array[2][]}[]}";
		LinkedList<Character> stack = new LinkedList<Character>();
		
		for (char c: str.toCharArray()) {
			if (dictionary().containsKey(c)) {
				stack.push(c);
				
			} else  {
				if (dictionary().containsValue(c)) {
					char p = stack.pop();
					if(dictionary().get(p) != c) {
						break;
					} 
				}
								
			}
			
		}
		
		if (stack.isEmpty()) System.out.println("String valid: true");
		else System.out.printf("String invalid character <%s>", stack.peek());
	}
	
	static HashMap<Character, Character> dictionary() {
        HashMap<Character, Character> dc = new HashMap<Character, Character>();
        dc.put('{', '}');
        dc.put('(', ')');
        dc.put('[', ']');
        return dc;
    }
	
	public static int[] sortByFreq(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int n: arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		//System.out.println(map.toString());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a) );
		pq.addAll(map.keySet());
		//System.out.println(String.format("Piority Queue: %s, peek: %s", pq.toString(), pq.peek() ) ); 
		
		List<Integer> res = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			int n = pq.remove();
			for (int i=0; i < map.get(n); i++) {
				res.add(n);
			}
		}
		
		return res.stream().mapToInt(i -> i).toArray();
	}
	
	
	public static List<String> subdomainVisits(String[] cpdomains) {
		if (cpdomains == null || cpdomains.length == 0) return null;
        
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> res = new ArrayList<String>();
        
        for (String s : cpdomains) {
            String[] arr = s.split(" ");
            //int visits = Integer.valueOf(s.substring(0, s.indexOf(" ") ));
            //String domain = s.substring(s.indexOf(" ") + 1) ;
        	int visits = Integer.valueOf(arr[0]);
        	String domain = arr[1];
        	System.out.println(String.format("visits=%s, domain='%s'", visits, domain));
            
            while (domain.indexOf(".") > 0) {
                map.put(domain, map.getOrDefault(domain, 0) + visits );
                domain = domain.substring(domain.indexOf(".") + 1) ;
            } 
            map.put(domain, map.getOrDefault(domain, 0) + visits );
                    
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        
        return res;
    }

}
