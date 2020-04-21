package com.gbicr.serviceimpl;

import com.gbicr.exception.NotFoundException;
import com.gbicr.model.Account;
import com.gbicr.repository.AccountRepo;
import com.gbicr.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public Account findById(String id) {
		List<Account> accounts =accountRepo.findAll();
		for (Account account:accounts ) {
			if(account.getId().equals(id)){
				return accountRepo.findById(id).get();
			}

		}
		throw new NotFoundException("id " + id + " in account is not found");
	}


	@Override
	public Account update(String id, Account account) {
		Account someAccount = accountRepo.findById(id).orElseThrow(() -> new NotFoundException("id " + id + " is not found" ));
		someAccount.setId(account.getId());
		someAccount.setBirthdate(account.getBirthdate());
		someAccount.setBirthplace(account.getBirthplace());
		someAccount.setEmail(account.getEmail());
		someAccount.setFull_name(account.getFull_name());
		someAccount.setPassword(account.getPassword());
		someAccount.setPhone_number(account.getPhone_number());
		someAccount.setUsername(account.getUsername());
		return accountRepo.save(account);
	}
}
