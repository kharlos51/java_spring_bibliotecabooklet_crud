package com.edutecno.app.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.app.dao.LibroDAO;
import com.edutecno.app.modelo.Libro;
import com.edutecno.app.vo.LibroVO;

@Service
public class LibroServiceImpl implements LibroService{
private static final Logger log = LoggerFactory.getLogger(LibroVO.class);
	
	@Autowired
	LibroDAO libroDao;
	LibroVO respuesta;

	@Override
	public LibroVO addLibro(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			log.info("LibroService: addLibro");
			int registroIngresado = libroDao.addLibro(libro);
			respuesta.setMensaje(registroIngresado == 1 ? "Se ha creado el Libro correctamente"
					: "No se ha podido crear el Libro");
			respuesta.setCodigo(registroIngresado == 1 ? "100" : "101");
		} catch (Exception e) {
			log.error("LibroService: Error en addLibro " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO updateLibro(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			log.info("LibroService: updateLibro");
			int registrosActualizados = libroDao.updateLibro(libro);
			respuesta.setMensaje("Se ha actualizado correctamente " + registrosActualizados);
			respuesta.setCodigo("100");
		} catch (Exception e) {
			log.error("LibroService: Error en updateLibro " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO deleteLibro(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		try {
			log.info("LibroService: deleteLibro");
			int registroEliminado = libroDao.deleteLibro(libro);
			respuesta.setMensaje("Se ha eliminado correctamente " + registroEliminado);
			respuesta.setCodigo("100");
		} catch (Exception e) {
			log.error("LibroService: Error en deleteLibro " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO updateDisponibilidadLibro(int idLibro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");
		try {
			log.info("LibroService: updateDisponibilidadLibro");
			Libro libro = getLibroById(idLibro).getLibros().get(0);
			if (libro.getDisponible() == 1) {
				libro.setDisponible(0);
			}
			else {
				libro.setDisponible(1);
			}
			
			respuesta.setLibros(new ArrayList<Libro>(libroDao.updateDisponibilidadLibro(libro)));
			respuesta.setMensaje("Se ha actualizado correctamente la disponibilidad ");
			respuesta.setCodigo("100");
		} catch (Exception e) {
			log.error("LibroService: Error en updateDisponibilidadLibro " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO getAllLibros() {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			log.info("LibroService: getAllLibros");
			respuesta.setLibros(new ArrayList<Libro>(libroDao.getAllLibros()));
			respuesta.setMensaje("Se han encontrado " + respuesta.getLibros().size() + " Libros");
			respuesta.setCodigo("100");
		} catch (Exception e) {
			log.error("LibroService: Error en getAllLibros " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO getAllLibrosByTituloAndAutor(String busqueda) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106");
		try {
			log.info("LibroService: getAllLibrosByTituloAndAutor");
			respuesta.setLibros(new ArrayList<Libro>(libroDao.getAllLibrosByTituloAndAutor(busqueda)));
			
			if(respuesta.getLibros().size() > 0) {
				respuesta.setCodigo("100");
				respuesta.setMensaje("Se han encontrado " + respuesta.getLibros().size() + " Libros");
			}else {
				respuesta.setCodigo("106");
				respuesta.setMensaje("Se han encontrado " + respuesta.getLibros().size() + " Libros");
			}
			
			
		} catch (Exception e) {
			log.error("LibroService: Error en getAllLibrosByTituloAndAutor " + e);
		}
		return respuesta;
	}

	@Override
	public LibroVO getLibroById(int id) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107");
		try {
			log.info("LibroService: getLibroById");
			respuesta.setLibros(new ArrayList<Libro>(libroDao.getLibroById(id)));
			respuesta.setMensaje("Se han encontrado " + respuesta.getLibros().size() + " Libros");
			respuesta.setCodigo("100");
			
		} catch (Exception e) {
			log.error("LibroService: Error en getLibroById " + e);
		}
		return respuesta;
	}
}
