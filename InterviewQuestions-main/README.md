# Some small/minor things about Java that may not be widely known by mid-senior Java developers:

1. The `switch` statement can also take a `String` argument in Java 7 and later versions.
2. You can use underscores in numeric literals to improve readability. For example, `int million = 1_000_000;`.
3. Java provides a `var` keyword for type inference in local variable declarations, starting from Java 10.
4. The `ThreadLocalRandom` class provides a fast and efficient way to generate random numbers in a multi-threaded environment.
5. The `Objects.requireNonNull` method can be used to check for null values in method parameters, and can throw a helpful `NullPointerException` message.
6. The `Map.computeIfAbsent` method can be used to add a new key-value pair to a map only if the key does not already exist.
7. The `BigDecimal` class should be used for precise decimal calculations, as `double` and `float` are subject to rounding errors.
8. Java 8 introduced the `Stream` API, which provides functional-style operations on collections and arrays, making it easier to process large amounts of data in parallel.
9. Java provides a `ClassLoader` hierarchy, which allows you to dynamically load and unload classes at runtime.
10. Java provides a mechanism for creating custom annotations, which can be used to add metadata to your code and provide a way for other tools to interact with it.
