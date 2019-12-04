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

import ma.ac.emi.School.dao.CoursRepository;
import ma.ac.emi.School.entities.Cours;
import ma.ac.emi.School.services.CoursService;

@CrossOrigin( origins = "*" )
@RestController
public class CoursController {
	@Autowired
	private CoursRepository cRep;
	@Autowired
	private CoursService coursService;
	
	@PostMapping("/cours")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCours(@RequestBody Cours crs) {
		coursService.addCours(crs);
	}
	
	@GetMapping("/cours")
	public List<Cours> findAllCours() {
			return coursService.findAllCours();
	} 
	@GetMapping("/cours/{id}")
	public Cours findCrsbyId(@PathVariable Integer id) {
			return coursService.findCrsbyId(id);
	} 
	

	@PutMapping("/cours")
	public void updateCours(@RequestBody Cours crs) {
		coursService.updateCours(crs);
	}

	@DeleteMapping("/cours/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deleteCours(@PathVariable Integer id) {
		return coursService.deleteCours(id);
	}
	
	@DeleteMapping("/cours/{id}/force")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String deleteCoursForced(@PathVariable Integer id) {
		return coursService.deleteAllCoursAffectation(id) + coursService.deleteCours(id);
	}
}
