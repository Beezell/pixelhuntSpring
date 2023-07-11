package fr.pixelhunt.back_spring_user.dao;

import org.springframework.data.repository.CrudRepository;

import fr.pixelhunt.back_spring_user.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByUsername(String username);
	
}
