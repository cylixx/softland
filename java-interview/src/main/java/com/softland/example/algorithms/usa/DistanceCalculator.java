package com.softland.example.algorithms.usa;
/*
 07/29/2020
 
 Classes and Objects: Distance
 
 There is an abstract class with its fields methods declared. The object will
 contain a distance in feet and inches. Implement the methods as described to
 initialize the class instance and return which of the distances is greater, if there is
 one.
 
 Answer:
 
 The key is in convert the feed in inches,
 we can create a new method to obtain the distance in inches 
 or we can set the values in the method setFeetAndInches(..)
 
 based on the test you can observe that
 1 ft = 12.0 in
 
 */
public class DistanceCalculator {

	public static void main(String[] args) {
		DistanceImplementation dist1 =  new DistanceImplementation();
		dist1.setFeetAndInches(1, 2);
		
		DistanceImplementation dist2 =  new DistanceImplementation();
		dist2.setFeetAndInches(3, (float)4.1);
		
		System.out.println(String.format("inches obj1 = %s, inches obj2 = %s", dist1.getInches(), dist2.getInches()));
		System.out.println(dist1.getDistanceComparison(dist2));
	}

}


abstract class Distance {
	protected int feed;
	protected float inches;
	
	abstract void setFeetAndInches(int feed, float inches);
	abstract int getFeed();
	abstract float getInches();
	abstract String getDistanceComparison(Distance dist2);
	
}

class DistanceImplementation extends Distance {

	@Override
	void setFeetAndInches(int feed, float inches) {
		this.feed = feed + (int) (inches / 12);   // 1 ft = 12.0 in
		this.inches = inches + (float) (feed * 12.0);
	}

	@Override
	int getFeed() {
		return this.feed;
	}

	@Override
	float getInches() {
		return this.inches;
	}
	

	@Override
	String getDistanceComparison(Distance dist2) {
		
		if (this.getInches() > dist2.getInches()) 
			return "First distance ins greater.";
		
		else if (dist2.getInches() > this.getInches())	
			return "Second distance is greater.";
		
		return "Both distances are equal.";
	}
	
}





