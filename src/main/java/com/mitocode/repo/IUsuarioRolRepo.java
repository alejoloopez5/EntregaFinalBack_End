package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitocode.model.UsuarioRol;

@Repository
public interface IUsuarioRolRepo extends JpaRepository<UsuarioRol, Integer>{

	@Modifying
	@Query(value = "INSERT INTO usuario_rol(id_usuario, id_rol) VALUES (:idUsuario, :idRol)", nativeQuery = true)
	Integer registrar(@Param("idUsuario") Integer idUsuario, @Param("idRol") Integer idRol);
	
	@Query("from UsuarioRol ur where ur.rol.id_rol = :id_rol")
	List<UsuarioRol> listarRolPorUsuario(@Param("id_rol") Integer id_rol);
}
