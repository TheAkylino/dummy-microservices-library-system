INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1547-09-29','ESPAÑOLA','MIGUEL DE CERVANTES SAAVEDRA');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1927-03-06','COLOMBIANA','GABRIEL GARCÍA MÁRQUEZ');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1899-04-22','RUSA','VLADIMIR NABOKOV');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1564-04-23','BRITÁNICA','WILLIAM SHAKESPEARE');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1902-09-18','CHILENA','PABLO NERUDA');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1812-02-07','BRITÁNICA','CHARLES DICKENS');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1930-06-24','ARGENTINA','ERNESTO SÁBATO');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1844-10-15','ALEMANA','FRIEDRICH NIETZSCHE');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1917-08-25','PERUANA','JOSÉ MARÍA ARGUEDAS');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1954-01-18','CHILENA','ISABEL ALLENDE');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1809-02-12','ESTADOUNIDENSE','EDGAR ALLAN POE');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1896-12-09','ITALIANA','GIUSEPPE TOMASI DI LAMPEDUSA');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1888-09-26','BRASILEÑA','THOMAS MANN');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1915-10-13','BRASILEÑA','LISPECTOR CLARICE');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1865-12-30','BRITÁNICA','RUDYARD KIPLING');
INSERT INTO AUTOR (FECHA_NACIMIENTO,NACIONALIDAD,NOMBRE) VALUES ('1906-03-03','ITALIANA','CESARE PAVESE');

--INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES
--('Don Quijote de la Mancha, Parte 1', '9781234567890', '1605-01-16', 1, 'DISPONIBLE'),
--('Don Quijote de la Mancha, Parte 2', '9780987654321', '1615-11-05', 1, 'DISPONIBLE'),
--('La Galatea', '9782345678901', '1585-10-01', 1, 'PRESTADO'),
--('Los trabajos de Persiles y Sigismunda', '9783456789012', '1617-04-26', 1, 'DISPONIBLE'),
--('Novelas ejemplares', '9784567890123', '1613-09-20', 1, 'DISPONIBLE'),
--('La Numancia', '9785678901234', '1585-08-15', 1, 'DISPONIBLE'),
--('El trato de Argel', '9786789012345', '1582-06-10', 1, 'DISPONIBLE'),
--('La casa de los celos', '9787890123456', '1615-02-10', 1, 'DISPONIBLE');

-- Insertar libros de Miguel de Cervantes Saavedra (Autor ID 1)
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Don Quijote de la Mancha', '978-84-376-0494-7', '1605-01-16', 1, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('La Galatea', '978-84-376-0493-0', '1585-01-01', 1, 'PRESTADO');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Novelas ejemplares', '978-84-376-0491-6', '1613-01-01', 1, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Los trabajos de Persiles y Sigismunda', '978-84-376-0492-3', '1617-01-01', 1, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Viaje al Parnaso', '978-84-376-0495-4', '1614-01-01', 1, 'PRESTADO');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('El cerco de Numancia', '978-84-376-0496-1', '1585-01-01', 1, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('La casa de los celos', '978-84-376-0497-8', '1615-01-01', 1, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('La entretenida', '978-84-376-0498-5', '1615-01-01', 1, 'DISPONIBLE');

-- Insertar libros de Gabriel García Márquez (Autor ID 2)
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Cien años de soledad', '978-84-376-0499-2', '1967-05-30', 2, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('El amor en los tiempos del cólera', '978-84-376-0500-5', '1985-09-15', 2, 'PRESTADO');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('Crónica de una muerte anunciada', '978-84-376-0501-2', '1981-04-10', 2, 'DISPONIBLE');
INSERT INTO libro (titulo, isbn, fecha_publicacion, autor_id, estado) VALUES ('El otoño del patriarca', '978-84-376-0502-9', '1975-10-20', 2, 'DISPONIBLE');


INSERT INTO prestamo (libro_id, fecha_prestamo, fecha_devolucion, estado) VALUES (1, '2024-10-01', '2024-12-12','Activo');

