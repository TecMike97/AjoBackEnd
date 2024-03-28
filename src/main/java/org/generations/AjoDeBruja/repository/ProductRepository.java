package org.generations.AjoDeBruja.repository;


import java.util.Optional;

import org.generations.AjoDeBruja.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	Optional<Product> findByNombre(String nombre);
}
