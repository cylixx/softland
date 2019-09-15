/*
 * 
 * You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.

For example, assume your bird sightings are of types
. There are two each of types and , and one sighting of type . Pick the lower of the two types seen twice: type

.

Function Description

Complete the migratoryBirds function in the editor below. It should return the lowest type number of the most frequently sighted bird.

migratoryBirds has the following parameter(s):

    arr: an array of integers representing types of birds sighted

Input Format

The first line contains an integer denoting
, the number of birds sighted and reported in the array .
The second line describes as

space-separated integers representing the type numbers of each bird sighted.

Constraints

It is guaranteed that each type is , , , , or

    .

Output Format

Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input 0

6
1 4 4 4 5 3

Sample Output 0

4

Explanation 0

The different types of birds occur in the following frequencies:

    Type 

:
bird
Type
:
birds
Type
:
bird
Type
:
birds
Type
:

    bird

The type number that occurs at the highest frequency is type
, so we print

as our answer.

Sample Input 1

11
1 2 3 4 5 4 3 2 1 3 4

Sample Output 1

3

Explanation 1

The different types of birds occur in the following frequencies:

    Type 

: Type : Type : Type : Type : Two types have a frequency of , and the lower of those is type .
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.List;

public class P08_MigratoryBirds {

	public static void main(String[] args) {
		System.out.println("-------- Example 1 ------------");
		List<Integer> l = Arrays.asList(1, 4, 4, 4, 5, 3);
		System.out.println("Input: " + l.toString());
		System.out.println("Outpu: " + migratoryBirds(l));

		System.out.println("-------- Example 2 ------------");
		List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
		System.out.println("Input: " + l2.toString());
		System.out.println("Outpu: " + migratoryBirds(l2));
	}
	
	/*
	 * Implementamos un hash table por medio de un array con el número total de tipos de aves
	 * 
	 * O(n) - n es el numero de aves
	 */
    static int migratoryBirds(List<Integer> arr) {
        int freq[] = new int[5];
        int type = 0, max = 0;

        for(Integer b : arr) {
            freq[b-1] = freq[b-1] + 1;
            if(freq[b-1] == max) {
                if(b < type)  type = b;
                max = freq[b-1];
            } else if(freq[b-1] > max) {
                type = b;
                max = freq[b-1];
            }    
        }
        return type;
    }

}
