# 📘 API Gestión de Tareas - NUEVO SPA

## 🧾 Descripción

Esta es una API RESTful desarrollada en Java 17 con Spring Boot 3.3.x que permite la gestión de tareas por parte de usuarios autenticados mediante JWT. La API está documentada con Swagger (OpenAPI) y utiliza una base de datos H2 en memoria.

---

## ⚙️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.x
- Spring Security + JWT
- Spring Data JPA + H2
- OpenAPI + Swagger UI
- Maven

---

## 🚀 Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/josmejia2401/java-full-previred-chile.git
cd java-full-previred-chile
```

### 2. Compilar y ejecutar

```bash
./mvnw spring-boot:run
```

> Requiere Java 17 instalado.

### 3. Acceder a la documentación de la API

- 👉 Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui.html)
- 👉 OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🔐 Autenticación

- Usuario precargado:
   - **username:** `admin`
   - **password:** `password`

### Paso 1: Login

**POST** `/auth/login`  
Cuerpo:

```json
{
  "username": "admin",
  "password": "password"
}
```

**Respuesta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

> Usa este token como `Bearer Token` en las peticiones a endpoints protegidos.

---

## 👥 Gestión de Usuarios

Los endpoints de usuarios permiten a los administradores registrar, consultar, actualizar y eliminar usuarios en el sistema.

| Método | Endpoint        | Descripción                         |
|--------|-----------------|-------------------------------------|
| GET    | `/usuarios`     | Listar todos los usuarios           |
| GET    | `/usuarios/{id}`| Obtener un usuario por ID           |
| POST   | `/usuarios`     | Crear un nuevo usuario              |
| PUT    | `/usuarios/{id}`| Actualizar un usuario existente     |
| DELETE | `/usuarios/{id}`| Eliminar un usuario existente       |

> Todos los campos son validados y se maneja el error de integridad si ya existe un usuario con el mismo nombre de usuario (`username`).

---

## 📚 Endpoints principales

| Método | Endpoint           | Descripción                      |
|--------|--------------------|----------------------------------|
| POST   | `/auth/login`      | Genera el token JWT              |
| GET    | `/tareas`          | Lista las tareas del usuario     |
| POST   | `/tareas`          | Crea una nueva tarea             |
| PUT    | `/tareas/{id}`     | Actualiza una tarea existente    |
| DELETE | `/tareas/{id}`     | Elimina una tarea                |

---

## 🗃️ Base de datos

Al iniciar la aplicación se crean y cargan automáticamente las siguientes tablas:

### Tabla: `usuarios`

| ID | Username | Password (BCrypt) |
|----|----------|-------------------|
| 1  | admin    | password          |

### Tabla: `estados_tarea`

| ID | Nombre       |
|----|--------------|
| 1  | Pendiente    |
| 2  | En Progreso  |
| 3  | Completada   |

---

## 🔄 JSON de prueba para Postman

Archivo disponible en: `postman/Gestión de Tareas - NUEVO SPA.postman_collection.json`

Contiene:
- Login con credenciales válidas
- CRUD completo de tareas
- CRUD de usuarios

---

## 🧹 Buenas prácticas aplicadas

- Principios SOLID
- Separación de responsabilidades (DTO, entidad, repositorio, servicio, controlador)
- Uso de Streams y Lambdas de Java 17
- Validación con `@Valid` en DTOs
- Seguridad mediante filtros JWT
- Manejo de errores con excepciones personalizadas y `@ControllerAdvice`

---

## 👤 Autor

- Nombre: José Mejía
- Correo: josmejia.2401@gmail.com
- Cargo postulado: Desarrollador Java Backend