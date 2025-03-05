package com.mx.ApiRestCinepolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PeliculasSerImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "PeliculasWebService")
@CrossOrigin

public class PeliculasWebService {

	@Autowired
	PeliculasSerImp impPeliculas;

	// http://localhost:9000/PeliculasWebService/listar
	@GetMapping(path = "listar")
	public List<Peliculas> listar() {
		return impPeliculas.listar();
	}

	// http://localhost:9000/PeliculasWebService/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {

		boolean repuesta = impPeliculas.guardar(pelicula);
		if (repuesta)
			return new ResponseEntity<>("Ese nombre ya esxite y no se puede guardar", HttpStatus.OK);
		else
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
	}

	// http://localhost:9000/PeliculasWebService/buscar
	@PostMapping(path = "buscar")
	public Peliculas buscar(@RequestBody Peliculas pelicula) {
		return impPeliculas.buscarXId(pelicula.getIdPelicula());
	}

	// http://localhost:9000/PeliculasWebService/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas pelicula) {
		boolean response = impPeliculas.editar(pelicula);

		if (response = false)
			return new ResponseEntity<>("Esa clave no existe", HttpStatus.OK);
		else
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
	}
	
	
	// http://localhost:9000/PeliculasWebService/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Peliculas pelicula){
		boolean response = impPeliculas.eliminar(pelicula.getIdPelicula());
		
		if(!response)
			return new ResponseEntity<String>("No existe esta clave, no se puede eliminar",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Se elimino correctamente",HttpStatus.OK);
	}
}
