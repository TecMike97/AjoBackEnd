package org.generations.AjoDeBruja.repository;

import java.util.Optional;

import org.generations.AjoDeBruja.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {// Esto Tipo de datos se llama Generic
	Optional<Usuarios> findByEmail(String email);
}// interface UsuariosRepository

