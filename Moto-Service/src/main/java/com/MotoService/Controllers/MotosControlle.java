package com.MotoService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.MotoService.Entidad.Motos;
import com.MotoService.Service.MotosService;

@RestController
@RequestMapping("/motos")
public class MotosControlle {

	@Autowired
	MotosService motosService;
	@PostMapping
	public ResponseEntity<Motos> GuardarMoto(@RequestBody Motos moto) {
		Motos motos = motosService.CrearMotos(moto);
		return ResponseEntity.ok(motos);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Motos>> listarCarro(){
		List<Motos> carro = motosService.ListaMotos();
		if (carro.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(carro);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Motos> listarID(@PathVariable ("id") int id) {
		Motos carro= motosService.Byid(id);
		
		if(carro == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(carro);
		}
		
	}

	@GetMapping("usuario/{usuarioId}")
	public ResponseEntity<List<Motos>> ListarCarrosUsuario(@PathVariable ("usuarioId") int id){
		List<Motos> carros = motosService.ByIusaurio(id);
			return ResponseEntity.ok(carros);
			
	}
}
