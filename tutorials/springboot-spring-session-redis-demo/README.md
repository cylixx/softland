
# Session Management using Spring Session with JDBC DataStore  / Redis
In web applications, user session management is very crucial for managing user state. In this article, we are going to learn about what are the approaches we have been following to manage user sessions in a clustered environment and how we can use Spring Session to implement it in a much simpler and more scalable way.

Typically in production environments, we will have multiple server nodes with a load balancer in front of them and all the client traffic will be coming through the load balancer to one of the server nodes. So we need some mechanism to make the user session data available to each client in a clustered environment.

Traditionally we have been using the following techniques to manage sessions:


1.  Single Node Server
2.  Multi-Node Server with Load Balancer and Sticky sessions
3.	Multi-Node Server with Load Balancer and Session Replication
4.  Multi-Node Server with Load Balancer and Session Data in a Persistent DataStore
    

###### Reference
*   [Session Management using Spring Session with JDBC DataStore](https://sivalabs.in/2018/02/session-management-using-spring-session-jdbc-datastore/ "title")

###### Others reference
*	[Spring Security Login Page with Angular](https://www.baeldung.com/spring-security-login-angular "title")
*	[Simple Single Sign-On with Spring Security OAuth2](https://www.baeldung.com/sso-spring-security-oauth2 "title")
*	[Control the Session with Spring Security](https://www.baeldung.com/spring-security-session "title")   
*   [Spring Session and Spring Security](https://docs.spring.io/spring-session/docs/current/reference/html5/guides/java-security.html#security-spring-configuration "title") 

