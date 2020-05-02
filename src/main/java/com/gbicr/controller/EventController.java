package com.gbicr.controller;

import com.gbicr.model.Event;
import com.gbicr.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/event")
public class EventController {

    @Autowired
    EventService eventService;
    
    @GetMapping("/all")
	public ResponseEntity<Page<Event>> getListEvent(@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize) {
		Page<Event> eventList = eventService.list(page, pageSize);
		return new ResponseEntity<>(eventList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> findById(@PathVariable String id){
    	Event eventFindId = eventService.findById(id);
		return new ResponseEntity<>(eventFindId,HttpStatus.OK);
	}
	
	@GetMapping("/tittle/{tittle}")
	public ResponseEntity<List<Event>> findEventByTittle(@PathVariable String tittle){
    	List<Event> eventFindTittle = eventService.findByTittle(tittle);
		return new ResponseEntity<>(eventFindTittle,HttpStatus.OK);
	}
	
    @PostMapping("/")
	public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
		Event eventAdd = eventService.save(event);
		return new ResponseEntity<>(eventAdd, HttpStatus.OK);
	}
    @PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") String id, @Valid @RequestBody Event event) {
		Event eventUpdate = eventService.update(id,event);
		return new ResponseEntity<>(eventUpdate, HttpStatus.OK);
	}

}
