package org.generation.app.repository;

import java.util.List;

import org.generation.app.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRolesRepository extends CrudRepository<Role, Long> {
	
}
