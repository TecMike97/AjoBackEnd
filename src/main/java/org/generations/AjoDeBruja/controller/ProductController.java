package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Product;
import org.generations.AjoDeBruja.service.ProductService;
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
@RequestMapping(path = "/api/productos/") // http://localhost:8080/api/productos/
public class ProductController {

	private final ProductService productService;// variable constante

	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}//constructor
	
	//GET
	@GetMapping
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}//getProducts
	
	
	//GET
	@GetMapping (path="{prodId}") //http://localhost:8080/api/productos/
	public Product getProduct(@PathVariable("prodId") Long prodId) {
		return productService.getProduct(prodId);
	}//getProduct
	
	//POST
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}//addProduct
	
	//DELETE
	@DeleteMapping (path="{prodId}") //http://localhost:8080/api/productos/
	public Product deleteProduct(@PathVariable("prodId") Long prodId) {
		return productService.deleteProduct(prodId);
	}//getProduct
	
	//PUT
		@PutMapping(path="{prodId}")
		public Product updateProduct(@PathVariable("prodId") Long prodId,
				@RequestBody Product product){
					return productService.updateProduct(prodId, product.getNombre(),
							product.getDescripcion(), product.getImagen(),
							Double.valueOf(product.getPrecio()));
				}//updateProduct
}//class ProductController