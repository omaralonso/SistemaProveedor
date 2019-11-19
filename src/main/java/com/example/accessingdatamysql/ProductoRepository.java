package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
