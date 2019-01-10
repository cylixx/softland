/**
 * https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * Factory Pattern
 * 
 */
package com.softland.example.designpatterns.creational;

public class FactoryMethod2 {

	interface Shape {
		void draw();
	}

	class Rectangle implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Rectangle::draw() method.");
		}
	}

	class Square implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Square::draw() method.");
		}
	}

	class Circle implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Circle::draw() method.");
		}
	}

	// Create a Factory to generate object of concrete class based on given
	// information.
	//class ShapeFactory {
	class ShapeFactory {

		// use getShape method to get object of type shape
		public Shape getShape(String shapeType) {
			if (shapeType == null) {
				return null;
			}
			if (shapeType.equalsIgnoreCase("CIRCLE")) {
				return new Circle();

			} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
				return new Rectangle();

			} else if (shapeType.equalsIgnoreCase("SQUARE")) {
				return new Square();
			}

			return null;
		}
	}

	public static void main(String[] args) {

		FactoryMethod2 factoryMethod2 = new FactoryMethod2();
		// Use the Factory to get object of concrete class by passing an information
		// such as type.
		//ShapeFactory shapeFactory = new ShapeFactory();
		ShapeFactory shapeFactory = factoryMethod2.new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();

		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Rectangle
		shape2.draw();

		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// call draw method of square
		shape3.draw();
	}

}
