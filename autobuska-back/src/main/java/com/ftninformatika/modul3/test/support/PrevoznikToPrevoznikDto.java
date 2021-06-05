package com.ftninformatika.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.modul3.test.model.Prevoznik;
import com.ftninformatika.modul3.test.web.dto.PrevoznikDTO;

@Component
public class PrevoznikToPrevoznikDto implements Converter<Prevoznik, PrevoznikDTO>{
	
	@Override
	public PrevoznikDTO convert(Prevoznik prevoznik) {
		PrevoznikDTO prevoznikDTO = new PrevoznikDTO();
		prevoznikDTO.setId(prevoznik.getId());
		prevoznikDTO.setNaziv(prevoznik.getNaziv());
		prevoznikDTO.setAdresa(prevoznik.getAdresa());
		prevoznikDTO.setPib(prevoznik.getPib());
		
		return prevoznikDTO;
	}
	
	public List<PrevoznikDTO> convert(List<Prevoznik> prevoznici) {
		List<PrevoznikDTO> prevozniciDTO = new ArrayList<>();
		
		for(Prevoznik prevoznik : prevoznici) {
			prevozniciDTO.add(convert(prevoznik));
		}
		return prevozniciDTO;
	}

}
