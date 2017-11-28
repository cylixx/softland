package com.mkyong.customer.bo.impl;

import com.mkyong.annotation.MyAnnotation;
import com.mkyong.customer.bo.SomeOtherBo;

public class SomeOtherImpl implements SomeOtherBo{

	@MyAnnotation("ABC")
	public String someMethod(String name) {

		return "tu nombre es: " + name;
	}
}
