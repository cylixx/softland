package com.softland.example.various;

public class BuyTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static long waitingTime(int[] tickets, int p) {

		int[] tempArray = tickets;
		int pTemp = p;
		int unitTime = 0;
		int totalTickets = tickets[p];

		while (totalTickets >= 0) {
			for (int i = 1; i < tickets.length; i++) {
				tempArray[i] = tickets[i + 1];
				unitTime++;
			}
			tempArray[tickets.length - 1] = tickets[1];
			pTemp--;
			waitingTime(tempArray, pTemp);
		}
		return pTemp;
	}

}
