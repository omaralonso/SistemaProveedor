package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	public Producto findByIdProducto(int idProducto);
	
	public List<Producto> findByIdCategoria(int idCategoria);
	
}