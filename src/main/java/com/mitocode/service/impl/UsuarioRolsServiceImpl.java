package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.UsuarioRol;
import com.mitocode.repo.IUsuarioRolRepo;
import com.mitocode.service.IUsuarioRolService;

@Service
public class UsuarioRolsServiceImpl implements IUsuarioRolService {
	
	@Autowired
	private IUsuarioRolRepo repo;
	
	@Override
	public List<UsuarioRol> listarRolPorUsuario(Integer id) {		
		return repo.listarRolPorUsuario(id);
	}

}
