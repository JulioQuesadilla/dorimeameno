package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.Role;
import org.generation.app.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/api") //localhost:port/api
public class RolesRestController {
	
	@Autowired
	IRolesService orderService;
	
	@GetMapping("/roles") //localhost:puerto/api/orders
	public List<Role> roles(){
		return (List<Role>) orderService.findAllRoles();		
	}
	
	@GetMapping("/roles/{id}")
	public Role productById(@PathVariable Long id) {		
		return orderService.findRolById(id);
	}
	
	@PostMapping("/roles")
	public Role newRole(@RequestBody Role rol) {
		rol.setRoleId(null);
		return orderService.saveRol(rol);
	}
	
	@PutMapping("/roles")
	public Role replaceOrder(@RequestBody Role rol) {
		//Filtros para asegurar que esté un ID y exista
		return orderService.saveRol(rol);
	}
	
	

}
