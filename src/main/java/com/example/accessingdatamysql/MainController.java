package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/proveedor")
public class MainController {

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
		return productoRepository.findAll();
	}
}