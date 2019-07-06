package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PA104_PrioritazedOrders {

	public static void main(String[] args) {

		List<String> list = Arrays.asList(
				"zld 9312",
				"fp kindle book",
				"10a echo show",
				"17g 12 25 6",
				"ab1 kindle book",
				"125 echo dot second generation"
				);
		System.out.println("Input: " + list.toString());
		
		
		//System.out.println("Output: " + prioritizedOrders(6, list).toString());
		System.out.println("1. Output: ");
		List<String> res = prioritizedOrders(6, list);
		for(String output : res) {
			System.out.println(output);
		}
		
		System.out.println("2. Output: ");
		List<String> res2 = prioritizedOrders2(6, list);
		for(String output2 : res2) {
			System.out.println(output2);
		}
		
		
		List<String> list2 = Arrays.asList(
				"mi2 jog mid pet",
				"wz3 34 54 398",
				"a1 alps cow bar",
				"x4 45 21 7"
				);
		System.out.println("\nInput 2: " + list.toString());
		
		System.out.println("1. Output: ");
		List<String> res3 = prioritizedOrders(6, list2);
		for(String output3 : res3) {
			System.out.println(output3);
		}
		
		System.out.println("2. Output: ");
		List<String> res4 = prioritizedOrders2(6, list2);
		for(String output4 : res4) {
			System.out.println(output4);
		}

	}

	/*
	  	For this algorith I use Java 8
	  	Algorithm complexity =  O(n) + O(n Log n) + O(n)
	  	  => = O(n*n*n Log n)
	  	     = O(n pow 3 Logn)
	  	
	
	 * Prime order - alphanumericID + aditional metadata (space delimited of lowercase)
	 * Non-prime order - alphanumericID + aditional metadata (space delimited of positive integrers)
	*/
	static public List<String> prioritizedOrders(int numOrders, List<String> orderList) {
		List<Order> prime = new ArrayList<Order>();
		List<Order> nonPrime = new ArrayList<Order>();
		
		// for each order get to sublist one prime an another nonPrime
		// O(n) complexity
		orderList.forEach(
				x -> {
					String[] words = x.split("\\s", 2);
//					System.out.println("Split word: " + Arrays.toString(words));
					//if (words[1].trim().matches("[a-z]+")) {
					if (words[1].replace(" ", "").matches("[0-9]+")) {
						nonPrime.add(new Order(words[0], words[1]));
					} else {
						prime.add(new Order(words[0], words[1]));
					}
				});
		System.out.println("Prime: " + prime.toString());
		System.out.println("Non Prime: " + nonPrime.toString());
		
		// we order the list according with the metadata, 
		//if the metadata is the same then we order by orderID
		// O(n Log n) complexity  for collections.sort()
		List<Order> result = 
		prime.stream().sorted(
					(o1, o2) -> {
//						System.out.printf("\no1=%s  o2=%s", o1, o2); 
						if (o1.getMetadata().equals(o2.getMetadata())) {
							return o1.getId().compareTo(o2.getId());
						} 
						return o1.getMetadata().compareTo(o2.getMetadata());
					}
				).collect(Collectors.toList());
		
		// we join prime and nonPrime orders
		result.addAll(nonPrime);
		
		//finally transform the bean list orders in an array of strings
		// O(n) complexity
		return result.stream().map(x -> x.getId() + " " + x.getMetadata()).collect(Collectors.toList());
	}
	
	static class Order {
		private String id;
		private String metadata;
		
		public Order(String id, String metadata) {
			super();
			this.id = id;
			this.metadata = metadata;
		}
		public String getId() {
			return id;
		}
		public String getMetadata() {
			return metadata;
		}
		@Override
		public String toString() {
			return String.format("Order [id=%s, metadata=%s]", id, metadata);
		}
	}
	
	//-----------------------------
	/*
	 Best answer
	 * Prime order - alphanumericID + aditional metadata (space delimited of lowercase)
	 * Non-prime order - alphanumericID + aditional metadata (space delimited of positive integrers)
  	
  	For this algorith I use Java 8
  	Algorithm complexity =  O(n) + O(n Log n)
  	  => = O(n*n Log n)
  	     = O(n pow 2 Logn)
  	
  	First is necessary divide the orders list in 2 one prime and other nonPrime
  	after that we need to sort the prime list according to the metadata value, 
  	but for obtain that value is necessary split the string in 2 in the first space found
  	for that way we obtain an array with two values the first is the orderId and the second is the metadata.
  	The first criteria for sort is the metadata and if we have a problem with same values, then sort by orderID.
  	The next step is only join the two list prime and non prime. 
  	

	*/
	static public List<String> prioritizedOrders2(int numOrders, List<String> orderList) {
		List<String> prime = new ArrayList<String>();
		List<String> nonPrime = new ArrayList<String>();
		
		// for each order get to sublist one prime an another nonPrime
		// O(n) complexity
		orderList.forEach(
				x -> {
					String[] words = x.split("\\s", 2);
//					System.out.println("Split word: " + Arrays.toString(words));
					//if (words[1].trim().matches("[a-z]+")) {
					if (words[1].replace(" ", "").matches("[0-9]+")) {
						nonPrime.add(x);
					} else {
						prime.add(x);
					}
				});
		System.out.println("Prime: " + prime.toString());
		System.out.println("Non Prime: " + nonPrime.toString());
		
		// we order the list according with the metadata, 
		//if the metadata is the same then we order by orderID
		// O(n Log n) complexity  for collections.sort()
		List<String> result = 
		prime.stream().sorted(
					(o1, o2) -> {
						String[] ao1 = o1.split("\\s", 2); // arra 1
						String[] ao2 = o2.split("\\s", 2); // attay 2
						
//						System.out.printf("\no1=%s  o2=%s", o1, o2);
						// if metadata is the same, then compare orderID
						if ( ao1[1].equals(ao2[1]) ) {  
							return ao1[0].compareTo(ao2[0]);
						} 
						return ao1[1].compareTo(ao2[1]);
					}
				).collect(Collectors.toList());
		
		// we join prime and nonPrime orders
		result.addAll(nonPrime);
		
		//finally transform the bean list orders in an array of strings
		// O(n) complexity
		return result;
	}
	
	
}
