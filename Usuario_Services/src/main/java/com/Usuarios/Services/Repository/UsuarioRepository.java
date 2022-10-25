package com.Usuarios.Services.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Usuarios.Services.Entidades.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Integer> {

}
