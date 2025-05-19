# Security-Application

A Spring Boot application demonstrating advanced Spring Security features, including JWT authentication, OAuth2 login, session management, and role-based access control.

---

## Features

- **JWT Authentication**: Secure login and token-based authentication for REST APIs.
- **OAuth2 Login**: Social login support with OAuth2 providers.
- **Session Management**: Custom session limiting and refresh token handling.
- **Role-Based Access Control**: Restrict access to endpoints based on user roles (USER, ADMIN).
- **Secure Cookie Handling**: HttpOnly and Secure flags for refresh tokens.
- **Stateless APIs**: Session policy set to stateless for REST endpoints.

---

## Getting Started

### Prerequisites
- Java 17 or above
- Maven 3.6+

### Setup
1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd Security-Application
   ```
2. **Configure application properties:**
   - Edit `src/main/resources/application.properties` or `application.yml` for DB, JWT secret, and OAuth2 settings.
3. **Build the project:**
   ```sh
   ./mvnw clean install
   ```
4. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```

---

## API Endpoints

- `POST /auth/signup` &mdash; Register a new user
- `POST /auth/login` &mdash; Login and receive JWT tokens
- `POST /auth/refresh` &mdash; Refresh JWT access token
- `GET /posts` &mdash; Get all posts (secured)
- `GET /posts/{postId}` &mdash; Get a post by ID (secured, owner only)

> Additional endpoints may exist; refer to controller classes for details.

---

## Security Overview
- **JWT Filter**: Validates JWTs on each request, sets authentication context.
- **OAuth2 Success Handler**: Handles new users and token generation after OAuth2 login.
- **SessionService**: Limits concurrent sessions, manages refresh tokens.
- **WebSecurityConfig**: Configures public and secured routes, disables CSRF for APIs.

---

## Contributing
1. Fork the repo
2. Create your feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -am 'Add feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## License
This project is licensed under the MIT License.

---

## Author
- [Your Name](https://github.com/AnuragSh2003)

---

For any questions, please open an issue or contact the maintainer.
