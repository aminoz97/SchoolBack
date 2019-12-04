package ma.ac.emi.School.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.School.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
