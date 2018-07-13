package com.mkyong.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();

	int val();
}

public class ReadAnnotationExample {


	@MyAnno(str = "Two Parameters", val = 19)
	public static void myMeth(String str, int i) {
		ReadAnnotationExample ob = new ReadAnnotationExample();

		try {
			Class c = ob.getClass();

			Method m = c.getMethod("myMeth", String.class, int.class);

			MyAnno anno = m.getAnnotation(MyAnno.class);

			System.out.println(anno.str() + " " + anno.val());
			
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String[] args) {
		myMeth("test", 10);

	}

}
