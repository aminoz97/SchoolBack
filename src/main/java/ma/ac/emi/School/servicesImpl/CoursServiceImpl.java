package ma.ac.emi.School.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.emi.School.dao.CoursRepository;
import ma.ac.emi.School.entities.Cours;
import ma.ac.emi.School.entities.Etudiant;
import ma.ac.emi.School.services.CoursService;

@Service
public class CoursServiceImpl implements CoursService {
	@Autowired
	private CoursRepository cRep;
	
	@Override
	public void addCours(Cours crs) {
		this.cRep.save(crs);
	}

	@Override
	public List<Cours> findAllCours() {
		return cRep.findAll();
	}

	@Override
	public Cours findCrsbyId(Integer id) {
		return cRep.findById(id).get();
	}

	@Override
	public void updateCours(Cours crs) {
		this.cRep.save(crs);
	}

	@Override
	public String deleteCours(Integer id) {
		Cours crs =cRep.findById(id).get();
		if(crs.getEtudiants().isEmpty()) {
			this.cRep.deleteById(id);
			return "Deleted";
		}
		else return"not Deleted";
	}
	
	@Override
	public String deleteAllCoursAffectation(Integer id) {
		Cours crs =cRep.findById(id).get();
		List<Etudiant> etuds = crs.getEtudiants();
		for(Etudiant e : etuds) {
			e.removeCours(crs);
		}
		crs.getEtudiants().clear();
		cRep.save(crs);
		return "All affectation deleted";
	}
	
	
	
}