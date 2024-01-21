package com.gustavonascimento.DsEvent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsEvent.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}