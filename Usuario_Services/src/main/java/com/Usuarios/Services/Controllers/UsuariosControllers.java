package com.Usuarios.Services.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Usuarios.Services.Entidades.Usuarios;
import com.Usuarios.Services.SERVICES.UsuarioServices;

import Modelos.Carros;
import Modelos.Motos;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllers {

	@Autowired
	private UsuarioServices usaurioServices;
	
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> listarUsuarios(){
		
		List<Usuarios>usuarios = usaurioServices.getAll();
		
		 if (usuarios.isEmpty()) {
			 return ResponseEntity.noContent().build();
		 }
		return ResponseEntity.ok(usuarios);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> ObtenerXid(@PathVariable("id")int id){
		
		Usuarios usuario = usaurioServices.getUsuarioByid(id);
	
		if (usuario ==null) {
			 return ResponseEntity.notFound().build();
		 }
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> GuardarUsuario(@RequestBody Usuarios usuario){
		Usuarios nuevo_Usuario = usaurioServices.save(usuario);
		return ResponseEntity.ok(nuevo_Usuario);
	}
	//REStTemplate
	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carros>> ListarCarros(@PathVariable("usuarioId")int id){
		Usuarios usuario = usaurioServices.getUsuarioByid(id);
		if (usuario ==null) {
			 return ResponseEntity.notFound().build();
		 }
		List<Carros> carro = usaurioServices.getCarros(id);
		 return ResponseEntity.ok(carro);
	}
	//REStTemplate
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Motos>> ListarMotos(@PathVariable("usuarioId")int id){
		Usuarios usuario = usaurioServices.getUsuarioByid(id);
		if (usuario ==null) {
			 return ResponseEntity.notFound().build();
		 }
		List<Motos> motos = usaurioServices.getMotos(id);
		 return ResponseEntity.ok(motos);
	}
	
	////FeignClient guardar un carro
	@PostMapping("/carros/{usuarioId}")
	public ResponseEntity<Carros> GuardarCarros(@PathVariable ("usuarioId")int usuarioId,  @RequestBody Carros carros){
		Carros nuevoCarro =usaurioServices.saveCarros(usuarioId, carros);
		return ResponseEntity.ok(nuevoCarro);
	}
////FeignClient guardar un carro
	@PostMapping("/motos/{usuarioId}")
	public ResponseEntity<Motos> GuardarMotos(@PathVariable ("usuarioId")int usuarioId,  @RequestBody Motos motos){
		Motos nuevoMoto =usaurioServices.saveM(usuarioId, motos);
		return ResponseEntity.ok(nuevoMoto);
	}
	
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String , Object>> ListarTodos(@PathVariable ("usuarioId")int usuarioId){
		Map<String , Object> Consulta =usaurioServices.listarMotosCarrosUusarioId(usuarioId);
		return ResponseEntity.ok(Consulta);
		
	}
}
