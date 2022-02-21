# File Upload Server

Created for CSE 5306 Distributed Systems at University of Texas at Arlington 

Server supports the follow operations:
- `/upload`
- `/download`
- `/delete`
- `/rename`

## Prerequisites
- Java 11
- nothing running on port 8080
- run the following commands in this folder

## Compiling
`./gradlew clean build`

## Compiling and Running the code
`./gradlew clean bootRun` 

## Running the code after Compiling it
```
./gradlew clean build
java -jar build/libs/data-upload-svc-0.0.1-SNAPSHOT.jar
```