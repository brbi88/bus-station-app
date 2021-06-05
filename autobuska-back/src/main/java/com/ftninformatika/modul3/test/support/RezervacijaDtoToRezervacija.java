package com.ftninformatika.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.modul3.test.model.Rezervacija;
import com.ftninformatika.modul3.test.web.dto.RezervacijaDTO;

@Component
public class RezervacijaDtoToRezervacija implements Converter<RezervacijaDTO, Rezervacija>{
	
	@Autowired
	private LinijaDtoToLinija toLinija;
	
	@Override
	public Rezervacija convert(RezervacijaDTO dto) {
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setId(dto.getId());
		rezervacija.setBrPutnika(dto.getBrPutnika());
		rezervacija.setLinija(toLinija.convert(dto.getLinija()));
	
		return rezervacija;
	}

	
}
