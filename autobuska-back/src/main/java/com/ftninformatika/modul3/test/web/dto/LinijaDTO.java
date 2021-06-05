package com.ftninformatika.modul3.test.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class LinijaDTO {
	
	private Long id;
	
	@Positive(message = "Broj mesta nije negativna vrednost.")
	private int brMesta;
	
	private double cenaKarte;
	
	private String vrPolaska;
	
	@NotBlank
	@NotNull
	private String destinacija;
	
	private Long prevoznikId;
	
	private String prevoznikNaziv;

	public LinijaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrMesta() {
		return brMesta;
	}

	public void setBrMesta(int brMesta) {
		this.brMesta = brMesta;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getVrPolaska() {
		return vrPolaska;
	}

	public void setVrPolaska(String vrPolaska) {
		this.vrPolaska = vrPolaska;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Long getPrevoznikId() {
		return prevoznikId;
	}

	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}

	public String getPrevoznikNaziv() {
		return prevoznikNaziv;
	}

	public void setPrevoznikNaziv(String prevoznikNaziv) {
		this.prevoznikNaziv = prevoznikNaziv;
	}
	
	
	
	
	

}
