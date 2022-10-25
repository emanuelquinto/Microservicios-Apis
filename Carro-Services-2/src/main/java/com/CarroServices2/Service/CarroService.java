package com.CarroServices2.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.CarroServices2.Entidad.Carros;
import com.CarroServices2.Repository.CarroRepository;

@Service
public class CarroService {

@Autowired
private	CarroRepository carroRepo;
	
	public Carros CrearCarro(Carros carros) {
		Carros carro = carroRepo.save(carros);
		return carros; 
		
	}
	public List<Carros> getAll(){
		return carroRepo.findAll();
		
	}
	
	public Carros getUsuarioByid(int id) {
		return carroRepo.findById(id).orElse(null);
		
	}
	

	public List<Carros> ByUsuarios(int usuarioId) {
		return carroRepo.findByUsuarioId(usuarioId);
	}

}
