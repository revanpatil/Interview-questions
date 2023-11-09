## **1. Diff between JAR, WAR, EAR file type?**

"JAR, WAR, and EAR are different file formats used for different purposes:

1. **JAR (Java Archive)** is a file format that aggregates many files into one, to distribute a set of libraries, resources,
  or components. It's commonly used for Java applications and libraries.
2. **WAR (Web Application Archive)** is a file format used to package Java web applications in a single archive. It contains
  the compiled Java classes, JSP files, HTML files, and other resources needed for a Java web application.
3. **EAR stands for Enterprise ARchive**, and it is a file format used in Java-based enterprise applications. An EAR file is a JAR (Java ARchive) file that contains all the necessary components required to deploy a Java enterprise application.

- An EAR file typically includes one or more Java EE (Enterprise Edition) modules, such as EJB (Enterprise JavaBeans) modules, web modules, and connector modules. These modules are packaged as JAR files and included in the EAR file along with the deployment descriptor files that specify the configuration and deployment settings for the application.

- The purpose of using an EAR file is to simplify the deployment and management of complex Java enterprise applications. By packaging all the required modules and configuration files into a single file, it becomes easier to deploy and manage the application on different servers and platforms.

- To deploy an EAR file, you need to have a Java EE application server such as JBoss, WebSphere, or WebLogic installed on the target machine. The server reads the deployment descriptors in the EAR file and deploys the application components according to the specified configuration. 

---
## **2. What is Thymeleaf?**

- Thymeleaf is a modern server-side Java template engine used for web and standalone applications. It is designed to be
  a natural templating solution for HTML, XML, and other markup languages. Thymeleaf provides a number of features that
  make it well-suited for web application development, including natural templating syntax, integrations with popular
  web frameworks like Spring, and the ability to seamlessly mix dynamic and static content.

- In Thymeleaf, templates are written using a mix of standard HTML, with Thymeleaf-specific syntax for embedding dynamic
  expressions. These expressions are evaluated at runtime to produce the final output, which is then sent to the client.

- Thymeleaf provides a number of advantages over traditional template engines, including a natural templating syntax
  that is easy to understand and use, a flexible architecture that makes it easy to extend and customize, and a strong
  focus on HTML standards, which helps ensure that templates are accessible and properly formatted.

---

## **3. Explain YAML file structure**

- YAML (short for "YAML Ain't Markup Language") is a human-readable data serialization language that is commonly used
  for configuration files. It uses indentation and special characters to structure the data, rather than using explicit
  markup tags like XML or JSON.

- **The basic structure of a YAML file is a set of key-value pairs, where each key is followed by a colon and the
  corresponding value. Indentation is used to indicate nested structures.**

- Here's an example of a simple YAML file:

```yaml
    database:
      host: localhost
      port: 3306
      username: myuser
      password: mypassword

    server:
      port: 8080
      context-path: /myapp
```

- In this example, the YAML file defines two top-level keys: database and server. The database key has four nested
  keys (host, port, username, and password) with their corresponding values. The server key has two nested keys (port
  and context-path) with their corresponding values.
- Some important features of YAML file structure are:

    - Indentation: YAML uses indentation to indicate nested structures. Each level of indentation is typically two or
      four spaces.
    - Colon: A colon is used to separate the key from the value.
    - Hyphen: A hyphen is used to denote a list item.
    - Comments: YAML supports both single-line and multi-line comments, which start with the # character.
    - Literal values: YAML supports literal values such as strings, numbers, and booleans, as well as special values
      such as null and timestamps.

- YAML is flexible and can be used to represent complex data structures with multiple levels of nesting, as well as
  simple key-value pairs. It is often used in configuration files for applications and infrastructure, as well as in
  data exchange formats.

---
## **4. Diff between Path/ClassPath/ClassPathResources**

- Path, Classpath, and ClasspathResources are all related to locating and accessing files or resources in a Java
  application, but they refer to different concepts.

- Path: A Path in Java refers to a file or directory location in the file system. It is typically used for accessing
  files on the local machine or on a network file system. The Path class provides methods for manipulating and resolving
  file paths, such as resolve() and getParent().
- Classpath: The Classpath is a list of directories and JAR files that the Java runtime uses to search for classes and
  resources. It can include directories on the local file system, as well as JAR files and other archives. The Classpath
  is set using the -classpath or -cp option when running a Java application from the command line, or by setting the
  CLASSPATH environment variable.
- ClasspathResources: ClasspathResources are resources that are packaged with a Java application and can be accessed
  using the ClassLoader. They can include files such as configuration files, images, and other assets that are needed by
  the application. The ClassLoader provides methods for loading resources from the Classpath, such as getResource() and
  getResourceAsStream().

- In summary, Path refers to file or directory locations in the file system, Classpath is a list of directories and JAR
  files used by the Java runtime to search for classes and resources, and ClasspathResources are resources that are
  packaged with a Java application and can be loaded using the ClassLoader.

---
## **5. Command to run Spring boot application through CLI?**

```commandline  
java -jar myapp.jar
```        

- Also, more options can be specified using -D option

```commandline  
java -jar myapp.jar -Dserver.port = 8080
```        

---        
## **6. XML file structure?**

- XML (Extensible Markup Language) is a markup language used to store and transport data. An XML file consists of a
  tree-like structure of elements, each of which can have attributes and child elements. Here's an example of a basic
  XML file:

```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <bookstore>
      <book category="Science Fiction">
        <title>The Hitchhiker's Guide to the Galaxy</title>
        <author>Douglas Adams</author>
        <price>12.50</price>
      </book>
      <book category="Mystery">
        <title>The Da Vinci Code</title>
        <author>Dan Brown</author>
        <price>15.00</price>
      </book>
    </bookstore>
```

- The XML file begins with a declaration specifying the version of XML being used and the character encoding being used.
  The root element of the file is bookstore, which contains two child elements, book. Each book element has three child
  elements: title, author, and price, as well as an attribute category. The text content of each element provides the
  data being stored.

- Elements can be nested within other elements to create a hierarchical structure, and attributes can be used to provide
  additional information about an element. XML can be used to represent a wide range of data, from simple text documents
  to complex data structures such as configuration files and web services.

---

## **7. Difference between Authentication and Authorization?**

- `Authentication`: To check whether the user is who he claims to be
- `Authorization`: Process of determining the actions user/app can perform

---

## **8. What is Docker and how does it work?**


Docker is a platform for developing, shipping, and running applications using containerization technology. Containers allow developers to package an application and its dependencies into a single package, which can then be deployed to any environment that supports Docker, without having to worry about the specific environment's configuration.

Here's a basic overview of how Docker works:

1. Developers write code and define the dependencies required by their application in a Dockerfile. The Dockerfile specifies the base image to use, as well as any additional software or packages needed to run the application.

2. The Docker engine takes the Dockerfile and builds an image. The image is a read-only template that contains the application code and all its dependencies.

3. Containers are created from the image at runtime. A container is a lightweight, standalone, and executable package that includes everything needed to run the application, such as code, libraries, system tools, and settings.

4. Containers are launched by the Docker engine, which provides an isolated environment for the container to run in. The container runs as an isolated process in the host operating system, with its own file system, networking, and resources.

5. Multiple containers can be run on the same host, each with its own isolated environment. This makes it possible to run multiple applications on the same host without worrying about conflicts or dependencies.

Docker also provides tools for managing and orchestrating containers, such as Docker Compose for defining and running multi-container applications, and Kubernetes for managing containerized applications at scale.

In summary, Docker uses containerization technology to package applications and their dependencies into lightweight and portable containers, which can be deployed to any environment that supports Docker, without worrying about the specific environment's configuration.

---

## **9: What is the difference between Pom.xml and web.xml file?**

- `pom.xml` is a file used by Apache Maven to manage dependencies, build configuration, and project information in a
  Maven project. It contains metadata about the project and its dependencies, as well as configuration details for the
  build process. The `pom.xml` file is usually located in the root directory of the project and is used by Maven to
  build and package the project.
- `web.xml` is a deployment descriptor file used by Java web applications. It contains configuration information for the
  web application, such as servlet mappings, filter definitions, security constraints, and more. The `web.xml` file is
  usually located in the `WEB-INF` directory of a web application and is used by the application server to configure the
  web application at deployment time.

In summary, `pom.xml` is used by Apache Maven to manage project dependencies and build configuration, while `web.xml` is
used by Java web applications to configure the application at deployment time.

---

## 10. What is the Difference between Simple Auth and OAuth 2.0?

Simple Auth and OAuth 2.0 are two different authentication mechanisms used in software development, particularly in web applications, to handle user authentication and authorization. Here's the key difference between them:

1. **Authentication vs. Authorization**:
    - **Simple Auth (Basic Authentication)**:
        - Simple Auth, often referred to as Basic Authentication, is primarily focused on authentication. It is a straightforward method where a user provides their credentials (usually a username and password) to access a resource.
        - It relies on sending the user's credentials with each request to the server, typically in the form of a base64-encoded string in the `Authorization` header.
        - The server validates the provided credentials and grants access if they are correct. However, it doesn't provide a mechanism for fine-grained authorization control.

    - **OAuth 2.0**:
        - OAuth 2.0, on the other hand, is primarily focused on authorization. It allows a user to grant a third-party application limited access to their resources without sharing their credentials.
        - OAuth 2.0 provides a framework for granting access tokens to applications. These access tokens are used to make authorized requests on behalf of the user.
        - OAuth 2.0 is not concerned with the user's authentication; it assumes that authentication has already occurred. It's more about managing permissions and access to resources.

2. **Use Cases**:
    - **Simple Auth**:
        - Typically used for user authentication within an application.
        - Commonly used when a user needs to log in with their credentials to access a protected area of a website or API.

    - **OAuth 2.0**:
        - Primarily used for granting third-party applications limited access to user resources (e.g., social media logins, allowing apps to access your Google Drive files, etc.).
        - It's suitable for scenarios where a user wants to grant access to their data to an application without sharing their username and password directly.

3. **Security**:
    - **Simple Auth**:
        - Less secure compared to OAuth 2.0, especially if used without HTTPS because credentials can be easily intercepted.
        - Credentials are typically sent with each request, making them more vulnerable to eavesdropping.

    - **OAuth 2.0**:
        - More secure as it doesn't expose the user's credentials to the third-party application.
        - Access tokens have a limited scope and expiration, enhancing security.

In summary, the key difference between Simple Auth (Basic Authentication) and OAuth 2.0 is their primary focus: Simple Auth is about user authentication, while OAuth 2.0 is about authorization and access delegation. OAuth 2.0 is often the preferred choice for scenarios where you need to grant third-party applications controlled access to user resources while maintaining a higher level of security.

---

## 11. What is the difference between Horizontal and Vertical scaling?

Horizontal scaling and vertical scaling are two different approaches to increasing the capacity and performance of a computer system, particularly in the context of handling increased workloads or demand. They are commonly used in the field of distributed computing and server architecture. Here's a breakdown of the differences between horizontal and vertical scaling:

1. **Definition**:

   - **Horizontal Scaling (Scale-Out)**:
     - Horizontal scaling involves `adding more machines` (or nodes) to your existing infrastructure to distribute the load.
     - It is also known as "scaling out" because you are expanding the system horizontally by adding more identical machines.
     - Each new machine added in horizontal scaling typically runs the same software and performs the same functions as the existing ones.

   - **Vertical Scaling (Scale-Up)**:
     - Vertical scaling involves enhancing the capabilities of an existing machine by adding more resources to it.
     - It is also known as "scaling up" because you are expanding the capacity of a single machine vertically by upgrading its CPU, memory, storage, or other hardware components.
     - In vertical scaling, you are essentially making a single machine more powerful.

2. **Resource Allocation**:

   - **Horizontal Scaling**:
     - Resources (such as CPU, memory, and storage) are distributed across multiple machines.
     - Each machine typically handles a portion of the overall workload.

   - **Vertical Scaling**:
     - Resources are concentrated on a single machine.
     - This machine becomes more capable of handling a larger workload due to increased resources.

3. **Scalability**:

   - **Horizontal Scaling**:
     - Provides better scalability when the workload can be easily divided into smaller tasks or requests that can run independently on different machines.
     - It is suitable for applications that need to handle a high number of concurrent users or transactions.

   - **Vertical Scaling**:
     - Offers limited scalability since there's a practical limit to how much you can upgrade a single machine.
     - It's more suitable when you need to enhance the performance of a specific component or application but may not be as cost-effective for extreme scalability needs.

4. **Fault Tolerance**:

   - **Horizontal Scaling**:
     - Provides inherent fault tolerance because if one machine fails, the others can continue to handle the workload.
     - Load balancers are often used to distribute incoming requests across multiple machines.

   - **Vertical Scaling**:
     - Typically, if the single machine being scaled up fails, there is no inherent redundancy, which can be a single point of failure.

5. **Cost and Complexity**:

   - **Horizontal Scaling**:
     - Can be cost-effective because you can use commodity hardware and add machines as needed.
     - Complex load balancing and distributed system management may be required.

   - **Vertical Scaling**:
     - Can be expensive because upgrading hardware components (e.g., adding more CPU cores, RAM) often involves higher costs.
     - It is generally simpler to manage since you're dealing with a single machine.

In practice, many systems use a combination of both horizontal and vertical scaling to achieve the desired level of performance, scalability, and fault tolerance. The choice between these approaches depends on factors like the specific use case, budget, and infrastructure constraints.
