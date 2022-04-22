package net.codejava.services;

import net.codejava.repositories.ProductRepository;
import net.codejava.entity.Product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
	return (List<Product>) repo.findAll();
	}
	
	public void save(Product product) {
               
		repo.save(product);
	}
	
	public Product get(double id) {
		return repo.findById(id).get();
	}
	
	public void delete(double id) {
		repo.deleteById(id);
	}
}
