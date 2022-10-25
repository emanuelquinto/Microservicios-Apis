package com.Usuarios.Services.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Modelos.Carros;
import Modelos.Motos;

@FeignClient(name= "motos-service",url ="http://localhost:8003")
@RequestMapping("/motos")
public interface MotosFeignCliens {

	@PostMapping()
	public Motos saveMoto(@RequestBody Motos motos );
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Motos> getMotos(@PathVariable ("usuarioId")int usuarioId);
		
	
}
