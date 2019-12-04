package ma.ac.emi.School.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.School.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{

}
