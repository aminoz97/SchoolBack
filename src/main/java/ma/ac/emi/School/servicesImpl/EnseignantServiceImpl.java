package ma.ac.emi.School.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.emi.School.dao.EnseignantRepository;
import ma.ac.emi.School.entities.Enseignant;
import ma.ac.emi.School.services.EnseignantService;

@Service
public class EnseignantServiceImpl implements EnseignantService {
	@Autowired
	private EnseignantRepository ensRep;

	@Override
	public void addEnseignant(Enseignant ens) {
		this.ensRep.save(ens);
		
	}

	@Override
	public void modifiyEnseignant(Enseignant ens) {
		this.ensRep.save(ens);
	}

	@Override
	public List<Enseignant> findAllCours() {
		return ensRep.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enseignant findEnsbyId(Integer id) {
		return ensRep.findById(id).get();
		
	}

	@Override
	public void deleteEnseignant(Integer id) {
		this.ensRep.deleteById(id);
	}

	@Override
	public void deleteAllEnseignant() {
		this.ensRep.deleteAll();		
	}
	
}