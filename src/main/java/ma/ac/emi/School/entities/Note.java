package ma.ac.emi.School.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idNote")
	Integer idNote;
	@Column(name = "Note")
	Integer note;
	@Column(name = "Appreciation")
	String apreciation;
	
	@ManyToOne
	@JoinColumn(name = "Etudiant")
	@JsonIgnoreProperties({"notes","cours"})
	Etudiant etudiant;
	@ManyToOne
	@JoinColumn(name = "Cours")
	@JsonIgnoreProperties({"notes","etudiants"})
	Cours cours;

	public Note(Integer note, String apreciation, Etudiant etudiant, Cours cours) {
		super();
		this.note = note;
		this.apreciation = apreciation;
		this.etudiant = etudiant;
		this.cours=cours;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdNote() {
		return idNote;
	}

	public void setIdNote(Integer idNote) {
		this.idNote = idNote;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getApreciation() {
		return apreciation;
	}

	public void setApreciation(String apreciation) {
		this.apreciation = apreciation;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
	
	
}
