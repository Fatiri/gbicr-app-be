package com.gbicr.serviceimpl;

import com.gbicr.exception.NotFoundException;
import com.gbicr.model.Event;
import com.gbicr.repository.EventRepo;
import com.gbicr.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepo eventRepo;
	
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}

	public Event doUpdateEvent(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public Event save(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public Page<Event> list(int page, int pageSize) {
		PageRequest paging = PageRequest.of(page, pageSize);
		return eventRepo.findAll(paging);
	}

	@Override
	public Event findById(String id) {
		List<Event> events = eventRepo.findAll();
		for (Event event:events ) {
			if(event.getId().equals(id)){
				return eventRepo.findById(id).get();
			}

		}
		throw new NotFoundException("id " + id + " in event is not found");
	}
	
	@Override
	public List<Event> findByTitle(String event) {
			List<Event> events = eventRepo.searchEventByTitle(event);
			if(events.size() == 0) {
				throw new NotFoundException("title " + event + " in event is not found");
			} else {
				return events;	
			}
	}


	@Override
	public Event update(String id, Event event) {
		Event someEvent = eventRepo.findById(id).orElseThrow(() -> new NotFoundException("id " + id + " is not found" ));
		someEvent.settitle(event.gettitle());
		someEvent.setDate(event.getDate());
		someEvent.setDetail(event.getDetail());
		someEvent.setLink_photo(event.getLink_photo());
		return eventRepo.save(someEvent);
	}
}
