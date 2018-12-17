package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public class CreditCard implements PaymentMethod{
	@Override
    public void pay(Shopping shopping){
        // Performs payment using a credit card
		System.out.println("Performs payment using a credit card");
    }
}
