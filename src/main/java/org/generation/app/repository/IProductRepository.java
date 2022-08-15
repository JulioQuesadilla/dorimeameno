package org.generation.app.repository;

import java.util.List;

import org.generation.app.entity.Order;
import org.generation.app.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
	
}
