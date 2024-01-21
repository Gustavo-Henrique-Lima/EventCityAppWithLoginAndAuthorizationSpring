package com.gustavonascimento.DsEvent.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsEvent.entities.City;
import com.gustavonascimento.DsEvent.entities.dto.CityDTO;
import com.gustavonascimento.DsEvent.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	@Transactional(readOnly = true)
	public List<CityDTO> findAllSortedByName() {
		List<City> entitys = repository.findAll(Sort.by("name"));
		List<CityDTO> city = entitys.stream().map(cities -> new CityDTO(cities)).collect(Collectors.toList());
		return city;
	}

	public CityDTO insertCity(CityDTO entity) {
		City city = new City();
		city.setName(entity.getName());
		repository.save(city);
		return new CityDTO(city);
	}
}