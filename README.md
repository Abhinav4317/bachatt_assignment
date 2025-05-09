## Project Summary

I was able to implement the basic functionality as described in the problem statement and ensured all technical requirements were followed.

- The REST API works well and has been tested locally using Postman.
- Brownie point tasks are implemented. However, for fetching challans or insurance details, I couldn't find any real API or public database online.
- As a result, those features currently return a `503 Service Unavailable` error since they use placeholder/example URLs.

---

## Deployment:

I attempted to deploy the application using Docker on Railway under a free-tier plan.

- The Docker container builds and deploys successfully.
- However, POST requests to the deployed URL are being interpreted as GET requests for some reason.
- Since deployment was **not** explicitly required in the problem statement, I have decided to keep the focus on local functionality for now.

---

## Setting up DB to run locally:
The major dependencies used were:**Spring Web**,**Spring Data JPA**,**MySQL Driver**,**Spring Boot DevTools**,**Validation** and project was initialized using Spring Initializr.

To run the project locally, follow these steps to setup DB:

### 1. Create a MySQL Database
You can use MySQL Workbench or any MySQL client to create a database.

### 2. Configure `application.properties`

Navigate to `src/main/resources/application.properties` and set the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<DATABASE_NAME>
spring.datasource.username=<USERNAME>      # Usually 'root'
spring.datasource.password=<PASSWORD>      # Replace with your actual password
