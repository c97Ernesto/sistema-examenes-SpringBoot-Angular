package com.sistema.examenes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // mapeamos a la base de datos
@Table(name = "usuarios") // nombre de la tabla en la base de datos (opcional)
public class Usuario {
//	ATTRIBUTES
	@Id // le indica al campo que va a ser único, sirve como identificacion de los demás
		// objetos
	@GeneratedValue(strategy = GenerationType.IDENTITY) // le indicamos que la estrategia sea de autoincremento
	private Long id;

	private String username;

	private String password;

	private String nombre;

	private String apellido;

	private String email;

	private String telefono;

	private boolean enable = true; // usuario habilitado

	private String perfil;

	/*
	 * CascadeType.ALL: cuando realizamos alguna acción en la entidad objetivo, la
	 * misma acción se aplicará automaticamente a sus entidades asociadas
	 * FetchType.EAGER: nos devuelve todos los registros asociados a la entidad (sin
	 * la creación de métodos en controller) mappedBy: apunta a la entidad
	 * propietaria de la relación
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

//	CONSTRUCTORS

	public Usuario() {
		super();
	}

//	GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

}
