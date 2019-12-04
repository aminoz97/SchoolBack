package ma.ac.emi.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.School.entities.Etudiant;
import ma.ac.emi.School.services.EtudiantService;

@CrossOrigin( origins = "*" )
@RestController
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;
	
	
	@PostMapping("/etudiants")
	@ResponseStatus(HttpStatus.CREATED)
	public void addEtudiant(@RequestBody Etudiant etu) {
		etudiantService.addEtudiant(etu);;
	}
	
	@GetMapping("/etudiants")
	public List<Etudiant> findAllEtudiants() {
			return etudiantService.findAllEtudiants();
	} 
	@GetMapping("/etudiants/{id}")
	public Etudiant findEtbyId(@PathVariable Integer id) {
			return etudiantService.findEtubyId(id);
	} 
	
	@DeleteMapping("/etudiants/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deleteEtudiant(@PathVariable Integer id) {
		return etudiantService.deleteEtudiant(id);
	}
	@DeleteMapping("/etudiants/all")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deleteAllEtudiant() {
		return etudiantService.deleteAllEtudiant();
	}
	
}
