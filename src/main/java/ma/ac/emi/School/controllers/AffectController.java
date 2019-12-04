package ma.ac.emi.School.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.School.services.AffectService;


@CrossOrigin( origins = "*" )
@RestController
public class AffectController {

	
	@Autowired
	private AffectService affectService;
	
//ens-crs
	
	@PutMapping("/affect/ens-crs/{idEns}/{idCrs}")
	@ResponseStatus(HttpStatus.CREATED)
	public String affectEnsCrs(@PathVariable Integer idEns,@PathVariable Integer idCrs) {
		return affectService.affectEnsCrs(idEns,idCrs);
	}
	
	
	@DeleteMapping("/affect/ens-crs/{idEns}/{idCrs}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String remmoveAffectEnsCrs(@PathVariable Integer idEns,@PathVariable Integer idCrs) {
		
		return affectService.remmoveAffectEnsCrs(idEns,idCrs);
	}

	
	
//etu-crs
	
	@PutMapping("/affect/etu-crs/{idEtu}/{idCrs}")
	@ResponseStatus(HttpStatus.CREATED)
	public String affectEtuCrs(@PathVariable Integer idEtu,@PathVariable Integer idCrs) {
		return affectService.affectEtuCrs(idEtu,idCrs);
	}
	
	
	@DeleteMapping("/affect/etu-crs/{idEtu}/{idCrs}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String remmoveAffectEtuCrs(@PathVariable Integer idEtu,@PathVariable Integer idCrs) {
		return affectService.remmoveAffectEtuCrs(idEtu,idCrs);
	}

}
