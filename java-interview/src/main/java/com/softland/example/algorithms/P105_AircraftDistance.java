package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P105_AircraftDistance {

	public static void main(String[] args) {

		List<List<Integer>> forwardRouteList = Arrays.asList(
				Arrays.asList(1, 8),
				Arrays.asList(2, 7),
				Arrays.asList(3, 14)
				);
		List<List<Integer>> returnRouteList = Arrays.asList(
				Arrays.asList(1, 5),
				Arrays.asList(2, 10),
				Arrays.asList(3, 14)
				); 
		System.out.println("forwardRouteList: " + forwardRouteList.toString());
		System.out.println("returnRouteList: " + returnRouteList.toString());
		
		List<List<Integer>> output1 =  optimalUtilization(20, forwardRouteList, returnRouteList);
		System.out.println("1. output: " + output1.toString());
		List<List<Integer>> output1_1 =  optimalUtilization2(20, forwardRouteList, returnRouteList);
		System.out.println("2. output: " + output1_1.toString());
		
		
		List<List<Integer>> forwardRouteList2 = Arrays.asList(
				Arrays.asList(1, 8),
				Arrays.asList(2, 15),
				Arrays.asList(3, 9)
				);
		List<List<Integer>> returnRouteList2 = Arrays.asList(
				Arrays.asList(1, 8),
				Arrays.asList(2, 11),
				Arrays.asList(3, 12)
				); 
		
		System.out.println("--------------------Test 2------------------------");
		System.out.println("forwardRouteList: " + forwardRouteList2.toString());
		System.out.println("returnRouteList: " + returnRouteList2.toString());
		
		List<List<Integer>> output2 =  optimalUtilization(20, forwardRouteList2, returnRouteList2);
		System.out.println("1. output: " + output2.toString());
		List<List<Integer>> output2_1 =  optimalUtilization2(20, forwardRouteList2, returnRouteList2);
		System.out.println("2. output: " + output2_1.toString());
		
	}

	
	
	// travel - amount fixed
	// forwardRouteList: [0=fowardID, 1=Amount travel distance ]
	// returnRouteList: [0=fowardID, 1=Amount travel distance ]
	/*
	    Algorithm complexity
	   		O(n) - To go through forwardRouteList
	    	O(n) - To go through returnRouteList
	    	O(1) - To add and remove in a new list result 
	    	O(n) - To stream and filter result
	    	=>
	    	    = O(n) + O(n) + O(1) + O(n)
	        	= O(1*n*n*n)
	        	= O(n^3)  
	   
	 */
	static List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {

		 System.out.println("maxTravelDist=" + maxTravelDist);

		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 Integer maxTD = 0;
		 int totalD = 0;

		 // Obtenemos todas las combinaciones
		for (int i=0; i<forwardRouteList.size(); i++) {  //O(n)
			for(int j=0; j<returnRouteList.size(); j++) {   //O(n)
				
				totalD = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
				if (totalD <= maxTravelDist) {
					//O(1)
					res.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0), totalD) ); 
					
					//guardamos la distancia maxima de los vuelos que estan antes del tope de distancia
					if (totalD > maxTD ) maxTD = totalD; 
				}
			}
		}

		System.out.println("Result: " + res.toString());
		final Integer max = maxTD;
		
		// O(n)
		return 
		res.stream()
			.filter(
					f -> f.get(2) == max
				) 
			.map(
				 x -> Arrays.asList(x.get(0), x.get(1))
				) 
			.collect(Collectors.toList());
		
	}
	
	/*
	 * Best answer
	 
	  Algorithm complexity
	    O(n) - To go through forwardRouteList
	    O(n) - To go through returnRouteList
	    O(1) - To add and remove in a new list result 
	    =>
	        = O(n) + O(n) + O(1)
	        = O(1*n*n)
	        = O(n^2)  - quadratic complexity
	 
	 */
	static List<List<Integer>> optimalUtilization2(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {

		 System.out.println("maxTravelDist=" + maxTravelDist);

		 List<List<Integer>> res = new LinkedList<List<Integer>>(); // O(1) - Mejor opcion para agregar y eliminar
		 Integer maxDist = 0;
		 int totalDist = 0;
		 
		 
		 // Obtenemos todas las combinaciones de vuelos
		for (int i=0; i<forwardRouteList.size(); i++) {   //O(n)
			for(int j=0; j<returnRouteList.size(); j++) {  //O(n)
				
				totalDist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
				if (totalDist <= maxTravelDist) {
					
					//guardamos la distancia maxima de los vuelos que estan antes del tope de distancia
					if (totalDist >= maxDist ) {
						
						//O(1)
						// Si la distancia total del vuelo es igual a la maxima calculada hasta el momento, entonces agregar a la lista
						if (totalDist == maxDist) {
							res.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0)) );

						} else { // Si distancia total es mayor a distancia maxima actual, entonces borrar lista y agregar el nuevo valor
							maxDist = totalDist; // Acualizamos la distancia maxima actual a la del total de vuelo actual
							res.clear();
							res.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0)) );
						}
						
					}
				}
			}
		}
		return res;
	}

}
