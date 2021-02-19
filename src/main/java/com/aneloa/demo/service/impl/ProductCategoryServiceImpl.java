package com.aneloa.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneloa.demo.dao.IProductCategoryDao;
import com.aneloa.demo.entity.ProductCategory;
import com.aneloa.demo.service.IProductCategoryService;

@Service	
public class ProductCategoryServiceImpl implements IProductCategoryService{
		
	@Autowired
	private IProductCategoryDao repo;

	@Override
	public ProductCategory save(ProductCategory obj) {	
		return repo.save(obj);
	}

	@Override
	public ProductCategory update(ProductCategory obj) {
		return repo.save(obj);
	}

	@Override
	public List<ProductCategory> listAll() {
		return repo.findAll();
	}

	@Override
	public ProductCategory listId(Integer id) {
		Optional<ProductCategory> op = repo.findById(id);
		return op.isPresent() ? op.get() : new ProductCategory();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}	

}
