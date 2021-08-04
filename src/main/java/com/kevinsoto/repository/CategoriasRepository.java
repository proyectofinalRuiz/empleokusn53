package com.kevinsoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevinsoto.model.Categoria;

public interface CategoriasRepository extends  JpaRepository<Categoria, Integer> {

}
