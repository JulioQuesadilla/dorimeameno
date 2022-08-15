package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.Role;

public interface IRolesService {
	/**
	 * Enlista todos los roles de la base de datos
	 * @param Product 
	 * @return Listado de productos
	 */
	public List<Role> findAllRoles();
	/**
	 * Nos guarda el producto en la base de datos
	 * @param Product Datos del producto
	 * @return Devuelve el producto con el Id asignado
	 */ 
	public Role saveRol(Role rol); 
	
	
	/**
	 * Encontrar un producto en la base de datos
	 * @param Id identificador del producto a buscar
	 * @return
	 */
	public Role findRolById(Long id);
	
	
}
