package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.UsuarioRol;
import com.mitocode.service.impl.UsuarioRolsServiceImpl;

@RestController
@RequestMapping("/usuariosroles")
public class UsuarioRolController {
	
	@Autowired
	private UsuarioRolsServiceImpl service;
	
	@GetMapping("/listausuarioroles/{id}")
	public ResponseEntity<List<UsuarioRol>> listarusuariosroles(@PathVariable("id") Integer id){
		List<UsuarioRol> lista = new ArrayList<>(); 
		lista = service.listarRolPorUsuario(id);
		return new ResponseEntity<List<UsuarioRol>>(lista,HttpStatus.OK);
	}

}
