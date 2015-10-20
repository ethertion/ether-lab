A J2EE laboratory with the purpose of integrating software development solutions in order to learn how to build applications with the newest technologies.

### 1. Introduction 
The projects consists of a multi-tier modular Maven project that implements a J2EE application which emulates the behavior of a library. 

### 2. Technological environment
- Java 1.8
- Maven 3.
- Spring 4. 
- JUnit 4.
- ehCache
- Spring Boot

### 3. Architecture

- **Web layer**: Spring MVC (RESTful API)
- **Service layer**: Spring
- **Repository layer**: Spring Data JPA
- **Boot**: Spring Boot

### 4. Release notes

#### 1.0-SNAPSHOT

	- Publishes RESTful API to find, save and delete books at the library.
	- Caches books when finding with ehCache.
	- Integrates Spring Boot.

### 5. Installation

Run the following command to boot the application with Spring Boot:

	$ cd lab-webapp
	$ mvn spring-boot:run
	
### 6. The RESTful API

You can easily test the RESTful API by sending HTTP requests for all methods as follows:

* http://localhost:8080/lab-webapp/book/1/ (GET) (Finds a book with id 1)
* http://localhost:8080/lab-webapp/books/ (GET) (Finds all books)
* http://localhost:8080/lab-webapp/book/?title=Batman (GET) (Finds a book by title 'Batman')
* http://localhost:8080/lab-webapp/book/ (POST) (Saves a book. Title and author parameters as input in json format are optional, i.e: {"title": "Batman", "author": "Bob Kane"})
* http://localhost:8080/lab-webapp/book/1/ (DELETE) (Deletes the book with id 1)
