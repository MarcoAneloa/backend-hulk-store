package com.aneloa.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aneloa.demo.entity.Product;
import com.aneloa.demo.entity.ProductCategory;

public interface IProductCategoryDao extends JpaRepository<ProductCategory, Integer>{
	
}
	