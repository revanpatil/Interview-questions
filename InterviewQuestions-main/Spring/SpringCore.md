# SpringBoot version ; spring version inside that? 

1. Started the development with SpringBoot version 2.5.4 - underlying Spring version 5.3.9 (Septmber 2021) With Java 8
2. Right now upgraded to SpringBoot 2.7.15 with Java 11
3. Need to upgrade to Java 17/18 in order to use SpringBoot 3.0 or 3.1 with Spring 6
   (From Spring Framework 6.0, it requires Java 17+. )


# Why would I need springboot?

"Why would I need Spring Boot?" is a common interview question that focuses on your understanding of Spring Boot and its advantages. Here's a comprehensive answer you can use:

Spring Boot is a framework that simplifies the process of building production-ready, stand-alone, and web-based applications. It's built on top of the Spring Framework and provides several benefits that make it a popular choice for developing Java applications:

1. **Easy Configuration:** Spring Boot offers a convention-over-configuration approach, meaning it provides sensible defaults for various configurations. This eliminates the need for extensive XML configurations, resulting in a more streamlined development process.

2. **Rapid Development:** Spring Boot's auto-configuration and starter dependencies enable developers to quickly set up projects and get them running. It reduces boilerplate code and simplifies development tasks, allowing developers to focus on writing application logic.

3. **Microservices:** Spring Boot is well-suited for building microservices architecture due to its lightweight nature and easy containerization. It supports building and deploying individual microservices that can work together as part of a larger application.

4. **Embeddable Servers:** Spring Boot includes support for embedded web servers such as Tomcat, Jetty, and Undertow. This means you can package your application as a standalone executable JAR or WAR file, simplifying deployment.

5. **Production-Ready Features:** Spring Boot provides built-in features for monitoring, health checks, metrics, and configuration management, making it easier to develop production-ready applications with necessary monitoring and management capabilities.

6. **Spring Ecosystem Integration:** Spring Boot integrates seamlessly with other components of the Spring ecosystem, such as Spring Data, Spring Security, and Spring Cloud, enabling you to leverage a wide range of features.

7. **Automated Testing:** Spring Boot encourages and facilitates automated testing. It provides tools for writing unit tests, integration tests, and end-to-end tests, ensuring the application's quality.

8. **Community and Documentation:** Spring Boot has a large and active community, which means you can find a wealth of resources, tutorials, and documentation to help you troubleshoot issues and accelerate development.

9. **Opportunity for Scalability:** Spring Boot applications can be scaled horizontally and vertically to accommodate increasing user loads.

10. **Industry Adoption:** Spring Boot is widely used across various industries, making it a valuable skill to have for job opportunities and career growth.

In summary, Spring Boot simplifies and accelerates Java application development by providing a set of tools and conventions that minimize configuration overhead, promote best practices, and facilitate the creation of robust, scalable, and production-ready applications.

---

# **1. How do you access web.xml file through code in Spring?**

- In Spring, you can access the web.xml file through code by using the ServletContext object. The ServletContext object
  represents the configuration of your web application and can be obtained in a Spring bean by using the
  ServletContextAware interface. Here's an example:

```java
        import javax.servlet.ServletContext;
        import org.springframework.web.context.ServletContextAware;

        public class WebXmlConfig implements ServletContextAware {

            private ServletContext servletContext;

            @Override
            public void setServletContext(ServletContext servletContext) {
                this.servletContext = servletContext;
            }

            public void readWebXmlConfig() {
                // Get the value of a context parameter defined in web.xml
                String parameterValue = servletContext.getInitParameter("parameterName");

                // Do something with the parameter value...
            }
        }
```        
- In this example, the WebXmlConfig class implements the ServletContextAware interface and implements the
  setServletContext method to store a reference to the ServletContext object. You can then use this reference to access
  the configuration information stored in the web.xml file.

---

# **2. What are Actuators/ use of actuators?**

- Spring Boot Actuators are a set of tools for monitoring and managing a Spring Boot application. They provide a number
  of endpoints for gathering information about the health and performance of a running application, as well as for
  managing the application's configuration and state.
- Some of the key features provided by Spring Boot Actuators include:
    - **Health monitoring:** provides a simple way to monitor the health of a Spring Boot application, and to expose
      health information to external systems, such as load balancers or monitoring tools.
    - **Metrics collection:** provides a way to collect metrics about the performance and resource usage of a Spring
      Boot application, such as request counts, response times, and memory usage.
    - **Configuration management:** provides a way to manage the configuration of a Spring Boot application, and to
      retrieve configuration information at runtime.
    - **Logging:** provides a way to retrieve log information at runtime, and to manage the logging configuration of a
      Spring Boot application.

- By default, Spring Boot Actuators automatically enable some common endpoints, such as `/health`, `/info`, and `/actuator`. However, you can customize the endpoints that are exposed by the Actuators.

- To customize the Actuator endpoints, you can use the `application.properties` or `application.yml` file. For example, to enable additional endpoints like `/beans`, `/env`, and `/metrics`, you can add the following to your `application.properties` file:

```properties
management.endpoints.web.exposure.include=beans,env,metrics
```

For example:

- `/actuator/health`: Provides information about the health of the application.
- `/actuator/info`: Provides general information about the application.
- `/actuator/beans`: Provides information about Spring beans in the application.
- `/actuator/env`: Provides information about the application's environment properties.
- `/actuator/metrics`: Provides various metrics related to the application's performance.

Please note that some endpoints, like `/shutdown`, are sensitive and should not be exposed in a production environment without proper security measures.

- In summary, Spring Boot Actuators provide a simple and effective way to monitor and manage a Spring Boot application,
  and are a key component of the Spring Boot framework for building production-ready applications.

---

# **3. What can be used for logging in Spring?**

- Java Util Logging (JUL)
- Log4j
- Commons Logging
- SLF4J

- Of these, SLF4J (Simple Logging Facade for Java) is the most widely used, as it provides a simple and flexible logging
  facade for various logging frameworks, such as Log4j, JUL, and Commons Logging. With SLF4J, you can use the same API
  for logging across different implementations, making it easier to switch between logging frameworks without changing
  your code.
- To use SLF4J in Spring, you'll need to add the following dependency to your pom.xml file:

```xml

<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
```

- Then, you can use the SLF4J API in your code as follows:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public void doSomething() {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("Warn log message");
        logger.error("Error log message");
    }
}
```

- In this example, the Logger object is created using the LoggerFactory and the class type. You can then use the logger
  object to log messages at different levels (debug, info, warn, error). To configure the logging framework, you'll need
  to add a separate dependency for the desired implementation and configure it according to the instructions provided by
  the framework.

---

# **4. What is singleton Pattern?**

- In Java, a singleton is a design pattern that restricts the instantiation of a class to a single instance and provides
  a global point of access to that instance. The singleton pattern is used to ensure that there is only one instance of
  a class in the entire application and that it is easily accessible from anywhere in the application.
- In Spring Framework, which is a popular Java framework for building web applications, the Singleton scope is one of
  the five built-in scopes that can be used to manage the lifecycle of beans. The Singleton scope is the default scope
  for Spring beans and it means that only one instance of the bean will be created per Spring context (per application).
  This means that any other bean that depends on the singleton bean will get the same instance.

  --- 

# 5. If I have a class with singleton scope and inside that class I have another class of Prototype scope; what happens to the inner class object if I instantiate the outer class object? Does multiple objects get created for that inner class?

- When you instantiate a class with a singleton scope, only one instance of that class will be created and shared across the application. However, if that singleton class has a dependency on another class with prototype scope, multiple instances of the inner class will be created.

Each time you request an instance of the outer class from the container, it will return the same singleton instance. However, each time that singleton instance needs an instance of the inner class, a new instance of the inner class will be created and returned.

So, if you instantiate the outer class object multiple times, you will get the same instance of the singleton class each time, but each instance of the singleton class will have its own instance of the inner class.

It's important to note that if the inner class has any state that is modified during its lifetime, you may encounter unexpected behavior if you're not careful about managing the lifetime of the inner class instances.

--- 

# **6. Annotations in Spring:**

- @RequestMapping: `RequestMapping is an annotation in Spring framework used to map HTTP requests to specific handler
  methods`. It is used to define the endpoint of a RESTful web service or a specific controller method in a Spring MVC
  application. The RequestMapping annotation maps a specific URL or URL pattern to a controller method, which then
  processes the request and returns the response.
- @Component: Indicates that a class is a Spring-managed component and can be automatically discovered by Spring.
- @Autowired: Injects a dependency (i.e. another Spring-managed component) into a Spring-managed component.
- @Configuration: Marks a class as a source of Spring configuration.
- @Bean: Marks a method as a provider of a Spring bean.
- @Controller, @Service, @Repository: Specialized forms of @Component that are used to indicate the role of a component
  within the application architecture.
- @Transactional: Marks a method or class as transactional, allowing Spring to automatically manage transactions for the
  annotated component.

--- 

# **7. What are annotations in Spring?**

- Annotations are a form of metadata that can be added to classes, methods, and fields in Java code. In the Spring
  framework, annotations are extensively used to provide additional information about the application and its
  components, and to configure Spring's behavior.

---

# **8. Post/Get Mapping difference?**

- Both @PostMapping and @GetMapping are annotations in Spring that are used to handle HTTP POST and GET requests
  respectively.

- **The primary difference between @PostMapping and @GetMapping is the type of request that they handle. While
  @PostMapping is used to handle requests that submit data to a server, @GetMapping is used to handle requests that
  retrieve data from a server.**

- @PostMapping is used to handle HTTP POST requests, which are typically used to submit data to a web server. When a
  client makes a POST request, the request body contains data that is intended to be processed by the server.

- In contrast, @GetMapping is used to handle HTTP GET requests, which are typically used to retrieve data from a web
  server. When a client makes a GET request, the request URL contains any parameters that are needed to identify and
  retrieve the requested resource.

- Here's an example of how to use @PostMapping to handle a form submission:

        @PostMapping("/submit")
        public String submitForm(@RequestParam("name") String name, @RequestParam("email") String email) {
          // process form submission
          return "success";
        }

- Here's an example of how to use @GetMapping to retrieve data from a server:

        @GetMapping("/users/{userId}")
        public User getUser(@PathVariable("userId") Long userId) {
          // retrieve user with the given ID from the database
          return user;
        }

---

# **9. Which Spring features you have used in your project?**

- Dependency Injection:
- Spring Boot
- Spring Data
- Spring JPA
- Spring Actuators
- Embedded Server

---

# **11. How do you change the port number?**

- Using Application.properties file
- server.port = 8081

---

# **12. Why do we need constructor injection even if we can achieve the same results using field injection?**

 ```java
private MyService myService;

@Autowired
public MyController(MyService myService){
        this.myService=myService;
        }
 ```

- In this code we really don't need to use a constructor to autowire the bean, we simply can delete the constructor. Why
  you or anyone else would use it?
- The constructor in this code is being used to inject an instance of the MyService bean into the MyController class.
  The @Autowired annotation tells Spring to automatically wire the myService parameter with an instance of MyService
  from the Spring container.

- While it's true that you can remove the constructor and still achieve the same result using field injection like this:

```java
@Autowired
private MyService myService;

```

- There are some potential downsides to using field injection. Field injection can make it harder to write unit tests
  for your code, because you can't easily pass in a mock version of the dependency for testing. It can also make it
  harder to reason about the dependencies of your class, since they are not explicitly defined in the constructor.

- In general, it's considered good practice to use constructor injection instead of field injection, since it provides
  more explicit and testable dependencies. However, in some cases, such as with simple classes or small projects, using
  field injection may be acceptable.

---

# **13. Define Bean**

- A bean is simply an object that is managed by the Spring IoC (Inversion of Control) container. A bean is an instance
  of a Java class that is created, configured, and managed by the Spring container, and it can be used throughout an
  application.

---

# **14. Controller Define and Use**

- A controller is a type of bean that handles incoming requests and returns responses to clients.
- Controllers are responsible for processing requests, invoking business logic, and returning views or JSON/XML
  responses.
- A controller in Spring can be defined in several ways, including using annotations
  like `@Controller`, `@RestController`, `@RequestMapping`, or by extending the `AbstractController`
  or `AbstractCommandController` classes.

```java

@Controller
public class MyController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "hello";
    }

}
```

- In this example, the @Controller annotation indicates that the MyController class is a Spring MVC controller. The
  @RequestMapping annotation maps HTTP requests with the URL "/hello" to the hello method. The Model object is used to
  pass data to the view, and the hello method returns the name of the view to be rendered, in this case, "hello".

- To use this controller, you would typically define a view resolver in your Spring configuration, which would map the
  view name "hello" to an actual view resource, such as a JSP file or a Thymeleaf template.

- When a client makes an HTTP request to the URL "/hello", the Spring MVC dispatcher servlet will route the request to
  the hello method of the MyController class. The method will execute, set a message attribute in the model, and return
  the name of the view to be rendered. The view resolver will then resolve the view name "hello" to an actual view,
  which will be used to render the response.

---

# **15. What is Spring MVC?**

- Spring MVC (Model-View-Controller) is a web framework built on top of the Spring Framework that provides a structured
  and flexible approach to building web applications. It follows the MVC design pattern and separates the application
  into three main components: the model, the view, and the controller.
    - The `model` represents the data and the business logic of the application.
    - The `view` is responsible for rendering the model data as HTML or other formats.
    - The `controller` handles the user input, manipulates the model data, and decides which view to render.
- Spring MVC provides a set of built-in features that make it easy to build web applications, such as request mapping,
  data binding, form handling, validation, and more. It also integrates with other Spring projects like Spring Security,
  Spring Data, and Spring Boot, to provide a complete web application development stack.
- Here's an example of a Spring MVC controller that handles HTTP GET requests for a specific URL pattern:

```java

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookDetails";
    }
}
```

- In this example, the @Controller annotation declares the BookController class as a Spring MVC controller. The
  @RequestMapping annotation defines a base URL mapping for all requests handled by the controller. The @Autowired
  annotation injects an instance of the BookService class, which provides access to the business logic for retrieving
  book details.

- The @GetMapping annotation maps HTTP GET requests to the getBookById method, which takes a path variable id and a
  Model object as parameters. The method uses the BookService to retrieve the book details for the given id, adds the
  book to the model, and returns the name of the view to be rendered, in this case, "bookDetails".

- This is just a simple example of how Spring MVC works, but it gives an idea of how the components interact to handle
  user requests and generate responses.

---

# **16. What is Model attribute in Spring?**

- In Spring MVC, a model attribute is a way to pass data from a controller to a view. It is essentially a key-value
  pair, where the key is a string that identifies the data and the value is the data itself. Model attributes can be
  used to display dynamic data in a view, such as database records or form inputs.

- Model attributes are typically added to a Model object, which is passed as a parameter to a controller method. The
  Model object is used to hold the model attributes that will be sent to the view.

- Here's an example of a controller method that adds a model attribute:

```java

@Controller
public class MyController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "hello";
    }

}
```

- In this example, the hello method takes a Model object as a parameter and adds a model attribute with the key "
  message" and the value "Hello, world!". The method then returns the name of the view to be rendered, in this case, "
  hello".

- In the corresponding view, you can use the model attribute by referencing its key:

```html

<html>
<body>
<h1>${message}</h1>
</body>
</html>
```

- In this example, the view uses the message model attribute to display a dynamic message in the HTML output.

- Model attributes can also be passed to a view using other types of Spring MVC constructs, such as @ModelAttribute
  annotations or RedirectAttributes.

---

# **18: How do you create Spring projects?**

A:

- **Spring Initializr**: A web-based tool that generates the initial structure of a Spring Boot project. You can use it
  to select the project's configuration options, such as language, build tool, dependencies, and packaging. Once you
  have made your selections, Spring Initializr generates a zip file that you can download and import into your preferred
  IDE, such as Eclipse or IntelliJ IDEA.
- **Spring Tool Suite (STS)**: An IDE for developing Spring applications. It includes features such as an embedded
  Apache Tomcat server, templates for creating new Spring projects, and integration with Maven and Gradle build tools.
  To create a Spring project in STS, select "New > Spring Starter Project" from the File menu and follow the prompts to
  configure the project.
- **Command-line interface (CLI)**: A command-line interface that you can use to create new Spring projects. The CLI is
  based on the Groovy language and can be installed as a standalone tool or as part of the Spring Boot project. To
  create a new Spring project using the CLI, open a terminal or command prompt, navigate to the desired directory, and
  type `spring init` followed by the project's configuration options.
- **Maven or Gradle build tool**: If you prefer to use Maven or Gradle as your build tool, you can create a new Spring
  project using either of them. First, create a new Maven or Gradle project, and then add the required Spring
  dependencies to the project's `pom.xml` or `build.gradle` file. You can find the list of available dependencies on the
  Spring website.

In summary, you can create a Spring project using Spring Initializr, Spring Tool Suite, CLI, or Maven/Gradle build
tools.

---

# **19: What is a component in Spring?**

- In Spring, a component is a Java class that is managed by the Spring IoC (Inversion of Control) container. Components
  are typically annotated with the `@Component` annotation, which is a specialization of the more general `@Bean`
  annotation. Components can be used to define beans that encapsulate a certain functionality or resource, such as a
  database connection or a web service client.

- Components are one of the fundamental building blocks of a Spring application, and they are used extensively
  throughout the framework. By using components, you can define your application's objects and dependencies in a modular
  and flexible way, making it easier to manage and test your code.

- In addition to the `@Component` annotation, Spring also provides several other specialized annotations for components,
  such as `@Service`, `@Repository`, and `@Controller`. These annotations are used to indicate the specific role of a
  component within an application, and they can be used to enable additional Spring-specific features, such as
  transaction management or web request handling.

---

# **20: What is a DAO and Entity in Hibernate?**

- **DAO (Data Access Object)**: In Hibernate, a DAO is an object that provides an abstract interface to interact with a
  database. It encapsulates the details of persistence, such as managing database connections, executing queries, and
  mapping query results to objects. `By using DAOs, you can separate the persistence logic from the rest of your
  application, making it more modular and easier to maintain.`

- **Entity**: In Hibernate, an entity is a lightweight persistence domain object that is mapped to a database table.
  Entities are typically annotated with the `@Entity` annotation, which tells Hibernate that the class is a persistent
  entity. Entities can have properties that correspond to the columns in the database table, and Hibernate uses a
  technique called object-relational mapping (ORM) to map between the object-oriented model and the relational model.

Together, DAOs and entities are used to build the persistence layer of a Hibernate application. DAOs provide a way to
interact with the database without exposing the underlying persistence details, while entities provide a way to map
database tables to object-oriented classes. By using DAOs and entities, you can create a flexible and modular
persistence layer that can be easily adapted to changing requirements.

---

# **21: What is a REST API and how is it used? Can you provide an example?**

- **REST (Representational State Transfer)** is a software architectural style that is used to create web services. A
  RESTful web service is designed to be simple, lightweight, and scalable, and it uses standard HTTP methods (such as
  GET, POST, PUT, and DELETE) to expose resources and perform operations on them.

- To use a REST API, you typically make HTTP requests to a server that exposes the API, specifying the resource you want
  to access and the operation you want to perform. For example, you might make a GET request to retrieve a list of
  users, a POST request to create a new user, a PUT request to update an existing user, or a DELETE request to delete a
  user.

- Here's an example of a simple REST API declaration using Java and Spring:

```java

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
```

---

# **22: How do you handle exceptions in a Spring Boot application?**

- **Exception handling** is an important aspect of any software application, and Spring Boot provides several mechanisms
  for handling exceptions in a centralized and consistent way.

- One approach to exception handling in Spring Boot is to use **global exception handling**. This involves defining
  an `@ExceptionHandler` method in a `@ControllerAdvice` class, which is a centralized location for handling exceptions
  across all controllers in your application. Here's an example:

```java

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        String message = "User not found";
        ErrorDetails errorDetails = new ErrorDetails(new Date(), message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        String message = "An error occurred";
        ErrorDetails errorDetails = new ErrorDetails(new Date(), message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
```

- In this example, the GlobalExceptionHandler class is a @ControllerAdvice that defines two @ExceptionHandler methods:
  one for handling UserNotFoundException exceptions, and one for handling all other types of exceptions. Each method
  returns a ResponseEntity that includes a custom error message and status code based on the type of exception that was
  thrown.

- Another approach is to use controller-level exception handling. This involves defining an @ExceptionHandler method in
  a specific controller class to handle exceptions that are specific to that controller. Here's an example:

```java

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        String message = "User not found";
        ErrorDetails errorDetails = new ErrorDetails(new Date(), message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
```

In this example, the UserController class defines a @GetMapping method for retrieving a user by ID, as well as an
@ExceptionHandler method for handling UserNotFoundException exceptions that might be thrown by the getUser method. This
approach allows you to handle exceptions in a more granular way, and can be useful for cases where different controllers
might have different exception-handling requirements.

---

# **23: What is lazy loading in Hibernate? Can you provide an example?**

- **Lazy loading** is a technique used in Hibernate to defer the loading of an object or collection until it is actually
  needed. This can help improve performance and reduce memory consumption, since you only load the data you actually
  need.

- One example of lazy loading is with the `@OneToMany` annotation, which can be used to define a one-to-many
  relationship between two entities. By default, Hibernate will use lazy loading for the collection that represents
  the "many" side of the relationship. Here's an example:

```java

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
  private final List<Book> books = new ArrayList<>();

  // getters and setters

}

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private Author author;

  // getters and setters

}
```

- In this example, the Author entity has a one-to-many relationship with the Book entity, and the books collection is
  configured to use lazy loading with the fetch = FetchType.LAZY attribute. This means that when you load an Author
  object from the database, Hibernate will not automatically load the associated Book objects - it will only load them
  when you actually try to access the books collection.

- To illustrate, consider the following code:

```java
Author author=entityManager.find(Author.class,1L);
        List<Book> books=author.getBooks(); // the books collection is lazily loaded here

```

- In this code, we load an Author object from the database using the EntityManager, and then try to access the books
  collection. Because we've configured the collection to use lazy loading, Hibernate will not actually load the
  associated Book objects until this line is executed. This can help improve performance and reduce memory consumption,
  since we only load the data we actually need.

---

# **24: What is the difference between a RestController and a Component in Spring?**

- A **RestController** is a special type of controller in Spring that is used to handle RESTful web services. It is
  responsible for receiving HTTP requests and returning HTTP responses in a format such as JSON or XML. RestController
  is a specialized version of the @Controller annotation that adds the @ResponseBody annotation to the returned object.

- On the other hand, a **Component** is a general-purpose annotation in Spring that is used to mark a class as a bean
  component. It is typically used to identify classes that are candidates for auto-detection and auto-configuration when
  using Spring's annotation-based configuration.

- The key difference between a RestController and a Component is their purpose and usage. RestController is specifically
  used for handling RESTful web services, while Component is a more general-purpose annotation that can be used to
  identify any bean component in the Spring application context.

- Here's an example of a RestController and a Component in Spring:

```java

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // other RESTful endpoints
}

@Component
public class UserService {

    private List<User> users;

    public UserService() {
        // initialize users list
    }

    public List<User> getUsers() {
        return users;
    }

    // other business logic methods
}
```

- In this example, we have a RestController named UserController that is responsible for handling HTTP requests related
  to users. It has a getUsers() method that returns a list of users by calling a UserService object.

- The UserService class is marked with the Component annotation and contains the business logic for working with users.
  It is not specifically tied to handling HTTP requests or returning HTTP responses, but is a general-purpose bean
  component that can be used throughout the Spring application context.

---

# 25: HttpMethods working in SpringBoot?

Spring Boot is built on top of the Spring Framework, which provides comprehensive support for handling HTTP requests and
responses. Spring Boot supports all the standard HTTP methods, also known as HTTP verbs, including:

1. `GET`: Used to retrieve a resource from the server.
2. `POST`: Used to submit data to the server to create a new resource.
3. `PUT`: Used to update an existing resource on the server.
4. `DELETE`: Used to delete a resource from the server.
5. `PATCH`: Used to partially update an existing resource on the server.
6. `HEAD`: Used to retrieve metadata about a resource without actually retrieving the resource itself.
7. `OPTIONS`: Used to retrieve information about the communication options available for a resource.
8. `TRACE`: Used to retrieve a diagnostic trace of the actions taken by the server.

In Spring Boot, you can handle HTTP requests using several different approaches, including:

1. Using the @RequestMapping annotation: This is the most basic approach for handling HTTP requests in Spring Boot. You
   can use the @RequestMapping annotation to map a method to a specific URL and HTTP method. For example:

    ```java
    @RestController
    public class MyController {
    
        @RequestMapping(value = "/my-resource", method = RequestMethod.GET)
        public ResponseEntity<String> getMyResource() {
            // Handle GET request
        }
    
        @RequestMapping(value = "/my-resource", method = RequestMethod.POST)
        public ResponseEntity<String> createMyResource() {
            // Handle POST request
        }
    }
    ```

   In this example, the MyController class defines two methods, getMyResource() and createMyResource(), which handle GET
   and POST requests, respectively, for the /my-resource URL.

2. Using the @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping annotations: These are shortcut
   annotations that you can use instead of @RequestMapping to map a method to a specific HTTP method. For example:

    ```java
    @RestController
    public class MyController {
    
        @GetMapping("/my-resource")
        public ResponseEntity<String> getMyResource() {
            // Handle GET request
        }
    
        @PostMapping("/my-resource")
        public ResponseEntity<String> createMyResource() {
            // Handle POST request
        }
    }
    ```

   In this example, we've replaced the @RequestMapping annotations with @GetMapping and @PostMapping annotations to map
   the methods to the corresponding HTTP methods.

3. Using the RESTful API approach: This is a more structured approach to building APIs that follows a set of conventions
   and best practices. In a RESTful API, each resource is identified by a unique URL, and different HTTP methods are
   used to perform CRUD operations on the resource. Spring Boot provides support for building RESTful APIs using the
   @RestController and @RequestMapping annotations. Here's an example:

```java

@RestController
@RequestMapping("/api")
public class MyRestController {

    @GetMapping("/my-resource")
    public ResponseEntity<String> getMyResource() {
        // Handle GET request
    }

    @PostMapping("/my-resource")
    public ResponseEntity<String> createMyResource() {
        // Handle POST request
    }

    @PutMapping("/my-resource/{id}")
    public ResponseEntity<String> updateMyResource(@PathVariable Long id) {
        // Handle PUT request with path variable
    }

    @DeleteMapping("/my-resource/{id}")
    public ResponseEntity<String> deleteMyResource(@PathVariable Long id) {
        // Handle DELETE request with path variable
    }
}
```

In this example, we've defined a RESTful API for the /api/my-resource URL, which supports GET, POST, PUT, and DELETE
requests. We've also used path variables to handle PUT and DELETE requests for a specific resource identified by its ID.

---

# 26: What is Callable in Spring?

- In the Spring Framework, a Callable is a task that can be executed asynchronously on a separate thread. It represents
  a task that returns a result and may throw an exception. A Callable is similar to a Runnable, but it has a return
  value and can throw checked exceptions.
- In a Spring Boot application, you can use Callable in conjunction with the @Async annotation to execute a long-running
  task in a separate thread and return a result to the client when the task is complete. This can be useful for
  improving the performance and responsiveness of your application, especially for tasks that may take a long time to
  complete, such as data processing or complex calculations.
- Here's an example of using Callable in a Spring Boot controller:

```java

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/my-resource")
    public Callable<ResponseEntity<String>> getMyResource() {
        return () -> {
            String result = myService.longRunningTask();
            return ResponseEntity.ok(result);
        };
    }
}
```

- In this example, we have a `MyController` class with a `getMyResource()` method that returns
  a `Callable<ResponseEntity<String>>`. The method is annotated with `@GetMapping` to handle a GET request for
  the `/my-resource` URL.
- The getMyResource() method executes a long-running task asynchronously by returning a Callable lambda expression.
  Inside the lambda expression, we call the longRunningTask() method of a MyService bean to perform the task and return
  the result as a String. We then wrap the result in a ResponseEntity object and return it to the client with a status
  code of 200 OK.
- By using Callable in conjunction with the @Async annotation, the long-running task will be executed on a separate
  thread, allowing the main thread to return immediately to the client with a response. When the task is complete, the
  result will be available to the main thread, which can then return it to the client.

---

# 27. Dependency Injection in Spring

**Q:** What is dependency injection in Spring?

**A:** Dependency injection is a design pattern used in software engineering, where a component's dependencies are injected (i.e. passed) to it from the outside rather than the component creating or looking up its dependencies itself. In the context of Spring, dependency injection is a core feature of the Spring framework, where Spring manages and injects dependencies for objects at runtime, based on configuration.

**Q:** Why is dependency injection important in Spring?

**A:** Dependency injection is important in Spring because it allows for loose coupling between components, making the code more modular, flexible, and maintainable. By using dependency injection, components can be easily replaced, extended, and tested, without affecting the rest of the application.

**Q:** How does Spring perform dependency injection?

**A:** Spring performs dependency injection through a process called inversion of control (IoC). In IoC, the control over object creation and wiring is passed from the application code to a framework or container, like Spring. Spring uses annotations, XML files, or Java configuration classes to specify the dependencies of a component, and then injects them at runtime using one of three methods: constructor injection, setter injection, or field injection.

**Q:** What are the advantages of using Spring's dependency injection?

**A:** The advantages of using Spring's dependency injection include:

- Loose coupling between components
- Easy testing and mocking of components
- Flexible and modular code
- Reduced boilerplate code
- Encourages good coding practices, like separation of concerns and single responsibility principle

**Q:** What is the difference between constructor injection, setter injection, and field injection in Spring?

**A:** Constructor injection involves injecting dependencies through a component's constructor. Setter injection involves injecting dependencies through a component's setter methods. Field injection involves injecting dependencies directly into a component's fields. Constructor injection is generally considered the best practice, as it ensures that a component's dependencies are available at creation time, and makes the component immutable. Setter and field injection are less preferred, as they make components mutable and can result in hard-to-debug errors if the dependencies are not properly set.

# 28. Inversion of Control in Spring

**Q:** What is inversion of control in Spring?

**A:** Inversion of Control (IoC) is a design pattern and principle in software engineering, where the control over object creation and wiring is passed from the application code to a framework or container, like Spring. In the context of Spring, IoC is a core feature of the framework, where the framework manages the creation and configuration of objects and their dependencies, based on configuration metadata.

**Q:** How does IoC work in Spring?

**A:** In Spring, IoC is implemented through a container, which is responsible for managing the lifecycle of objects and their dependencies. The container is configured with metadata that describes the objects and their dependencies, such as XML files, Java configuration classes, or annotations. When the application is run, the container creates and initializes the objects and their dependencies based on the metadata, and then injects the dependencies into the objects.

**Q:** What are the benefits of using IoC in Spring?

**A:** The benefits of using IoC in Spring include:

- Reduced boilerplate code
- Modular and flexible code
- Loose coupling between components
- Easier testing and mocking of components
- Encourages good coding practices, like separation of concerns and single responsibility principle

**Q:** What is the difference between IoC and Dependency Injection?

**A:** Dependency Injection (DI) is a specific implementation of the IoC principle, where the framework injects the dependencies of an object at runtime, instead of the object creating or looking up its dependencies itself. DI is a key feature of the Spring framework, and is used to achieve loose coupling between components and improve the modularity of the code. Therefore, IoC is a broader concept that includes DI as one of its implementation techniques.

# 29. Critical Hibernate Annotations

**Q:** What are the two annotations related to Hibernate that are critical for its functionality?

**A:** The two annotations related to Hibernate that are critical for its functionality are:

1. `@Entity`: This annotation is used to mark a Java class as a persistent entity in the database. The `@Entity` annotation can be applied to a class level or a field level, and is used to indicate that the object is to be persisted in the database.

2. `@Id`: This annotation is used to mark a field or property as the primary key of an entity. The `@Id` annotation can be applied to a single field or property, or to a combination of fields or properties, depending on the requirements of the entity.

**Q:** What is the purpose of the `@Entity` annotation?

**A:** The `@Entity` annotation is used to mark a Java class as a persistent entity in the database. This means that the object represented by the class can be stored, updated, and retrieved from a database using Hibernate. The `@Entity` annotation is critical for Hibernate to identify which classes should be persisted in the database, and how they should be mapped to database tables.

**Q:** What is the purpose of the `@Id` annotation?

**A:** The `@Id` annotation is used to mark a field or property as the primary key of an entity. This means that the field or property identified by the `@Id` annotation uniquely identifies each instance of the entity in the database. The `@Id` annotation is critical for Hibernate to identify the primary key of an entity, and how it should be mapped to the primary key column of the corresponding database table.

**Q:** Can you give an example of how the `@Entity` and `@Id` annotations are used in Hibernate?

**A:** Sure, here's an example:

```java
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private int age;

    // constructors, getters and setters
}
```
In this example, the Employee class is marked as an entity using the @Entity annotation, and the id field is marked as the primary key using the @Id annotation. This tells Hibernate that instances of the Employee class should be persisted in the database, and that the id field should be used as the primary key column in the corresponding database table.

---

# 30. Dispatcher Servlet in Spring

**Q:** What is a Dispatcher Servlet in Spring?

**A:** The Dispatcher Servlet is the key component of the Spring Web MVC framework. It is responsible for handling incoming HTTP requests and sending them to the appropriate controller for processing. The Dispatcher Servlet is configured in the `web.xml` file of a Spring MVC web application, and it intercepts all incoming requests that match the URL pattern defined in its configuration.

**Q:** How does the Dispatcher Servlet work?

**A:** When an incoming HTTP request arrives, the Dispatcher Servlet first checks the request URL to determine which controller should handle the request. It then consults a Handler Mapping, which maps the request URL to a specific controller. Once the correct controller is identified, the Dispatcher Servlet passes the request to the controller for processing. The controller typically returns a ModelAndView object, which contains the model data and the view to be rendered. The Dispatcher Servlet then selects the appropriate view resolver and renders the response to the client.

**Q:** What is the role of the Dispatcher Servlet in the Spring MVC architecture?

**A:** The Dispatcher Servlet is the front controller in the Spring MVC architecture. It acts as a centralized request handler that coordinates the flow of requests and responses in a Spring MVC application. The Dispatcher Servlet is responsible for delegating incoming requests to the appropriate controller, and it provides a consistent interface for handling different types of requests.

**Q:** Can we have multiple Dispatcher Servlets in a Spring MVC application?

**A:** Yes, it is possible to have multiple Dispatcher Servlets in a Spring MVC application. This can be useful if we want to handle different types of requests with different Dispatcher Servlets, or if we want to partition the application into separate modules. Each Dispatcher Servlet can have its own URL pattern, which determines the requests it will handle. However, having multiple Dispatcher Servlets can also add complexity to the application and make it harder to manage, so it should be used judiciously.

---

# 31. Dispatcher Servlet in detail:

In Spring, the DispatcherServlet is a central servlet that plays a crucial role in handling incoming HTTP requests and managing the flow of the web application. It acts as a front controller, meaning that it is the `first point of contact for all incoming requests` and is responsible for dispatching these requests to the appropriate handlers (controllers) for further processing.

Here's a step-by-step explanation of how the DispatcherServlet works with a simple example:

1. **Client sends an HTTP request**: Suppose a client (e.g., a web browser) sends an HTTP request to the Spring web application. The request typically contains a URL that maps to a specific resource or action on the server.

2. **DispatcherServlet receives the request**: The DispatcherServlet is configured to listen for incoming requests. When a request arrives, the web container (e.g., Tomcat) intercepts it and passes it to the DispatcherServlet.

3. **Handler Mapping**: The DispatcherServlet consults the HandlerMapping, which is responsible for determining which controller should handle the incoming request based on the URL or other criteria. The HandlerMapping returns a reference to the appropriate controller for further processing.

4. **Handler Execution**: The DispatcherServlet then executes the chosen controller (handler) to process the request. The controller performs the required business logic and prepares a model that holds the data to be displayed on the view.

5. **View Resolution**: After the controller has finished its processing, it returns the logical view name to the DispatcherServlet. The view name is typically a reference to the actual view template that needs to be rendered and returned to the client.

6. **View Rendering**: The DispatcherServlet consults the ViewResolver, which maps the logical view name returned by the controller to an actual view template (e.g., JSP, Thymeleaf, etc.). The ViewResolver returns the appropriate view.

7. **Response Generation**: Finally, the DispatcherServlet hands over the model data to the selected view, and the view is rendered with the data. The generated HTML (or other content) is sent back as an HTTP response to the client.

**Example**:
Let's consider a simple Spring MVC application that handles requests related to books. The goal is to create a page that displays a list of books.

1. **Controller**:
```java
@Controller
public class BookController {

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<String> books = Arrays.asList("Book 1", "Book 2", "Book 3");
        model.addAttribute("books", books);
        return "book-list"; // Logical view name
    }
}
```

2. **DispatcherServlet Configuration (web.xml or Java Config)**:
In a web.xml configuration (traditional way):
```xml
<servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring-servlet.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

In Java Config (using `WebApplicationInitializer`):
```java
public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
```

3. **View Template**:
Assuming you are using a Thymeleaf template named `book-list.html` (located in the appropriate view folder):

```html
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h1>List of Books</h1>
    <ul>
        <li th:each="book : ${books}" th:text="${book}"></li>
    </ul>
</body>
</html>
```

In this example, when a client sends a request to the URL `/books`, the DispatcherServlet will receive the request. It will consult the `@GetMapping("/books")` annotation on the `BookController` and execute the `showBooks` method. The controller will add a list of books to the model and return the logical view name "book-list."

The DispatcherServlet will then use a `ViewResolver` to map the logical view name "book-list" to the `book-list.html` Thymeleaf template. The template will be rendered with the model data, and the generated HTML will be sent back as an HTTP response to the client, displaying the list of books on the web page.

---

**Q: Diff types of aspects in Spring? How do you log using aspect?**

A: In Spring, there are three types of aspects:

1. **@Before:** This aspect runs before the method execution.
2. **@After:** This aspect runs after the method execution, regardless of its outcome.
3. **@AfterReturning:** This aspect runs after the method execution, only if the method completes successfully.

//legacy found on udemy video
1. Before advice: run before the method
2. After finally advice: run after the method (finally)
3. After returning advice: run after the method (success execution)
4. After throwing advice: run after method (if exception thrown)
5. Around advice: run before and after method


To log using an aspect in Spring, we can define an aspect with a pointcut that matches the methods we want to log, and then use the logging framework of our choice (e.g. Log4j or SLF4J) to log the method name, arguments, and return value. Here is an example of logging using an aspect:

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.*.*(..))")
    public void logMethodCall() {
        logger.info("Method called.");
    }
}
```

---

# 32. What is response entity in spring?

In Spring, ResponseEntity is a class that represents `an HTTP response with a status code, headers, and a body`. It can be used to create custom responses for web requests in a Spring application.

The ResponseEntity class is typically used in Spring web controllers to generate responses for RESTful web services. It allows you to set the HTTP status code, response headers, and response body in a single object, and return it as the result of a controller method.

Here's an example of how to use the ResponseEntity class in a Spring controller:

```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.findById(id);
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

In this example, the controller method returns a ResponseEntity object with a User object as its body. If the user is found, the method returns a ResponseEntity with a status code of 200 (OK) and the user object as its body. If the user is not found, the method returns a ResponseEntity with a status code of 404 (Not Found) and no body.

The ResponseEntity class provides a range of methods to build different types of responses. For example, you can set response headers using the headers() method, or create a response with no body using the noContent() method. The class provides a flexible and powerful way to generate HTTP responses in a Spring application.

---

# 33. What is the difference between Contoller, DAO, DTO, Service package in springboot?
In a Spring Boot application, the Controller, DAO (Data Access Object), DTO (Data Transfer Object), and Service packages serve different purposes and play distinct roles in the application architecture:

1. Controller:
   - Responsible for handling incoming HTTP requests and returning appropriate responses.
   - Acts as an entry point for client requests.
   - Handles request mapping, input validation, and invoking the appropriate business logic.
   - Typically deals with the presentation layer and interacts with the user interface.

2. DAO (Data Access Object):
   - Provides an abstraction layer for interacting with the underlying database or data source.
   - Encapsulates the logic for data retrieval, storage, and manipulation.
   - Performs CRUD (Create, Read, Update, Delete) operations on the data.
   - Focuses on data access and persistence, often using technologies like JDBC or an ORM (Object-Relational Mapping) framework like Hibernate.

3. DTO (Data Transfer Object):
   - Represents a structured object used for transferring data between layers or components.
   - Contains only the necessary data fields and no business logic.
   - Provides a convenient way to encapsulate and transport data across different layers of the application.
   - Often used to decouple the data exchanged between the Controller and Service layers.

4. Service:
   - Contains the business logic of the application.
   - Acts as an intermediary between the Controller and the DAO.
   - Orchestrates the flow of data and operations between multiple DAOs or other external services.
   - Implements transaction management, security, and other cross-cutting concerns.
   - Typically handles complex business operations and validations.

In summary, the Controller handles incoming requests and manages the user interface, the DAO deals with data access and persistence, the DTO facilitates data transfer between layers, and the Service contains the application's business logic. These components work together to implement the functionality of a Spring Boot application.

---

# 34. Difference between Controller, DAO, DTO, Service packages in detail:

In a Spring Boot application, each package serves a distinct purpose and follows a specific design pattern to maintain the separation of concerns. Let's explore the differences between the Controller, DAO, DTO, and Service packages and provide examples for better understanding:

1. **Controller Package**:
The Controller package is responsible for handling incoming HTTP requests, processing them, and returning the appropriate HTTP responses. Controllers are the entry points of your application, and they facilitate the interaction between the user interface (UI) and the business logic. They receive input from the client, invoke the relevant business logic (usually in the Service layer), and send the response back to the client, often in the form of a view to be displayed.

Example:
```java
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return BookMapper.toDtoList(books);
    }
    
    // Other methods for handling various CRUD operations for books
}
```

2. **DAO (Data Access Object) Package**:
The DAO package is responsible for interacting with the data source (typically a database) and abstracting away the data access logic. It provides an interface for the application to perform CRUD (Create, Read, Update, Delete) operations on the underlying data storage. DAOs handle the database interactions and provide a layer of separation between the application and the database.

Example:
```java
@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> getAllBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    // Other methods for CRUD operations on the Book entity
}
```

3. **DTO (Data Transfer Object) Package**:
The DTO package contains classes that represent data objects used for data transfer between layers or modules of the application. DTOs are used to encapsulate data and transfer it efficiently between different components, often between the Service layer and the Controller layer. They help to avoid exposing the domain model directly to the presentation layer, promoting better separation of concerns.

Example:
```java
public class BookDto {
    private Long id;
    private String title;
    private String author;
    // Getters and setters
}
```

4. **Service Package**:
The Service package contains the business logic of the application. It acts as an intermediary between the Controller layer (presentation layer) and the DAO layer (data access layer). Services encapsulate the application's business rules, validations, and complex operations. They coordinate data access and manipulation, often using one or more DAOs, and return the processed data to the Controller or other parts of the application.

Example:
```java
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    // Other business logic methods for books
}
```

In summary, the Controller handles incoming HTTP requests and defines the application's endpoints, the DAO provides data access and encapsulates the database operations, the DTOs represent data objects for efficient data transfer, and the Service layer contains the application's business logic and coordinates data access between the Controller and the DAO layers. By adhering to these design patterns and maintaining separation of concerns, Spring Boot applications become more maintainable, scalable, and easier to understand.


# 35. What happens if I get multiple api hits on my app? how spring will handle it? How many objects will be created for those requests?

In a Java Spring Boot application, when you receive multiple API hits (HTTP requests), Spring will handle them by creating a new instance of the controller class for each request. This means that a new object of your controller class will be created for each incoming request, and these objects will be responsible for processing their respective requests. Here's how Spring handles multiple API hits:

1. **Servlet Container and Threads**:
   - When a request arrives at your Spring Boot application, it is typically handled by a servlet container (e.g., Tomcat, Jetty, or Undertow) that manages incoming requests and spawns threads to process them.
   - Each incoming request is processed by a separate thread. Spring Boot, being a Java framework, leverages the multithreading capabilities of the underlying servlet container.

2. **Controller Instantiation**:
   - Spring manages the creation and management of controller instances. When a request is received, Spring will instantiate a new controller object (if it's not already in the pool of reusable controllers) to handle that specific request.
   - This means that different requests will have their own controller instances, and these instances are not shared between requests.

3. **Request Scope**:
   - By default, Spring controllers are scoped as "request" scope. This means that the controller instance created to handle a particular request will only exist for the duration of that request. Once the request is processed, the controller instance is typically eligible for garbage collection.
   - This request scope is designed to ensure that each request is isolated from others and has its own separate controller instance.

4. **Thread Safety**:
   - While each request has its own controller instance, you should ensure that your controller classes are thread-safe. This is especially important if your controllers make use of instance variables, as concurrent requests could potentially access and modify these variables simultaneously.

In summary, Spring Boot handles multiple API hits by creating separate instances of your controller classes for each request. These instances are scoped to the request and are not shared among different requests, ensuring isolation and thread safety. You can leverage Spring's dependency injection and request-scoped beans to manage the state and behavior of your controllers effectively.


---

# 36. 
