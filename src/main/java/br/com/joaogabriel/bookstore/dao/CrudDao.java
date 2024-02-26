package br.com.joaogabriel.bookstore.dao;

import java.util.Collection;
import java.util.List;

public interface CrudDao<T, ID> {
	
	T save(T type);
	
	T update(T type);
	
	void delete(ID id);
	
	Collection<T> findAll();
	
	List<T> findAllPageable(int init, int size, Ordering ordering, String orderByField);
	
	T findById(ID id);

}
