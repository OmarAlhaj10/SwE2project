# Recruitment & Interview Manager Microservices System

This project is a microservices-based Recruitment & Interview Manager built with Spring Boot. It consists of the following components:

- **Job Service**: Manages job postings
- **Applicant Service**: Handles applicant data
- **Interview Service**: Manages interview scheduling and results
- **Eureka Server**: Service discovery
- **Spring Cloud Gateway**: API gateway and routing

Each service has its own package structure with controller, service, repository, and model layers, and connects to a shared MySQL database. Aspect Oriented Programming (AOP) is used for cross-cutting concerns like logging and security.

## Structure

- `/job-service`
- `/applicant-service`
- `/interview-service`
- `/eureka-server`
- `/gateway`

## Getting Started

1. Ensure MySQL is running and accessible.
2. Build each service using Maven or Gradle.
3. Start the Eureka Server, then the Gateway, then the microservices.

## Technologies
- Java 21
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- MySQL
- Maven
