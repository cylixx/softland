
# Spring Boot Profiles example


##### Run app

`$ mvn package` 

**default profile, sunny day!** 

`$ java -jar target/spring-boot-profile-1.0.jar` 
  
Today is sunny day!

**set a profile** 
  
`$ java -jar -Dspring.profiles.active=raining target/spring-boot-profile-1.0.jar` 
  
Today is raining day!



------------------------------------------------------------
###### REFERENCE 

*   [Spring Boot Profiles example](https://www.mkyong.com/spring-boot/spring-boot-profiles-example/ "title") 

