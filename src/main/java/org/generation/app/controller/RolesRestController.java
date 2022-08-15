package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.Product;
import org.generation.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/api") //localhost:port/api
public class RolesRestController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/products") //localhost:puerto/api/orders
	public List<Product> products(){
		return (List<Product>) productService.findAllProducts();		
	}
	
	@GetMapping("/products/{id}")
	public Product productById(@PathVariable Long id) {		
		return productService.findProductById(id);
	}
	
	@PostMapping("/products")
	public Product newProduct(@RequestBody Product product) {
		product.setProductId(null);
		return productService.saveProduct(product);
	}
	
	@PutMapping("/products")
	public Product replaceOrder(@RequestBody Product product) {
		//Filtros para asegurar que esté un ID y exista
		return productService.saveProduct(product);
	}
	
	@DeleteMapping("products/{id}")
	public Product byeProduct(@PathVariable Long id) {
		return productService.deleteProductById(id);
	}

	

}
