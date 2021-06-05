package com.ftninformatika.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.modul3.test.model.Rezervacija;
import com.ftninformatika.modul3.test.repository.RezervacijaRepository;
import com.ftninformatika.modul3.test.service.RezervacijaService;

@Service
public class JpaRezervacija implements RezervacijaService{
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Override
	public List<Rezervacija> findAll(){
		return rezervacijaRepository.findAll();
	}
	
	@Override
	public Rezervacija rezervisi(Rezervacija rezervacija) {
		return rezervacijaRepository.save(rezervacija);
	}

}
