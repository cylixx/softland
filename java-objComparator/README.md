
# Java object sorting (Comparator)
  
This example it shows the use of **java.util.Comparator**  to sort a Java object based on its property value.



*   Sort an Array   

_To sort an Array, use the Arrays.sort()._ 

Example:  

`String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"};  
  
Arrays.sort(fruits); 
` 

*   Sort an ArrayList   

_To sort an ArrayList, use the Collections.sort()._ 

Example:  

`List<String> fruits = new ArrayList<String>();
fruits.add("Pineapple");
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");
Collections.sort(fruits);
`   
  
  

To create project:  
`mvn archetype:generate -DgroupId=com.softland.example -DartifactId=java-objComparator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false` 
