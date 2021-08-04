package com.kevinsoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kevinsoto.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	//metodo personalizado con sql nativo
	@Query(value="select count(*) from Usuarios", nativeQuery = true)
	Integer totalEntidades();
}
