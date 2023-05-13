-- ------------------------------------------------------------------------ --
-- Archivo: 01_DDL_PruebaCastores.sql										--
-- Version: 1.0                                                     		--
-- Autor:   Francisco Javier Rocha Aldana   								--
-- Email:   rochaaldanafcojavier@gmail.com									--
-- Fecha de elaboracion: 10-05-2023                                 		--
-- ------------------------------------------------------------------------ --

DROP DATABASE IF EXISTS francisco_rocha;

CREATE DATABASE francisco_rocha;

USE francisco_rocha;

CREATE TABLE personal(
	idPersonal			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    apellidoPaterno 	VARCHAR(45) NOT NULL,
    apellidoMaterno		VARCHAR(45) NOT NULL,
    nombre				VARCHAR(45) NOT NULL,
    direccion			VARCHAR(45) NOT NULL,
    fechaIngreso		DATE NOT NULL
);

INSERT INTO personal(apellidoPaterno, apellidoMaterno, nombre, direccion, fechaIngreso) VALUES("Rocha", "Aldana", "Francisco Javier", "Cromo 202", STR_TO_DATE("01/05/2023", '%d/%m/%Y'));

CREATE TABLE usuario(
	idUsuario			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario		VARCHAR(20) NOT NULL,
    contrasenia			VARCHAR(40) NOT NULL,
    correo				VARCHAR(45) NOT NULL,
    esInterno			VARCHAR(45) NOT NULL
);

INSERT INTO usuario(nombreUsuario, contrasenia, correo, esInterno) VALUES("Alda", "1234", "rochaaldanafcojavier@gmail.com", "Interno");
INSERT INTO usuario(nombreUsuario, contrasenia, correo, esInterno) VALUES("Juan", "5678", "juan@gmail.com", "Externo");

SELECT * FROM usuario WHERE nombreUsuario="Alda" AND contrasenia="1234";

CREATE TABLE noticia(
	idNoticia			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo				VARCHAR(45),
    contenido			VARCHAR(1000),
    fechaPublicacion	DATETIME,
    idPersonal			INT NOT NULL,
    CONSTRAINT noticia_idPersonal_fk FOREIGN KEY(idPersonal) REFERENCES personal(idPersonal)
);

INSERT INTO noticia(titulo, contenido, fechaPublicacion, idPersonal) VALUES("Titulo 1", "Esta es la primera noticia", STR_TO_DATE("11/05/2023", '%d/%m/%Y'), 1);

SELECT * FROM noticia n INNER JOIN personal p ON n.idPersonal=p.idPersonal;

CREATE TABLE comentario(
	idComentario		INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    texto				VARCHAR(1000) NOT NULL,
    fechayHora			DATETIME,
    idNoticia			INT NOT NULL,
    idUsuario			INT NOT NULL,
    CONSTRAINT comentario_idNoticia_fk FOREIGN KEY(idNoticia) REFERENCES noticia(idNoticia),
    CONSTRAINT comentario_idUsuario_fk FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario)
);

INSERT INTO comentario(texto, fechayHora, idNoticia, idUsuario) VALUES("Este es el primer comentario del primer titulo", STR_TO_DATE("11/05/2023", '%d/%m/%Y'), 1, 1);

SELECT * FROM comentario c INNER JOIN noticia n ON c.idNoticia=n.idNoticia INNER JOIN usuario u ON c.idUsuario=u.idUsuario;

CREATE TABLE respuesta(
	idRespuesta			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    texto				VARCHAR(1000) NOT NULL,
    fechayHora			DATETIME,
    idComentario		INT NOT NULL,
    idUsuario			INT NOT NULL,
    CONSTRAINT respuesta_idComentario_fk FOREIGN KEY(idComentario) REFERENCES comentario(idComentario),
    CONSTRAINT respuesta_idUsuario_fk FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario)
);

INSERT INTO respuesta(texto, fechayHora, idComentario, idUsuario) VALUES("Esta es la respuesta al comentario uno del titulo uno", STR_TO_DATE("11/05/2023", '%d/%m/%Y'), 1, 2);

SELECT r.* FROM respuesta r INNER JOIN comentario c ON r.idComentario=c.idComentario INNER JOIN usuario u ON r.idUsuario=u.idUsuario;
