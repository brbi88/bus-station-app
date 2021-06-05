package com.ftninformatika.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.modul3.test.model.Linija;
import com.ftninformatika.modul3.test.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDto implements Converter<Linija, LinijaDTO> {
	
	@Override
	public LinijaDTO convert(Linija linija) {
		LinijaDTO linijaDTO = new LinijaDTO();
		linijaDTO.setId(linija.getId());
		linijaDTO.setBrMesta(linija.getBrMesta());
		linijaDTO.setCenaKarte(linija.getCenaKarte());
		linijaDTO.setVrPolaska(linija.getVrPolaska());
		linijaDTO.setDestinacija(linija.getDestinacija());
		linijaDTO.setPrevoznikId(linija.getPrevoznik().getId());
		linijaDTO.setPrevoznikNaziv(linija.getPrevoznik().getNaziv());
		
		return linijaDTO;
	}
	
	public List<LinijaDTO> convert(List<Linija> linije) {
		List<LinijaDTO> linijeDTO = new ArrayList<>();
		
		for(Linija linija : linije) {
			linijeDTO.add(convert(linija));
		}
		return linijeDTO;
	}

}
