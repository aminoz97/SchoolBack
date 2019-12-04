package ma.ac.emi.School.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.School.entities.Note;;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
