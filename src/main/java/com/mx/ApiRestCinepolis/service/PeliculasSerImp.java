package com.mx.ApiRestCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestCinepolis.dao.ApiRestCinepolisDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service
public class PeliculasSerImp {

	@Autowired
	ApiRestCinepolisDao dao;

	@Transactional(readOnly = true)
	public List<Peliculas> listar() {
		return dao.findAll();
	}

	@Transactional
	public boolean guardar(Peliculas pelicula) {
		boolean encontrado = false;
		for (Peliculas p : dao.findAll()) {
			if(p.getNombre().equals(pelicula.getNombre())) {
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			dao.save(pelicula);
		}
		return encontrado;
	}

	@Transactional(readOnly = true)
	public Peliculas buscarXId(int idPelicula) {
		return dao.findById(idPelicula).orElse(null);
	}

	@Transactional
	public boolean editar(Peliculas pelicula) {
		boolean bandera = false;

		for (Peliculas p : dao.findAll()) {
			if (p.getIdPelicula().equals(pelicula.getIdPelicula())) {
				dao.save(pelicula);
				bandera = true;
				break;
			}
		}
		return bandera;
	}
	
	
	@Transactional
	public boolean eliminar(int idPelicuka) {
		boolean bandera = false;
		Peliculas pEncontrado = buscarXId(idPelicuka);
		
		if(pEncontrado != null) {
			dao.deleteById(idPelicuka);
			bandera = true;;
		}
		return bandera;
	}
	

}
