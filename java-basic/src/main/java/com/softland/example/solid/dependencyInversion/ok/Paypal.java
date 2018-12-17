package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public class Paypal implements PaymentMethod {
	 
    @Override
    public void pay(Shopping shopping) {
        // Performs payment using Paypal account
    	System.out.println("Performs payment using Paypal account");
    }
}
