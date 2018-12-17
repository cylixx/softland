package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public interface Persistence {
	void save(Shopping shopping);
}
