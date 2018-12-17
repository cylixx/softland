package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public class Server implements Persistence {
	 
    @Override
    public void save(Shopping shopping) {
        // Saves data in a server
    	System.out.println("Saves data in a server");
    }
}
