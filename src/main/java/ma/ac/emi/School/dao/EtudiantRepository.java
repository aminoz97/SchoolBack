package ma.ac.emi.School.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.School.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
