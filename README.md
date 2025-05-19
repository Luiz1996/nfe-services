# NF-e Services (DFE Exercise) [![Build and JaCoCo Coverage](https://github.com/Luiz1996/nfe-services/actions/workflows/build-and-coverage.yml/badge.svg)](https://github.com/Luiz1996/nfe-services/actions/workflows/build-and-coverage.yml)
This is the microservice for NF-e Upload.

### Main Technology Stack
* Java 21
* [SpringBoot 3.4.5](https://spring.io/projects/spring-boot)
* PostgreSQL
* Apache Kafka
* Flyway
* Docker
* Maven 3.9.1
* JUnit / Mockito
* JaCoCo
* OpenAPI UI
* K6 (performance tests)

## Running locally this application

You can then start a docker-compose by typing the command bellow:
```
docker-compose up -d
```

The command above will start a PostgreSQL, Kafka and Kafdrop containers.

The command below will clean and install dependencies:
```
mvn clean install
```
To run locally using any IDE, execute NfeServicesApplication class.

## Running locally this application using Docker

Execute the command below for generate .jar file:
```
mvn clean package -DskipTests
```

In the docker-compose.yml file, uncomment the block referring to nfe-services-app.

Then, build the docker image by running the command below:
```
docker build -t nfe-services:latest .
```

And finally, run:
```
docker-compose up -d
```

## K6 Execution
An NF-e Upload scenario was developed using the K6 tool.

The scenario itself aims to upload 250,000 NFes with 500 threads (virtual users - VUs) in a maximum time of 30 minutes.

To run it, make sure the application is running and follow the instructions below:

1) Enter the 'k6' directory
```
cd .\k6\
```

2) Run the command
```
k6 run --summary-trend-stats="avg,med,min,max,p(75),p(90),p(95),p(99)" .\scenarios\upload-nfe.js
```

3) Wait for the execution to finish and analyze the resulting metrics

#### Local Execution on 05-18-2025:

![upload-nfe.png](k6%2Fevidences%2FLOCAL%2F05-18-2025%2Fupload-nfe.png)

## JaCoCo Coverage
In this project the minimum coverage of unit tests is 95% and the report file can be found in the directory below:

```
/target/site/jacoco/index.html
```

## OpenAPI Documentation
The OpenAPI documentation can be viewed by opening the URL below after running the application:

```
http://localhost:8080/swagger-ui/index.html
```

# Design Decisions and Implementation Choices

This microservice was developed in Java 21 with Spring Boot 3.4.5, designed to process large 
volumes of NF-es with a focus on scalability, resilience and consistency. We use PostgreSQL as 
a relational database and Apache Kafka as a distributed messaging system.

PostgreSQL was chosen for its ability to handle structured data and ensure referential 
integrity, essential in real NF-e scenarios involving multiple related tables. The versioning 
and evolution of the database are controlled by Flyway, which brings predictability and 
security to the deployment.

In Kafka, we configured the nfe_upload topic with 24 partitions and a replication factor of 3, 
ensuring high availability and fault tolerance. The 24 configured consumer threads allow for 
high throughput and scalability. We implemented retries with exponential backoff and fallback to 
a Dead Letter Topic (DLT), which stores messages that fail after 5 retries, allowing auditing 
and reprocessing. Permanent errors, such as malformed XMLs or NPE exceptions, are quickly 
forwarded to the DLT via DefaultErrorHandler, avoiding rework and optimizing consumption.

To extract data from the NF-e XML, we use the JAXB (Jakarta XML Bind) library, which directly 
converts files to Java objects, simplifying the extraction and conversion of fields such as 
date (LocalDate) and value (BigDecimal).

We chose to keep the HTTP controller and the Kafka consumer in the same microservice to 
simplify the project and speed up development. In larger scenarios, separating them into 
distinct services can improve isolation and scalability.

The environment was fully dockerized, using docker-compose to orchestrate Kafka, PostgreSQL, 
Kafdrop (a tool for visualizing messages), and even the application itself, which allowed 
realistic simulations and stress tests with K6, ensuring development close to the production 
environment.

Others resources used:
* JUnit and Mockito (unit tests);
* JaCoCo (test coverage);
* OpenAPI UI (documentation of the endpoint(s));
* K6 (execution of performance tests).