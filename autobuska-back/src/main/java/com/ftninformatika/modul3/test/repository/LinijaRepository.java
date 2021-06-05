package com.ftninformatika.modul3.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninformatika.modul3.test.model.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long>{
	
	Linija findOneById(Long id);
	
	@Query("SELECT l from Linija l WHERE" +
	"(:destinacija = NULL OR l.destinacija LIKE %:destinacija%) AND " +
	"(:prevoznikId = NULL OR l.prevoznik.id = :prevoznikId) AND " +
	"(:maxCena = NULL OR l.cenaKarte >= :maxCena)")
	Page<Linija> search(@Param("destinacija") String destinacija, @Param("prevoznikId") Long prevoznikId, @Param("maxCena") Double maxCena, Pageable pageable);
	
	
}
