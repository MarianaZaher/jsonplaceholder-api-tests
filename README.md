# jsonplaceholder-api-tests
# JSONPlaceholder Cucumber API Test 

This project performs functional API testing for the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) mock REST API using **Java**, **Cucumber**, **TestNG**, and **RestAssured** with **Object-Oriented Programming (OOP)** best practices.

---

## Test Scenarios

The following steps are implemented in the Cucumber feature file:

1. Retrieve a random user.
2. Print out the user's email address.
3. Get the user's posts and verify all returned Post IDs are between 1 and 100.
4. Create a new post using the same user ID with a non-empty title and body.
5. Verify that the correct response is returned.

---

## How to Run

### 1. Prerequisites

- Java 8 or higher
- Maven
- IDE like Visual Studio Code or IntelliJ IDEA

### 2. Open the Project

Open the extracted folder in your IDE or terminal:
```bash
cd jsonplaceholder-cucumber-api-test
mvn test



