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
	}//constructor
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}// getAllProducts

	public Product getProduct(Long prodId) {
		return productRepository.findById(prodId).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id ["
						+ prodId + "] no existe.") //este mensaje es para nosotros en consola, no para el usuario
				);//orElseThrow es cuando te aparece un Optional
	}//getProduct

	public Product addProduct(Product product) {
		Optional<Product> tmpProd = productRepository.findByNombre(product.getNombre());
		if (tmpProd.isEmpty()) {
			return productRepository.save(product);
		}else {
			System.out.println("Ya existe el producto con el nombre ["+
					product.getNombre() + "]");
			return null;
		}//if
	}//addProduct

	public Product deleteProduct(Long prodId) {
		Product tmpProd = null;
		if(productRepository.existsById(prodId)) {
			tmpProd=productRepository.findById(prodId).get();
			productRepository.deleteById(Long.valueOf(prodId));
		}//if
		return tmpProd;
	}//deleteProduct
	
	public Product updateProduct(Long prodId, String nombre, String descripcion, String imagen, Double precio) {
		Product product = null;
		if(productRepository.existsById(prodId)) {
			product=productRepository.findById(prodId).get();
			if(nombre.length()!=0) product.setNombre(nombre);
			if(descripcion.length()!=0) product.setDescripcion(descripcion);
			if(imagen.length()!=0) product.setImagen(imagen);
			if(precio.doubleValue()>0) product.setPrecio(precio);
			productRepository.save(product);
			}//if exist
		
		return product;
	}//updateProduct
}//class ProductService
