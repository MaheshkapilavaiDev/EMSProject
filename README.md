 Employee Management System (Spring Boot + JWT)

Overview:

This project is a backend **Employee Management System** built using Spring Boot.
It supports authentication, role-based authorization, and employee operations.

---

## Features

*  JWT Authentication (Login/Register)
*  Role-based Access (ADMIN, USER)
*  Employee CRUD APIs
*  Analytics Dashboard (Admin only)
*  Secure password encryption using BCrypt


---

## Tech Stack

* Java 17+
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* H2 / MySQL Database
* Maven
* JUnit & Mockito

---

Authentication APIs

 ➤ Register User

`POST /auth/register`

```json
{
  "username": "user1",
  "password": "1234"
}
```

👉 Default role: USER

---

### ➤ Login

`POST /auth/login`

```json
{
  "username": "user1",
  "password": "1234"
}
```

👉 Returns JWT Token

---

## Employee APIs

post:/employees/add       |
getAll: /employees      
getbyid:/employees/{id} 
putbyid:/employees/{id} 
Deletenyid:/employees/{id}

 Analytics API

### ➤ Dashboard (Admin only)

`GET /analytics/dashboard`

Response:

```json
{
  "totalEmployees": 10,
  "employeesByDepartment": {
    "IT": 5,
    "HR": 3
  }
}

---

# Security

* JWT-based authentication
* Role-based authorization using `@PreAuthorize`
* Password encrypted using BCrypt

---

# How to Run

```bash
# Clone project
git clone <your-repo-url>

# Navigate
cd employee-management-system

# Run
mvn spring-boot:run

---

Project Structure

```
controller/
service/
repository/
entity/
security/
```

---

 Author

Mahesh Kapilavai

