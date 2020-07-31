package dev.collegues.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.collegues.entite.Collegue;

@Mapper
public interface CollegueMapper {

	CollegueMapper INSTANCE = Mappers.getMapper(CollegueMapper.class);
	
	CollegueDto collegueToCollegueDto(Collegue collegue);
	Collegue CollegueDtoToCollegue(CollegueDto collegueDto);
}
