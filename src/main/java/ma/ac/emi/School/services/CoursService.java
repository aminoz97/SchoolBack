package ma.ac.emi.School.services;

import java.util.List;

import ma.ac.emi.School.entities.Cours;

public interface CoursService {
	public abstract void addCours(Cours crs);
	public abstract List<Cours> findAllCours();
	public abstract Cours findCrsbyId(Integer id);
	public abstract void updateCours(Cours crs);
	public abstract String deleteCours(Integer id);
	public abstract String deleteAllCoursAffectation(Integer id);
}