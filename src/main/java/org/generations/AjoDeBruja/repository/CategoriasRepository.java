package org.generations.AjoDeBruja.repository;

import java.util.Optional;

import org.generations.AjoDeBruja.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {// Esto Tipo de datos se llama Generic
	Optional<Categorias> findByNombre(String nombre);
}// interface CategoriasRepository
