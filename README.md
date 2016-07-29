This repository has several solutions to the common Java interview question: given a nested list
data structure, wrap it in an implementation of `Iterator` to present a flattened view.

# Try it out
Run:
```
./gradlew build
```
or on Windows:
```
gradlew.bat build
```

`FlattenerTest.java` shows how a hypothetical client could use the implementations. To try a
 different implementation, in the test class switch `Flattener1` for a different one.

# For the reader
Can you harden one or all of these implementations against `NullPointerException`s? Can you analyse
the runtime and memory performance (big O notation) of each?
