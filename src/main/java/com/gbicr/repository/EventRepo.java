package com.gbicr.repository;

import com.gbicr.model.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepo extends JpaRepository<Event, String> {
	
	@Query("Select c from Event c where c.title LIKE  %?1%")
	List<Event> searchEventByTitle(String title);
	
}
