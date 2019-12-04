package ma.ac.emi.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.School.dao.AccountRepository;
import ma.ac.emi.School.entities.Account;

@CrossOrigin( origins = "*" )
@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accRep;
	
	
	@PostMapping("/account")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAccount(@RequestBody Account acc) {
		accRep.save(acc);;
	}
	
	@GetMapping("/account")
	public List<Account> findAllaccount() {
			return accRep.findAll();
	} 
	@GetMapping("/account/{id}")
	public Account findEtbyId(@PathVariable String username) {
			return accRep.findById(username).get();
	} 
	
	@DeleteMapping("/account/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deleteAccount(@PathVariable String username) {
		if(accRep.existsById(username)) {
			accRep.deleteById(username);
			return "Deleted";
		}
		else return "Not deleted";
	}
	
	
}
