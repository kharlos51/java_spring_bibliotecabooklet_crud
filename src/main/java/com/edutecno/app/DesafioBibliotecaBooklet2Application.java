package com.edutecno.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class DesafioBibliotecaBooklet2Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DesafioBibliotecaBooklet2Application.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(DesafioBibliotecaBooklet2Application.class, args);
	}
	
	/*@Bean
	public CommandLineRunner prueba(LibroService libroService) {
	
		return(args)-> {
			Libro auxLibro;/* = new Libro();
			auxLibro.setTitulo("titulo de prueba 4 ");
			auxLibro.setAnio(1990);
			auxLibro.setAutor("Autor de prueba 4");
			auxLibro.setImprenta("imprenta de prueba 4");
			auxLibro.setDisponible(1);
			System.out.println(libroService.addLibro(auxLibro).getMensaje());
			
			auxLibro = libroService.getAllLibros().getLibros().get(0);
			
			//auxLibro.setDisponible(0);
			//System.out.println(libroService.updateLibro(auxLibro).getMensaje());
			//System.out.println(libroService.updateDisponibilidadLibro(auxLibro).getMensaje());
			
			//System.out.println(libroService.deleteLibro(auxLibro).getMensaje());
			
			for (Libro libro : libroService.getAllLibrosByTituloAndAutor("allende").getLibros()) {
				System.out.println(libro);
			}
		};
	}*/

}
