# Student Management System

A REST API backend built with Java Spring Boot and PostgreSQL.

## Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- Spring Security (BCrypt)
- JPA 

## Features
- Add, view, update, and delete students
- User registration with email and password
- Password validation (min 8 chars, alphanumeric + special character)
- Password hashing using BCrypt
- Login with email and password

## API Endpoints

### Student APIs

-GET - /students (Get all students)
-GET - /students/{id} (Get student by ID)
-POST - /students  (Add new student)
-PUT - /students/{id} (Update student)
-DELETE - /students/{id} (Delete student)

### Auth APIs

-POST - /auth/register ( Register new user)
-POST - /auth/login  (Login)
-POST - /auth/change-password (Change password)

