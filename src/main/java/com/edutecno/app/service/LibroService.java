package com.edutecno.app.service;

import com.edutecno.app.modelo.Libro;
import com.edutecno.app.vo.LibroVO;

public interface LibroService {
	public LibroVO addLibro(Libro libro);
	public LibroVO updateLibro(Libro libro);
	public LibroVO deleteLibro(Libro libro);
	public LibroVO updateDisponibilidadLibro(int idLibro);
	
	public LibroVO getAllLibros();
	public LibroVO getAllLibrosByTituloAndAutor(String busqueda);
	public LibroVO getLibroById(int id);
}
