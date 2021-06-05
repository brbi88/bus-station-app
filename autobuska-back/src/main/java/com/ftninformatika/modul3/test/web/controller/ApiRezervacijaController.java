package com.ftninformatika.modul3.test.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.modul3.test.model.Rezervacija;
import com.ftninformatika.modul3.test.service.RezervacijaService;
import com.ftninformatika.modul3.test.support.RezervacijaDtoToRezervacija;
import com.ftninformatika.modul3.test.support.RezervacijaToRezervacijaDto;
import com.ftninformatika.modul3.test.web.dto.RezervacijaDTO;

@RestController
@RequestMapping(value = "api/rezervacije", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRezervacijaController {
	
	@Autowired 
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private RezervacijaToRezervacijaDto toRezervacijaDto;
	
	@Autowired
	private RezervacijaDtoToRezervacija toRezervacija;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> create(@Valid @RequestBody RezervacijaDTO rezervacijaDTO) {
		Rezervacija rezervacija = toRezervacija.convert(rezervacijaDTO);
		
		Rezervacija sacuvanaRezervacija = rezervacijaService.rezervisi(rezervacija);
		
		return new ResponseEntity<>(toRezervacijaDto.convert(sacuvanaRezervacija), HttpStatus.CREATED);
	}

}
