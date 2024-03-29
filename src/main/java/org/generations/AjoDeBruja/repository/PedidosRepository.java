package org.generations.AjoDeBruja.repository;

import java.util.Optional;

import org.generations.AjoDeBruja.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
	Optional<Pedidos> findById(Long id_pedido);
}//interface PedidosRepository
