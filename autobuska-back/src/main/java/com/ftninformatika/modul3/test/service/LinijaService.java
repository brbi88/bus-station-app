package com.ftninformatika.modul3.test.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import com.ftninformatika.modul3.test.model.Linija;


public interface LinijaService {
	
	Linija save(Linija linija);
	
	Linija update(Linija linija);
	
	Linija delete(Long id);
	
	Optional<Linija> findOne(Long id);
	
	Linija rezervacija(Long id);
	
	Page<Linija> findAll(int page);
	
	Page<Linija> search(String destinacija, Long prevoznikId, Double maxCena, int pageNo);
	
	
	
	

}
