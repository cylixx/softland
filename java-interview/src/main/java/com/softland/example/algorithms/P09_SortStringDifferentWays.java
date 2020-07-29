/*
 * Sort a String in Java (2 different ways)
 * https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class P09_SortStringDifferentWays {

	public static void main(String[] args) {

		System.out.println("======================== Method 1 ==============================");
		String inputString = "geeksforgeeks"; 
        String outputString = sortString1(inputString); 
          
        System.out.println("Input String : " + inputString); 
        System.out.println("Output String : " + outputString); 
        
        System.out.println("======================== Method 2 ==============================");
		String inputString2 = "geeksforgeeks"; 
        String outputString2 = sortString2(inputString); 
          
        System.out.println("Input String : " + inputString2); 
        System.out.println("Output String : " + outputString2); 
	}
	
	 // Method to sort a string alphabetically 
    public static String sortString1(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
    
 // Method to sort a mixed string 
    public static String sortString2(String inputString) 
    { 
        // convert input string to Character array 
        Character tempArray[] = new Character[inputString.length()]; 
        for (int i = 0; i < inputString.length(); i++) { 
            tempArray[i] = inputString.charAt(i); 
        } 
          
          
        // Sort, ignoring case during sorting 
        Arrays.sort(tempArray, new Comparator<Character>(){
  
            @Override
            public int compare(Character c1, Character c2) 
            { 
                // ignoring case 
                return Character.compare(Character.toLowerCase(c1), 
                                        Character.toLowerCase(c2)); 
            } 
        }); 
          
        // using StringBuilder to convert Character array to String 
        StringBuilder sb = new StringBuilder(tempArray.length); 
        for (Character c : tempArray) 
            sb.append(c.charValue()); 
  
        return sb.toString(); 
    } 
    
    

}
