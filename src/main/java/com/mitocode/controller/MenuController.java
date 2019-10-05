package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@GetMapping("leerporid/{id}")
	public ResponseEntity<Menu> listarporid(@PathVariable("id") Integer id){
		Menu list = service.leerPorId(id);
		return new ResponseEntity<Menu>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
	
	@PostMapping(value = "/rol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listarRol(@RequestBody String nombreRol) {
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorRol(nombreRol);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Menu obj){
		Menu menu = service.registrar(obj);
		return new ResponseEntity<Object>(menu,HttpStatus.CREATED);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Menu obj){
		Menu menu = service.modificar(obj);
		return new ResponseEntity<Object>(menu,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Menu menu = service.leerPorId(id);
		if(menu==null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}else {
			service.eliminar(id);
		}			
		return new ResponseEntity<Object>(menu, HttpStatus.OK);
	}
	
}
