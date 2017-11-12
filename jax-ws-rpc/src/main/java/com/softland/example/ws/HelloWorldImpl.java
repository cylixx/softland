package com.softland.example.ws;
 
import javax.jws.WebService;
 
//Service Implementation
@WebService(serviceName = "HelloWorldService", endpointInterface = "com.softland.example.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS RPC style " + name;
	}
 
}