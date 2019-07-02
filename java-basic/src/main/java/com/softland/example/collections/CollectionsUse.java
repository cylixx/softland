package com.softland.example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Collections examples:
 * 
 */
public class CollectionsUse {
	
	public static void main(String[] args) {
		List<String> lnkLst = new LinkedList<String>();
	      lnkLst.add("element1");
	      lnkLst.add("element2");
	      lnkLst.add("element3");
	      lnkLst.add("element4");
	      System.out.println("===============[ LinkedList ]===============");
	      displayAll(lnkLst);
	      
	      List<String> aryLst = new ArrayList<String>();
	      aryLst.add("x");
	      aryLst.add("y");
	      aryLst.add("z");
	      aryLst.add("w");
	      System.out.println("===============[ ArrayList ]===============");
	      displayAll(aryLst);
	      
	      Set<String> hashSet = new HashSet<String>();
	      hashSet.add("set1");
	      hashSet.add("set2");
	      hashSet.add("set3");
	      hashSet.add("set4");
	      System.out.println("===============[ HashSet ]===============");
	      displayAll(hashSet);
	      
	      SortedSet<String> treeSet = new TreeSet<String>();
	      treeSet.add("1");
	      treeSet.add("2");
	      treeSet.add("3");
	      treeSet.add("4");
	      System.out.println("===============[ TreeSet ]===============");
	      displayAll(treeSet);
	      
	      LinkedHashSet<String> lnkHashset = new LinkedHashSet<String>();
	      lnkHashset.add("one");
	      lnkHashset.add("two");
	      lnkHashset.add("three");
	      lnkHashset.add("four");
	      System.out.println("===============[ LinkedHashSet ]===============");
	      displayAll(lnkHashset);
	      
	      Map<String,String> map1 = new HashMap<String, String>();
	      map1.put("A", "value1");
	      map1.put("B", "value2");
	      map1.put("C", "value3");
	      map1.put("D", "value4");
	      map1.put("B", "value5");
	      System.out.println("===============[ HashMap ]===============");
	      System.out.println( map1.toString() );
//	      displayAll(map1.keySet());
//	      displayAll(map1.values());
	      
	      SortedMap<String,String> map2 = new TreeMap<String,String>();
	      map2.put("A", "value1");
	      map2.put("B", "value2");
	      map2.put("C", "value3");
	      map2.put("D", "value4");
	      map2.put("B", "value5");
	      System.out.println("===============[ TreeMap ]===============");
	      System.out.println( map2.toString() );
//	      displayAll(map2.keySet());
//	      displayAll(map2.values());
	      
	      LinkedHashMap<String,String> map3 = new LinkedHashMap<String,String>();
	      map3.put("A", "value1");
	      map3.put("B", "value2");
	      map3.put("C", "value3");
	      map3.put("D", "value4");
	      map3.put("B", "value5");
	      System.out.println("===============[ LinkedHashMap ]===============");
	      System.out.println( map3.toString() );
//	      displayAll(map3.keySet());
//	      displayAll(map3.values());
	      
	      System.out.println("\n----------------------------");
	      System.out.println(">Collection Set time spent: ");
	      CollectionSetTime();
	      
	   }
	
	   static void displayAll(Collection col) {
	      Iterator itr = col.iterator();
	      while (itr.hasNext()) {
	         String str = (String) itr.next();
	         System.out.print(str + " ");
	      }
	      System.out.println();
	   }
	   
	   
	   static void CollectionSetTime() {
		   final Set<Integer> hashSet = new HashSet<Integer>(1000000);
			final Long startHashSetTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++) {
			    hashSet.add(i);
			}
			final Long endHashSetTime = System.currentTimeMillis();
			System.out.println("Time spent by HashSet: " + (endHashSetTime - startHashSetTime));

			final Set<Integer> treeSet = new TreeSet<Integer>();
			final Long startTreeSetTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++) {
			    treeSet.add(i);
			}
			final Long endTreeSetTime = System.currentTimeMillis();
			System.out.println("Time spent by TreeSet: " + (endTreeSetTime - startTreeSetTime));

			final Set<Integer> linkedHashSet = new LinkedHashSet<Integer>(1000000);
			final Long startLinkedHashSetTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++) {
			    linkedHashSet.add(i);
			}
			final Long endLinkedHashSetTime = System.currentTimeMillis();
			System.out.println("Time spent by LinkedHashSet: " + (endLinkedHashSetTime - startLinkedHashSetTime));
			
	   }
	   
}
