package dev.collegues.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.exception.CodeErreur;
import dev.collegue.exception.CollegueNonTrouveException;
import dev.collegue.exception.MessageErreur;
import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@RestController
@RequestMapping("collegues")
public class CollegueController {
	
	private CollegueService service;

	public CollegueController(CollegueService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<String>> getMatricules(
			@RequestParam String nom) {	
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getMatricules(nom));
	}
	
	@GetMapping("{matricule}")
	public ResponseEntity<List<Collegue>> getCollegueByMatricule(@PathVariable String matricule){
		List<Collegue> collegues = service.getCollegues(matricule);
		if(!collegues.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(collegues);
		}
		else {
			throw new CollegueNonTrouveException(new MessageErreur(CodeErreur.VALIDATION, "Ce collègue n'existe pas"));
		}
		
	}

}
