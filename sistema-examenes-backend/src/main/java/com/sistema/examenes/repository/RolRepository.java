package com.sistema.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
	
}
