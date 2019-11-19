package com.example.accessingdatamysql;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/proveedor")
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductoRepository productoRepository;

	/*
	 * @PostMapping(path="/add") public @ResponseBody String addNewUser
	 * (@RequestParam String name , @RequestParam String email) { // @ResponseBody
	 * means the returned String is the response, not a view name // @RequestParam
	 * means it is a parameter from the GET or POST request
	 * 
	 * User n = new User(); n.setName(name); n.setEmail(email);
	 * userRepository.save(n); return "Saved"; }
	 */

	@GetMapping(path = "/productos")
	public @ResponseBody Iterable<Producto> getAllProdutos() {
		Iterable<Producto> listaProductos = productoRepository.findAll();
		logger.info("Resultado /productos: {}", listaProductos);
		
		return listaProductos;
		
	}
	
	@GetMapping(path = "/producto/{id}")
	public @ResponseBody Producto getProductById(@PathVariable String id) {
		int iId = Integer.parseInt(id);
		Producto producto = productoRepository.findByIdProducto(iId);
		logger.info("Resultado /producto/{}: {}", id, producto);
		
		return producto;
	}
	
	@GetMapping(path = "/productos/{categoria}")
	public @ResponseBody Iterable<Producto> getProductsPorCategoria(@PathVariable String categoria) {
		int categ = Integer.parseInt(categoria);
		Iterable<Producto> listaProductos = productoRepository.findByIdCategoria(categ);
		logger.info("Resultado /productos/{}: {}", categoria, listaProductos);
		
		return listaProductos;
	}
	
	@PostMapping(path = "/actualizar")
	public ResponseEntity<Producto> actualizarProducto(@RequestBody ActualizarRequest request) {
		int idProducto = request.getIdProducto();
		int cantidad = request.getCantidadProductos();
		
		Producto producto = productoRepository.findByIdProducto(idProducto);

		int stockActual = producto.getStockProducto();
		
		if(stockActual <= cantidad) {
			//Si no hay stock se retorna estadoProducto = -1
			logger.info("No hay suficiente stock");
			producto.setEstadoProducto(-1);
		} else {
			//Si hay suficiente stock se actualiza
			logger.info("Actualizando stock");
			int stockActualizado = stockActual - cantidad;
			producto.setStockProducto(stockActualizado);
			productoRepository.save(producto);
		}
		
		logger.info("Resultado /actualizar: {}", producto);
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
}
