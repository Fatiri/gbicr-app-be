package com.gbicr.service;

import com.gbicr.model.Event;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    Event save (Event event);
    Page<Event> list (int page, int pageSize);
    Event findById(String id);
    List<Event> findByTittle(String tittle);
    Event update (String id, Event event);

}
