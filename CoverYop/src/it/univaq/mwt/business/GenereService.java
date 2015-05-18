package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Genere;

import java.util.List;



public interface GenereService {
	
	List<Genere> findAllGeneri();
	List<String> findAllGeneriTitoli();
	Genere getGenereById(int Id);
}
