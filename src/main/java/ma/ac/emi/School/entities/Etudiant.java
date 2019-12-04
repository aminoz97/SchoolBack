package ma.ac.emi.School.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "matricule")
    private Integer matricule;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "mail")
    private String mail;
    @Column(name = "annee")
    private Integer annee;
    @Column(name = "filiere")
    private String filiere;
    
    @ManyToMany(cascade = CascadeType.ALL) 
    @JsonIgnoreProperties("etudiants")
    List<Cours> cours;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "matricule")
    @JsonIgnoreProperties("etudiant")
    private List<Note> notes;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(Integer matricule, String nom, String prenom, String mail, Integer annee, String filiere,
			List<Cours> cours, List<Note> notes) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.annee = annee;
		this.filiere = filiere;
		this.cours = cours;
	}

	public Etudiant(Integer matricule, String nom, String prenom, String mail, Integer annee, String filiere) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.annee = annee;
		this.filiere = filiere;
	}

	public Integer getMatricule() {
		return matricule;
	}

	public void ListMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void ListNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void ListPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void ListMail(String mail) {
		this.mail = mail;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void ListAnnee(Integer annee) {
		this.annee = annee;
	}

	public String getFiliere() {
		return filiere;
	}

	public void ListFiliere(String filiere) {
		this.filiere = filiere;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void ListCours(List<Cours> cours) {
		this.cours = cours;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void ListNotes(List<Note> notes) {
		this.notes = notes;
	}


	public void addCours(Cours crs) {
		if(!this.cours.contains(crs)) this.cours.add(crs);
	}
	
	public void addNote(Note note) {
		if(!this.notes.contains(note)) this.notes.add(note);
	}
	public void removeCours(Cours crs) {
		this.cours.remove(crs);
	}
	
	public void removeNote(Note note) {
		this.notes.remove(note);
	}
	
}