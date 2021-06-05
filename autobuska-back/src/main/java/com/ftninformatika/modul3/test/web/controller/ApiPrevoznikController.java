package com.ftninformatika.modul3.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.modul3.test.model.Prevoznik;
import com.ftninformatika.modul3.test.service.PrevoznikService;
import com.ftninformatika.modul3.test.support.PrevoznikDtoToPrevoznik;
import com.ftninformatika.modul3.test.support.PrevoznikToPrevoznikDto;
import com.ftninformatika.modul3.test.web.dto.PrevoznikDTO;

@RestController
@RequestMapping(value = "api/prevoznici", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiPrevoznikController {
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired
	private PrevoznikToPrevoznikDto toPrevoznikDto;
	
	@Autowired
	private PrevoznikDtoToPrevoznik toPrevoznik;
	
	@GetMapping
	ResponseEntity<List<PrevoznikDTO>> getAll() {
		List<Prevoznik> prevoznici = prevoznikService.findAll();
		
		return new ResponseEntity<>(toPrevoznikDto.convert(prevoznici), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<PrevoznikDTO> create(@Valid @RequestBody PrevoznikDTO prevoznikDTO) {
		Prevoznik prevoznik = toPrevoznik.convert(prevoznikDTO);
		
		Prevoznik sacuvanPrevoznik = prevoznikService.save(prevoznik);
		
		return new ResponseEntity<>(toPrevoznikDto.convert(sacuvanPrevoznik), HttpStatus.CREATED);
	}
	

}
