-- Usuarios precargados (contraseña codificada con BCrypt: "password")
INSERT INTO usuarios (id, username, password, email, role)
VALUES (1, 'admin', '$2a$12$FUKor6Qk4XXD7GP3uQCfSuRpH3Ee1qpdq4iqQbwEXQy754cZfpY/C', 'josmejia.2401@gmail.com', 'admin');

-- Estados precargados
INSERT INTO estados_tarea (nombre) VALUES
('Pendiente'),
('En Proceso'),
('Completada');
