package com.softland.example.javasenior2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.nashorn.internal.ir.ContinueNode;

//public class Test {
//
////	 static int [ ] a;
//	public[]
//	int a;
//
////	public static void main(String... args) {
////
//	Pattern p = Pattern.compile("a*b");
////		Matcher m = p.matcher("b");
////		boolean b = m.matches();
////		System.out.println(b);
////	}
//
//	public static void main(String[] args) {
////		Byte z = (byte)100L;
//////		 All the options are correct
////		 Byte x = (byte)1000L;
////		 Int w = (int) 888.8;
////		 Long y = (byte)100;
//		File f1 = new File("dirname");
//		File f2 = new File(f1, "filename");
//
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(0, 59);
//		int total = list.get(0);
//		System.out.println(total);
//	}
//
//	public class Calculator {
//		protected int Operation;
//
//		virtual
//		
////				 private int [3] a [ ];
////				 public final int [ ] a;
//
////				
//
//		protected void Calculate() {
//			Operation = 4;
//			p = null;
//		}
//	}
//
//	public class B extends Thread {
//		public static void main(String argv[]) {
//			B b = new B();
//			b.run();
//		}
//
//		public void start() {
//			for (int i = 0; i < 10; i++) {
//				System.out.println("Value of i = " + i);
//			}
//		}
//	}

//}


public class Test0 {

	public static void main(String... args) {

		Pattern p = Pattern.compile("a{3}b?c*");
		Matcher m = p.matcher("aaab");
		boolean b = m.matches();
		System.out.println(b);
	}
}
