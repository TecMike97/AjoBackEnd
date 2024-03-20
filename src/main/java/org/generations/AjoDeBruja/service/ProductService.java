package org.generations.AjoDeBruja.service;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public final ArrayList<Product> list = new ArrayList<Product>();

	public ProductService() {
		list.add(new Product("Cacao en Polvo", "Comestibles",
				"Cacao orgánico en polvo sin azúcar, colorantes ni conservadores. <br/> Presentación: 150g.", 100.00,
				"ADB_CacaoPolvo.png"));
		list.add(new Product("Café Verde", "Comestibles",
				"Granos de café sin tostar en polvo, para el óptimo aprovechamiento de sus propiedades.<br/> Presentación: 150g.", 85.00,
				"ADB_CafeVerde"));
		list.add(new Product("Crema de Almendras", "Comestible",
				"Crema de almendras naturales, libre de aceites, azúcar, colorantes y conservadores.<br/> Presentación: 250g.", 150.00,
				"ADB_CAlmendra.png"));
		list.add(new Product("Crema de Cacahuate", "Comestibles",
				"CCrema de almendras naturales, libre de aceites, azúcar, colorantes y conservadores.<br/> Presentación: 250g.", 150.00,
				"ADB_CCacahuate1.png"));
	}// constructor

	public ArrayList<Product> getAllProducts() {
		return list;
	}// getAllProducts

	public Product getProduct(int prodId) {
		Product tmpProd = null;
		for (Product product : list) {
			if (product.getId_producto() == prodId)
				tmpProd = product;
			break;
		} // forEach
		return tmpProd;
	}// getProduct

	public Product addProduct(Product product) {
		Product tmpProd = null;
		if (list.add(product)) {
			tmpProd = product;
		} // if
		return tmpProd;
	}// addProduct

	public Product deleteProduct(int prodId) {
		Product tmpProd = null;
		for (Product product : list) {
			if (product.getId_producto() == prodId) {
				tmpProd = product;
				list.remove(product);// borrar el producto de la lista
				break;
			} // if ==
		} // forEach
		return tmpProd;
	}// deleteProduct
}
