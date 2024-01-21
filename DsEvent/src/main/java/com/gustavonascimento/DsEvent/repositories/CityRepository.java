package com.gustavonascimento.DsEvent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsEvent.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}