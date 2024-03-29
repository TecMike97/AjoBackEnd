package org.generations.AjoDeBruja.repository;

import java.util.Optional;

import org.generations.AjoDeBruja.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {// Esto Tipo de datos se llama Generic
	Optional<Clientes> findByNombre(String nombre);
}// interface ClientesRepository
