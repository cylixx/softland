package com.softland.example.client;
 
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.softland.example.ws.HelloWorldService;
 
public class HelloWorldClient{
 
	public static void main(String[] args) throws Exception {
 
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
 
        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.example.softland.com/", "HelloWorldService");
        Service service = Service.create(url, qname);
        HelloWorldService hello = service.getPort(HelloWorldService.class);
        System.out.println(hello.getHelloWorldAsString("cylixx"));
 
    }
 
}