package ma.ac.emi.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.School.entities.Enseignant;
import ma.ac.emi.School.services.EnseignantService;

@CrossOrigin( origins = "*" )
@RestController
public class EnseignantController {
	@Autowired
	private EnseignantService enseignantService;
	
	@PostMapping("/enseignants")
	@ResponseStatus(HttpStatus.CREATED)
	public void addEnseignant(@RequestBody Enseignant ens) {
		enseignantService.addEnseignant(ens);
	}
	
	
	@PutMapping("/enseignants/")
	@ResponseStatus(HttpStatus.CREATED)
	public void modifiyEnseignant(@RequestBody Enseignant ens) {
		enseignantService.modifiyEnseignant(ens);
	}
	
	@GetMapping("/enseignants")
	public List<Enseignant> findAllCours() {
			return enseignantService.findAllCours();
	} 
	@GetMapping("/enseignants/{id}")
	public Enseignant findEnsbyId(@PathVariable Integer id) {
			return enseignantService.findEnsbyId(id);
	} 
	
	@DeleteMapping("/enseignants/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteEnseignant(@PathVariable Integer id) {
		enseignantService.deleteEnseignant(id);;
	}
	@DeleteMapping("/enseignants/all")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteAllEnseignant() {
		enseignantService.deleteAllEnseignant();
	}
	
}
