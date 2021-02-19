package com.aneloa.demo.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aneloa.demo.ModeloNotFoundException;
import com.aneloa.demo.entity.Product;
import com.aneloa.demo.entity.ProductCategory;
import com.aneloa.demo.service.IProductCategoryService;
import com.aneloa.demo.service.IProductService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class ProductCategoryController {

	@Autowired
	private IProductCategoryService service;
	
	@GetMapping
	public ResponseEntity<List<ProductCategory>> listar(){
		List<ProductCategory> lista = service.listAll();
		return new ResponseEntity<List<ProductCategory>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
		ProductCategory obj = service.listId(id);	
		Map<String, Object> response = new HashMap<>();
		if(obj.getId_category()== null) {	
			response.put("mensaje", "Producto no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductCategory>(obj, HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody ProductCategory objeto) {
		ProductCategory obj = service.save(objeto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_category()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping	
	public ResponseEntity<ProductCategory> modificar(@RequestBody ProductCategory objeto) {
		ProductCategory obj = service.update(objeto);
		return new ResponseEntity<ProductCategory>(obj, HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
