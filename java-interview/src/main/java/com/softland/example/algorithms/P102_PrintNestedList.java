/*
 * Write a function called "dumpList(prefix, list)" that prints the value of each list 
 * element on a separate line. The list a is nested, which may only contain stings and 
 * other nested lists.
 * The value of each line should be preceded by the string and numbers indicating the 
 * depth and index of the element in the list. 
 * 
 * 
 */
package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P102_PrintNestedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Foo";
		List list = Arrays.asList(
				"a string",
				Arrays.asList("a", "b", Arrays.asList("c")),
				"spam", 
				Arrays.asList("eggs")
				);
	    
	    dumpList("Foo", list);
	    System.out.println("//----------------- Opcion 2------------------------");
	    dumpList2("Foo", list);
	}

	private static void dumpList(String string, Iterable<?> list) {
	    int i = 0;
	    for (Object item : list) {
	        if (item instanceof Iterable) {
	            dumpList(string +" "+ i, (Iterable<?>) item);
	        } else {
	            System.out.println(String.format("%s %d %s", string, i, item));
	        }
	        ++i;
	    }
	}
	
	private static void dumpList2(String string, List<Object> list) {
	    int i = 0;
	    for (Object item : list) {
	        if (item instanceof List) {
	        	System.out.println(string +"."+ i + ",  " + ((List) item).toString());
	            dumpList(string +"."+ i, (List) item);
	        } else {
	            //System.out.println(String.format("%s%d %s", string, i, item));
	        	System.out.println(String.format("%s.%d: %s", string, i, item));
	        }
	        ++i;
	    }
	}
	
	
}
