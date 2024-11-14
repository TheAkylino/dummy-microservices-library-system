CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE
);

CREATE TABLE libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20),
    fecha_publicacion DATE,
    autor_id INT,
    estado VARCHAR(10),
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);

CREATE TABLE prestamo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    estado VARCHAR(10),
    FOREIGN KEY (libro_id) REFERENCES libro(id)
);
