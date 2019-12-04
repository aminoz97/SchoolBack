package ma.ac.emi.School.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.emi.School.dao.EtudiantRepository;
import ma.ac.emi.School.dao.NoteRepository;
import ma.ac.emi.School.entities.Etudiant;
import ma.ac.emi.School.services.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	private EtudiantRepository etuRep;
	@Autowired
	private NoteRepository noteRep;
	
	@Override
	public void addEtudiant(Etudiant etu) {
		this.etuRep.save(etu);
		
	}
	
	@Override
	public String deleteEtudiant(Integer id) {
		Etudiant etud = etuRep.findById(id).get();
		etud.ListCours(null);
		this.etuRep.deleteById(id);
		return "Deleted";
	}

	@Override
	public String deleteAllEtudiant() {
		List<Etudiant> etudiants = this.etuRep.findAll();
		for (Etudiant e: etudiants) {
			e.ListCours(null);
			etuRep.delete(e);
		}
		return "All Students deleted";	
	}

	@Override
	public void modifiyEtudiant(Etudiant etu) {
		this.etuRep.save(etu);
	}

	@Override
	public List<Etudiant> findAllEtudiants() {
		return etuRep.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etudiant findEtubyId(Integer id) {
		return etuRep.findById(id).get();
		
	}


	
}