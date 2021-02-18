package com.aneloa.demo.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.aneloa.demo.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> listar(){
		List<Product> lista = service.listAll();
		return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
		Product obj = service.listId(id);	
		Map<String, Object> response = new HashMap<>();
		if(obj.getId() == null) {	
			response.put("mensaje", "Producto no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Product objeto) {
		Product obj = service.save(objeto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Product> modificar(@RequestBody Product objeto) {
		Product obj = service.update(objeto);
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
