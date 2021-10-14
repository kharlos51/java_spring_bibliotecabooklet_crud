package com.edutecno.app.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.app.modelo.Libro;
import com.edutecno.app.modelo.LibroMapper;

@Repository
public class LibroDAOImpl implements LibroDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LibroDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addLibro(Libro libro) {
		return jdbcTemplate.update("insert into libro values(sq_libro.nextval, ?, ?, ?, ?, ?)",
				libro.getTitulo(),
				libro.getAnio(),
				libro.getAutor(),
				libro.getImprenta(),
				libro.getDisponible());
	}

	@Override
	public int updateLibro(Libro libro) {
		return jdbcTemplate.update("update libro set titulo = ?, anio = ?, autor = ?, imprenta = ?, disponible = ? where id_libro = ?",
				libro.getTitulo(),
				libro.getAnio(),
				libro.getAutor(),
				libro.getImprenta(),
				libro.getDisponible(),
				libro.getIdLibro());
	}

	@Override
	public int deleteLibro(Libro libro) {
		return jdbcTemplate.update("delete from libro where id_libro = ?",
				libro.getIdLibro());
	}

	@Override
	public int updateDisponibilidadLibro(Libro libro) {
		return jdbcTemplate.update("update libro set disponible = ? where id_libro = ?",
				libro.getDisponible(),
				libro.getIdLibro());
	}

	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("select * from libro", new LibroMapper());
	}

	@Override
	public List<Libro> getAllLibrosByTituloAndAutor(String busqueda) {
		String like = "%".concat(busqueda.toLowerCase()) + "%";
		return jdbcTemplate.query("select * from libro where lower(titulo) like ? or lower(autor) like ?",
				new LibroMapper(), like, like);
	}

	@Override
	public List<Libro> getLibroById(int id) {
		return jdbcTemplate.query("select * from libro where id_libro = ?",new LibroMapper(), id);
	}

}