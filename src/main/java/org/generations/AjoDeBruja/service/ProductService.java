package org.generations.AjoDeBruja.service;

import java.util.List;
import java.util.Optional;

import org.generations.AjoDeBruja.model.Product;
import org.generations.AjoDeBruja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}// getAllProducts

	public Product getProduct(Long id_producto) {
		return productRepository.findById(id_producto).orElseThrow(
				() -> new IllegalArgumentException("El producto con el id [" + id_producto + "] no existe"));
	}// getProduct

	public Product deleteProduct(Long id_producto) {
		Product tmpProd = null;
		if (productRepository.existsById(id_producto)) {
			tmpProd = productRepository.findById(id_producto).get();
			productRepository.deleteById(id_producto);
		} // if
		return tmpProd;
	}// deleteProduct

	public Product addProduct(Product product) {
		Optional<Product> tmpProd = productRepository.findByNombre(product.getNombre());
		if (tmpProd.isEmpty()) {
			return productRepository.save(product);
		} else {
			System.out.println("Ya existe el producto con el nombre [" + product.getNombre() + "]");
			return null;
		} // if
	}// addProduct

	public Product updateProduct(Long id_producto, String nombre, String categoria, String descripcion, String imagen,
			Double precio) {
		Product product = null;
		if (productRepository.existsById(id_producto)) {
			product = productRepository.findById(id_producto).get();
			if (nombre.length() != 0)
				product.setNombre(nombre);
			if (categoria.length() != 0)
				product.setCategoria(categoria);
			if (descripcion.length() != 0)
				product.setDescripcion(descripcion);
			if (imagen.length() != 0)
				product.setImagen(imagen);
			if (precio.doubleValue() > 0)
				product.setPrecio(precio);
			productRepository.save(product);
		} // exist
		return product;
	}// updateProduct

}
