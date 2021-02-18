package com.aneloa.demo.service;

import java.util.List;

public interface ICRUD<T, V> {

	T save(T obj);
	T update(T obj);
	List<T> listAll();
	T listId(V id);
	boolean delete(V id);
}		