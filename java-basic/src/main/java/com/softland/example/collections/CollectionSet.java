package com.softland.example.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionSet {

	public static void main(String[] args) {

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
