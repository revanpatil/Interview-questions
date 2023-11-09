### **1. What is the difference between an Abstract class and Interface in Java?**

- An abstract class and an interface in Java both provide a way to define a contract that specifies a set of methods
  that must be implemented by any concrete (i.e., non-abstract) class that implements the contract. However, there are
  several key differences between abstract classes and interfaces in Java:
- **Multiple Inheritance:** Java does not support multiple inheritance of classes, but it does support multiple
  inheritance of interfaces. That means a class can implement multiple interfaces, but it can only extend one abstract
  class.
- **Method Implementation:** An abstract class can contain both abstract methods (methods without a body) and concrete
  methods (methods with a body). Concrete classes that extend the abstract class must provide implementations for the
  abstract methods. An interface, on the other hand, can only contain abstract methods. All methods in an interface are
  abstract and must be implemented by any concrete class that implements the interface.
- **Access Modifiers:** An abstract class can have access modifiers (public, private, protected) on its methods, while
  interface methods are public by default and cannot have any access modifiers.
- **Fields**: An abstract class can have instance variables and instance methods, while an interface can only have
  constants (static final variables) and abstract methods.
- **Constructors**: An abstract class can have constructors, while an interface cannot have constructors.
- In general, you should use an interface if you want to define a set of methods that must be implemented by any
  concrete class that implements the interface, regardless of the concrete class's parent class. You should use an
  abstract class if you want to provide a base class that other concrete classes can extend, and you want to specify
  default behavior for some methods or enforce a common structure among the concrete classes.

---

### **2. If the abstract class cannot be instantiated then why does it supports the use of constructors?**

- when we create an object of a class which is concrete and subclass of the abstract class, the constructor of the
  abstract class is automatically invoked
- This is done in order to initialize the instance variables in the abstract class as well as to enforce common
  initialization logic among all concrete subclasses.

---

### **3. What are checked and unchecked exceptions?**

- In Java, exceptions are used to handle errors and other exceptional conditions that occur during the execution of a
  program. There are two main types of exceptions in Java: checked exceptions and unchecked exceptions.
- **Checked Exceptions:** Checked exceptions are exceptions that the Java compiler requires you to handle in your code.
  For example, if your code attempts to open a file, and that file doesn't exist, a checked exception (
  FileNotFoundException) will be thrown. You must either catch the exception in a try-catch block or declare that your
  method throws the exception. If you do not handle the exception, the Java compiler will not allow your code to
  compile.
- The classes that directly inherit the Throwable class except RuntimeException and Error are known as checked
  exceptions. For example, IOException, SQLException, etc. Checked exceptions are checked at compile-time.
- **Unchecked Exceptions:** Unchecked exceptions, also known as runtime exceptions, are exceptions that occur at runtime
  and do not need to be declared or caught in your code. Examples of unchecked exceptions include NullPointerException,
  IllegalArgumentException, and ArrayIndexOutOfBoundsException. These exceptions indicate programming errors and are
  usually caused by bugs in your code. While you do not need to catch or declare unchecked exceptions, it's still a good
  idea to handle them in your code to ensure your program behaves correctly.
- The classes that inherit the RuntimeException are known as unchecked exceptions. For example, ArithmeticException,
  NullPointerException, ArrayIndexOutOfBoundsException, etc. Unchecked exceptions are not checked at compile-time, but
  they are checked at runtime.

---

### **4. Difference between **throw** and **throws**?**

- "throw" is used to throw an exception explicitly in your code. For example:

```java
            if(age< 18){
        throw new ArithmeticException("Person is not eligible to vote");
        }
```

- In this example, the "throw" keyword is used to throw an ArithmeticException if the age of the person is less than 18.
  This exception can be caught in a try-catch block and handled appropriately.
- "throws" is used to declare that a method might throw an exception.
- For example:

```java   
            public void checkAge(int age)throws ArithmeticException{}
```    

---

### **5. What is the difference between C++ & Java?**

- Java is multithreaded
- Java has no pointers
- Java has automatic memory management (garbage collection)
- Java is platform independent
- Java has built-in support for comment documentation
- Java has no operator overloading
- Java doesn’t provide multiple inheritance
- There are no destructors in Java

---

### **6. What is JAR file**

- A JAR (Java Archive) file is a package file format used to aggregate many Java class files and associated metadata and
  resources (text, images, etc.) into one file for distribution. JAR files are similar to ZIP files, but they have a
  different file format and are used specifically for Java applications.

- JAR files have the following benefits:
    - They allow you to package multiple class files, resources, and metadata into a single file, making distribution
      and deployment of Java applications much easier.
    - They allow you to package Java applications with their dependencies, so you don't have to worry about installing
      the right version of each library on each user's machine.
    - They allow you to hide the source code of your Java application, as the class files in a JAR file are compiled and
      cannot be easily decompiled.
    - They allow you to apply digital signatures to your Java application, so users can verify that your application has
      not been tampered with.
- JAR files can be executed directly by double-clicking them or by using the java -jar command. They can also be added
  to the classpath when compiling and running Java programs, allowing the programs to use the classes and resources
  packaged in the JAR file.

---   

### **7. What is JNI**

- JNI is an acronym of Java Native Interface. Using JNI we can call functions which are written
  in other languages from Java.

---

### **8. What is serialization?**

- Serialization in Java is the process of converting an object's state to a byte stream so that it can be stored in a
  file, transmitted over a network, or used for other purposes. The byte stream can then be restored to create a new
  object that is an exact copy of the original object.

- Serialization is useful in many situations, such as when you want to store the state of an object on disk or transmit
  it over a network. When an object is serialized, all of its instance variables and other data are written to a byte
  stream, and when the object is deserialized, the byte stream is used to recreate the object.

- In Java, serialization is implemented using the Serializable interface, which is a marker interface that indicates
  that an object can be serialized. To serialize an object, you can use the ObjectOutputStream and ObjectInputStream
  classes to write the object to a byte stream and read it back, respectively.

- Here's an example of how you might use serialization in Java:

**serialization**

 ```java  
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
    SomeObject obj = new SomeObject();
    // Set properties of obj
    oos.writeObject(obj); // Serialize the object to the file "data.bin"
} catch (IOException e) {
    // Handle serialization exception
}
```

**Deserialization**
```java
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
    SomeObject obj = (SomeObject) ois.readObject(); // Deserialize the object from "data.bin"
    // Use the deserialized object
} catch (IOException | ClassNotFoundException e) {
    // Handle deserialization exceptions
}
```

--- 

### **Does duplicate copies of objects are stored if I serialize the same object again??**

- No, duplicate copies of the same object are not stored when you serialize the same object multiple times. When you serialize an object, the process only writes its state once to the output stream, regardless of how many times you perform serialization on the same object.

- The Java serialization mechanism maintains a reference table that keeps track of objects that have been serialized. If an object has already been serialized and it appears again during the serialization process (e.g., due to object references within the object graph), the serialization mechanism recognizes that it has already serialized that object before and will only write a reference to the previously serialized version of the object in the byte stream.

- This reference sharing during serialization ensures that the object graph can be accurately reconstructed during deserialization. It also helps in avoiding redundant data and controlling the size of the serialized output.

- Here's a simple example to illustrate this behavior:

```java
import java.io.*;

class SomeObject implements Serializable {
    // Some fields and methods
}

public class SerializationExample {
    public static void main(String[] args) {
        SomeObject obj = new SomeObject();
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(obj); // Serialize the object to the file "data.bin"
            oos.writeObject(obj); // Serialize the same object again
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In the above example, the object `obj` is serialized twice in a row. However, the resulting file `"data.bin"` will only contain the serialized state of `obj` once, and the second occurrence will be a reference to the first occurrence.

So, no matter how many times you serialize the same object, it will not lead to duplicate copies being stored in the serialized output.

---

### **9. Why there are some null interface in java ? What does it mean ? Give me some null interfaces in JAVA?**

- Null interfaces act as markers..they just tell the compiler that the objects of this class need to be treated
  differently..some marker interfaces are : Serializable, Remote, Cloneable

---

### **10. Is synchronised a modifier?indentifier??what is it??**

- It's a modifier. Synchronized methods are methods that are used to control access to an object.

---

### **11. What is singleton class?where is it used?**

- Singleton is a design pattern meant to provide one and only one instance of an object.Other objects can get a
  reference to this instance through a static method **(class constructor is kept private)**.
- Why do we need one? Sometimes it is necessary, and often sufficient, to create a single instance of a given class.
  This has advantages in memory management, and for Java, in garbage collection.
- Moreover, restricting the number of instances may be necessary or desirable for technological or business reasons--for
  example, we may only want a single instance of a pool of database connections.

---

### **12. Is string a wrapper class?**

- String is a class, but not a wrapper class. Wrapper classes like (Integer) exist for each primitive type. They can be
  used to convert a primitive data value into an object, and vice-versa.

---

### **13. Why java is not a 100% oops?**

- Many people say this because Java uses primitive types such as int, char, double. But then all the rest are objects.

---

### **14. What is transient variable?**

- Transient variable can't be serialize. For example if a variable is declared as transient in a Serializable class and
  the class is written to an ObjectStream, the value of the variable can't be written to the stream instead when the
  class is retrieved from the ObjectStream the value of the variable becomes null

---

### **15. What is Collection API?**

- The Collection API is a set of classes and interfaces that support operation on collections of objects. These classes
  and interfaces are more flexible, more powerful, and more regular than the vectors, arrays, and hashtables if
  effectively replaces.
- **Example of classes**: HashSet, HashMap, ArrayList, LinkedList, TreeSet and TreeMap.
- **Example of interfaces**: Collection, Set, List and Map

---

### **16. Is Iterator a Class or Interface? What is its use?**

- Iterator is an interface which is used to step through the elements of a Collection.

---

### **17. What is synchronization and why is it important?**

- With respect to multithreading, synchronization is the capability to control the access of multiple threads to shared
  resources. Without synchronization, it is possible for one thread to modify a shared object while another thread is in
  the process of using or updating that
  object's value. This often leads to significant errors

---

### **18. Is null a keyword?**

- Yes, null is a reserved word in Java, and it is used to represent the absence of a value. In Java, null is a special
  value that can be assigned to a reference variable, indicating that the variable does not currently refer to an
  object.

---

### **19. What is JVM?**

- JVM, short for Java Virtual Machine, is an abstract computing machine that enables a computer to run Java programs. It
  acts as a run-time engine to run Java applications.
- In simple terms, JVM is a software layer that provides a platform for executing Java code on a particular device. It
  acts as an intermediary between the Java code and the underlying hardware, allowing the same Java code to run on
  different operating systems and hardware configurations without modification.
- In summary, JVM is an essential component of the Java programming language that allows Java code to run on different
  devices and systems, providing a secure and standard environment for executing Java applications.

---

### **20. What is the difference between JDK, JRE, and JVM?**

- JDK (Java Development Kit): The JDK is a software development kit that includes all the tools and resources necessary
  for developing Java applications. It includes the JRE, as well as a compiler, debugger, and other tools for developing
  Java code.
- JRE (Java Runtime Environment): The JRE is a set of libraries and tools that allow Java applications to run on a
  specific platform. It includes the JVM, as well as the class libraries required to run Java applications.
- JVM (Java Virtual Machine): The JVM is an abstract computing machine that enables a computer to run Java programs. It
  acts as a run-time engine to run Java applications, interpreting the compiled Java code and executing the
  instructions.
- In summary, **JDK is a complete software development kit for Java developers, which includes the JRE and other
  development tools. JRE is the environment required to run Java applications, which includes the JVM and the class
  libraries. JVM is the core component that interprets and executes Java code, providing a secure and standard
  environment for running Java applications.**

---

### **21. What are the main differences between the Java platform and other platforms?**

- Java is the software-based platform whereas other platforms may be the hardware platforms or software-based platforms.
- Java is executed on the top of other hardware platforms whereas other platforms can only have the hardware components.

---

### **22.What gives Java its 'write once and run anywhere' nature?**

- The bytecode. Java compiler converts the Java programs into the class file (Byte Code) which is the intermediate
  language between source code and machine code. This bytecode is not platform specific and can be executed on any
  computer.

---

### **23.What are the various access specifiers in Java?**

- In Java, access specifiers are the keywords which are used to define the access scope of the method, class, or a
  variable. In Java, there are four access specifiers given below.
    - **Public** The classes, methods, or variables which are defined as public, can be accessed by any class or method.
    - **Private** The private class, methods, or variables defined as private can be accessed within the class only.
    - **Default** Default are accessible within the package only. By default, all the classes, methods, and variables
      are of default scope.
    - **Protected** Protected can be accessed by the class of the same package, and also from any subclass, regardless of whether it's in the same package or not

- The main difference between **default** and **protected** access modifiers is that default is more restrictive than protected.      

---

### **24.What is an object?**

- The Object is the real-time entity having some state and behavior. In Java, Object is an instance of the class having
  the instance variables as the state of the object and the methods as the behavior of the object. The object of a class
  can be created by using the new keyword.

---

### 25.Explain `this` keyword in java

- The `this` keyword in Java is a reference to the current object of a class. It is used to refer to the instance
  variables and methods of the current object.

```java
Student(int id,String name){
        this.id=id;
        this.name=name;
        }
```    

- In this example, the constructor uses the `this` keyword to refer to the instance variables, and it assigns the values
  of the arguments to the instance variables.

- The `this` keyword can be used in any method or constructor of a class to refer to the current object. It is a useful
  mechanism for accessing the instance variables and methods of the current object, and it helps to ensure that the
  instance variables and methods are used in a controlled and predictable manner.

---

### 25a. Uses of `this` keyword with examples:

- The `this` keyword in Java refers to the current instance of the class. It is used to access instance variables and
  methods within the class. Here are a few example scenarios in which the this keyword is used:
- **Accessing instance variables:** If a local variable has the same name as an instance variable, you can use
  the `this` keyword to refer to the instance variable.

```java   
            public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
```            

- **Calling instance methods:** The `this` keyword can be used to call one instance method from another within the same
  class.

```java   
            public class Person {
    private String name;

    public void setName(String name) {
        this.setNameAndAge(name, 0);
    }

    public void setNameAndAge(String name, int age) {
        this.name = name;
    }
}
```            

- **Passing `this` as an argument:** The this keyword can be used to pass the current instance of a class as an argument
  to another method.

```java   
            public class Person {
    private String name;

    public void setName(String name) {
        PersonUtils.printPerson(this);
    }
}

public class PersonUtils {
    public static void printPerson(Person person) {
        System.out.println(person.name);
    }
}
```            

- **Constructor chaining:** The this keyword can be used to invoke a different constructor of the same class.

```java   
            public class Person {
    private final String name;
    private final int age;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

---

### **26.What are the restrictions that are applied to the Java static methods?**

- The static method can not use non-static data member or call the non-static method directly.
- `this` and `super` cannot be used in static context as they are `non-static`.

---

### **27. Static Method more info:**

- Access to non-static members: A static method cannot directly access non-static variables or methods. It can access
  them only through an object reference.
- `this` and `super` keyword: The `this` and `super` keyword cannot be used in static methods, as they do not belong to
  a specific instance of a class.
- Overriding: Static methods cannot be overridden because they are associated with the class, not with the objects of
  the class.
- Inheritance: Static methods can be inherited, but cannot be overridden in the subclass.
- Abstract: Static methods cannot be declared abstract.
- Final: Static methods can be declared final, which means they cannot be overridden in any subclass.
- Overloading: Static methods can be overloaded, meaning multiple static methods can have the same name with different
  parameters.

---

### **28.Java static block:**

- Is used to initialize the static data member.
- It is **executed before the main method** at the time of classloading.
- Example:

```java
         static {
        System.out.println("static block is invoked");
        }
```

---

### **29. What is runtime polymorphism in Java?**

- Runtime polymorphism, also known as dynamic method dispatch, is a feature of object-oriented programming that allows a
  method to be called at runtime based on the type of the object, rather than the type of the reference variable.

- In Java, runtime polymorphism is achieved through method overriding. Method overriding allows a subclass to provide a
  new implementation for a method that is already defined in its superclass. When an object of the subclass is created,
  the appropriate method is called at runtime based on the type of the object, not the type of the reference variable.

- For example, consider the following code:

```java   
            class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.makeSound();
    }
}
```            

- In this example, the makeSound method is overridden in the Dog class. When the makeSound method is called on the
  animal object, the makeSound method of the Dog class is called, even though the type of the reference variable animal
  is Animal. This is runtime polymorphism in action.

---

### **30.What is super in java?**

- The super keyword in Java is a reference variable that is used to refer to the immediate parent class object. Whenever
  you create the instance of the subclass, an instance of the parent class is created implicitly which is referred by
  super reference variable. The super() is called in the class constructor implicitly by the compiler if there is no
  super or this.
- super can be used to refer immediate parent class instance variable.
- super can be used to invoke immediate parent class method.
- super() can be used to invoke immediate parent class constructor.

---

### **31. What are the differences between this and super keyword?**

- The super keyword always points to the parent class contexts whereas this keyword always points to the current class
  context.
- The super keyword is primarily used for initializing the base class variables within the derived class constructor
  whereas this keyword primarily used to differentiate between local and instance variables when passed in the class
  constructor.
- **The super and this must be the first statement inside constructor otherwise the compiler will throw an error.**

---

### **32. Difference between method arguments and parameters?**

- Method **parameters**: The **variables listed** in the method declaration are known as the method parameters.
- Method **arguments**: The **values passed** to a method when it is called are known as method arguments.

--- 

### **33. What is the abstraction?**

- Abstraction is a process of hiding the implementation details and showing only functionality to the user. It displays
  just the essential things to the user and hides the internal information
- In Java, there are two ways to achieve the abstraction.
    - Abstract Class
    - Interface

--- 

### **34. Can you declare an interface method static?**

- No, because methods of an interface are abstract by default, and we can not use static and abstract together.

---

### 35. If I have a class with a singleton class and inside that class I have another class of Prototype scope; what happens to the inner class object if I instantiate the outer class object? Does multiple objects get created for that inner class?

- If you have a class with a singleton scope and inside that class you have another class with a prototype scope, then
  when you instantiate the outer class object, only one instance of the outer class will be created, as it is a
  singleton.
  However, the inner class, which has a prototype scope, can have multiple instances created, depending on how you
  instantiate it.
- The inner class objects will not be tied to the outer class object, they are independent and will have their own
  state. So, every time you create an object of the inner class, a new instance of that class will be created,
  regardless of whether the outer class is a singleton or not.
- It's important to note that the inner class has access to the private members of the outer class, but it's not tied to
  the lifecycle of the outer class. Each instance of the inner class will be independent, and creating a new instance of
  the outer class will not affect the inner class instances.

---

### **36. Do we have static class in Java?**

- In Java, we do not have the concept of a "static class" as such, but we have inner classes. A static inner class is a
  class defined within another class, but it does not have access to the instance variables and methods of the outer
  class. It can only access the static variables and methods of the outer class. It can be instantiated and used just
  like a top-level class and it does not require an instance of the outer class to be created first.

---

### **37. Is it possible to inherit the static inner class?**

- No, it is not possible to inherit a static inner class in Java, because a static inner class is not an independent
  class, it is a nested class and it is associated with the outer class. Since it does not have its own object, it does
  not make sense for it to be inherited by another class.
- A static inner class is similar to a top-level class, but it has access to the static members of the outer class. It
  can also be instantiated and used just like a top-level class, but it does not require an instance of the outer class
  to be created first.
- However, a non-static inner class can inherit from other classes or interfaces and also can be inherited by other
  classes.

---

### **38. Can you elaborate more about inner class and its uses?**

- An inner class, also known as a nested class, is a class defined within another class. Inner classes can be divided
  into two categories: static and non-static.
- A non-static inner class, also known as an inner class, has access to the instance variables and methods of the outer
  class, and it requires an instance of the outer class to be created before it can be instantiated. It can be used to
  encapsulate the implementation details of the outer class, to provide a more convenient interface, or to implement
  helper classes that are only used by the outer class.
- A static inner class, also known as a static nested class, does not have access to the instance variables and methods
  of the outer class, it only has access to the static members of the outer class. It can be instantiated and used just
  like a top-level class, but it does not require an instance of the outer class to be created first. It is mainly used
  to group related classes together, or to provide a more convenient namespace for a group of classes.
- Inner classes can also be further divided into two categories: local and anonymous.
- A local inner class is defined within a block of code, such as a method or a constructor, and it has access to the
  final variables of the enclosing block. It is mainly used to implement helper classes that are only used by the
  enclosing block.
- An anonymous inner class is an inner class that is defined and instantiated in a single statement, without giving it a
  name. Anonymous inner classes are mainly used for implementing event listeners and other similar interfaces that have
  only one method to be overridden.
- Inner classes can also be used to implement the decorator and adapter design patterns, as well as to provide a more
  elegant and readable way of implementing inner classes.

---

## **39. Java 8 EE features**

- Java 8 Enterprise Edition (Java EE) is an extension of Java 8 Standard Edition (Java SE) and provides a set of
  specifications for building enterprise-level applications. It includes several new features and improvements over
  previous versions, such as:

- Lambda Expressions: Java 8 introduced lambda expressions, which make it easier to write functional-style code in Java.
- Stream API: Java 8 introduced a new Stream API, which provides functional-style operations for processing collections
  of data.
- Date and Time API: Java 8 introduced a new Date and Time API, which provides improved support for handling dates and
  times in Java.
- JSON Processing API: Java 8 EE includes a new JSON Processing API, which provides a simple and consistent way to
  parse, generate, and manipulate JSON data.
- JavaServer Faces (JSF) 2.2: Java 8 EE includes a new version of JSF, which adds several new features, such as HTML5
  support, resource library contracts, and improved state management.
- Java API for WebSocket: Java 8 EE includes a new API for WebSocket, which enables bidirectional communication between
  a client and a server over a single TCP connection.
- Java API for RESTful Web Services (JAX-RS) 2.0: Java 8 EE includes a new version of JAX-RS, which adds support for
  server-sent events and improved support for hypermedia.
- JavaServer Pages (JSP) 2.3: Java 8 EE includes a new version of JSP, which adds support for the Expression Language (
  EL) 3.0 and improved support for the EL 2.2.
- Java Persistence API (JPA) 2.1: Java 8 EE includes a new version of JPA, which adds support for the Stored Procedure
  Query and improved support for the Criteria API.
- Java Transaction API (JTA) 1.2: Java 8 EE includes a new version of JTA, which adds support for the UserTransaction
  and the TransactionSynchronizationRegistry interfaces.

---

## **40. Stream API**

- The Stream API is a new feature in Java 8 that allows functional-style operations to be performed on collections of
  data.
- Streams are similar to collections, but they do not store data, they process data.
- A stream can be created from a collection using the stream() method or by using the of() method to create a stream
  from a set of values.
- The elements in a stream can be processed using intermediate operations such as filter(), map(), and sorted()
- Intermediate operations return a new stream, allowing operations to be chained together.
- Terminal operations, such as forEach() and count(), are used to obtain the final result of a stream operation.
- Streams can be parallelized to take advantage of multiple CPU cores to improve performance.
- The Stream API provides a functional and efficient way to process large amounts of data.
- Streams are useful for performing operations such as filtering, mapping, and reducing large collections of data.
- The Stream API is a powerful feature in Java 8 that makes it easier to write functional-style code in Java.

```java
public class JavaStreamExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products  
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        List<Float> productPriceList2 = productsList.stream()
                .filter(p -> p.price > 30000)// filtering data  
                .map(p -> p.price)        // fetching price  
                .collect(Collectors.toList()); // collecting as list  

        System.out.println(productPriceList2);
    }
}
```

---            

### **41. Date time API**

```java
         // Java code for LocalDate
// / LocalTime Function

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {

    public static void LocalDateTimeApi() {

        // the current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is " + date);


        // the current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is " + time);


        // will give us the current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " + current);


        // to print in a particular format
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("in formatted manner " + formatedDateTime);


        // printing months days and seconds
        Month month = current.getMonth();
    }
}
```

---

### **42. Java 8 vs 11?**

- Java 8 and Java 11 are both popular versions of the Java programming language. Here are some of the key differences
  between the two versions:
- Performance: Java 11 includes several performance improvements over Java 8, including faster startup time, reduced
  memory footprint, and better garbage collection.
- Features: Java 11 includes several new features that were not available in Java 8, including new APIs for HTTP and
  JSON, enhancements to the existing APIs, and support for new language features such as var.
- Security: Java 11 includes several security enhancements over Java 8, including TLS 1.3 support, stronger algorithms
  for secure communications, and improvements to the security APIs.
- Support: Java 8 was released in March 2014, while Java 11 was released in September 2018. Oracle provides support for
  Java 8 until at least December 2030, while Java 11 has long-term support until at least September 2026.
- Licensing: Java 11 introduced a new licensing model for the Java Development Kit (JDK) that requires businesses to
  purchase a subscription for commercial use. Java 8, on the other hand, is still available under the previous licensing
  model, which allows for free use in certain circumstances.

---


### **44. What does `synchronized` mean?**

`synchronized` is a keyword in Java that is used to achieve thread safety by restricting concurrent access to a shared
resource.

#### Example

```java
public synchronized void incrementCounter(){
        // code to increment a shared counter variable
        }
```

- In this example, the incrementCounter() method is marked as synchronized, which means that only one thread can execute
  this method at a time, and all other threads must wait until the lock is released. This ensures that the shared
  counter variable is incremented atomically and avoids race conditions.

---

### **45. What is Optional keyword?**

`Optional` is a class in Java that was introduced in Java 8 as a way to represent a value that may or may not be
present. It is used to avoid NullPointerExceptions and make code more concise and readable by explicitly handling the
case where a value is absent.

Here's an example of how Optional can be used in Java:

### Example

```java
Optional<String> optionalName=Optional.ofNullable(getName());

        if(optionalName.isPresent()){
        String name=optionalName.get();
        System.out.println("Name is: "+name);
        }else{
        System.out.println("Name is not present.");
        }

```

- In this example, optionalName is an Optional object that contains a value that may or may not be present. The
  ofNullable() method is used to create an Optional object from a nullable value. The isPresent() method is used to
  check if the value is present, and the get() method is used to retrieve the value if it is present.
- By using Optional in this way, we can avoid null checks and make our code more concise and readable. If the value is
  not present, we can handle that case explicitly using the else block.

---

### **46. Volatile Keyword**

volatile is a keyword in Java that is used to ensure that a variable is always read and written to from main memory,
  rather than from a thread's local cache. It is used to ensure that changes to a variable made by one thread are
  visible to all other threads.

Here's an example of how volatile can be used in Java:

```java
public class Counter {
    private volatile int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
```

- In this example, count is marked as volatile, which ensures that changes made to count by one thread are immediately
  visible to all other threads. If count were not marked as volatile, different threads might see different values of
  count due to caching.
- It's important to note that while volatile ensures visibility of changes between threads, it does not ensure atomicity
  or synchronization. If multiple threads are updating a volatile variable at the same time, you may still need to use
  other synchronization mechanisms, such as locks or atomic variables, to ensure correct behavior.

---

### 47. In a single try block can we have multiple catch blocks?

- Yes, in Java it is possible to have multiple catch blocks for a single try block. This allows you to handle different
  types of exceptions in different ways.

- The syntax for a try-catch block with multiple catch blocks looks like this:-

```java
        try{
        // read data from file and process it
        }catch(FileNotFoundException e){
        // handle file not found error
        }catch(IOException e){
        // handle general I/O error
        }catch(DataFormatException e){
        // handle specific data format error
        }catch(Exception e){
        // handle all other types of exceptions
        }
```
- By using multiple catch blocks, we can handle different types of exceptions in different ways, allowing us to provide more specific error messages or take different actions depending on what went wrong.

--- 

## **48. Explain Functional Interface in Java like you are giving an interview**

**Q:** Can you explain what a Functional Interface is in Java?

**A:** Yes, a Functional Interface in Java is an interface that has only one abstract method. The main purpose of a Functional Interface is to enable the use of lambda expressions or method references as a shorthand for implementing the single abstract method of the interface.

**Q:** What is the significance of Functional Interfaces in Java?

**A:** The significance of Functional Interfaces in Java is that they provide a way to represent functional concepts in Java. This is particularly useful when dealing with functional programming paradigms such as lambda expressions and method references. `Functional Interfaces make it possible to pass behavior as an argument to a method`, which enables greater flexibility and modularity in your code.

**Q:** Can you give an example of a Functional Interface in Java?

**A:** Sure, here's an example of a Functional Interface in Java:

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void doSomething();
}
```
This interface has only one abstract method, doSomething(). The @FunctionalInterface annotation is optional, but it's a good practice to use it to indicate that this interface is intended to be a Functional Interface.

**Q:** How can we use a lambda expression or method reference with a Functional Interface in Java?

**A:** We can use a lambda expression or method reference to implement the single abstract method of a Functional Interface. Here's an example:

```java
MyFunctionalInterface myLambda = () -> System.out.println("Do something!");
myLambda.doSomething();
```

In this example, we've created a lambda expression that implements the doSomething() method of the MyFunctionalInterface. We've then assigned this lambda expression to a variable myLambda of type MyFunctionalInterface. Finally, we've called the doSomething() method on myLambda, which will execute the lambda expression.

**Q:** Are there any built-in Functional Interfaces in Java?

**A:** Yes, there are several built-in Functional Interfaces in Java, such as Runnable, Supplier, Consumer, Predicate, and Function, to name a few. These interfaces are included in the java.util.function package and provide a way to use functional programming concepts in Java.

---

### 49. Multiple inheritance ? How do you achieve it in java?

Java does not support multiple inheritance of classes, which means that a class cannot inherit from multiple classes at the same time. This is because multiple inheritance can lead to diamond inheritance problems, where a class inherits from two or more classes that have a common ancestor, and may inherit conflicting or ambiguous behaviors.

However, Java does support multiple inheritance of interfaces. An interface can extend multiple interfaces, allowing a class to inherit multiple sets of behaviors from different interfaces.

Here's an example of how multiple inheritance of interfaces can be achieved in Java:

```java
public interface Interface1 {
    void method1();
}

public interface Interface2 {
    void method2();
}

public class MyClass implements Interface1, Interface2 {
    public void method1() {
        System.out.println("Method 1");
    }
    
    public void method2() {
        System.out.println("Method 2");
    }
}
```

In this example, we have two interfaces Interface1 and Interface2, each with a single abstract method. We then have a class MyClass that implements both Interface1 and Interface2, and provides implementations for both methods.

By implementing multiple interfaces, MyClass is able to inherit multiple sets of behaviors and provide a rich set of functionality.

---

## 51:  .equals() vs == in Java

**Q:** What is the difference between the `.equals()` method and the `==` operator in Java?

**A:** The `.equals()` method and the `==` operator are both used to compare objects in Java, but they have different purposes:

1. The `==` operator compares two object references to see if they refer to the same object in memory. It checks if the two objects are exactly the same instance. If two object references are equal using `==`, then they must refer to the same object.

2. The `.equals()` method compares the content of two objects to see if they are equivalent. It checks if the two objects have the same values for all of their properties. If two objects are equal using `.equals()`, then their contents are identical, even if they are not the same instance.

**Q:** How does the `.equals()` method work?

**A:** The `.equals()` method is defined in the `Object` class, which is the base class for all Java classes. By default, the `.equals()` method compares two objects based on their memory address, which is the same as using the `==` operator. However, most Java classes override the `.equals()` method to compare the contents of the objects instead. When we call `.equals()` on an object, it will compare the contents of the object to the contents of the object passed as an argument.

**Q:** When should we use `.equals()`, and when should we use `==`?

**A:** We should use `==` when we want to compare two object references to see if they refer to the same object in memory. We should use `.equals()` when we want to compare the contents of two objects to see if they are equivalent. For example, if we have two `String` objects, we should use `.equals()` to compare them, since we care about the contents of the strings, not their memory address.

**Q:** Can we override the `==` operator?

**A:** No, we cannot override the `==` operator in Java. The `==` operator always compares object references to see if they refer to the same object in memory. We can only override the `.equals()` method to customize how objects are compared for equality.

---

## **52. Static access modifier**

**Q:** How does the static access modifier work in Java?

**A:** The static access modifier is used to create class-level variables and methods that are shared by all instances of a class. When a variable or method is declared as static, it belongs to the class rather than to any particular instance of the class. This means that it can be accessed without creating an instance of the class.

**Q:** What are some use cases for the static access modifier?

**A:** Some common use cases for the static access modifier include:

- **Constants**: When a variable is declared as static final, it becomes a constant that can be accessed without creating an instance of the class.

- **Utility methods**: When a method is declared as static, it can be used as a utility method that performs a specific function that is not tied to any particular instance of the class.

- **Counters**: When a variable is declared as static, it can be used as a counter that is shared by all instances of the class.

**Q:** What are some drawbacks of using the static access modifier?

**A:** Some of the drawbacks of using the static access modifier include:

- Reduced flexibility: Because static variables and methods belong to the class rather than to any particular instance of the class, they can be less flexible than instance variables and methods.

- Increased coupling: When a variable or method is declared as static, it can be accessed from anywhere in the code, which can increase the coupling between different parts of the code.

- Thread safety: When a variable is declared as static, it is shared by all instances of the class, which can create thread safety issues if multiple threads try to access or modify the variable at the same time.

---

## **53. Defining Objects in Java**

**Q:** What are the different ways to define an object in Java?

**A:** There are two main ways to define an object in Java:

1. Using the new keyword: The most common way to create an object in Java is by using the `new` keyword. This involves creating a new instance of a class and assigning it to a variable. For example:

    ```java
    MyClass myObj = new MyClass();
    ```
   - This creates a new instance of the `MyClass` class and assigns it to the `myObj` variable.

2. Using a static factory method: Another way to create an object in Java is by using a static factory method. This involves creating a method in the class that returns an instance of the class. For example:

```java
public class MyClass {
private MyClass() {}

  public static MyClass createInstance() {
    return new MyClass();
  }
```

This creates a private constructor for the `MyClass` class, and a static factory method called `createInstance()` that returns a new instance of the class. This approach can be useful in situations where you want to control the creation of objects or perform some additional logic during the creation process.

**Q:** Are there any other ways to define objects in Java?

**A:** While these are the two main ways to create objects in Java, there are also a few other ways to create objects in certain situations. For example:

- Object cloning: In some cases, you can create a new object by cloning an existing object using the `clone()` method.

- Reflection: You can also create new instances of classes using reflection, which involves dynamically creating new objects at runtime based on their class name and other metadata.


---

## **54. Serialization and Deserialization in Java**

**Q:** What is serialization and deserialization in Java?

**A:** Serialization is the process of converting an object into a stream of bytes, which can be stored in a file or transmitted over a network. Deserialization is the opposite process of converting a stream of bytes back into an object.

**Q:** How do you perform serialization and deserialization in Java?

**A:** In Java, serialization and deserialization can be performed using the `ObjectOutputStream` and `ObjectInputStream` classes, respectively. Here's an example of how to serialize and deserialize an object:

```java
import java.io.*;

public class SerializationExample {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
// Create an object to serialize
    MyClass obj = new MyClass("Hello", 123);

    // Serialize the object to a file
    FileOutputStream fileOut = new FileOutputStream("myobject.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(obj);
    out.close();
    fileOut.close();

    // Deserialize the object from the file
    FileInputStream fileIn = new FileInputStream("myobject.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    MyClass newObj = (MyClass) in.readObject();
    in.close();
    fileIn.close();

    // Print the deserialized object
    System.out.println(newObj);
  }
}
```
```java
class MyClass implements Serializable {
  private String str;
  private int num;

  public MyClass(String str, int num) {
    this.str = str;
    this.num = num;
  }

  public String toString() {
    return "MyClass [str=" + str + ", num=" + num + "]";
  }
}
```


In this example, we define a class called `MyClass` that implements the `Serializable` interface. This allows the object to be serialized and deserialized using the `ObjectOutputStream` and `ObjectInputStream` classes.

We then create an instance of `MyClass`, serialize it to a file called `myobject.ser`, and then deserialize it back into a new instance of `MyClass`. Finally, we print out the deserialized object to verify that it was properly deserialized.

Note that in order for an object to be serializable, all of its member variables must also be serializable or marked as transient. If a non-serializable object is included as a member variable, a `NotSerializableException` will be thrown during serialization.

---

## **55. Inheritance in Java**

**Q:** What are the different types of inheritance in Java?

**A:** There are five types of inheritance in Java:
- Single inheritance
- Multilevel inheritance
- Hierarchical inheritance
- Multiple inheritance (not supported in Java)
- Hybrid inheritance (not supported in Java)

**Q:** Why does Java not support multiple or cyclic inheritance?

**A:** Java does not support multiple or cyclic inheritance to avoid the "diamond problem". The diamond problem occurs when two superclasses have a common method and a subclass tries to override it. In multiple inheritance, it is not clear which superclass method should be overridden. In other words, there is an ambiguity in method resolution.

Cyclic inheritance, on the other hand, occurs when a class extends itself directly or indirectly through a chain of classes. This can result in infinite recursion and is therefore not allowed in Java.

To avoid these problems, Java supports only single and multilevel inheritance. Single inheritance is when a class extends only one superclass, while multilevel inheritance is when a class extends a superclass, which in turn extends another superclass. Hierarchical inheritance is a special case of single inheritance where one superclass is extended by multiple subclasses.

---

## **56. Inheriting the Object Class in Java**

**Q:** You have a class in Java. How will it inherit the Object class by default?

**A:** In Java, every class is a direct or indirect subclass of the Object class. This means that every class inherits the methods of the Object class by default. If a class does not explicitly extend any other class, it will implicitly extend the Object class.

The Object class is a special class in Java that provides some common behavior and functionality that is shared by all classes. Some of the important methods provided by the Object class are:

- `equals()`: compares two objects for equality
- `hashCode()`: returns a hash code value for the object
- `toString()`: returns a string representation of the object
- `getClass()`: returns the class of the object
- `clone()`: creates a new object that is a copy of the original object
- `finalize()`: called by the garbage collector when the object is no longer needed

When a class does not provide its own implementation of these methods, it inherits them from the Object class.

---

## **57. List multiple types of Functional interfaces with their usage example**

- A functional interface in Java is an interface that contains a single abstract method. Here are some examples of functional interfaces and their usage:

1. Predicate<T> - Takes an input of type T and returns a boolean value based on some condition.

  ```java
  Predicate<Integer> isPositive = num -> num > 0;
  System.out.println(isPositive.test(5)); // Output: true
  ```

2. Consumer<T> - Accepts an input of type T and performs some operation without returning any value.

  ```java
  Consumer<String> printString = str -> System.out.println(str);
  printString.accept("Hello world!"); // Output: Hello world!
  ```

3. Function<T, R> - Accepts an input of type T and returns a result of type R.   

  ```java
  Function<Integer, Integer> square = num -> num * num;
  System.out.println(square.apply(5)); // Output: 25
  ```

4. Supplier<T> - Provides an output of type T without taking any input.

  ```java
  Supplier<String> greeting = () -> "Hello world!";
  System.out.println(greeting.get()); // Output: Hello world!
  ```

---  

## **58. What is try with resources block in Java?**
In Java, the try-with-resources block is a language feature that enables automatic closing of resources used within a try block. It is a simplified and safer way to handle the closing of resources like files, network sockets, database connections, and other objects that require clean-up actions after their usage.

The try-with-resources block automatically closes the resource objects when the block is exited, whether normally or due to an exception being thrown. This ensures that resources are always closed, regardless of any exceptions that may have been thrown, and eliminates the need for explicit finally blocks to close resources.

Here's an example of how to use the try-with-resources block to automatically close a file:

```java
try (FileInputStream fis = new FileInputStream("example.txt")) {
    // do something with the file input stream
} catch (IOException e) {
    // handle exception
}
```

In this example, the FileInputStream object is created within the parentheses of the try statement, and will be automatically closed when the try block is exited. If an exception is thrown, the catch block can handle it as usual.

## **59. How can we decide the number of threads we can have or provide the number of threads that threadpool can have?**

Deciding the number of threads to use in a thread pool is an important consideration in designing a multithreaded application. The optimal number of threads will depend on various factors such as the nature of the tasks, the hardware configuration of the system, and the available resources.

In general, there is no fixed rule for determining the number of threads to use, but you can follow some guidelines and best practices to arrive at an optimal number. Here are some tips:

  1. Consider the nature of the tasks: The number of threads should be proportional to the nature of the tasks you want to execute. If the tasks are CPU-bound and require intensive computations, you may need fewer threads than if the tasks are I/O bound and involve waiting for data from external sources.

  2. Consider the hardware configuration: The number of threads should be aligned with the number of CPU cores available on the system. Having more threads than the available cores may lead to inefficient use of system resources and degrade performance due to context switching overhead.

  3. Benchmark and experiment: You can experiment with different thread pool sizes and measure the performance of the application to arrive at an optimal number of threads. You can use profiling tools to monitor the behavior of the threads and identify bottlenecks.

Once you have determined the optimal number of threads to use, you can specify it while creating the thread pool. For example, you can create a fixed-size thread pool with 10 threads using the Executors.newFixedThreadPool(10) method. Alternatively, you can create a cached thread pool that can dynamically adjust the number of threads based on the workload using the Executors.newCachedThreadPool() method.

In summary, deciding the number of threads to use in a thread pool requires careful consideration of various factors. You can follow some guidelines and best practices to arrive at an optimal number and specify it while creating the thread pool.

## **60. I have provided 10 tasks and have used synchronized keyword to run one task at a time. What will happen if one of the task fails or get stuck? Will the other tasks execute?**

If you have used the synchronized keyword to ensure that only one task is executed at a time and one of the tasks fails or gets stuck, it can cause the other tasks to block and wait for the failed/stuck task to complete. This is because the synchronized keyword acquires a lock on the shared resource (in this case, the method or code block that is synchronized) and only one thread can execute it at a time.

So if a task fails or gets stuck, the other tasks that are waiting to acquire the lock on the shared resource will be blocked and wait until the lock is released. This can lead to decreased performance and possibly deadlock if the failed/stuck task does not release the lock.

To avoid this situation, you can add timeouts to the tasks so that they do not run indefinitely and can fail gracefully. You can also consider using a thread pool to execute the tasks, as thread pools can manage the execution of tasks more efficiently and can handle failures or stuck tasks more gracefully. Additionally, using a thread pool can allow you to parallelize the execution of tasks, improving the overall performance of your application.

In summary, using the synchronized keyword to ensure that only one task is executed at a time can cause other tasks to block and wait if a task fails or gets stuck. Adding timeouts and using a thread pool can help to prevent these issues and improve the overall performance of your application.


---

## **61. How does threadpool help in above situation?**

In the scenario where you have 10 tasks to execute and are using the synchronized keyword to ensure that only one task is executed at a time, using a thread pool can provide several benefits over manually managing the execution of the tasks:

  1. Efficient use of system resources: A thread pool can manage the number of threads used to execute tasks, based on the availability of system resources such as CPU cores and memory. This can ensure that the tasks are executed efficiently, without consuming excessive system resources.

  2. Improved performance: A thread pool can execute tasks in parallel, which can improve the overall performance of the application. Instead of waiting for one task to complete before starting the next one, the thread pool can execute multiple tasks concurrently, reducing the overall execution time.

  3. Graceful handling of failures: A thread pool can handle task failures gracefully, without affecting the execution of other tasks. If a task fails or gets stuck, the thread pool can mark the task as failed and move on to execute other tasks. This can prevent other tasks from getting blocked or waiting indefinitely.

To use a thread pool in your scenario, you can create a fixed-size thread pool using the Executors.newFixedThreadPool(n) method, where n is the number of threads in the pool. You can then submit your tasks to the thread pool using the ExecutorService.submit() method. The thread pool will manage the execution of the tasks and ensure that they are executed efficiently and in parallel.

In summary, using a thread pool can provide several benefits over manually managing the execution of tasks, including efficient use of system resources, improved performance, and graceful handling of failures.

---

## **62. How does threadpool handle failures gracefully?**

Thread pools can handle task failures gracefully in several ways, depending on the implementation and configuration of the thread pool. Here are some ways thread pools can handle failures:

  1. Catching and logging exceptions: Thread pools can catch and log any exceptions that occur during the execution of a task. This can provide visibility into the cause of the failure and help with debugging and troubleshooting.

  2. Returning Future objects: When a task is submitted to a thread pool, it can return a Future object that represents the result of the task. If the task fails, the Future object can contain an exception that caused the failure. The application can then handle the exception and take appropriate action, such as retrying the task or reporting the failure to a monitoring system.

  3. Automatic retries: Thread pools can be configured to automatically retry failed tasks. For example, you can specify a maximum number of retries for a task and a delay between retries. This can help to recover from transient failures, such as network errors or temporary resource unavailability.

  4. Fault tolerance: Some thread pool implementations, such as the Hystrix library, provide fault tolerance mechanisms that can handle failures of entire services or subsystems. These mechanisms can include fallback strategies, circuit breakers, and bulkheads, which can help to isolate and recover from failures.

In summary, thread pools can handle task failures gracefully by catching and logging exceptions, returning Future objects that contain the cause of the failure, automatically retrying failed tasks, and providing fault tolerance mechanisms. These features can help to improve the reliability and resilience of multithreaded applications.

---

## **63. Can you provide actual code for above mentioned ways?**

Sure! Here is an example code that demonstrates some of the ways thread pools can handle failures:

  1. Catching and logging exceptions:
     ```java
     ExecutorService executor = Executors.newFixedThreadPool(5);

      Runnable task = () -> {
          try {
              // Code that may throw an exception
          } catch (Exception e) {
              // Log the exception
              logger.error("Task failed: " + e.getMessage(), e);
          }
      };

      executor.execute(task);
     ```
  2. Returning Future objects:
     ```java
     ExecutorService executor = Executors.newFixedThreadPool(5);

      Callable<Integer> task = () -> {
          // Code that may throw an exception
      };

      Future<Integer> future = executor.submit(task);

      try {
          Integer result = future.get();
      } catch (Exception e) {
          // Handle the exception
          logger.error("Task failed: " + e.getMessage(), e);
      }
     ```
  
  3. Automatic retries:
     ```java
     ExecutorService executor = Executors.newFixedThreadPool(5);

      Runnable task = () -> {
          int retries = 0;

          while (retries < 3) {
              try {
                  // Code that may throw an exception
                  break;
              } catch (Exception e) {
                  retries++;
                  // Log the exception and wait before retrying
                  logger.warn("Task failed, retrying in 1 second: " + e.getMessage(), e);
                  Thread.sleep(1000);
              }
          }

          if (retries == 3) {
              // Handle the failure
              logger.error("Task failed after 3 retries");
          }
      };

      executor.execute(task);
     ```

  4. Fault tolerance using Hystrix:
     ```java

     HystrixCommand.Setter config = HystrixCommand.Setter
        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyService"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("MyCommand"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MyThreadPool"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                .withFallbackEnabled(true)
                .withCircuitBreakerEnabled(true)
                .withCircuitBreakerRequestVolumeThreshold(10)
                .withCircuitBreakerErrorThresholdPercentage(50)
                .withCircuitBreakerSleepWindowInMilliseconds(5000));

      HystrixCommand<Integer> command = new HystrixCommand<Integer>(config) {
          @Override
          protected Integer run() throws Exception {
              // Code that may fail
          }

          @Override
          protected Integer getFallback() {
              // Fallback code that is executed when the command fails
          }
      };

      int result = command.execute();     
     ```

     ---

## **64. Define functional interface in java, state its needs and how it is different from lambda expressions**

In Java, a functional interface is an interface that contains a single abstract method. Functional interfaces are used in lambda expressions and method references, which provide a concise and flexible way to express behavior.

The `main purpose` of functional interfaces is to enable the creation of lambda expressions, which are anonymous functions that can be passed as arguments to methods or assigned to variables. A lambda expression is an implementation of the single abstract method of a functional interface.

Here's an example of a functional interface:

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
}
```

In this example, the MyFunctionalInterface interface contains a single abstract method called doSomething(). The @FunctionalInterface annotation is used to indicate that this interface is intended to be used as a functional interface.

Functional interfaces are needed in Java because they enable the creation of lambda expressions, which provide a concise and flexible way to express behavior. Lambda expressions are particularly useful for functional programming, which involves treating functions as first-class citizens and using them to compose behavior.

Lambda expressions are different from functional interfaces because they are expressions that evaluate to a function. A lambda expression can be used to create an instance of a functional interface by providing an implementation for its single abstract method.

Here's an example of a lambda expression that implements the MyFunctionalInterface interface:

```java
MyFunctionalInterface myLambda = () -> System.out.println("Hello, world!");
```

## **List down all the main or important built-in functional interfaces in java**

Certainly! Here is a list of some main or important built-in functional interfaces in Java from the `java.util.function` package:

1. `Predicate<T>`: Represents a predicate (boolean-valued function) that takes an argument of type `T` and returns a boolean result.

2. `Function<T, R>`: Represents a function that takes an argument of type `T` and produces a result of type `R`.

3. `Consumer<T>`: Represents an operation that takes an argument of type `T` and returns no result (void).

4. `Supplier<T>`: Represents a supplier of results of type `T`. It has no input arguments and provides a value when invoked.

5. `UnaryOperator<T>`: Represents an operation on a single operand of type `T` that produces a result of the same type `T`.

6. `BinaryOperator<T>`: Represents an operation on two operands of type `T` that produces a result of type `T`.

7. `BiPredicate<T, U>`: Represents a predicate (boolean-valued function) that takes two arguments of types `T` and `U` and returns a boolean result.

8. `BiFunction<T, U, R>`: Represents a function that takes two arguments of types `T` and `U` and produces a result of type `R`.

9. `BiConsumer<T, U>`: Represents an operation that takes two arguments of types `T` and `U` and returns no result (void).

10. `Supplier<T>`: Represents a supplier of results of type `T`. It has no input arguments and provides a value when invoked.

These functional interfaces cover a wide range of use cases in functional programming and provide a foundation for working with lambda expressions and method references in Java.

It's worth noting that the `java.util.function` package also provides additional specialized functional interfaces for specific primitive types (`int`, `long`, `double`) and corresponding functional interfaces with "To" prefix for conversion operations. These specialized interfaces include `IntPredicate`, `IntFunction`, `IntConsumer`, `IntSupplier`, `IntUnaryOperator`, `IntBinaryOperator`, and similar ones for `long` and `double` types.

These functional interfaces, along with the general ones mentioned above, form the core set of building blocks for functional programming in Java.

---
  
## **65. I am a beginner in lambda expressions, teach me from basics on about lambda expressions, its used, advantages and drawbacks**

Sure! Lambda expressions are a powerful feature introduced in Java 8 that allow you to write concise and functional code. In this answer, I will explain what lambda expressions are, how they are used, and their advantages and drawbacks.
What are Lambda Expressions?

Lambda expressions are a way to represent a block of code as a function. In other words, they allow you to treat a block of code as an object that can be passed around and executed later. A lambda expression consists of a list of parameters, a "->" symbol, and a body, as shown in the following example:

```java
(parameter1, parameter2) -> { /* code block */ }
```

  The parameters are optional and the body can be a single expression or a block of code.

Here's an example of a lambda expression that takes two integers and returns their sum:

```java
(int a, int b) -> { return a + b; }
```
  
This lambda expression takes two integer parameters (a and b) and returns their sum.
How are Lambda Expressions Used?

Lambda expressions are used in Java to provide a concise and functional way to express behavior. They are particularly useful for functional programming, which involves treating functions as first-class citizens and using them to compose behavior.

Lambda expressions are often used in conjunction with functional interfaces. A functional interface is an interface that contains a single abstract method. Lambda expressions can be used to implement the single abstract method of a functional interface, which can then be used as an object that represents behavior.

Here's an example of a functional interface that represents a predicate:

java

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

This interface contains a single abstract method called test(), which takes a generic parameter T and returns a boolean. A lambda expression can be used to implement this interface as follows:

rust

Predicate<String> p = s -> s.startsWith("a");

This lambda expression implements the test() method of the Predicate interface by checking if a string starts with the letter "a". The lambda expression can be assigned to a variable of type Predicate<String>, which can then be used to test strings.
Advantages of Lambda Expressions

Lambda expressions provide several advantages over traditional Java programming:

    Concise syntax: Lambda expressions allow you to write code in a more concise and readable way. This can lead to better code maintainability and understanding.

    Functional programming: Lambda expressions enable functional programming, which involves treating functions as first-class citizens and using them to compose behavior. This can lead to more modular and reusable code.

    Parallel programming: Lambda expressions can be used in conjunction with parallel streams to process large amounts of data in parallel. This can lead to faster processing times and better performance.

Drawbacks of Lambda Expressions

Lambda expressions also have some drawbacks:

    Learning curve: Lambda expressions are a new feature in Java 8, so they may take some time to learn and understand.

    Overuse: Lambda expressions can be overused, leading to less readable and maintainable code. It's important to use them judiciously and only where they provide a clear advantage.

    Performance: Lambda expressions may have a slight performance overhead compared to traditional Java programming. However, this is usually negligible in practice.

In summary, lambda expressions are a powerful feature introduced in Java 8 that provide a concise and functional way to express behavior. They are particularly useful for functional programming, parallel programming, and improving code maintainability and understanding. However, they also have some drawbacks, such as a learning curve and the potential for overuse.


---

## **66. Define streams in java, state its needs, uses, advantages and drawbacks**

In Java, a stream is a sequence of elements that can be processed in a pipeline-like manner. Streams are introduced in Java 8 as a way to simplify and improve the processing of collections of data. In this answer, I will explain what streams are, their uses, advantages, and drawbacks.
What are Streams in Java?

In Java, a stream is a sequence of elements that can be processed in a pipeline-like manner. Streams provide a way to process collections of data in a functional and declarative way, without having to write loops and conditional statements.

Streams can be created from a variety of sources, including arrays, lists, and other collections. Once a stream is created, it can be processed in a series of operations, such as filtering, mapping, and reducing.

Here's an example of creating a stream of integers and processing it to get the sum of all the even numbers:

java

int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .sum();

In this example, we create a stream of integers from an array, filter out the odd numbers, and then sum the remaining even numbers.
What are the Needs and Uses of Streams?

Streams are designed to simplify the processing of collections of data. They provide a way to write more concise and declarative code that is easier to read and understand.

Streams are particularly useful in functional programming, where they can be used to compose functions that perform complex operations on collections of data. They can also be used in parallel processing, where they can take advantage of multiple cores to process data more quickly.

Here are some examples of the uses of streams:

    Filtering: Streams can be used to filter data based on a condition. For example, you can use a stream to filter out all the elements that don't meet a certain criteria.

    Mapping: Streams can be used to transform data from one form to another. For example, you can use a stream to transform a list of strings into a list of integers.

    Reducing: Streams can be used to perform operations on a collection of data and return a single result. For example, you can use a stream to calculate the sum of all the elements in a list.

What are the Advantages of Streams?

Streams provide several advantages over traditional Java programming:

    Concise and declarative: Streams allow you to write code in a more concise and declarative way. This can lead to better code maintainability and understanding.

    Composable: Streams are composable, meaning that you can chain multiple operations together to create complex data processing pipelines.

    Parallel processing: Streams can be processed in parallel, allowing for faster processing times and better performance on multi-core systems.

What are the Drawbacks of Streams?

Streams also have some drawbacks:

    Learning curve: Streams are a new feature in Java 8, so they may take some time to learn and understand.

    Performance overhead: Streams may have a slight performance overhead compared to traditional Java programming. However, this is usually negligible in practice.

    Not suitable for all scenarios: Streams may not be suitable for all scenarios, such as cases where you need low-level control over memory management or performance.

In summary, streams are a powerful feature introduced in Java 8 that provide a way to process collections of data in a functional and declarative way. They are particularly useful for simplifying data processing and improving code maintainability and understanding. However, they also have some drawbacks, such as a learning curve and performance overhead.

--- 

## **67. How does this gives output as true even if it is comparing the adreesses of the two objects?**

Integer a = 100, b = 100;
System.out.println(a == b); 

In Java, the range of values for the type `int` is from -2,147,483,648 to 2,147,483,647. However, Java provides a special case for `int` values between -128 and 127, where these values are cached and reused when they are autoboxed. This is known as "integer caching" or "integer pooling".

When you create two `Integer` objects with the same value between -128 and 127, Java will reuse the same object, rather than creating a new one. In this case, both `a` and `b` are assigned the value of 100, which is within the range of cached `Integer` objects. Therefore, both `a` and `b` point to the same `Integer` object in memory, and the `==` operator compares the memory addresses of these two objects, which are the same.

If you try to compare two `Integer` objects with values outside of the cached range, such as `a = 200` and `b = 200`, then the `==` operator will return `false`, because Java will create separate `Integer` objects for each value.

---

## **68. Why the range -128 to 127 only?**

The range -128 to 127 is used for integer caching in Java because it covers the range of values that are most commonly used in typical programs. 

In many programs, integer values within this range are used frequently and repeatedly, for example, in loops or for indexing arrays. By caching these values, Java can avoid the overhead of creating new `Integer` objects for each occurrence of these values, and instead reuse the same objects, leading to improved performance and reduced memory usage.

However, caching a larger range of values would require more memory, and caching smaller ranges might not be as useful since fewer values would be cached. Therefore, the range of -128 to 127 is a good balance between practical usefulness and memory usage.
  
  
  ---
  
  ## **69. Difference betweeen sleep and wait in Java**
  
In Java, both `sleep()` and `wait()` methods are used to pause the execution of a thread. However, they are used in different contexts and have different behaviors.

The `sleep()` method is used to pause the execution of a thread for a specific amount of time. It takes an argument in milliseconds that specifies the amount of time the thread should sleep. During this time, the thread remains in the same state and does not release any locks or resources it may hold.

For example, the following code will pause the execution of the current thread for 1 second:

```java
try {
    Thread.sleep(1000); // sleep for 1 second
} catch (InterruptedException e) {
    // handle exception
}
```

On the other hand, the `wait()` method is used to pause the execution of a thread until another thread notifies it to wake up. This method is typically used in a multi-threaded environment where one thread is waiting for another thread to perform some action before continuing its execution. When a thread calls `wait()`, it releases any locks or resources it may hold and enters a waiting state.

For example, consider the following code where one thread waits for another thread to update a shared variable:

```java
synchronized (sharedObject) {
    while (sharedVariable < someValue) {
        try {
            sharedObject.wait(); // wait for notification from another thread
        } catch (InterruptedException e) {
            // handle exception
        }
    }
}
```

In this example, the thread enters a waiting state using `wait()` and waits for another thread to call `notify()` or `notifyAll()` on the same shared object. When the other thread calls `notify()`, the waiting thread wakes up and resumes its execution.

In summary, the `sleep()` method is used to pause the execution of a thread for a specific amount of time, while the `wait()` method is used to pause the execution of a thread until it receives a notification from another thread.
                                   
                                      
---

## **70. HashCode and equals contract**
                                      
- In Java, the `hashCode()` and `equals()` methods are used to compare objects for equality. The `equals()` method is used to compare the content of two objects, while the `hashCode()` method is used to generate a unique hash code for each object. 

The `hashCode()` method generates a hash code based on the contents of the object. Two objects with the same content should have the same hash code. However, it is possible for two objects with different contents to have the same hash code. Therefore, the `hashCode()` method should be implemented carefully to avoid hash collisions as much as possible.

The `equals()` method is used to compare the content of two objects. It returns `true` if the content of the two objects is the same, and `false` otherwise. The `equals()` method should be implemented to follow the following contract:

1. Reflexive: An object must be equal to itself. That is, `x.equals(x)` should return `true`.
2. Symmetric: If `x.equals(y)` returns `true`, then `y.equals(x)` should also return `true`.
3. Transitive: If `x.equals(y)` returns `true` and `y.equals(z)` returns `true`, then `x.equals(z)` should also return `true`.
4. Consistent: If the content of an object doesn't change, then `x.equals(y)` should consistently return the same result.
5. Null check: `x.equals(null)` should return `false`.

It is important to note that when the `equals()` method is overridden, the `hashCode()` method must also be implemented to follow the following contract:

1. Consistent: If the content of an object doesn't change, then `x.hashCode()` should consistently return the same hash code.
2. If `x.equals(y)` returns `true`, then `x.hashCode()` and `y.hashCode()` must return the same hash code.
3. It is not required that if `x.hashCode()` and `y.hashCode()` return the same hash code, then `x.equals(y)` must return `true`. However, it is desirable to minimize the number of hash collisions by generating different hash codes for different objects as much as possible.

By following these contracts, we ensure that the `equals()` and `hashCode()` methods work correctly together and are consistent with each other. This is important when working with collections such as `HashMap` and `HashSet`, which rely on the correct implementation of these methods for efficient and correct operation.

--- 
                                      
## 71. Singleton class and its example

In Java, a Singleton class is a class that can have only one instance at a time, and provides a global point of access to that instance. The Singleton pattern is used to ensure that a class has only one instance, and to provide a way to access that instance from anywhere in the application.

To implement a Singleton class in Java, we can follow the following steps:

1. Make the constructor of the class private so that it cannot be instantiated from outside the class.
2. Create a private static instance variable of the class within the class itself.
3. Create a public static method to access the single instance of the class. This method should check if the instance has already been created, and if not, it should create a new instance.

Here is an example implementation of a Singleton class in Java:

```java
public class MySingleton {
    private static MySingleton instance = null;
    
    private MySingleton() {
        // private constructor to prevent instantiation from outside the class
    }
    
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
    
    // other methods and variables of the class...
}
```

In this example, the `MySingleton` class has a private constructor to prevent instantiation from outside the class, and a private static instance variable `instance` of the same class. The `getInstance()` method is used to get the single instance of the class. If the `instance` variable is null, it creates a new instance of the `MySingleton` class, and then returns the `instance`.

Using this Singleton class, we can get the single instance of the class from anywhere in the application by calling `MySingleton.getInstance()`. The first time this method is called, a new instance of the `MySingleton` class is created, and subsequent calls to this method return the same instance.
                                      
---                                      
                                      
## 72. How to create a custom immutable class

- To create a custom immutable class in Java, we need to follow the following steps:

1. Make the class `final` so that it cannot be subclassed.
2. Make all the fields of the class `private` and `final`, so that they cannot be modified after initialization.
3. Provide a constructor that initializes all the fields of the class, and does not provide any setters or mutable methods.
4. If any of the fields are mutable objects, make sure to return a copy of the object instead of the original reference in the constructor and any accessor methods, to ensure that the object cannot be modified from outside the class.

Here's an example of an immutable class in Java:

```java
public final class Person {
    private final String name;
    private final Date birthDate;
    private final List<String> hobbies;

    public Person(String name, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.birthDate = new Date(birthDate.getTime()); // create a copy of the Date object
        this.hobbies = new ArrayList<>(hobbies); // create a copy of the List object
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime()); // return a copy of the Date object
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies); // return a copy of the List object
    }
}
```

In this example, the `Person` class is `final`, and has three `private` and `final` fields: `name`, `birthDate`, and `hobbies`. The constructor initializes all the fields, and creates a copy of the `Date` and `List` objects passed in as parameters to ensure that they cannot be modified from outside the class. There are no setters or mutable methods in the class. The accessor methods return copies of the `Date` and `List` objects to ensure that they cannot be modified from outside the class.

By following these steps, we have created an immutable class that cannot be modified once it is initialized, ensuring that the state of the object remains constant throughout its lifetime. This makes the class thread-safe, and can be used safely in multi-threaded environments without worrying about concurrent modifications to the object.                                      

---

##73. What's wrong with below code? will it compile/run?

```java

try{some statements}
catch(Exception e){}
catch(Custom exception){}
```

- The code you provided will not compile. In Java, when you have multiple catch blocks, they must be ordered from most specific to most general.
- In Java, you can have multiple catch blocks for different exception types, but they must be ordered from most specific to most general. The reason for this is that once an exception is caught by a specific catch block, subsequent catch blocks are not executed. If you place a more general catch block before a specific one, the specific exception will never be caught because the more general catch block will handle it first.
- The error message would likely indicate something like "exception SpecificException has already been caught."

---

## 74. Difference between Exception and Error?

In Java, both `Exception` and `Error` are subclasses of the `Throwable` class and represent exceptional conditions that can occur during the execution of a program. However, they serve different purposes and are intended to handle different types of situations.

1. **Exception:**
   - `Exception` class is used to represent exceptional conditions that can be handled and recovered from within the program.
   - Exceptions are typically caused by the application's code or external factors like user input or network issues.
   - They can be caught and handled using `try-catch` blocks to prevent the program from crashing and to take appropriate actions.
   - Examples of exceptions include `NullPointerException`, `IOException`, `NumberFormatException`, etc.

2. **Error:**
   - `Error` class represents exceptional conditions that usually cannot be recovered from by the application itself.
   - Errors are often caused by external factors or internal system issues that are beyond the control of the application code.
   - They are usually serious and indicate problems that might be impossible to handle programmatically, like out-of-memory errors (`OutOfMemoryError`) or stack overflow errors (`StackOverflowError`).
   - It's generally not recommended to catch and handle errors in your application because they often signify fundamental problems in the runtime environment.

In summary, the key difference between `Exception` and `Error` lies in their intended handling and nature of the problem they represent. Exceptions are meant to be caught and handled by your application's code, while errors usually indicate serious issues in the runtime environment and are typically not handled by your application directly.

---

## 75. What is OutOfMemory Exception? Can we handle it?

`OutOfMemoryError` is a type of `Error` in Java that occurs when the Java Virtual Machine (JVM) runs out of memory to allocate for new objects and classes. This usually happens when an application consumes too much memory or when there's a memory leak.

There are different types of `OutOfMemoryError` based on the memory area that is exhausted:

1. `java.lang.OutOfMemoryError`: This is a general `OutOfMemoryError` that occurs when the overall heap memory is exhausted.

2. `java.lang.OutOfMemoryError: Java heap space`: This specifically indicates that the Java heap (where objects are stored) is full.

3. `java.lang.OutOfMemoryError: PermGen space` (prior to Java 8): This occurred when the permanent generation space (used to store class metadata, among other things) was exhausted. In Java 8 and later, PermGen space was replaced by the Metaspace, and this specific error is not applicable.

4. `java.lang.OutOfMemoryError: GC overhead limit exceeded`: This error occurs when the Garbage Collector is spending too much time collecting garbage with very little memory being freed.

Handling an `OutOfMemoryError` is generally not recommended. It often indicates a fundamental issue with memory management or application design that should be addressed rather than trying to recover from the error itself.

However, in some cases, you might be able to handle it by:

1. **Optimizing Memory Usage:** Review your application's memory usage and identify areas where you can reduce memory consumption. Make sure you're not holding onto references that are no longer needed (potential memory leaks).

2. **Adjusting JVM Memory Settings:** You can try to allocate more memory to your JVM by adjusting the `-Xmx` (maximum heap size) and `-Xms` (initial heap size) command-line options. However, this is a temporary solution and might not work in extreme cases.

3. **Using Profiling Tools:** Profiling tools can help you identify memory leaks and optimize memory usage in your application.

4. **Refactor Code:** In some cases, inefficient algorithms or design patterns can cause excessive memory usage. Refactoring the code can help alleviate this issue.

In any case, it's important to thoroughly investigate and address the root causes of an `OutOfMemoryError` rather than simply attempting to catch and handle it in your code.

---

## 76. Does try and finally work without catch block?

Yes, you can use a `try` block with a `finally` block without including a `catch` block. The `finally` block is designed to execute code that should run regardless of whether an exception occurred or not, whether you have a `catch` block or not.

Here's an example of using a `try` block with just a `finally` block:

```java
try {
    // Code that might throw an exception
    int result = 10 / 2; // No exception will be thrown
} finally {
    // Code that will be executed regardless of whether an exception occurred or not
    System.out.println("This is the finally block.");
}
```

In this example, there's no `catch` block because the division operation won't throw an exception. The `finally` block will still execute after the `try` block completes.

However, note that if an exception occurs within the `try` block and there's no corresponding `catch` block to handle it, the exception won't be caught and the program will terminate abruptly. This is generally not recommended because it doesn't handle exceptions and might lead to unexpected behavior.

In most cases, it's best practice to include a `catch` block if you're using a `try` block. The `finally` block can be used to ensure cleanup or other necessary actions regardless of whether an exception occurred or not.

---

## 77. What is the difference between final, finalize, finally keywords in Java?

In Java, `final`, `finalize`, and `finally` are three distinct keywords with different purposes:

1. **`final`:**
   - The `final` keyword is used to declare a variable, method, or class as "unchangeable" or "immutable".
   - When applied to a variable, it indicates that the variable's value cannot be modified after its initial assignment.
   - When applied to a method, it indicates that the method cannot be overridden by subclasses.
   - When applied to a class, it indicates that the class cannot be extended (subclassed).

2. **`finalize`:**
   - The `finalize` keyword is not a keyword in the same sense as `final` and `finally`. Instead, it's a method defined in the `java.lang.Object` class.
   - The `finalize` method is called by the garbage collector before reclaiming the memory occupied by an object.
   - You can override the `finalize` method in your own classes to provide cleanup operations before an object is garbage collected. However, it's generally recommended to use explicit resource management and not rely on the `finalize` method for cleanup.

3. **`finally`:**
   - The `finally` keyword is used in exception handling to define a block of code that will be executed regardless of whether an exception is thrown or not.
   - It's typically used with a `try` block and an optional `catch` block.
   - The code in the `finally` block will be executed after the `try` block completes, whether an exception occurred or not.
   - This is useful for performing cleanup operations or releasing resources that need to be done regardless of exception scenarios.

Here's a simple example illustrating the differences:

```java
public class KeywordExamples {
    public static void main(String[] args) {
        // 'final' keyword example
        final int x = 10; // x cannot be changed after initialization

        // 'finally' keyword example
        try {
            // Some code that might throw an exception
        } catch (Exception e) {
            // Handle the exception
        } finally {
            // This block will execute regardless of exception occurrence
        }
    }

    @Override
    protected void finalize() throws Throwable {
        // This method is called before an object is garbage collected
        // Use explicit resource management instead of relying on finalize
    }
}
```

To summarize:
- `final`: Used for making variables, methods, and classes unchangeable or immutable.
- `finalize`: A method defined in `java.lang.Object` for pre-garbage collection cleanup.
- `finally`: Used in exception handling to define code that executes regardless of exception occurrence.
 
---

## 78. What are the java 8 performance changes / actual performance improvement and not the features?

Java 8 introduced several performance improvements and optimizations, apart from its language features. These improvements were aimed at enhancing the overall performance and efficiency of Java applications. Here are some of the key performance-related changes in Java 8:

1. **Lambda Expression Performance:** While the introduction of lambda expressions and the Stream API was primarily a language feature, it had performance implications. Java 8 introduced optimizations to make lambda expressions more efficient, reducing the overhead associated with creating and using lambda functions.

2. **Nashorn JavaScript Engine:** Java 8 included the Nashorn JavaScript engine, which replaced the older Rhino engine. Nashorn provided better performance and improved JavaScript support by leveraging modern JavaScript engines, making it more suitable for embedding JavaScript in Java applications.

3. **Metaspace:** Java 8 introduced Metaspace to replace the Permanent Generation (PermGen) in the Java HotSpot VM. Metaspace is designed to be more efficient and scalable, addressing issues related to PermGen, such as out-of-memory errors and classloading performance problems.

4. **Garbage Collection (G1 Collector):** While the Garbage-First (G1) Garbage Collector was introduced in Java 7, Java 8 brought further refinements and improvements to G1. G1 is designed to provide better overall garbage collection performance and predictability, especially for large heaps.

5. **Parallel Array Sorting:** Java 8 introduced optimized parallel sorting algorithms for arrays and collections, improving sorting performance for large datasets. The `Arrays.parallelSort` and `Collections.sort` methods can automatically parallelize the sorting process when running on multi-core processors.

6. **Enhanced Performance Monitoring:** Java 8 improved monitoring and diagnostic capabilities through enhancements to the Java Mission Control (JMC) and Java Flight Recorder (JFR) tools. These tools allow developers to analyze and diagnose performance issues in real-time.

7. **JavaFX Performance:** JavaFX, included with Java 8, received various performance improvements, making it more responsive and efficient for building graphical user interfaces (GUIs).

8. **String Deduplication:** Java 8 introduced the `-XX:+UseStringDeduplication` JVM option to reduce memory consumption by deduplicating strings, especially in scenarios where string interning was causing excessive memory usage.

9. **Optimizations in Stream API:** The Stream API in Java 8 underwent performance optimizations to make stream operations more efficient. The introduction of a "pipeline" model helped improve performance by enabling lazy evaluation and reducing intermediate data copying.

10. **Optimized Libraries:** Java 8 included various optimizations in its standard libraries, making them more efficient and performant. For example, the `java.util.HashMap` and `java.util.ArrayList` classes saw performance improvements.

These performance changes and optimizations in Java 8 aimed to make Java applications more efficient, scalable, and responsive. Developers could take advantage of these enhancements to build applications that perform better, especially in multi-threaded and parallel processing scenarios.

---

## 79. What are the java 11 performance changes / actual performance improvement and not the features over java 8?

Java 11 introduced several performance improvements and optimizations compared to Java 8, with a focus on making Java applications more efficient and responsive. Here are some of the key performance-related changes in Java 11, emphasizing actual performance improvements over new features:

1. **Epsilon Garbage Collector:** Java 11 introduced the Epsilon garbage collector, which is a no-op garbage collector. It is designed for use in scenarios where memory management and garbage collection are not critical, and you want to minimize any impact on application performance. Epsilon helps in situations where you want to test or profile an application with minimal GC overhead.

2. **Local-Variable Syntax for Lambda Parameters:** While this is a language feature, it has performance implications for code readability. Java 11 allows the use of the `var` keyword in lambda parameter lists, making lambda expressions more concise and improving code readability.

3. **Z Garbage Collector (Experimental):** Although the Z Garbage Collector (ZGC) was introduced as experimental in Java 11, it became a production-ready feature in subsequent releases. ZGC is designed for low-latency and high-throughput garbage collection and can handle very large heaps with minimal impact on application pause times.

4. **Flight Recorder Enhancements:** Java Flight Recorder (JFR) received several enhancements in Java 11, making it a more powerful tool for performance monitoring and analysis. It provides low-overhead, detailed performance data, helping developers identify and optimize performance bottlenecks.

5. **G1 Garbage Collector Enhancements:** The G1 Garbage Collector, introduced earlier, received ongoing refinements and improvements in Java 11, making it more efficient and predictable for applications with large heaps.

6. **Performance Improvements in I/O Operations:** Java 11 introduced performance improvements in various I/O operations, including socket operations, file I/O, and network protocols. These enhancements help applications that rely heavily on I/O operations perform better.

7. **HTTP Client Improvements:** Java 11 included improvements to the `HttpClient` introduced in Java 9, making it more efficient for making HTTP requests and handling responses. These improvements can lead to better performance in applications that use HTTP.

8. **New `String` Methods:** While Java 11 introduced new methods to the `String` class as language features, they can have performance benefits in certain situations, such as the `isBlank()` method for checking if a string is empty or consists of whitespace.

9. **Optimizations in Core Libraries:** Java 11 includes various optimizations in its core libraries, making them more efficient and performant. These optimizations can positively impact the performance of applications using standard Java APIs.

10. **Enhancements in `java.util.stream`:** Java 11 introduced enhancements to the Stream API, improving its performance and usability in certain scenarios.

These performance changes and optimizations in Java 11 aimed to enhance the efficiency, scalability, and responsiveness of Java applications, particularly in scenarios involving garbage collection, I/O operations, and performance monitoring. Developers could leverage these improvements to build faster and more reliable Java applications.

--- 

## 80. What is the difference between java 8 and java 11? 

Java 11 brought several new features, enhancements, and changes compared to Java 8. While Java 8 was a significant release with the introduction of lambda expressions and the Stream API, Java 11 is part of Oracle's Long-Term Support (LTS) release cycle and includes various improvements and updates. Here are some of the key differences between Java 8 and Java 11:

1. **Language Features:**
   - **Java 8:** Introduced lambda expressions and the Stream API, enabling functional programming constructs in Java.
   - **Java 11:** Added several smaller language enhancements, such as the `var` keyword for local variable type inference, improvements to the `String` class, and better support for lambda parameters.

2. **Garbage Collectors:**
   - **Java 8:** Included the G1 Garbage Collector and introduced the concept of Metaspace to replace PermGen.
   - **Java 11:** Added the Epsilon Garbage Collector (for testing and profiling) and the Z Garbage Collector (experimental in Java 11 but became production-ready in later releases, designed for low-latency and high-throughput GC).

3. **New APIs and Libraries:**
   - **Java 8:** Introduced the `java.time` package for modern date and time handling, the `CompletableFuture` class for asynchronous programming, and the Nashorn JavaScript engine.
   - **Java 11:** Included enhancements to the `java.util.stream` API, the `HttpClient` for making HTTP requests, and the introduction of new APIs like `java.net.http` for HTTP/2 support and the `java.net.URI` class.

4. **Removal of Features:**
   - **Java 8:** Deprecated certain features, such as the `PermGen` space and the `Date` class's mutable methods.
   - **Java 11:** Removed some older, deprecated features, including the `java.applet` package and the `rmic` tool for generating stubs and skeletons for RMI.

5. **Improved Performance Monitoring:**
   - **Java 8:** Introduced Java Mission Control (JMC) and Java Flight Recorder (JFR) for performance monitoring and profiling.
   - **Java 11:** Enhanced JFR with additional features and optimizations for better performance analysis.

6. **API Enhancements:**
   - **Java 8:** Included enhancements to existing APIs and introduced the `java.util.function` package for functional interfaces.
   - **Java 11:** Made further improvements to APIs, added new methods to existing classes (e.g., `String` class), and introduced a new HTTP client API (`HttpClient`).

7. **Versioning and Release Schedule:**
   - **Java 8:** Released in March 2014 and marked as an LTS release, receiving updates and bug fixes until 2020.
   - **Java 11:** Released in September 2018 and is also an LTS release, providing long-term support and updates until at least 2026.

8. **License and Distribution:**
   - **Java 8:** Came with Oracle Binary Code License Agreement (BCLA) for Oracle JDK, and it marked the start of Oracle's new release cadence and support model.
   - **Java 11:** Adopted a new licensing model under Oracle's Binary Code License Agreement, which allowed free use for personal and development purposes but required a subscription for commercial use and support from Oracle.

9. **Modularization and Jigsaw:**
   - **Java 8:** Did not include the modularization feature introduced with Project Jigsaw (Java Platform Module System).
   - **Java 11:** Continued to evolve and refine the modularization introduced in Java 9, providing better support for building and using modular applications.

It's important to note that both Java 8 and Java 11 are LTS (Long-Term Support) releases, meaning they receive extended support and updates for an extended period. The choice between them depends on factors such as project requirements, compatibility, and support timelines. Developers often consider migrating from Java 8 to a later LTS release like Java 11 to benefit from newer features, enhancements, and long-term support.

---

## 81. I have a parent class with method m1, I have child class with overriden m1 method along with m2 method. I have created a parent class reference and object of child class in main method. I now try to call m2 method in child on that object, will this work in java?

In Java, when you create a reference of the parent class and assign it an object of the child class, you can only access the methods and fields that are defined in the parent class using that reference. If you try to call a method that is specific to the child class (like `m2()` in your case), the compiler will not allow it. This behavior is determined at compile-time and is known as **static (or compile-time) polymorphism**.

Here's an example to illustrate this:

```java
class Parent {
    public void m1() {
        System.out.println("Parent's m1 method");
    }
}

class Child extends Parent {
    @Override
    public void m1() {
        System.out.println("Child's m1 method");
    }
    
    public void m2() {
        System.out.println("Child's m2 method");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent parentRef = new Child(); // Parent class reference, Child class object
        
        parentRef.m1(); // Calls Child's overridden m1 method
        // parentRef.m2(); // This line would cause a compilation error
    }
}
```

In the given example, `parentRef.m1()` calls the overridden `m1` method from the `Child` class because the actual object type is `Child`. However, trying to call `parentRef.m2()` would result in a compilation error because the reference is of type `Parent`, and `m2()` is specific to the `Child` class.

If you want to call `m2()` on the object, you need to cast the reference back to the `Child` class:

```java
((Child) parentRef).m2(); // This would work
```

But remember, you should be careful when using type casting, as it can lead to `ClassCastException` at runtime if the actual object is not of the type you are casting to.
