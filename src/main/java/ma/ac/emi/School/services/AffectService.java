package ma.ac.emi.School.services;


public interface AffectService {
	public abstract String affectEnsCrs(Integer idEns, Integer idCrs);
	public abstract String remmoveAffectEnsCrs( Integer idEns, Integer idCrs);
	public abstract String affectEtuCrs(Integer idEtu, Integer idCrs);
	public abstract String remmoveAffectEtuCrs( Integer idEtu, Integer idCrs);
}