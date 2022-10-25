package com.MotoService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotoService.Entidad.Motos;
import com.MotoService.Repository.MotosRepository;

@Service
public class MotosService {

	@Autowired
	private MotosRepository motosRepo;
	
	public Motos CrearMotos(Motos moto) {
		return motosRepo.save(moto);
	}
	
	public List<Motos> ListaMotos(){
		return motosRepo.findAll();
	}
	
	public Motos Byid (int id) {
		return motosRepo.findById(id).orElse(null);
	}
	
	public List<Motos> ByIusaurio(int usuarioId){
		return motosRepo.findByUsuarioId(usuarioId);
	}
	
}
