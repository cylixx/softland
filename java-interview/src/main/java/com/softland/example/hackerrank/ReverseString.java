/*
 * Reference
 * https://www.geeksforgeeks.org/reverse-a-string-in-java/
 */
package com.softland.example.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ReverseString {

	public static void ConvertingStringIntoBytes() {
		String input = "Geeks for Geeks"; 
		  
        // getBytes() method to convert string  
        // into bytes[]. 
        byte [] strAsByteArray = input.getBytes(); 
        byte [] result = new byte [strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int i = 0; i<strAsByteArray.length; i++) 
            result[i] = strAsByteArray[strAsByteArray.length-i-1]; 
  
        System.out.println("Converting String into Bytes: ");
        System.out.println(new String(result)); 
	}
	
	// El mas facil y rapido
	public static void StringBuilderReverseMethod() {
		String input = "Geeks for Geeks"; 
		  
        StringBuilder input1 = new StringBuilder(); 
  
        // append a string into StringBuilder input1 
        input1.append(input); 
  
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
  
        System.out.println("ReverseString using StringBuilder: ");
        // print reversed String 
        System.out.println(input1); 
	}
	
	//======= El mas usado en las entrevistas
	public static void ConvertingStringToCharacterArray() {
		String input = "Geeks For Geeks"; 
		  
        // convert String to character array 
        // by using toCharArray 
        char[] try1 = input.toCharArray(); 
  
        System.out.println("Reverse a String by converting string to characters one by one : ");
        for (int i = try1.length-1; i>=0; i--) 
            System.out.print(try1[i]); 
        
        System.out.println(); 
	}
	
	public static void reverseStringUsingSwappingOfVariables() {
		String input = "Geeks For Geeks"; 
        char[] temparray = input.toCharArray(); 
        int left, right=0; 
        right = temparray.length-1; 
  
        for (left=0; left < right ; left++ ,right--) 
        { 
            // Swap values of left and right 
            char temp = temparray[left]; 
            temparray[left] = temparray[right]; 
            temparray[right]=temp; 
        } 
  
        System.out.println("Reverse a String using swapping of variables: ");
        for (char c : temparray) 
            System.out.print(c); 
        System.out.println(); 
	}
	
	public static void UsingArrayListObject() {
		String input = "Geeks For Geeks"; 
        char[] hello = input.toCharArray(); 
        List<Character> trial1 = new ArrayList<Character>(); 
  
        for (char c: hello) 
            trial1.add(c); 
  
        Collections.reverse(trial1); 
        ListIterator li = trial1.listIterator(); 
        System.out.println("Reverse a String using ListIterator ");
        while (li.hasNext()) 
            System.out.print(li.next()); 
        
        System.out.println(); 
	}
	
	public static void main(String[] args) {
		ConvertingStringIntoBytes();
		StringBuilderReverseMethod();
		ConvertingStringToCharacterArray();
		reverseStringUsingSwappingOfVariables();
		UsingArrayListObject();
	}

}
