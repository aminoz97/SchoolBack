package ma.ac.emi.School.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.emi.School.dao.CoursRepository;
import ma.ac.emi.School.dao.EnseignantRepository;
import ma.ac.emi.School.dao.EtudiantRepository;
import ma.ac.emi.School.entities.Cours;
import ma.ac.emi.School.entities.Enseignant;
import ma.ac.emi.School.entities.Etudiant;
import ma.ac.emi.School.services.AffectService;

@Service
public class AffectServiceImpl implements AffectService {
	@Autowired
	private EnseignantRepository ensRep;
	@Autowired
	private EtudiantRepository etuRep;
	@Autowired
	private CoursRepository crRep;
	
	@Override
	public String affectEnsCrs(Integer idEns,Integer idCrs) {
		Enseignant ens;
		Cours crs;
		try {
			ens = ensRep.findById(idEns).get();
			crs = crRep.findById(idCrs).get();
		}
		catch(Exception e) {
			return "There is a problem with Id";
		}
		try{
			ens.addCours(crs);
			crs.setEns(ens);
			this.ensRep.save(ens);
			this.crRep.save(crs);
			return "Affected";
		}
		catch(Exception e) {
			return "Already affected here";
		}
	}

	@Override
	public String remmoveAffectEnsCrs(Integer idEns, Integer idCrs) {
		Enseignant ens;
		Cours crs;
		try {
			ens = ensRep.findById(idEns).get();
			crs = crRep.findById(idCrs).get();
		}
		catch(Exception e) {
			return "There is a problem with Id";
		}
		try{
			ens.removeCours(crs);
			crs.setEns(null);
			this.ensRep.save(ens);
			this.crRep.save(crs);
			return "Affectation Removed";
		}
		catch(Exception e) {
			return "There is problem with removing affect";
		}
	}

	@Override
	public String affectEtuCrs(Integer idEtu, Integer idCrs) {
		Etudiant etu;
		Cours crs;
		try {
			etu = etuRep.findById(idEtu).get();
			crs = crRep.findById(idCrs).get();
		}
		catch(Exception e) {
			return "There is a problem with Id";
		}
		try{
			crs.addEtudiant(etu);
			etu.addCours(crs);
			this.etuRep.save(etu);
			this.crRep.save(crs);
			return "Affected";
		}
		catch(Exception e) {
			return "Already affected here";
		}
	}

	@Override
	public String remmoveAffectEtuCrs(Integer idEtu, Integer idCrs) {
		Etudiant etu;
		Cours crs;
		try {
			etu = etuRep.findById(idEtu).get();
			crs = crRep.findById(idCrs).get();
		}
		catch(Exception e) {
			return "There is a problem with Id";
		}
		try{
			etu.removeCours(crs);
			crs.removeEtudian(etu);
			this.etuRep.save(etu);
			this.crRep.save(crs);
			return "Affectation Removed";
		}
		catch(Exception e) {
			return "There is problem with removing affect";
		}
	}
	
	
	
	
}