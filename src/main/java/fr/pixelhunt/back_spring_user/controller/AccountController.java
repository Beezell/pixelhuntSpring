package fr.pixelhunt.back_spring_user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pixelhunt.back_spring_user.dao.AccountRepository;
import fr.pixelhunt.back_spring_user.model.Account;

@RestController
@RequestMapping(path="/api/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;
	
	@PostMapping(path="/addAccount")
	public void createAccount(@Valid @RequestBody Account account){
		Account searchAccount = accountRepo.findByUsername(account.getUsername());
		if(searchAccount == null) {
			accountRepo.save(account);
		}else {
			System.out.println("The username already exists");
		}
	}
	
	@GetMapping(path="/all")
	public Iterable<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	@GetMapping(path="/getAccount/{username}")
	public Account getAccountByUsername(@PathVariable String username){
		return accountRepo.findByUsername(username);
	}
	
	@DeleteMapping (path="/delete/{id}")
	public void deleteAccount(@PathVariable Long id) {
		accountRepo.deleteById(id);
	}
	
}
