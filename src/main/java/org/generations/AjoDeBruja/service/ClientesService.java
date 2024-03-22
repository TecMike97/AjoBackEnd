package org.generations.AjoDeBruja.service;

import java.util.List;
import java.util.Optional;

import org.generations.AjoDeBruja.model.Clientes;
import org.generations.AjoDeBruja.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
	private final ClientesRepository clientesRepository;

	@Autowired
	public ClientesService(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}

	public List<Clientes> getAllClientes() {
		return clientesRepository.findAll();
	}// getAllProducts

	public Clientes getClientes(Long id_cliente) {
		return clientesRepository.findById(id_cliente).orElseThrow(
				() -> new IllegalArgumentException("El producto con el id [" + id_cliente + "] no existe"));
	}// getProduct

	public Clientes deleteClientes(Long id_cliente) {
		Clientes tmpCli = null;
		if (clientesRepository.existsById(id_cliente)) {
			tmpCli = clientesRepository.findById(id_cliente).get();
			clientesRepository.deleteById(id_cliente);
		} // if
		return tmpCli;
	}// deleteProduct

	public Clientes addClientes(Clientes clientes) {
		Optional<Clientes> tmpCli = clientesRepository.findByName(clientes.getNombre());
		if (tmpCli.isEmpty()) {
			return clientesRepository.save(clientes);
		} else {
			System.out.println("Ya existe el producto con el nombre [" + clientes.getNombre() + "]");
			return null;
		} // if
	}// addProduct

	public Clientes updateClientes(Long id_cliente, String nombre, String apellido_pa, String apellido_ma, String email,
			String telefono) {
		Clientes clientes = null;
		if (clientesRepository.existsById(id_cliente)) {
			clientes = clientesRepository.findById(id_cliente).get();
			if (nombre.length() != 0)
				clientes.setNombre(nombre);
			if (apellido_pa.length() != 0)
				clientes.setApellido_pa(apellido_pa);
			if (apellido_ma.length() != 0)
				clientes.setApellido_ma(apellido_ma);
			if (email.length() != 0)
				clientes.setEmail(email);
			if (telefono.length() != 0)
				clientes.setTelefono(telefono);
			
			clientesRepository.save(clientes);
		} // exist
		return clientes;
	}
}
