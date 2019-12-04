package ma.ac.emi.School.services;

import java.util.List;

import ma.ac.emi.School.entities.Note;

public interface NoteService {
	public abstract String addNote(Note note);
	public abstract List<Note> findAllNote();
	public abstract Note findNtbyId(Integer id);
	public abstract void updateNote (Note note);
	public abstract void deleteNote(Integer id);
	public abstract void deleteAllNote();
}