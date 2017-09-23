
# Spring MVC Web Project Example 
  
Create project with maven archetype and choose:
1046: maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)

**Example:**  
  
mvn archetype:generate -DgroupId=com.softland.example.web -DartifactId=spring-mvc-webapp -DarchetypeArtifactId=maven-archetype-webapp -DinterativeMode=false


Convert project to eclipse project:
mvn eclipse:eclipse -Dwtpversion=2.0


# Note:

*   mvn eclipse:eclipse --> Eclipse Java project (JAR)
*   mvn eclipse:eclipse -Dwtpversion=2.0 --> Eclipse Java web project (WAR)
 
  
For convenience, declares maven-eclipse-plugin and configure wtpversion to avoid typing the parameter -Dwtpversion=2.0
