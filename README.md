# News and Media Backend API
The Spring Boot News API is a RESTful web service designed to manage and deliver news articles. 
This application is built using Spring Boot and incorporates JWT-based authentication, role-based access control, and BCrypt password hashing for security. 
It is ideal for news platforms that need to handle user authentication, news categorization, and article management securely.

## Features
- User Authentication & Authorization
     Secure user registration and login with JWT authentication.
     Role-based access control (Admin, Editor, User) using Spring Security.
     Passwords securely stored with BCryptPasswordEncoder.
  
- News Management
    CRUD operations for Articles, Categories, and Comments.
    Articles associated with categories and user-generated comments

- Error Handling
    Custom exception handling and validation for API requests.

## API Reference
- Authentication
  
  Register new user: POST /auth/register
  
  Authenticate user & get JWT token: POST /auth/login

- Articles
 
  Create an article: POST /articles
  
  Get all articles: GET /articles
  
  Get article by ID: GET /articles/{id}
  
  Update an article: PUT /articles/{id}
  
  Delete an article: DELETE /articles/{id}

- Categories

  Create category: POST /categories
  
  Get all categories: GET /categories
  
  Get category by ID: /categories/{id}

- Comments

  Add a comment: POST /articles/{id}/comments
  
  Get all comments for an article: GET /articles/{id}/comments

## Tech Stack
- Backend: Java, Spring Boot, Spring Security, JWT, Hibernate, PostgreSQL
- Build Tool: Gradle
- Database: PostgreSQL
- Security: JWT Authentication, BCrypt Password Hashing

## How to Run
1. Clone the Repository: git clone repo_url
2. Configure Database : application.properties with PostgreSQL details.
3. Build and Run the Application: ./gradlew clean build and ./gradlew bootRun
