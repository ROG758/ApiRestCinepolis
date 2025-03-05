package com.mx.ApiRestCinepolis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestCinepolis.model.Peliculas;

public interface ApiRestCinepolisDao extends JpaRepository<Peliculas, Integer>{

}
