package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P103_FindNearestSteakHouse {

	public static void main(String[] args) {
		
		List<List<Integer>> allLocations = Arrays.asList( 
				Arrays.asList(1, 2),
				Arrays.asList(3, 4),
				Arrays.asList(1, -1)
	        );
		
		System.out.println("All Locations: " + allLocations.toString());
		System.out.println("Total Steak Houses: " + 3);
		System.out.println("Number steak hopuses to return: " + 3);
		System.out.println("1. Coordinates of nearest steak houses: " + nearestXsteakHouses(3, allLocations, 3).toString());
		System.out.println("2. Coordinates of nearest steak houses: " + nearestXsteakHouses2(3, allLocations, 3).toString());
		System.out.println("3. Using a bean and comparator>");
		System.out.println("   Coordinates of nearest steak houses: " + nearestXsteakHouses3(3, allLocations, 3).toString());

	}
	
	/**
	 * 1. Solutionn by Cylixx
	 * Algorithm complexity O(n x m)
	 * Where:
	 *  'n' is the number of total locations 
	 *  'm' is the number of results to show
	 *  
	 * @param totalSteakhouses the total number of possible steak houses in the customer's city
	 * @param allLocations a list of elemets where each element consists of a pair of integers representing coordinates
	 * @param numSteakHouses an integer representing the number of nearby steak houses that would be returned to the customer
	 * @return
	 */
	static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, 
			List<List<Integer>> allLocations, 
			int numSteakHouses) {
		
		int[] cvalue = null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Float, Integer> mapVal = new TreeMap<Float, Integer>();
		
		// Por cada par de coordenadas calculamosm la distancia en base a la formula dada
		for (int i=0; i<allLocations.size(); i++) {
			cvalue = allLocations.get(i).stream().mapToInt(j->j).toArray();
			int sum = (int) (Math.pow(cvalue[0], 2) + Math.pow(cvalue[1], 2) );
			float sq = (float) Math.sqrt(sum);
			mapVal.put(sq, i); // guardamos la distancia y el indice de la coordenada
		}
		
		//Llenamos array solo con los resultados a mostrar 
		int cont = 1;
		for(Map.Entry<Float, Integer> entry : mapVal.entrySet()) {
			if(cont <= numSteakHouses) {
				result.add(allLocations.get(entry.getValue())); 
				cont++;
			}
		}
		
		return result;
	}
	
	
	// 2. Solution by Cylixx
	static List<List<Integer>> nearestXsteakHouses2(int totalSteakhouses, 
			List<List<Integer>> allLocations, 
			int numSteakHouses) {
					
		Map<Float, List<Integer>> mapVal = new TreeMap<Float, List<Integer>>();
		
		allLocations.stream().forEach(
				x -> {
					int sum = (int) (Math.pow(x.get(0), 2) + Math.pow(x.get(1), 2) );
					float sq = (float) Math.sqrt(sum);
					mapVal.put(sq, x);
				});
		
		List<List<Integer>> res = mapVal.entrySet().stream().map( x -> x.getValue() ).collect(Collectors.toList());
		
		return res.subList(0, numSteakHouses);
	}
	
	
	//----------------------- 3. Solution by Cylixx
	// Using a list of bean and comparator
	
	static class Location {
		private float distance;
		private int x;
		private int y;
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			int sum = (int) (Math.pow(x, 2) + Math.pow(y, 2));
			this.distance = (float) Math.sqrt(sum);
		}
		public float getDistance() {
			return distance;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public List<Integer> getList() {
			return Arrays.asList(this.x, this.y);
		}
		@Override
		public String toString() {
			return String.format("Location [distance=%s, x=%s, y=%s]", distance, x, y);
		}
		
	}
	static List<List<Integer>> nearestXsteakHouses3(int totalSteakhouses, 
			List<List<Integer>> allLocations, 
			int numSteakHouses) {
	
		List<Location> locations =
		allLocations.stream().map(
				x -> {
					return new Location(x.get(0), x.get(1));  //llenamos lista de bean Locations
				}).sorted(Comparator.comparingDouble(Location::getDistance)). // Aplicamos ordenamiento a la lista 
		    collect(Collectors.toList());  // Obtenemos lista de bean Locations
		
		System.out.println(locations.toString());
		
		return locations.subList(0, numSteakHouses).stream().map(x -> x.getList()).collect(Collectors.toList());
	}
	
	
	

}
