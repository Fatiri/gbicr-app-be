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
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Event>> findEventBytitle(@PathVariable String title){
    	List<Event> eventFindTitle = eventService.findByTitle(title);
		return new ResponseEntity<>(eventFindTitle,HttpStatus.OK);
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

	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable String id) {
		eventService.deleteById(id);
	}
}
