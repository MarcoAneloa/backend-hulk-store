package com.aneloa.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneloa.demo.dao.IProductDao;
import com.aneloa.demo.entity.Product;
import com.aneloa.demo.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductDao repo;

	@Override
	public Product save(Product obj) {	
		return repo.save(obj);
	}

	@Override
	public Product update(Product obj) {
		return repo.save(obj);
	}

	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public Product listId(Integer id) {
		Optional<Product> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Product();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}	

}
