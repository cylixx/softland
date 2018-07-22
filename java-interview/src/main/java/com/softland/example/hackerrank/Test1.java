package com.softland.example.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	static List<List<Integer>> cleanup(List<List<Integer>> list) {
        Set<Integer> columnsWith0 = new TreeSet<Integer>();
        Integer[] rowList =null; 
        
        List<List<Integer>> matrix = list;
        
        //for (List<Integer> row : matrix) {
        for (int i = 0; i<matrix.size(); i++ ) {
        	
//        	 rowList = Arrays.toString( matrix.get(i) );
            
              //for (Integer column : row) {
            if ( matrix.get(i).contains(0) ) {
                for (int j=0; j<matrix.get(i).size(); j++) {
                 if(matrix.get(i).get(j) == 0) {
                     columnsWith0.add( j );
                 }
                 int tmp = 0;
                 matrix.get(i).set(j, 0);
               }
            }    
        }
        for (int i = 0; i<matrix.size(); i++ ) {
            for (int j=0; j<matrix.get(i).size(); j++) { 
                if ( columnsWith0.contains(j) ) {
//                    matrix.get(i).get(j) = 0;
                }
            }
        } 
        return matrix; 
    }
	
	
    static void dumpList(String prefix, List<List<String>> list) {
        
        for(int i=0; i<list.size(); i++) {
           for(int j=0; j<list.get(i).size(); i++) {
                
            }
            
        }
        
    }
    


}
