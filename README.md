
# Microservice Application with Spring Boot

This is a microservice-based application built using Spring Boot. The application demonstrates a distributed architecture with multiple services, including a service registry, configuration management, API gateway, and specific business services like Employee and Department services. It also performs data retrieval jobs and utilizes Zipkin for observability and monitoring.

## Overview

This application showcases a microservices architecture using various Spring Boot components to manage and communicate between distributed services. It provides a scalable solution for managing employee and department data within an organization.

## Architecture

The architecture of the application includes the following components:

1. **Service Registry (Eureka Server)**: Centralized service discovery and registration.
2. **Config Server**: Manages externalized configuration for all microservices.
3. **API Gateway**: Acts as a single entry point for client requests, routing them to the appropriate microservices.
4. **Employee Service**: Handles employee-related operations such as adding, updating, and retrieving employee data.
5. **Department Service**: Handles department-related operations such as adding, updating, and retrieving department data.
6. **Zipkin Server**: Provides distributed tracing to monitor service communication and latency.

## Technologies Used

- **Spring Boot**: Framework for building microservices.
- **Spring Cloud Netflix Eureka**: For service discovery and registration.
- **Spring Cloud Config**: For centralized configuration management.
- **Spring Cloud Gateway**: For API Gateway and routing.
- **Zipkin**: For distributed tracing.
- **Eureka server**: server for information about all client-service applications.

## Microservices Components

1. **Service Registry (Eureka Server)**
   - Manages service registration and discovery.
   
2. **Config Server**
   - Provides centralized configuration for all microservices.
   
3. **API Gateway**
   - Routes client requests to the appropriate backend services.
   
4. **Employee Service**
   - Manages CRUD operations for employee data.
   
5. **Department Service**
   - Manages CRUD operations for department data.
   
6. **Zipkin Server**
   - Collects tracing information to analyze request flows and detect performance bottlenecks.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
  
### Installation

1. Clone the repository:

   ```
   git clone <repository-url>
   cd <project-directory>
   ```

## Configuration

Ensure that the configuration files for all services are set up correctly in the configuration repository. The Config Server will read from this repository to provide configuration to each microservice.

Example configuration for the Employee Service (`application.yml`):

```yaml
  spring:
    application:
      name: employee-service
  
    config:
      import: "optional:configserver:http://localhost:{PORT}"
```

## Running the Application

1. Start the **Eureka Server** (Service Registry):

   ```
   cd service-registry
   mvn spring-boot:run
   ```

2. Start the **Config Server**:

   ```
   cd config-server
   mvn spring-boot:run
   ```

3. Start the **API Gateway**:

   ```
   cd Gateway
   mvn spring-boot:run
   ```

4. Start the **Employee Service**:

   ```
   cd employee-service
   mvn spring-boot:run
   ```

5. Start the **Department Service**:

   ```
   cd department-service
   mvn spring-boot:run
   ```

## Observability

- **Zipkin** is integrated into the microservices to provide distributed tracing capabilities.
- The Zipkin UI can be accessed at `http://localhost:9411` to visualize and troubleshoot service requests.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-branch-name`.
5. Submit a pull request.


Credit: https://www.youtube.com/watch?v=HFl2dzhVuUo
