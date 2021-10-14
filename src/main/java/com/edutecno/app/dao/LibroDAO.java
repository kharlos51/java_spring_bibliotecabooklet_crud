package com.edutecno.app.dao;

import java.util.List;

import com.edutecno.app.modelo.Libro;

public interface LibroDAO {
	public int addLibro(Libro libro);
	public int updateLibro(Libro libro);
	public int deleteLibro(Libro libro);
	public int updateDisponibilidadLibro(Libro libro);
	
	public List<Libro> getAllLibros();
	public List<Libro> getAllLibrosByTituloAndAutor(String busqueda);
	public List<Libro> getLibroById(int id);
}
