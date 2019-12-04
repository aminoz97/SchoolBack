package ma.ac.emi.School.services;

import java.util.List;

import ma.ac.emi.School.entities.Etudiant;

public interface EtudiantService {
	public abstract void addEtudiant( Etudiant etu);
	public abstract void modifiyEtudiant( Etudiant etu);
	public abstract List<Etudiant> findAllEtudiants();
	public abstract Etudiant findEtubyId( Integer id);
	public abstract String deleteEtudiant( Integer id);
	public abstract String deleteAllEtudiant();
}