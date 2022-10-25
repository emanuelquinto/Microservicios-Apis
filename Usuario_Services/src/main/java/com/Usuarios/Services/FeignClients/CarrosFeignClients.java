package com.Usuarios.Services.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Modelos.Carros;
import Modelos.Motos;


@FeignClient(name= "carro-service",url ="http://localhost:8002")
@RequestMapping("/carros")
public interface CarrosFeignClients {
 
	@PostMapping()
	public Carros save(@RequestBody Carros carros );
		
	@GetMapping("/usuario/{usuarioId}")
	public List<Carros> GetCarros(@PathVariable ("usuarioId")int usuarioId);
		
	
}
