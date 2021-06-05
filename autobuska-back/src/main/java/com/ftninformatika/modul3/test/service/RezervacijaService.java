package com.ftninformatika.modul3.test.service;

import java.util.List;

import com.ftninformatika.modul3.test.model.Rezervacija;

public interface RezervacijaService {
	
	List<Rezervacija> findAll();
	
	Rezervacija rezervisi(Rezervacija rezervacija);

}
