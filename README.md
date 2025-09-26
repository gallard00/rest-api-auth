# 🚀 REST API Auth

API REST desarrollada con **Spring Boot, JWT y Docker**.  
Este proyecto tiene como objetivo simular un entorno profesional, implementando autenticación con JSON Web Tokens, persistencia con PostgreSQL y documentación con Swagger.

## 🛠️ Tecnologías utilizadas
- Java 17+
- Spring Boot 3
  - Spring Web
  - Spring Data JPA
  - Spring Security
- PostgreSQL
- JWT (Json Web Token)
- Docker & Docker Compose
- Lombok
- Swagger / OpenAPI

## 📦 Levantar el proyecto con Docker
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/gallard00/rest-api-auth.git
   cd rest-api-auth
Levantar la base de datos:

docker-compose up -d
Ejecutar la aplicación:

mvn spring-boot:run

La API quedará disponible en:
👉 http://localhost:8080

🔑 Endpoints principales (ejemplo inicial)
POST /auth/login → Autenticación, devuelve token JWT.

POST /auth/register → Registro de usuario.

GET /users → Lista de usuarios (requiere token).

GET /users/{id} → Detalle de usuario (requiere token).

📖 Documentación Swagger
Acceder a:
👉 http://localhost:8080/swagger-ui.html

🧑‍💻 Autor
Nahuel Gallardo

[LinkedIn](https://www.linkedin.com/in/nahuel-gallardo-28a471263?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app)
