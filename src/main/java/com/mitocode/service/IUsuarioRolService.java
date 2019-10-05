package com.mitocode.service;

import java.util.List;

import com.mitocode.model.UsuarioRol;

public interface IUsuarioRolService {

	List<UsuarioRol> listarRolPorUsuario(Integer id);
}
