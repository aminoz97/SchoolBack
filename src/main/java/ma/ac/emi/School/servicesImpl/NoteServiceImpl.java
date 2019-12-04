package ma.ac.emi.School.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.emi.School.dao.CoursRepository;
import ma.ac.emi.School.dao.EtudiantRepository;
import ma.ac.emi.School.dao.NoteRepository;
import ma.ac.emi.School.entities.Cours;
import ma.ac.emi.School.entities.Etudiant;
import ma.ac.emi.School.entities.Note;
import ma.ac.emi.School.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository nRep;
	@Autowired
	private CoursRepository cRep;
	@Autowired
	private EtudiantRepository eRep;

	@Override
	public String addNote(Note note) {
		boolean etud = false;
		boolean crs= false;
		boolean in = false;
		boolean clean = true;
		Etudiant et;
		Cours cr;
		int idEtud;
		int idCrs;
		try {
			idEtud = note.getEtudiant().getMatricule();
			etud=eRep.existsById(idEtud);
			idCrs = note.getCours().getIdCours();
			crs=cRep.existsById(idCrs);
			if(etud & crs ) {
				et = eRep.findById(idEtud).get();
				cr= cRep.findById(idCrs).get();
				in = et.getCours().contains(cr);
				}
			else 
				return "note not added - There is no instance for this ID\n etud ="+etud+",crs="+crs;
			}
		catch (Exception e) {
			return "note not added - there is problem with id\n";
		}
		if(in) {
			List<Note> notes = nRep.findAll();
			for (Note n:notes) {
				if(n.getEtudiant().getMatricule() == idEtud & n.getCours().getIdCours() == idCrs) {
					clean = false;
				}
			}
		}
		else return "note not added - Etudiant are not affected to this cours (in=false)";
		if(clean == true) {
			this.nRep.save(note);
			et.addNote(note);
			cr.addNote(note);
			eRep.save(et);
			cRep.save(cr);
			return "note added";
			}
		else return "note not added - this note is already set\n clean="+clean;
	}

	@Override
	public List<Note> findAllNote() {
		return nRep.findAll();
	}

	@Override
	public Note findNtbyId(Integer id) {
		return nRep.findById(id).get();
	}

	@Override
	public void updateNote(Note note) {
		this.nRep.save(note);
	}

	@Override
	public void deleteNote(Integer id) {
		this.nRep.deleteById(id);		
	}

	@Override
	public void deleteAllNote() {
		this.nRep.deleteAll();
	}
}