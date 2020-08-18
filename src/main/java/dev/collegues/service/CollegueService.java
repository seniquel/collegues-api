package dev.collegues.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.collegues.dto.CollegueGalerieDto;
import dev.collegues.dto.UpdateCollegueDto;
import dev.collegues.entite.Collegue;
import dev.collegues.repository.CollegueRepository;

@Service
public class CollegueService {
	
	private CollegueRepository repo;

	public CollegueService(CollegueRepository repo) {
		this.repo = repo;
	}
	
	public List<String> getMatricules(String nom){
		//return repo.findAll().stream().filter(c -> c.getNom() == nom).map(Collegue::getMatricule).collect(Collectors.toList());
		return repo.findByNom(nom).stream().map(Collegue::getMatricule).collect(Collectors.toList());
	}
	
	public List<Collegue> getCollegues(String matricule){
		return repo.findByMatricule(matricule);
	}
	
	public List<CollegueGalerieDto> getGalerie(){
		return repo.findAll().stream()
				.map(c -> new CollegueGalerieDto(c.getMatricule(),c.getPhotoUrl()))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public Collegue creer(String nom, String prenoms, String email, LocalDate dateDeNaissance, String photoUrl) {
	
		Collegue collegue = new Collegue(nom, prenoms, email, dateDeNaissance, photoUrl);
		
		Collegue collegueSauvegarde = this.repo.save(collegue);
		
		return collegueSauvegarde;
	}
	
	@Transactional
	public Collegue update(UpdateCollegueDto collegueDto, String matricule) {
		Collegue collegue = repo.findByMatricule(matricule).get(0);
		collegue.setEmail(collegueDto.getEmail());
		collegue.setPhotoUrl(collegueDto.getPhotoUrl());
		repo.save(collegue);
		
		return collegue;
	}
}
