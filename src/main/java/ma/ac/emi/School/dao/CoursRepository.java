package ma.ac.emi.School.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.School.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer> {

}
