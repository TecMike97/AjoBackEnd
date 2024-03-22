package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Product;
import org.generations.AjoDeBruja.service.ProductService;
//import org.generation.ecommerce.model.Product;
//import org.generation.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products/") // http://localhost:8080/api/products/
public class ProductController {

	private final ProductService productService;// variable constante

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}// constructor

	// GET
	@GetMapping(path = "{id_producto}") // http://localhost:8080/api/products/1
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}// getProducts

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}// addProduct

	// PUT
	// DELETE
	@DeleteMapping(path = "{id_producto}") // http://localhost:8080/api/products/1
	public Product deleteProduct(@PathVariable("id_producto") Long id_producto) {
		return productService.deleteProduct(id_producto);
	}// delete

	@PutMapping(path = "{id_producto}") // http://locolhost:8080/ai/products/1
	public Product updateProduct(@PathVariable("id_producto") Long id_producto, @RequestBody Product product) {
		return productService.updateProduct(id_producto, product.getNombre(), product.getDescripcion(),
				product.getImagen(), product.getCategoria(), Double.valueOf(product.getPrecio()));
	}// updateProduct

}// class ProductController