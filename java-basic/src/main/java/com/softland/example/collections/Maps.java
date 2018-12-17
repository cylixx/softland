package com.softland.example.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Maps {

	public static void main(String[] args) {
		loopMap();
		
	}

	public static void loopMap() {
		
		Map<String, String> data = new HashMap<String, String>();
//		data.put("1", "Jan");
//		data.put("2", "Feb");
//		data.put("3", "Mar");
		dummyMap(data);
		
        // Un poco mas rapido
		System.out.println("===== 1. Java 8 with foreach");
        long lStartTime2 = System.nanoTime();
          withForeach(data);
        long lEndTime2 = System.nanoTime();
		long output2 = lEndTime2 - lStartTime2;
        System.out.println("Elapsed time in milliseconds: " + output2 / 1000000);
	        
		
        //mas lento
        System.out.println("===== 2. Java 8 with stream");
        long lStartTime = System.nanoTime();
           withStream(data);
        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
        
	}
	
	public static List<Month> withForeach(Map<String, String> data) {
		List<Month> monthList = new ArrayList<Month>();
		data.forEach(
				(k,v) -> {
					Month month = new Month();
					month.setId(k);
					month.setName(v);
					monthList.add(month);
				});
		return monthList;
	}
	
	public static List<Month> withStream(Map<String, String> data) {
			return data.entrySet().stream().map(
						x -> {
							return new Month(x.getKey(), x.getValue());
						}).collect(Collectors.toList());
	}
	
	public static void dummyMap(Map<String, String> data) {
		for(int i=1; i<=50000; i++) {
			data.put(String.valueOf(i), "data" + i);
		}
	}
	
	private static class Month {
		private String id;
		private String name;
		
		public Month() {
			super();
		}
		public Month(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "month [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name : "") + "]";
		}
	}
}
