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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cours {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idCours")
    private Integer idCours;
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "description")
    private String description;
    
    @ManyToMany(cascade = CascadeType.ALL,mappedBy="cours")
    @JsonIgnoreProperties("cours")
    List<Etudiant> etudiants;
    
    @ManyToOne
    @JoinColumn(name="Enseigants")
    @JsonIgnoreProperties("cours")
    Enseignant ens;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="cours")
    @JsonIgnoreProperties("cours")
    List<Note> notes;

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String intitule, String description, List<Etudiant> etudiants, Enseignant ens, List<Note> notes) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.etudiants = etudiants;
		this.ens = ens;
		this.notes = notes;
	}

	public Integer getIdCours() {
		return idCours;
	}

	public void setIdCours(Integer idCours) {
		this.idCours = idCours;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Enseignant getEns() {
		return ens;
	}

	public void setEns(Enseignant ens) {
		this.ens = ens;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
    
	public void addNote(Note note) {
		if(!this.notes.contains(note))
				this.notes.add(note);
	}
	public void addEtudiant(Etudiant etud) {
		if(!this.etudiants.contains(etud))
			this.etudiants.add(etud);
	}
	public void removeNote(Note note) {
		this.notes.remove(note);
	}
	public void removeEtudian(Etudiant etud) {
		this.etudiants.remove(etud);
	}
}