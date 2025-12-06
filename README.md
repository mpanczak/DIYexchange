# DIYexchange

A social platform for DIY enthusiasts to share projects, ideas, and connect with like-minded creators.

## Overview

DIYexchange is a web application built with Spring Boot that allows users to:
- Create and share DIY project posts with images
- Comment on and like posts
- Follow other users
- Manage their profile and settings
- Receive notifications

## Technology Stack

- **Backend Framework**: Spring Boot 3.1.0
- **Java Version**: 17
- **Database**: MySQL 8.0
- **Security**: Spring Security
- **Templating Engine**: Thymeleaf
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok
  - Spring Data JPA
  - Spring Mail

## Prerequisites

Before running the application, ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0 or higher

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd DIYexchange
```

### 2. Database Configuration

1. Create a MySQL database (or let the application create it automatically):
   ```sql
   CREATE DATABASE diy_exchange;
   ```

2. Update the database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.url=jdbc:mysql://localhost:3306/diy_exchange?createDatabaseIfNotExist=true
   ```

### 3. Email Configuration (Optional)

If you want to use email functionality, update the mail settings in `application.properties`:
```properties
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
```

### 4. Build and Run

Using Maven Wrapper (recommended):
```bash
# Windows
mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

Or using Maven directly:
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## Project Structure

```
DIYexchange/
├── src/
│   ├── main/
│   │   ├── java/com/example/diyexchange/
│   │   │   ├── config/          # Configuration classes (Security, MVC, Async)
│   │   │   ├── controller/      # REST/Web controllers
│   │   │   ├── entity/          # JPA entities (User, Post, Comment, etc.)
│   │   │   ├── repository/      # Data access layer
│   │   │   ├── service/         # Business logic layer
│   │   │   └── DiYexchangeApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/          # CSS, JS, images
│   │       └── templates/       # Thymeleaf templates
│   └── test/                    # Test files
├── pom.xml                      # Maven dependencies
└── README.md
```

## Features

### User Management
- User registration and authentication
- User profiles with customizable settings
- Follow/unfollow functionality
- User roles and permissions

### Posts
- Create posts with title and content
- Upload multiple pictures per post
- Like posts
- View all posts on home feed
- View your own posts

### Comments
- Comment on posts
- View comments on posts

### Additional Features
- Email notifications
- Responsive UI with Bootstrap
- Error handling

## API Endpoints

### Public Endpoints
- `GET /` - Home page
- `GET /about` - About page
- `GET /contact` - Contact page
- `GET /register` - Registration page
- `GET /login` - Login page

### Authenticated Endpoints
- `GET /home` - User home feed
- `GET /post/{id}` - View post details
- `GET /post/create` - Create new post
- `GET /my-posts` - View user's posts
- `GET /profile/{username}` - User profile
- `GET /settings` - User settings
- `POST /upload` - Upload pictures

## Database Schema

The application uses JPA entities with the following main relationships:

- **User**: Has many posts, comments, follows/followers
- **Post**: Belongs to a user, has many pictures, comments, and likes
- **Comment**: Belongs to a user and a post
- **Picture**: Belongs to a post
- **Role**: Many-to-many relationship with users

## Development

### Running Tests

```bash
mvn test
```

### Building for Production

```bash
mvn clean package
```

The JAR file will be created in the `target/` directory.

## Configuration

Key configuration options in `application.properties`:

- `spring.jpa.hibernate.ddl-auto`: Set to `create` for development (drops and recreates schema)
- `spring.jpa.show-sql`: Enable SQL logging for debugging
- `spring.jpa.properties.hibernate.format_sql`: Format SQL output

**Note**: For production, change `ddl-auto` to `validate` or `none` and use proper database migrations.

## Security

The application uses Spring Security for:
- Password encryption
- Session management
- Role-based access control
- CSRF protection

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is open source and available under the MIT License.

## Contact

For questions or support, please contact: exchangediy24@gmail.com

