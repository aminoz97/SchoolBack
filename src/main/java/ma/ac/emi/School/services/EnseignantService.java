package ma.ac.emi.School.services;

import java.util.List;

import ma.ac.emi.School.entities.Enseignant;

public interface EnseignantService {
	public abstract void addEnseignant( Enseignant ens);
	public abstract void modifiyEnseignant( Enseignant ens);
	public abstract List<Enseignant> findAllCours();
	public abstract Enseignant findEnsbyId( Integer id);
	public abstract void deleteEnseignant( Integer id);
	public abstract void deleteAllEnseignant();
}