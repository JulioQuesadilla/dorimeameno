package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.Role;
import org.generation.app.repository.IRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImp implements IRolesService {

	@Autowired
	IRolesRepository rolRepository;

	@Override
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return (List<Role>) rolRepository.findAll();
	}

	@Override
	public Role saveRol(Role rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public Role findRolById(Long id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).orElse(null);
	}
	

}
