# WordGuess

## Executable JAR

To generate an executable `jar`:

```
mvn clean install assembly:single
```

This will use the Maven JAR and Assembly plugins to generate a JAR with the necessary dependencies embedded and the correct `MANIFEST` file to be able to run it simply as a JAR.

## Running the JAR

```
java -jar target/word-guess-1.0-SNAPSHOT-jar-with-dependencies.jar
```
