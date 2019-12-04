package ma.ac.emi.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.School.entities.Note;
import ma.ac.emi.School.services.NoteService;

@CrossOrigin( origins = "*" )
@RestController
public class NoteController {
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/notes")
	@ResponseStatus(HttpStatus.CREATED)
	public String addNote(@RequestBody Note note) {
		return noteService.addNote(note);		
	}
	
	@GetMapping("/notes")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Note> findAllNote() {
			return noteService.findAllNote();
	} 
	@GetMapping("/notes/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Note findNtbyId(@PathVariable Integer id) {
			return noteService.findNtbyId(id);
	} 
	

	@PutMapping("/notes")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateNote(@RequestBody Note note) {
		noteService.updateNote(note);;
	}

	@DeleteMapping("/notes/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletteNote(@PathVariable Integer id) {
		noteService.deleteNote(id);
	}
	@DeleteMapping("/notes/All")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletteAllNote() {
		noteService.deleteAllNote();
	}
}
