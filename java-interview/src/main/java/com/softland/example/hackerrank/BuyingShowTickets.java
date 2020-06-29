/*
https://stackoverflow.com/questions/43950000/hackerrank-buying-show-tickets-optimization
https://github.com/spdeepak/hackerrank/tree/master/src/main/java/com/deepaksp/hackerrank



    There are n people standing in line to buy show tickets.Due to high demand, the venue sells tickets according to the following rules:

        The person at the head of the line can buy exactly one ticket and must then exit the line.
        if a person needs to purchase additional tickets,they must re-enter the end of the line and wait to be sold their next ticket(assume exit and re-entry takes zero seconds).
        Each ticket sale takes exactly one second.

    We express initial line of n people as an array, tickets = [tickets0, tickets1 ... ticketsN-1], where ticketsi denotes the number of tickets person i wishes to buy. 
    If Jesse is standing at a position p in this line, find out how much time it would take for him to buy all tickets. 
    Complete the waiting time function in the editor below. It has two parameters:

        An array, tickets, of n positive integers describing initial sequence of people standing in line. Each ticketsi describes number of tickets that a person waiting at initial place.

        An integer p, denoting Jesse's position in tickets.

        Sample 
        Input: 5 
        [2 6 3 4 5] 
        2 
        Output 12 
        
        Sample 
        Input: 4 
        [5 5 2 3]
        3 
        Sample Output 11


 
 */
package com.softland.example.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cylixx
 *
 */
public class BuyingShowTickets {
	
	public static void main(String[] args) {
	
		int[] arr = { 2, 6, 3, 4, 5 };   //inicializa array
		int p = 2;
		System.out.println("//---------------------[Solution #1]-------------------------");
//		int[] arr = { 5, 5, 2, 3 };   //inicializa array
//		int p = 3;
//		Long units = calculateTimeTakenToGetAllTickets(arr, p);
		Long u = waitingTime(arr, p);
		System.out.println("line: " + Arrays.toString(arr) + ", p=" + p);
		System.out.println("It took a total of <"+u+"> of time to purchase " + p );
		
		System.out.println("//---------------------[Solution #2 - My solution]-------------------------");
		int[] arr2 = { 2, 6, 3, 4, 5 };   //inicializa array
		int p2 = 2;
		Long units = waitingTime2(arr2, p2);
		System.out.println("line: " + Arrays.toString(arr2) + ", p=" + p2);
		System.out.println("It took a total of <"+units+"> of time to purchase " + p2 );
		
		System.out.println("//---------------------[Solution #3 - My Refactor]-------------------------");
		int[] arr3 = { 2, 6, 3, 4, 5 };   //inicializa array
		int p3 = 2;
		Long units3 = waitingTime3(arr3, p3);
		System.out.println("line: " + Arrays.toString(arr3) + ", p=" + p3);
		System.out.println("It took a total of <"+units3+"> of time to purchase " + p3 );
	}

	
// Esta solucion no funciona
//	private static Long calculateTimeTakenToGetAllTickets(int[] tickets, int p) {
//		Long count = 0L;
//		List<Integer> list = new ArrayList(Arrays.asList(tickets));
//		for (int i = 1; i < tickets.length; i++) {
//			list.add(tickets[i]);
//		}
//		final int size = list.size();
//		boolean done = false;
//		while (!done) {
//			for (int j = 1; j < size; j++) {
//				if (list.get(j) == 0) {
//					continue;
//				}
//				if (list.get(p + 1) == 0) {
//					done = true;
//					break;
//				}
//				list.set(j, list.get(j) - 1);
//				count++;
//			}
//		}
//		return count;
//	}
	
	static long waitingTime(int[] tickets, int p) {
		long noOfIterations = 0;
		int ticketBeingProcessed = 0;
		int numberOfParticipantsInLine = tickets.length;
		
		if (numberOfParticipantsInLine > p) {
			while (tickets[p] != 0) {
				// The person has already got his ticket and exited the line, just go to the
				// next person, dont increase number of iterations because it took no time
				if (tickets[ticketBeingProcessed] != 0) {
					// ticket being processed got one ticket
					tickets[ticketBeingProcessed] = tickets[ticketBeingProcessed] - 1;
					// if we have reached the end of the line
					if (ticketBeingProcessed == numberOfParticipantsInLine - 1)
						ticketBeingProcessed = 0;
					else
						ticketBeingProcessed++;
					noOfIterations++;
				} else {
					if (ticketBeingProcessed == numberOfParticipantsInLine - 1)
						ticketBeingProcessed = 0;
					else
						ticketBeingProcessed++;
				}
				// Log.d("asd",printArray(tickets));
				System.out.println(noOfIterations + ". tickets" + Arrays.toString(tickets));
			}
		}
		return noOfIterations;
	}
	
	
	/**
	 * Solution by Cylixx 2018-07-21
	 * @param tickets
	 * @param p
	 * @return
	 */
	private static long waitingTime2(int[] tickets, int p) {

		long unitTime = 0;
		int currentPlace = 0;
		int ticketsToBuy = tickets[p];

		while (ticketsToBuy > 0) {

			if (tickets[currentPlace] > 0 ) { //aqui validamos que al que le estamos vendiendo tenga boletos por comprar
				for (int i = 0; i < tickets.length; i++) {
					if (currentPlace == i) {
						if (tickets[i] > 0) {
							tickets[i] = tickets[i] - 1;
						}
					}
					ticketsToBuy = tickets[p];
				}
				if (currentPlace < tickets.length - 1) {
					currentPlace++;
				} else {
					currentPlace = 0;
				}
				unitTime++;  //contamos iteracion
			} else {
				currentPlace ++;  //si al que se esta atendiendo ya compro todos sus boletos (boletos=0), entonces nos pasamos al siguiente
			}
			
			System.out.println(unitTime + ". tickets" + Arrays.toString(tickets));
		}

		return unitTime;
	}
	
	
	/*
	 *------------------------------------------------------
	 * By Cylixx - BEST Solution.   06/28/2020
	 * En lugar de ir rotando las posiciones, lo que hacemos es hacer que el vendedor se mueva por cada
	 * cliente en la fila (index) y le vamos restando un boleto a cada clientes hasta que tenga 0 boletos,
	 * y mientras hacemos eso vamos contando cuantos ha vendido hasta llegar al cliente que queremos.
	 * 
	 * Big O(n*m) 
	 *     n - clientes en la fila
	 *     m - el numero de iteraciones
	 */
	private static long waitingTime3(int[] tickets, int p) {
		int size = tickets.length;
		int index = 0;
		long counter = 0;
		
		while(tickets[p] > 0) {
			if (tickets[index] == 0) {  //si el ticket en esa posicion es 0, entonces ya no locontamos, lo brincamos
				index++;
				continue;
			}
			
			tickets[index]--;
			counter++;
			
			if (tickets[p] == 0) { // paramos porque ya compro todos
				break;
			}
			
			index++;
			if (index == size) index = 0; //si llegamos al final del areglo regresamos el index al inicio
		}
		
		return counter;
	}
	
}
