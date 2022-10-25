package com.CarroServices2.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.CarroServices2.Entidad.Carros;
import com.CarroServices2.Service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarrosController {

	@Autowired
	CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<Carros>> listarCarro(){
		List<Carros> carro = carroService.getAll();
		if (carro.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(carro);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carros> listarID(@PathVariable ("id") int id) {
		Carros carro= carroService.getUsuarioByid(id);
		
		if(carro == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(carro);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Carros> GuradarCarro(@RequestBody Carros carros) {
		Carros nuevocarro = carroService.CrearCarro(carros);
		return ResponseEntity.ok(nuevocarro);
	}
	
	
	@GetMapping("usuario/{usuarioId}")
	public ResponseEntity<List<Carros>> ListarCarrosUsuario(@PathVariable ("usuarioId") int id){
		List<Carros> carros = carroService.ByUsuarios(id);
			return ResponseEntity.ok(carros);
			
	}
}
