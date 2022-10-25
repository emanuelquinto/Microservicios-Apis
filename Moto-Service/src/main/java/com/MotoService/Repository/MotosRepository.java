package com.MotoService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MotoService.Entidad.Motos;

@Repository
public interface MotosRepository extends JpaRepository<Motos,Integer> {

	List<Motos> findByUsuarioId(int usuarioId);
	
}
