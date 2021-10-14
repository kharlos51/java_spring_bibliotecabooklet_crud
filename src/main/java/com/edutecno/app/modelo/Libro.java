package com.edutecno.app.modelo;

import lombok.Data;

@Data
public class Libro {
	private Integer idLibro;
	private String titulo;
	private Integer anio;
	private String autor;
	private String imprenta;
	private Integer disponible;
}
