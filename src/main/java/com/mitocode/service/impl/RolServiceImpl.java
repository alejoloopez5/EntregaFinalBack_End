package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Rol;
import com.mitocode.repo.IRolRepo;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {
	
	@Autowired
	private IRolRepo rol;
	
	@Override
	public Rol registrar(Rol t) {		
		return rol.save(t);
	}

	@Override
	public Rol modificar(Rol t) {
		return rol.save(t);
	}

	@Override
	public Rol leerPorId(Integer id) {
		return rol.findOne(id);
	}

	@Override
	public List<Rol> listar() {
		return rol.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		rol.delete(id);
	}

	@Override
	public Page<Rol> listarPageable(Pageable pageable) {		
		return rol.listarPageable(pageable);
	}

}
