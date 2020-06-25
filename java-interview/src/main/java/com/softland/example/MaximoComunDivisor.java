package com.softland.example;


public class MaximoComunDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float resultado1 = (float) Math.sqrt(10);
		System.out.println(resultado1);
		
	}
	
	/*
	 
	  // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int gcd = 1;

        boolean flag = false;
        for(int i=0; i<num; i++) {
            gcd = arr[i];
            
            for(int j=0; j<num; j++) {
                if ( (arr[j]%gcd) != 0) {
                   break;
                }
                if (j == (num-1)) {
                    flag = true;
                    return gcd;
                }
            }
        }
        if (!flag) {
            gcd = 1;
        }    
        
        return gcd;
    }
    // METHOD SIGNATURE ENDS
}
	
	 */

}
