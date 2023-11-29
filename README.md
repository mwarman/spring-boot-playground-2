# Spring Boot Playground (2.x)

A Spring Boot playground project for Spring Boot 2.x

## How to use

### Prerequisites

This project requires Java 8 or later. It has been tested with Java 8 specifically to ensure compatibility, but should work with later versions.

### Run the application locally

Issue the following command in the project base directory to run the application locally.

```sh
./gradlew bootRun
```

The application starts, printing the log to the terminal console. The application may be accessed on base URL http://localhost:8080.

To stop the application, press `ctrl-C` (or `cmd-C` on a Mac).

### Package the application deployment

Issue the following command in the project base directory to package the application as an executable Jar.

```sh
./gradlew clean bootJar
```

The application is packaged as an executable Jar file, suitable for deployment to hosted environments. The Jar file is located in `./build/libs`, for example `./build/libs/demo-0.0.1-SNAPSHOT.jar`.

The Jar may be executed with a command like `java -jar demo-0.0.1-SNAPSHOT.jar`.

## See Also
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.17/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.17/gradle-plugin/reference/html/#build-image)
* [SpringDoc OpenAPI v1](https://springdoc.org/v1/)

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

