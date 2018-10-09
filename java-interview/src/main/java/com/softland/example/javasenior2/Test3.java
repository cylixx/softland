package com.softland.example.javasenior2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {

	public static void main(String... args) {

		Pattern p = Pattern.compile("a{3}b?c*");
		Matcher m = p.matcher("aaab");
		boolean b = m.matches();
		System.out.println(b);
	}
}
