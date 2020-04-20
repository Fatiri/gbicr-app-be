package com.gbicr.controller;

import com.gbicr.model.Account;
import com.gbicr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    
    @GetMapping("/all")
	public ResponseEntity<Page<Account>> getListAccount(@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize) {
		Page<Account> accountList = accountService.list(page, pageSize);
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}
    
    @PostMapping("/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account acc = accountService.save(account);
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}
    
    @PostMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		Account acc = accountService.Update(account);
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}

}
