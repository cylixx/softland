
# Spring Security Annotation y su configuración



> **What is Basic Authentication?** 

Traditional authentication approaches like login pages or session identification are good for web based clients involving human interaction but does not really fit well when communicating with [REST] clients which may not even be a web application. Think of an API over a server which tries to communicate with another API on a totally different server, without any human intervention.

**Basic Authentication**  provides a solution for this problem, although not very secure. With Basic Authentication, clients send it’s Base64 encoded credentials with each request, using HTTP [Authorization] header . That means each request is independent of other request and server may/does not maintain any state information for the client, which is good for scalability point of view.




------------------------------------------------------------
###### REFERENCE 

[Secure Spring REST API using OAuth2](http://websystique.com/spring-security/secure-spring-rest-api-using-oauth2/ "title") 

###### Others reference

*	[AngularJS+Spring Security using Basic Authentication](http://websystique.com/spring-security/angularjs-basic-authentication-using-spring-security/ "title") 
*   [Getting started with Spring Security, Spring Session and Redis](https://drissamri.be/blog/2015/05/21/spring-security-and-spring-session/ "title") 
*   second_item

