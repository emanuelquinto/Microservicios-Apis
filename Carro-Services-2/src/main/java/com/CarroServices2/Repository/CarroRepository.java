package com.CarroServices2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarroServices2.Entidad.Carros;


@Repository
public interface CarroRepository extends JpaRepository<Carros,Integer> {

 	List<Carros> findByUsuarioId(int usuarioId);
}
