package com.gbicr.service;

import com.gbicr.model.Account;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	
    Account save (Account account);
    
    Page<Account> list (int page, int pageSize);
    
    Account Update (Account account);

}
