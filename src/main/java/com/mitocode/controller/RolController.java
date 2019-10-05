package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> lista = service.listar();
		return new ResponseEntity<List<Rol>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/leerid/{id}")
	public ResponseEntity<Rol> leerid(@PathVariable("id") Integer id){
		Rol lista = service.leerPorId(id);
		if(lista == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Rol>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Rol>> listarPageable(Pageable pageable) {
		Page<Rol> roles = service.listarPageable(pageable);
		return new ResponseEntity<Page<Rol>>(roles, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Rol obj){
		Rol rol = service.registrar(obj);
		return new ResponseEntity<Object>(rol, HttpStatus.CREATED);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Rol obj){
		Rol rol = service.modificar(obj);
		return new ResponseEntity<Object>(rol,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Rol obj = service.leerPorId(id);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);		
	}
	
	
}
