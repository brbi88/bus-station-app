package com.ftninformatika.modul3.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.modul3.test.model.Prevoznik;
import com.ftninformatika.modul3.test.repository.PrevoznikRepository;
import com.ftninformatika.modul3.test.service.PrevoznikService;

@Service
public class JpaPrevoznik implements PrevoznikService {
	
	@Autowired
	private PrevoznikRepository prevoznikRepository;
	
	@Override
	public Optional<Prevoznik> findOne(Long id) {
		return prevoznikRepository.findById(id);
	}
	@Override
	public List<Prevoznik> findAll(){
		return prevoznikRepository.findAll();
	}
	
	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}
}
