package com.softland.example.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {

		PriorityQueue<String> pq=
                new PriorityQueue<String>(5, (a,b) -> a.length() - b.length());  // Using lambda expression
       // or pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));  // Using Method reference
		pq.add("PineApple");
		pq.add("Apple");
        pq.add("Custard Apple");
        while (pq.size() != 0)
        {
            System.out.println(pq.remove());
        }
         
        
        System.out.println("-----------------------[implements Comparator]-------------------------------------------");
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
        queue.add("PineApple");
        queue.add("Apple");
        queue.add("Custard Apple");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }
        
        System.out.println("-----------------------[reverse order]----------------------------");
        // To reverse the order (to change it to max-priority queue) simply change the order in inline 
        // comparator or use reversed as:
        PriorityQueue<String> pqInt = new PriorityQueue<String>(5, Comparator.comparing(String::length).reversed());
        // or PriorityQueue<Integer> pqInt = new PriorityQueue<>(5, Collections.reverseOrder());
        pqInt.add("Apple");
        pqInt.add("PineApple");
        pqInt.add("Custard Apple");
        while (pqInt.size() != 0)
        {
            System.out.println(pqInt.remove());
        }
        
	}

}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String x, String y) {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.length() < y.length()) {
            return -1;
        }
        if (x.length() > y.length()) {
            return 1;
        }
        return 0;
    }
}
