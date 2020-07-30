package dev.collegues.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
}
