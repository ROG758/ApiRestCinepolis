package com.mx.ApiRestCinepolis.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* CREATE TABLE PELICULAS(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(70) NOT NULL,
DURACION NUMBER NOT NULL,
FECHA_LANZ DATE NOT NULL
);*/

@Entity
@Table(name = "PELICULAS")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Peliculas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Integer idPelicula;

	@Column(name = "NOMBRE", columnDefinition = "VARCHAR2(70)", nullable = false)
	private String nombre;

	@Column(name = "DURACION", columnDefinition = "NUMBER", nullable = false)
	private Integer duracion;

	@Column(name = "FECHA_LANZ", columnDefinition = "DATE", nullable = false)
	private Date fechaLanz;
}
