package com.ftninformatika.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.modul3.test.model.Rezervacija;
import com.ftninformatika.modul3.test.web.dto.RezervacijaDTO;

@Component
public class RezervacijaToRezervacijaDto implements Converter<Rezervacija, RezervacijaDTO>{
	
	@Autowired 
	private LinijaToLinijaDto toLinijaDto;
	
	@Override
	public RezervacijaDTO convert(Rezervacija rezervacija) {
		RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
		rezervacijaDTO.setId(rezervacija.getId());
		rezervacijaDTO.setBrPutnika(rezervacija.getBrPutnika());
		rezervacijaDTO.setLinija(toLinijaDto.convert(rezervacija.getLinija()));
		
		return rezervacijaDTO;
	}
	
	public List<RezervacijaDTO> convert(List<Rezervacija> rezervacije) {
		List<RezervacijaDTO> rezervacijeDto = new ArrayList<>();
		
		for(Rezervacija rezervacija : rezervacije) {
			rezervacijeDto.add(convert(rezervacija));
		}
		return rezervacijeDto;
	}
	

}
