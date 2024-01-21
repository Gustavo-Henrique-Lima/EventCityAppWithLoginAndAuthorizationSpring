package com.gustavonascimento.DsEvent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsEvent.entities.Event;
import com.gustavonascimento.DsEvent.entities.dto.EventDTO;
import com.gustavonascimento.DsEvent.repositories.CityRepository;
import com.gustavonascimento.DsEvent.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageble){
		Page<Event> entity = repository.findAll(pageble);
		Page<EventDTO> events = entity.map(event -> new EventDTO(event));
		return events;
	}
	
	@Transactional
	public EventDTO insertEvent(EventDTO entity) {
		Event event = new Event();
		copyToEntity(event, entity);
		repository.save(event);
		return new EventDTO(event);
	}
	
	
	private void copyToEntity(Event event, EventDTO entity) {
		event.setName(entity.getName());
		event.setDate(entity.getDate());
		event.setUrl(entity.getUrl());
		event.setCity(cityRepository.getReferenceById(entity.getCityId()));
	}
}