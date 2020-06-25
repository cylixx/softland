package com.softland.example.designpatterns.dependencyInjection;

/**
 *	What is Dependency Injection with Java Code Example
 *  https://www.codejava.net/coding/what-is-dependency-injection-with-java-code-example
 *  
 *  Dependency injection: 
 *  Dependency injection is a technique that allows the client code to be independent from the services it is relying on. 
 *  The client does not control how objects of the services are created - it works with an implementation of the service through interface. 
 *  This is somewhat in inverse to trivial programming so dependency injection is also called inversion of control.
 *  
 */
public class DependencyInjection {

	public static void main(String[] args) {

		// Dependency Injection by constructor
		Service service = new ServiceB();
		Client client = new ClientA(service);
		client.doSomething();
		
		// setter injection 
		((ClientA) client).setService(new ServiceC());
		client.doSomething();
	}

}

interface Client {
    void doSomething();
}
 
interface Service {
    String getInfo();
}

class ServiceB implements Service {
	 
    @Override
    public String getInfo() {
        return "ServiceB's Info";
    }
}

class ServiceC implements Service {
	 
    @Override
    public String getInfo() {
        return "ServiceC's Info";
    }
}
 
class ServiceD implements Service {
 
    @Override
    public String getInfo() {
        return "ServiceD's Info";
    }
}

class ClientA implements Client {
    
    Service service;
     
    public ClientA(Service service) {
        this.service = service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }
 
    @Override
    public void doSomething() {
         
        String info = service.getInfo();
        System.out.println(info); 
    }
}

