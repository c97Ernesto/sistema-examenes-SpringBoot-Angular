package com.sistema.examenes.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.model.Usuario;
import com.sistema.examenes.model.UsuarioRol;
import com.sistema.examenes.repository.RolRepository;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal = this.usuarioRepository.findByUsername(usuario.getUsername());
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya está presente");
		} 
		else {
			for(UsuarioRol usuarioRol: usuarioRoles) {		//recorro los roles del usuario a crear
				this.rolRepository.save(usuarioRol.getRol());	//almaceno los roles
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);	//le almaceno los roles
			usuarioLocal = this.usuarioRepository.save(usuario);	//le asigno el usuario nuevo
		}
		
		return usuarioLocal;
		
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return this.usuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		this.usuarioRepository.deleteById(usuarioId);
		
	}
	
	
	
	
	
}
