/*
	A colony of eight houses, represented as cells, are arranged in a straight line. 
	Each day every cell competes with its adjacent cells (neighbours). An integer value of 1 
	represents an active cell and value of 0 represents an inactive cell. 
	If both the neighbours are either active or inactive, the cell becomes inactive the next day;
	otherwise it becomes active on the next day. The two cells on the ends have a single adjacent
	cell, so the other adjacent cell can be assumed to be always inactive. 
	Even after updating the cell state, its previous state is considered for updating the state 
	of other cells. The cell information of all cells should be updated simultaneously.


Una colonia de ocho casas, representadas como celdas, está dispuesta en línea recta. 
Cada día, cada célula compite con sus celdas adyacentes (vecinos). 
Un valor entero de 1 representa una celda activa y el valor de 0 representa una celda inactiva. 
Si ambos vecinos están activos o inactivos, la celda se vuelve inactiva al día siguiente; 
de lo contrario, se activa el día siguiente. Las dos celdas en los extremos tienen una sola 
celda adyacente, por lo que se puede asumir que la otra celda adyacente está siempre inactiva. 
Incluso después de actualizar el estado de la celda, se considera su estado anterior para 
actualizar el estado de otras celdas. La información de celda de todas las celdas debe 
actualizarse simultáneamente.

*/

package com.softland.example;

import java.util.ArrayList;
import java.util.List;

public class CelulasExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test = {1, 0, 0, 0, 0,1,0,0}; 
		List<Integer> result = cellCompete(test, 1);
		System.out.println("Result="+result);
		
	}
	
	     
	  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    static List<Integer> cellCompete(int[] states, int days)
	    {
	    // WRITE YOUR CODE HERE
	    //List<Integer> result = new ArrayList<Integer>();
	    //int[] temp = new int[states.length];
	    int[] temp = states;
	    int ant=0, sig=0;
	    
	    for (int d=1; d<=days; d++) {
	        for (int i=0; i<temp.length; i++) {
	            if ( i >= 1)  ant = temp[i-1];
	            else ant = 0;
	            
	             if (i <= temp.length - 2) sig = temp[i+1];
	             else sig = 0;
	             
	            if ( ant == sig ) {
	                temp[i] = 0;  //inactive next day
	            } else {
	                temp[i] = 1;  //active next day
	            }
	        }
	    }
	    List<Integer> result = new ArrayList<>(temp.length);
	    return result;
	    }
	    
	    
	    
	    /*
	     
	     
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.ArrayList;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
    //List<Integer> result = new ArrayList<Integer>();
    //int[] temp = new int[states.length];
    int[] temp = states;
    int[] res = new int[states.length];
    int ant=0, sig=0;
    
    for (int d=1; d<=days; d++) {
        for (int i=0; i<temp.length; i++) {
            //if ( i >= 1)  ant = temp[i-1];
            //else ant = 0;
            
            if (i==0) ant = 0; //0 beacuse is cell on the end
            else ant = temp[i-1];

             //if (i <= temp.length - 2) sig = temp[i+1];
             //else sig = 0;
             if (i == temp.length -1) sig = 0;
             else sig = temp[i+1];
             
            if ( ant == sig ) {
                res[i] = 0;  //inactive next day
            } else {
                res[i] = 1;  //active next day
            }
        }
        temp = res;
    }
    List<Integer> result = new ArrayList<>(res.length);
    return result;
    }
  // METHOD SIGNATURE ENDS
}

	     
	     */
		

}
