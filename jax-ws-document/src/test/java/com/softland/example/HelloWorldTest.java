package com.softland.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softland.example.ws.HelloWorldService;
import com.softland.example.ws.HelloWorldServiceImpl;

public class HelloWorldTest {

	static Endpoint ep = null; 
	
    
 // Publica web service
    @BeforeClass
    public static void runOnceBeforeClass() {
    	ep = Endpoint.create(new HelloWorldServiceImpl());
		ep.publish("http://localhost:9999/ws/hello");  //publica ws service 
		assertTrue("El servicio se encuentra publicado...OK", ep.isPublished() );
    	System.out.println("@BeforeClass - El servicio se encuentra publicado...OK");
    }
    
 // Detiene web service
    @AfterClass
    public static void runOnceAfterClass() {
    	ep.stop();
    	assertNotNull( ep );
        System.out.println("@AfterClass - El servicio se a detenido...OK");
    }
    
    //Invoca operacion de web service
	@Test
	public void testWS() throws Exception {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.example.softland.com/", "HelloWorldService");
        Service service = Service.create(url, qname);
        HelloWorldService hello = service.getPort(HelloWorldService.class);
        String result = hello.getHelloWorldAsString("cylixx");
        assertNotNull("Invocando metodo getHelloWorldAsString", result);
        System.out.println("@Test - Invocando operacion <getHelloWorldAsString>: " + result);
	}

}
