/*  20210615
 
	Encontrar los SteakHouse mas cercanos al origen (0,0).
	
	totalSteakhouses - total de steakhouses
	allLocations - cordenadas de todos los steakHouses (x, y)
	numSteakHouses - numero de los primeros steakHouses a mostrar


	Reference:
	https://www.freecodecamp.org/news/priority-queue-implementation-in-java/
*/

package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PA103_FindNearestSteakHouse_2 {

	public static void main(String[] args) {

		List<List<Integer>> allLocations = Arrays.asList(
				Arrays.asList(1, 2), 
				Arrays.asList(3, 4),
				Arrays.asList(1, -1));

		List<List<Integer>> result = nearestXsteakHouses(3, allLocations, 3);

		for (List<Integer> loc : result) {
			System.out.println(loc.toString());
		}

	}

	static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, List<List<Integer>> allLocations,
			int numSteakHouses) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (totalSteakhouses == 0) return result;
		if (totalSteakhouses == 1) return allLocations;

		Queue<List<Integer>> pq = new PriorityQueue<>(new DistanceComparator());
		for (List<Integer> loc : allLocations) {
			pq.add(loc);
		}
		
		for(int i=0; i < numSteakHouses; i++) {
			result.add(pq.poll());
		}

		return result;
	}

	/*
	   o1 < o2 ? 1 : -1   ==> descending order
	   o1 > o2 ? 1 : -1   ==> ascending order
	*/
	static class DistanceComparator implements Comparator<List<Integer>> {

		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			double o11 = Math.pow(o1.get(0), 2) + Math.pow(o1.get(1), 2);
			double o22 = Math.pow(o2.get(0), 2) + Math.pow(o2.get(1), 2);
//			double o11 = Math.sqrt( Math.pow(o1.get(0), 2) + Math.pow(o1.get(1), 2));
//			double o22 = Math.sqrt( Math.pow(o2.get(0), 2) + Math.pow(o2.get(1), 2));
			return o11 > o22 ? 1 : -1;
		}

	}

}
