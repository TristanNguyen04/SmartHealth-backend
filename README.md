# Smart Health - Backend

<div align="center">
  <div>
    <img src="https://img.shields.io/badge/-Spring Boot-black?style=for-the-badge&logoColor=white&logo=spring-boot&color=3CC10E" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/postgresql-4169e1?style=for-the-badge&logo=postgresql&logoColor=white" alt="postgreSQL" />
    <img src="https://img.shields.io/badge/AWS%20RDS-527FFF?style=for-the-badge&logo=Amazon%20RDS&logoColor=white" alt="AWS RDS" />
    <img src="https://img.shields.io/badge/AWS_S3-569A31?logo=amazons3&logoColor=fff&style=for-the-badge" alt="AWS S3" />
    <img src="https://img.shields.io/badge/docker-257bd6?style=for-the-badge&logo=docker&logoColor=white" alt="Docker" />
  </div>
  <p align="center">Self-hosted backend server for <a href=https://github.com/ItsMeOX/SmartHealth>Smart Health</a></p>
</div>

## Team 21

| Member                | Student Number |
|-----------------------|----------------|
| Nguyen Quoc Dung   	| 1008017        |
| Ong Xuan    		| 1008044        |
| Ng Zhao Hui 		| 1007803        |
| Le Viet Hai        	| 1008033        |
| Thng Aik Kiat  	| 1007781        |
| G K Dharesan       	| 1007885        |

This repository contains the backend server for the **SmartHealth** application, designed to help users track their health and wellness. It provides APIs for managing events, medicines, nutrient intake, user profiles, and much more. The backend is built using **Spring Boot** and is hosted on **Render**.

## Live Demo

The backend server is live and hosted on Render. You can access the API at:

[https://smarthealth-backend.onrender.com](https://smarthealth-backend.onrender.com)

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [API Documentation](#api-documentation)
- [Setup and Installation](#setup-and-installation)
- [Environment Variables](#environment-variables)
- [Usage](#usage)
- [Testing](#testing)
- [Acknowledgements](#acknowledgements)

## Features

- **User Management**: Allows users to register, update their profile, and authenticate (including via Google).
- **Event Management**: Users can create, update, view, and delete calendar events.
- **Medicine Management**: Manage medicines, their usage schedules, and stock.
- **Nutrient Intake Tracking**: Track daily nutrient intake and reset intakes.
- **Upcoming Schedule**: Set and view reminders for events, medicines, etc.
- **Google Authentication**: Secure login using Google account integration.

## Technologies Used

- **Spring Boot**: Framework for building the backend API.
- **Spring Data JPA**: Data access layer using JPA for interacting with the database.
- **Spring Security**: For user authentication and authorization.
- **AWS RDS (PostgreSQL)**: The database for storing user and health-related data.
- **Amazon S3**: For handling file uploads (e.g., profile pictures).
- **Render**: Cloud platform where the backend is hosted.

## API Documentation

This API provides several endpoints for interacting with the backend. Below are the main API categories and actions:

### Authentication

- **POST api/auth/login** - Authenticate user with email and password.
- **POST api/auth/register** - Register a new user.
- **POST api/auth/google** - Authenticate via Google.

### User Management

- **GET /users/{id}** - Get user details by user ID.
- **PUT /users/{id}** - Update user details.
- **PATCH /users/{id}/metrics** - Update user's metrics (i.e. height and weight)
- **PATCH /users/{id}/profile-picture** - Update user's profile picture (implemented with AWS S3 Bucket)
- **DELETE /users/{id}** - Delete a user.

### Events (Calendar)

- **POST /events/{userId}** - Create a new event for a specific user.
- **GET /events/{userId}** - Get all events for a specific user.
- **GET /events/{userId}/month/{year}/{month}** - Get a specific month's events for a specific user.
- **GET /events/{userId}/day/{year}/{month}/{day}** - Get a specific date's events for a specific user.
- **GET /events/{eventId}** - Get event details by event ID.
- **PUT /events/{eventId}** - Update an event.
- **DELETE /events/{eventId}** - Delete an event.

### Medicine

- **POST /medicines/{userId}** - Create a new medicine for a specific user.
- **GET /medicines/{userId}** - Get all medicines for a specific user.
- **GET /medicines/{id}** - Get medicine details by medicine ID.
- **PUT /medicines/{id}** - Update a medicine.
- **DELETE /medicines/{id}** - Delete a medicine.

### Nutrient Intake

- **POST /nutrient-intake/{userId}** - Add a new nutrient intake for a user.
- **GET /nutrient-intake/{userId}** - Get all nutrient intakes for a user on a specific date.
- **PUT /nutrient-intake/reset** - Reset all nutrient intake to 0 for a new coming day.

### Upcoming Schedule

- **POST /schedules/{userId}** - Create a new schedule (for food, medicines, etc.) for a specific user.
- **GET /schedules/{userId}/day/{year}/{month}/{day}** - Get schedules for a specific user on a given day.
- **PUT /schedules/take/{scheduleId}** - Mark a schedule as taken (for medicine intake).
- **DELETE /schedules/{scheduleId}** - Delete a schedule.

For more detailed API documentation, please refer to the Postman collection.

## Setup and Installation

To run this project locally, follow these steps:

### Prerequisites

- **Java 17** or higher
- **Maven** or **Gradle**
- **PostgreSQL Database** (or you can use another DB and adjust configuration)

### Steps

1. **Clone the repository**:

    ```bash
    git clone https://github.com/TristanNguyen04/SmartHealth-backend.git
    cd smarthealth-backend
    ```

2. **Set up your PostgreSQL database**:
   
   - Create a PostgreSQL database (or use another database of your choice).
   - Update your `application.properties` or `application.yml` to point to the correct database.

3. **Build the project**:

   Using Maven:

    ```bash
    mvn clean install
    ```

   Or using Gradle:

    ```bash
    ./gradlew build
    ```

4. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```
   Or using Gradle:
    ```bash
    ./gradlew bootRun
    ```

## Access the Server

The application will be running at `http://localhost:8080`. You can use tools like **Postman** to interact with the APIs.

---

## Environment Variables

The following environment variables should be configured for proper functioning of the application:

- `SPRING_DATASOURCE_URL`: JDBC URL for the PostgreSQL database.
- `SPRING_DATASOURCE_USERNAME`: Database username.
- `SPRING_DATASOURCE_PASSWORD`: Database password.
- `AWS_ACCESS_KEY`: Your AWS access key for S3.
- `AWS_SECRET_KEY`: Your AWS secret key for S3.
- `AWS_S3_BUCKET_NAME`: The S3 bucket name to store files.
- `JWT_SECRET_KEY`: Secret key for JWT tokens.

---

## Usage

The backend is designed for use with a frontend client or mobile app. You can use the API to manage users, events, medicines, and other features related to health tracking.

### Example

To register a new user:

- **POST** `api/auth/register`  
with a JSON payload containing the user’s information.

---

## Testing

### Running Unit Tests

You can run the tests for this project with Maven or Gradle:

**Maven:**

```bash
mvn test
```
**Gradle:**
```bash
./gradlew test
```
## Acknowledgements

This project serves as the backend server for the native Android application **Smart Health** — a project undertaken as part of **50.001 Information Systems and Programming (Spring 2025)** offered by the **Singapore University of Technology and Design (SUTD)**, in collaboration with **Singapore Telecommunications Limited (Singtel)**.
