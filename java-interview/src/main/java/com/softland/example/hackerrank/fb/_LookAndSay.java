package com.softland.example.hackerrank.fb;

/*
 
Question 2: Look and Say
Find the n’th term in Look-and-say (Or Count and Say) Sequence. 
Implement a function that outputs the Look and Say sequence:
1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
 
 
 An example:
    Starting with the number 1,   you have one 1 which produces 11
    Starting with 11,   you have two 1's.   I.E.:   21
    Starting with 21,   you have one 2, then one 1.   I.E.:   (12)(11) which becomes 1211
    Starting with 1211,   you have one 1, one 2, then two 1's.   I.E.:   (11)(12)(21) which becomes 111221
 
 
 */
public class _LookAndSay {

	public static void main(String[] args) {
		System.out.println("Solution #cylixx - recursive: " +  countnndSay(9));
		System.out.println("Solution #2    - iteratively: " +  countnndSay2(9));

	}
	/*
	 * Solution # cylixx - recursive
	 * 
	 */
	 static String countnndSay(int n) {
		 if (n == 0) return "";
		 if (n == 1) return "1";
		 if (n == 2) return "11";
		 
		 String prev = countnndSay(n - 1);  //get the previous serie
		 char[] arr =  prev.toCharArray();
		 
		 StringBuilder s = new StringBuilder();
		 int counter = 1;
		 int i;
		 for (i=1; i<arr.length; i++) {
			 if (arr[i] == arr[i-1]) {
				 counter++;
			 } else {
				 s.append(counter);
				 s.append(arr[i - 1]);
				 counter = 1;
			 }
		 }
		 s.append(counter);
		 s.append(arr[i - 1]);
		 
		 return s.toString();
	 }
	 
	 
	 	// Returns n'th term in  
	    // look-and-say sequence 
	/*
	 * The idea is simple, we generate all terms from 1 to n. First two terms are initialized as “1” and “11”, 
	 * and all other terms are generated using previous terms. To generate a term using previous term, we scan 
	 * the previous term. While scanning a term, we simply keep track of count of all consecutive characters. 
	 * For sequence of same characters, we append the count followed by character to generate the next term.
	 */
    static String countnndSay2(int n) {
	    // Base cases 
	    if (n == 1)     return "1"; 
	    if (n == 2)     return "11"; 
	  
	    // Find n'th term by generating  
	    // all terms from 3 to n-1.  
	    // Every term is generated  
	    // using previous term 
	      
	    // Initialize previous term 
	    String str = "11";  
	    for (int i = 3; i <= n; i++) {
	        // In below for loop, previous  
	        // character is processed in  
	        // current iteration. That is 
	        // why a dummy character is  
	        // added to make sure that loop 
	        // runs one extra iteration. 
	        str += '$'; 
	        int len = str.length(); 
	  
	        int cnt = 1; // Initialize count  
	                     // of matching chars 
	        String tmp = ""; // Initialize i'th  
	                         // term in series 
	        char []arr = str.toCharArray(); 
	          
	        // Process previous term 
	        // to find the next term 
	        for (int j = 1; j < len; j++) 
	        {
	            // If current character 
	            // does't match 
	            if (arr[j] != arr[j - 1]) 
	            { 
	                // Append count of  
	                // str[j-1] to temp 
	                tmp += cnt + 0; 
	  
	                // Append str[j-1] 
	                tmp += arr[j - 1]; 
	  
	                // Reset count 
	                cnt = 1; 
	            } 
	  
	            // If matches, then increment  
	            // count of matching characters 
	            else cnt++; 
	        } 
	  
	        // Update str 
	        str = tmp; 
	    }
	  
    return str; 
    } 

}
