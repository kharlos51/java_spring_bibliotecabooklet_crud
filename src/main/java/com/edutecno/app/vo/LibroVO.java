package com.edutecno.app.vo;

import java.util.List;

import com.edutecno.app.modelo.Libro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroVO {
	List<Libro> libros;
	String mensaje;
	String codigo;
}
