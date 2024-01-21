package com.gustavonascimento.DsEvent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gustavonascimento.DsEvent.entities.User;
import com.gustavonascimento.DsEvent.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User entity = repository.findByEmail(username);
		if(entity==null) {
			throw new UsernameNotFoundException("Email não encontrado");
		}
		return entity;
	}
}