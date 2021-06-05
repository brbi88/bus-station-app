package com.ftninformatika.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.modul3.test.model.Linija;
import com.ftninformatika.modul3.test.model.Prevoznik;
import com.ftninformatika.modul3.test.service.LinijaService;
import com.ftninformatika.modul3.test.service.PrevoznikService;
import com.ftninformatika.modul3.test.web.dto.LinijaDTO;

@Component
public class LinijaDtoToLinija implements Converter<LinijaDTO, Linija> {
	
	@Autowired 
	private LinijaService linijaService;
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@Override
	public Linija convert(LinijaDTO dto) {
		Prevoznik prevoznik = null;
		if(dto.getPrevoznikId() != null) {
			prevoznik = prevoznikService.findOne(dto.getPrevoznikId()).get();
		}
		Linija linija;
		
		if(dto.getId() == null) {
			linija = new Linija();
		}else {
			linija = linijaService.findOne(dto.getId()).get();
		}
		if(linija != null) {
			linija.setId(dto.getId());
			linija.setBrMesta(dto.getBrMesta());
			linija.setCenaKarte(dto.getCenaKarte());
			linija.setVrPolaska(dto.getVrPolaska());
			linija.setDestinacija(dto.getDestinacija());
			linija.setPrevoznik(prevoznik);
		}
		return linija;
		
	}

}
