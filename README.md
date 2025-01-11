# MyScalerProject

## Overview
MyScalerProject is a Spring Boot application that provides a RESTful API for managing products. It includes authentication and authorization mechanisms using JWT tokens.

## Technologies Used
- Java
- Spring Boot
- Spring Security
- Maven
- MySQL
- AWS RDS

## Prerequisites
- Java 11 or higher
- Maven
- MySQL database
- AWS RDS instance (optional)

## Setup Instructions

### Database Setup
1. Ensure that the `productservice` database exists on your MySQL or AWS RDS instance.
2. If the database does not exist, create it using the following SQL command:
    ```sql
    CREATE DATABASE productservice;
    ```

### Configuration
1. Update the `application.properties` file with your database and JWT issuer details:
    ```ini
    spring.datasource.url=jdbc:mysql://<your-database-url>:3306/productservice
    spring.datasource.username=<your-database-username>
    spring.datasource.password=<your-database-password>
    spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8283/.well-known/openid-configuration
    ```

### Build and Run
1. Navigate to the project directory.
2. Build the project using Maven:
    ```sh
    mvn clean install
    ```
3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### HelloController
- **GET /hello/say/{name}/{times}**: Returns a greeting message repeated a specified number of times.

### ProductController
- **GET /products**: Retrieves all products.
- **GET /products/{category}**: Retrieves products by category.
- **GET /products/{id}**: Retrieves a single product by ID.
- **POST /products**: Adds a new product.
- **PATCH /products/{id}**: Updates an existing product.
- **PUT /products/{id}**: Replaces an existing product.
- **DELETE /products/{id}**: Deletes a product by ID.

## Authentication
The application uses JWT tokens for authentication. Ensure that the `AuthenticationCommons` class is correctly configured to validate tokens against your authentication server.

## Logging
Logging is configured in the `application.properties` file:
```ini
logging.level.org.springframework.web=TRACE
logging.level.org.springframework.security.*=TRACE
logging.level.org.springframework.web.*=TRACE
```
