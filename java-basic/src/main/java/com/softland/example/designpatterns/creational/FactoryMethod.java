package com.softland.example.designpatterns.creational;

public class FactoryMethod {

	class A {
		public void doSomething() {
			Foo f = makeFoo();
			f.whatever();
		}

		protected Foo makeFoo() {
			return new RegularFoo();
		}
	}

	class B extends A {
		protected Foo makeFoo() {
			// subclass is overriding the factory method
			// to return something different
			return new SpecialFoo();
		}
	}

	public static void main(String[] args) {

	}
}
