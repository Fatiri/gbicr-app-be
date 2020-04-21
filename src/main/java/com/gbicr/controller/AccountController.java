package com.gbicr.controller;

import com.gbicr.model.Account;
import com.gbicr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable String id){
    	Account account= accountService.findById(id);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
    @PostMapping("/{id}")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account acc = accountService.save(account);
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}
    @PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") String id, @RequestBody Account account) {
		Account acc = accountService.update(id,account);
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}

}
