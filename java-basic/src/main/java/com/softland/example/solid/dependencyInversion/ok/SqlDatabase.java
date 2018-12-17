package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public class SqlDatabase implements Persistence {
    
    @Override
    public void save(Shopping shopping){
        // Saves data in SQL database
    	System.out.println("Saves data in SQL database");
    }
}
