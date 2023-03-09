package com.sistema.examenes.service;

import java.util.Set;

import com.sistema.examenes.model.Usuario;
import com.sistema.examenes.model.UsuarioRol;

public interface UsuarioService {
	
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
	
	public Usuario obtenerUsuario(String username);
	
	public void eliminarUsuario(Long usuarioId);
	
	

}
