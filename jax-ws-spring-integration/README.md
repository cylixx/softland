
# Create project with maven archetype  "maven-archetype-webapp"
mvn archetype:generate -DgroupId=com.softland.example.web -DartifactId=jax-ws-spring-integration -DarchetypeArtifactId=maven-archetype-webapp -DinterativeMode=false

# Convert project to eclipse project
mvn eclipse:eclipse -Dwtpversion=2.0


#Note:
mvn eclipse:eclipse --> Eclipse Java project (JAR)
mvn eclipse:eclipse -Dwtpversion=2.0 --> Eclipse Java web project (WAR)


For convenience, declares maven-eclipse-plugin and configure wtpversion to avoid typing the parameter -Dwtpversion=2.0
#Example
	<!-- Eclipse project plugin -->
	     <plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-eclipse-plugin</artifactId>
			<version>2.9</version>
			<configuration>
			        <!-- Always download and attach dependencies source code -->
				<downloadSources>true</downloadSources>
				<downloadJavadocs>false</downloadJavadocs>
				<!-- Avoid type mvn eclipse:eclipse -Dwtpversion=2.0 -->
				<wtpversion>2.0</wtpversion>
			</configuration>
		 </plugin>

