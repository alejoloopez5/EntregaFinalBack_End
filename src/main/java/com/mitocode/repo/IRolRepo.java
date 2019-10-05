package com.mitocode.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Rol;

@Repository
public interface IRolRepo extends JpaRepository <Rol, Integer> {
	
	Page<Rol> listarPageable(Pageable pageable);

}
