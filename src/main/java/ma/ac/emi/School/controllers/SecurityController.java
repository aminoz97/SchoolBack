package ma.ac.emi.School.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ma.ac.emi.School.entities.Account;


@CrossOrigin( origins = "*" )
@RestController
public class SecurityController {

	private HashMap<String, String> accounts = new  HashMap<String, String>(){{
	    put("amine", "amine");
	    put("hani", "hani");
	    put("ouzdou", "ouzdou");
	    put("test","test");
	}};
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public String testConnection(@RequestBody Account acc) {
		if(accounts.containsKey(acc.getUsername())) {
			if(accounts.get(acc.getUsername()).equals(acc.getPassword())) return "Login Success";
			else return "Login Failed";
		}
		else return "this account doesnt exist";
	}
	
	
}
