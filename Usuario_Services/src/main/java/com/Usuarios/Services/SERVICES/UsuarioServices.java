package com.Usuarios.Services.SERVICES;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Usuarios.Services.Entidades.Usuarios;
import com.Usuarios.Services.FeignClients.CarrosFeignClients;
import com.Usuarios.Services.FeignClients.MotosFeignCliens;
import com.Usuarios.Services.Repository.UsuarioRepository;

import Modelos.Carros;
import Modelos.Motos;

@Service
public class UsuarioServices {

	@Autowired
    private	UsuarioRepository  usuarioRepo;
	
	@Autowired
    private	RestTemplate  restemplate;
	
	@Autowired
	private CarrosFeignClients carrosFeign;
	
	@Autowired
	private MotosFeignCliens motoFeign;
	
	
	//REStTemplate
	public List<Carros> getCarros(int usuarioId){
		List<Carros> carros = restemplate.getForObject("http://localhost:8002/carros/usuario/"+ usuarioId,List.class);
		return carros;
	}
	
	//REStTemplate
	public List<Motos> getMotos(int usuarioId){
		List<Motos> motos = restemplate.getForObject("http://localhost:8003/motos/usuario/"+ usuarioId,List.class);
		return motos;
	}
	//FeignClient para insertar una moto
	public Carros saveCarros(int usuarioId,Carros carros) {
		carros.setUsuarioId(usuarioId);
		Carros Nuevocarro =carrosFeign.save(carros);
		return Nuevocarro;
	}
	//FeignClient para insertar una moto 
	public Motos saveM(int usuarioId,Motos motos) {
		motos.setUsuarioId(usuarioId);
		Motos NuevoMoto = motoFeign.saveMoto(motos);
		return NuevoMoto;
	}
	
	//FeignClient Optener multiples resultados de microservicios 
		public Map<String,Object> listarMotosCarrosUusarioId(int usuarioId) {
			Map<String,Object> Consulta = new HashMap<>();
			 Usuarios usuarios = usuarioRepo.findById(usuarioId).orElse(null);
		
			 if(usuarios == null) {
				 Consulta.put("Menssage", "usuarios no existe");
			    }
				 Consulta.put("usuarios", usuarios);
			     List<Carros> carros = carrosFeign.GetCarros(usuarioId);
			     if(carros.isEmpty()) {
			    	 Consulta.put("Carros", "Carros no existe");
			     }else {
			     Consulta.put("Carros",carros);
			 
			     }
			     List<Motos> motos = motoFeign.getMotos(usuarioId);
			     if(motos.isEmpty()) {
			    	 Consulta.put("Motos", "Motos no existe");
			     }else {
			     Consulta.put("Motos",motos);
			 
			     }
			     return Consulta;
			
		}
	
	
	public List<Usuarios> getAll(){
		return usuarioRepo.findAll();
		
	}
	public Usuarios getUsuarioByid(int id) {
		return usuarioRepo.findById(id).orElse(null);
		
	}
	
	public Usuarios save(Usuarios usuarios) {
		Usuarios nuevoUsuario = usuarioRepo.save(usuarios);
		return nuevoUsuario;
		
	}
}
