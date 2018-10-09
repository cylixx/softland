package com.softland.example.javasenior2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String... args) {
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("b");
		boolean b = m.matches();
		System.out.println(b);
	}

}
