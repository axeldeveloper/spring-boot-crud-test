# Spring CLI
  - $ ./mvnw packages
  - $ ./mvnw install
  - $ ./mvnw clean
  - $ ./mvnw spring-boot:run
 

# Add Maven Plugin to POM.XML
```xml
<build>
   <plugins>
     <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
```

# Build Spring Boot Project with Maven
  - ./mvnw packages
  
or

  - ./mvnw install 
  - ./mvnw clean install

# Run Spring Boot app using Maven:

    ./mvnw spring-boot:run