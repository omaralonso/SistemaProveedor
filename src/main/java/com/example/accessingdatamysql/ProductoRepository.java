package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	public List<Producto> findByIdCategoria(int idCategoria);
	
}