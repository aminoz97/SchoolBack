package ma.ac.emi.School.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
    @Column(name = "username")
    private String username;
    @Column(name = "intitule")
    private String password;
    
    
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    
    
    }
