package com.softland.example.javasenior2;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
//Byte z = (byte)100L;
//// All the options are correct
// Byte x = (byte)1000L;
// Int w = (int) 888.8;
// Long y = (byte)100;
//File f1 = new File("dirname");
//File f2 = new File(f1, "filename");

		List<Integer> list = new ArrayList<Integer>();
		list.add(0, 59);
		int total = list.get(0);
		System.out.println(total);
	}

}
