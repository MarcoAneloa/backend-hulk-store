package com.aneloa.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aneloa.demo.entity.Product;

public interface IProductDao extends JpaRepository<Product, Integer>{
	
}
