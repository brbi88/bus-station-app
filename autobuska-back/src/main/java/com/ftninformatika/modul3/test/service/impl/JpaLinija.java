package com.ftninformatika.modul3.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.modul3.test.model.Linija;
import com.ftninformatika.modul3.test.model.Rezervacija;
import com.ftninformatika.modul3.test.repository.LinijaRepository;
import com.ftninformatika.modul3.test.service.LinijaService;

@Service
public class JpaLinija implements LinijaService{
	
	@Autowired
	private LinijaRepository linijaRepository;
	
	@Autowired
	private LinijaService linijaService;
	
	@Override
	public Linija save(Linija linija) {
		return linijaRepository.save(linija);
	}
	
	@Override
	public Linija update(Linija linija) {
		return linijaRepository.save(linija);
	}
	
	@Override
	public Linija delete(Long id) {
		Optional<Linija> linija = linijaRepository.findById(id);
		if(linija.isPresent()) {
			linijaRepository.deleteById(id);
			return linija.get();
		}
		return null;
	}
	
	@Override
	public Optional<Linija> findOne(Long id){
		return linijaRepository.findById(id);
	}
	
	@Override
	public Linija rezervacija(Long id) {
		
		Linija linija = linijaRepository.getOne(id);
		
		if(linija.getBrMesta() > 0) {
			Rezervacija rezervacija = new Rezervacija();
			rezervacija.setBrPutnika(1);
			
			linija.setBrMesta(linija.getBrMesta() - 1);
			linijaService.update(linija);
			
			return linijaRepository.save(linija);
		}
		return null;
	}
	
	@Override
	public Page<Linija> findAll(int brojStranica) {
		return linijaRepository.findAll(PageRequest.of(brojStranica, 2));
	}
	
	@Override
	public Page<Linija> search(String destinacija, Long prevoznikId, Double maxCena, int pageNo) {
		if(destinacija != null) {
			destinacija = "%" + destinacija + "%";
		}
		return linijaRepository.search(destinacija, prevoznikId, maxCena, PageRequest.of(pageNo, 2));
	}
	
	

}
