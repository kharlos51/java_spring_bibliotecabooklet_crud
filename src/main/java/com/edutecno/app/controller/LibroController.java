package com.edutecno.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.app.modelo.Libro;
import com.edutecno.app.service.LibroService;

@Controller
@RequestMapping(value="/libros")
public class LibroController {
	@Autowired
	LibroService libroService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/listaLibros", method = RequestMethod.GET)
	public String getAllLibros(ModelMap model) {
		model.put("listaLibro", libroService.getAllLibros().getLibros());
		return "listaLibro";
	}
	
	//solo para mostrar la pagina
	@RequestMapping(value = "/agregarLibro", method = RequestMethod.GET)
	public String agregarLibro(ModelMap model) {
		model.put("listaLibro", libroService.getAllLibros().getLibros());
		return "agregarLibro";
	}
	
	//para agregar el libro
	@RequestMapping(value = "/agregarLibro", method = RequestMethod.POST)
	public String addLibro(ModelMap model, @ModelAttribute("mensaje") Libro libro) {
		//siempre los ingresa como disponible
		libro.setDisponible(1);
		String resultado = libroService.addLibro(libro).getCodigo();
		model.put("resultado", resultado);
		return "agregarLibro";
	}
	
	//solo para mostrar la pagina de modificarlibro con sus datos segun el id que reciba
	@RequestMapping(value = "/modificarLibro", method = RequestMethod.GET)
	public String modificarLibro(ModelMap model, @RequestParam("libroId") int idLibro) {
		model.put("listaLibro", libroService.getLibroById(idLibro).getLibros());
		return "modificarLibro";
	}
	
	@RequestMapping(value = "/modificarLibro", method = RequestMethod.POST)
	public String updateLibro(ModelMap model, @ModelAttribute("mensaje") Libro libro, @RequestParam(value = "disponibleCheck", required = false) String disponible) {
		if(disponible != null) {
			libro.setDisponible(1);
		}
		else {
			libro.setDisponible(0);
		}
		String resultado = libroService.updateLibro(libro).getCodigo();
		model.put("resultado", resultado);
		return "modificarLibro";
	}
	
	@RequestMapping(value = "/modificarDisponibilidadLibro", method = RequestMethod.GET)
	public String updateDisponibilidadLibro(ModelMap model, @RequestParam("libroId") int idLibro) {
		String resultado = libroService.updateDisponibilidadLibro(idLibro).getCodigo();
		model.put("resultado", resultado);
		return getAllLibros(model);
	}
	
	//solo para mostrar la pagina de eliminarLibro con sus datos segun el id que reciba
	@RequestMapping(value = "/eliminarLibro", method = RequestMethod.GET)
	public String eliminarLibro(ModelMap model, @RequestParam("libroId") int idLibro) {
		model.put("listaLibro", libroService.getLibroById(idLibro).getLibros());
		return "eliminarLibro";
	}
	
	@RequestMapping(value = "/eliminarLibro", method = RequestMethod.POST)
	public String deleteLibro(ModelMap model, @ModelAttribute("mensaje") Libro libro) {
		String resultado = libroService.deleteLibro(libro).getCodigo();
		model.put("resultado", resultado);
		return "eliminarLibro";
	}
	
	@RequestMapping(value = "buscarLibros", method = RequestMethod.GET)
	public String buscarLibros(ModelMap model,@RequestParam("busqueda") String busqueda) {
		String resultado = libroService.getAllLibrosByTituloAndAutor(busqueda).getCodigo();
		if (resultado.equals("100")) {
			model.put("listaLibro", libroService.getAllLibrosByTituloAndAutor(busqueda).getLibros());
		}
		else {
			model.put("resultado", resultado);
		}
		return "listaLibro";
	}
	
	

}
