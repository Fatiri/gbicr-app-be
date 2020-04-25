package com.gbicr.repository;

import com.gbicr.model.Account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepo extends JpaRepository<Account, String> {
	
	@Query("Select c from Account c where c.full_name LIKE  %?1%")
	List<Account> searchUserByName(String name);
	
}
