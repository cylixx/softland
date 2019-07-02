package com.softland.example.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayLeftRotation {

	
	/**
	 * @param data array data
	 * @param d number of lect rotations
	 * @return
	 */
	static int[] rotLeft(int[] data, int d) {
		
		int[] result = new int[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			index = (i + (data.length - d)) % data.length;
			System.out.println("("+i+" + ("+data.length+" - "+d+")) % "+data.length+" = "+ index);
		    result[index] = data[i];
		}
		return result;
	}
	
	/**
	 * Rota areglo a la derecha N posiciones.
	 * <br>NOTA: Para rotar a la izquierda, poner el número de posiciones en negativo
	 * @param data Array of elements
	 * @param d número de posiones a rotar a la derecha 
	 * @return Array con elementos rotados a la derecha N veces
	 */
	static int[] rotateRight(int[] data, int d) {
		int size = data.length;
		int[] result = new int[size];
		
		// Nos aseguramso que no se desborde el array por la distancia a rotar
		// Por eso tenemos que ajustar la rotacion a la derecha que este drentro del
		// tamaño del array
		d = d % size;
		if (d < 0) 
			d += size;
		if (d == 0)
			return data;
		
		for (int i=0, index=0; i < size; i++) {
			index = i + d;
			// si la rotacion ala derecha es mayor al tamaño entonces ajustamos restando el tamaño
			if (index >= size) {
				index -= size;  
			}
			System.out.println("Distancia = " + d + ", index = " + i + "+" + d + " ==> " + index);
			result[index] = data[i];
		}
		return result;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Tamaño array: ");
		int n = in.nextInt();   //size
		System.out.println("Número de rotaciones a la izquierda: ");
		int d = in.nextInt();   //number of left rotations
		int[] data = new int[n];
		
		System.out.println("Ingresa datos: ");
		for(int i=0; i<n; i++) {
			data[i] = in.nextInt();
		}
		
		
		System.out.println("============== Rota array a la izquierda #1 ================");
		List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList()); //convert array to list
		Collections.rotate(list, d * -1);   // rotate at the left
		System.out.println(list.toString());
		
		System.out.println("");
		System.out.println("============== Rota array a la izquierda #2 ================");
		int[] result = rotLeft(data, d);
		for (int i : result) {
		    System.out.print(i + "  ");
		}
		
		System.out.println("");
		System.out.println("============== Rota array a la izquierda #3 ================");
		int[] result2 = rotateRight(data, d * -1);
		for (int i : result2) {
		    System.out.print(i + "  ");
		}
		
		in.close();
	}

}
