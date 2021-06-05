package com.ftninformatika.modul3.test.service;

import java.util.List;
import java.util.Optional;

import com.ftninformatika.modul3.test.model.Prevoznik;


public interface PrevoznikService {
	
	Optional<Prevoznik> findOne(Long id);
	
	List<Prevoznik> findAll();
	
	Prevoznik save(Prevoznik prevoznik);
	
	
	


}
