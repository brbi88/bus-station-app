package com.ftninformatika.modul3.test.web.dto;

public class RezervacijaDTO {
	
	private Long id;
	
	private int brPutnika;
	
	private LinijaDTO linija;

	public RezervacijaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrPutnika() {
		return brPutnika;
	}

	public void setBrPutnika(int brPutnika) {
		this.brPutnika = brPutnika;
	}

	public LinijaDTO getLinija() {
		return linija;
	}

	public void setLinija(LinijaDTO linija) {
		this.linija = linija;
	}
	
	

}
