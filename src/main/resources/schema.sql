-- Crear tabla 'usuarios'
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Crear tabla 'estados_tarea'
CREATE TABLE estados_tarea (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Crear tabla 'tareas'
CREATE TABLE tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado_id BIGINT,
    usuario_id BIGINT,
    FOREIGN KEY (estado_id) REFERENCES estados_tarea(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
