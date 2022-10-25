


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Usuarios.Services.Entidades.Usuarios;
import com.Usuarios.Services.Repository.UsuarioRepository;


public class U {

	@Autowired
    private	UsuarioRepository  usuarioRepo;
	
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
