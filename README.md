# Parliament

Parliament is an API document center for microservice architecture based on [SpringFox](http://springfox.github.io/springfox/) and [Swagger](http://swagger.io/). It aims to manage all APIs of individual microservices in one place.

The idea comes from [GrokOla](http://www.grokola.com/) who provides a featured Wiki for dev teams. If you find Parliament is not enough for you, please take a look at [GrokOla](http://www.grokola.com/). 

## How to run Parliament server

### Prerequisites
This project is implemented using Spring Boot, and MongoDB for database.
- Java 1.8
- Maven
- MongoDB


### Config Database
Modify MongoDB configurations in application.properties:

    spring.data.mongodb.host = _MongoDB address_
    spring.data.mongodb.database = _MongoDB database name_
    spring.data.mongodb.port = _MongoDB port_

### Build and Start up
Use following command to start:

    mvn package && java -jar target/Parliament-1.0.0.jar

## Publish API information 
This section is only for Spring Boot application.

To publish API information to Parliament server, please use:
- springfox-swagger2 from SpringFox
- khs-spring-boot-publish-swagger-starter which build from [https://github.com/burnettzhong/khs-spring-boot-publish-swagger-starter](https://github.com/burnettzhong/khs-spring-boot-publish-swagger-starter)

CAUTION: for _khs-spring-boot-publish-swagger-starter_, please do not use original one from Keyhole Software, since there are several bugs. I have created pull request to them, if they merge my code, I will update this section.

1. Build and add khs-spring-boot-publish-swagger-starter dependency, run following command:


    git clone https://github.com/burnettzhong/khs-spring-boot-publish-swagger-starter
    cd khs-spring-boot-publish-swagger-starter
    mvn clean install
    
    
2. Add maven dependencies

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.6.1</version>
        </dependency>
        <dependency>
            <groupId>com.keyholesoftware</groupId>
            <artifactId>khs-spring-boot-publish-swagger-starter</artifactId>
            <version>1.0.2</version>
        </dependency>

3. Configure your Spring Boot application for Swagger and push API information to Parliament server.
Simply add **@EnableSwagger2** and **@PublishSwagger** annotations.


    @EnableSwagger2
    @PublishSwagger
    public class ServiceApplication {
        ...
    }

For more information about Swagger2 usage, please visit [Springfox Reference Documentation](http://springfox.github.io/springfox/docs/current/).

4. Add the following properties your application.yml file:
   swagger:
     publish:
       publish-url: http://{_Parliament server address_}/swagger/publish/
       swagger-url: http://127.0.0.1:${server.port}/v2/api-docs


That's all! Now you can start your Spring Boot application, the API information will be published to Parliament Server automatically.

### Visit API information

Open http://{_Parliament Server address_}/index.html, you will see a list of all your microservices, then you can see more details if click on them.

License
--------------------

Copyright 2017 Han Zhong - [@burnettzhong](https://github.com/burnettzhong)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at [apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

