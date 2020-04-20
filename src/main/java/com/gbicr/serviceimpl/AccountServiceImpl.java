package com.gbicr.serviceimpl;

import com.gbicr.model.Account;
import com.gbicr.repository.AccountRepo;
import com.gbicr.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepo accountRepo;
	
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	public Account doUpdateAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account save(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Page<Account> list(int page, int pageSize) {
		PageRequest paging = PageRequest.of(page, pageSize);
		return accountRepo.findAll(paging);
	}

	@Override
	public Account Update(Account account) {
		return accountRepo.save(account);
	}
}
