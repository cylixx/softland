package com.softland.example.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(
        //portName = "HelloWorldPort",
        serviceName = "HelloWorldService",
        //targetNamespace = "http://softland.com/",
        endpointInterface = "com.softland.example.ws.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS document style: " + name;
	}

}
