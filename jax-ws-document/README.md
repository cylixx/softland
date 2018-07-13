
# JAX-WS 	– Document Style

**This example show you how to use JAX-WS to create a SOAP-based web service (document style) endpoint. ** 


#### wsgen command

> 
Document style requires extra classes to run, you can use “wsgen” to generate all necessary Java artifacts (mapping classes, wsdl or xsd schema). The “wsgen” command is required to read a service endpoint implementation class :


`wsgen -verbose -keep -cp path_classes name_of_impl_class_with_package -s path_src_main_java`  

_Example:_ 

`wsgen -keep -cp . com.softland.example.ws.HelloWorldServiceImpl`  

`wsgen -verbose -keep -cp /home/marco/workspace/eclipseneon/jax-ws-document/target/classes com.softland.example.ws.HelloWorldServiceImpl -s /home/marco/workspace/eclipseneon/jax-ws-document/src/main/java` 


### Note

_In JAX-WS development, convert from “RPC style” to “Document style” is very easy, just change the @SOAPBinding style option._  

