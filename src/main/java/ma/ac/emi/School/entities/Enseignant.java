package ma.ac.emi.School.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idEnseignant")
    private Integer idEnseignant;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "mail")
    private String mail;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="ens") 
    @JsonIgnoreProperties("ens")
    List<Cours> cours;

	public Enseignant() {
	}

	public Enseignant(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Integer getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}
    
	
	public void addCours(Cours crs) {
		if(!this.cours.contains(crs)) this.cours.add(crs);
		this.cours.add(crs);
	}
	public void removeCours(Cours crs) {
		this.cours.remove(crs);
	}
    
}