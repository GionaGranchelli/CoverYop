package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Genere;

import java.util.List;



public interface GenereService {
	
	public List<Genere> findAllGeneri();
	
	public List<String> findAllGeneriTitoli();

	public Genere getGenereById(int Id);
}
