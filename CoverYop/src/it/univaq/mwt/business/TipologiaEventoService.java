package it.univaq.mwt.business;

import it.univaq.mwt.business.model.TipologiaEvento;

import java.util.List;


public interface TipologiaEventoService {

	List<TipologiaEvento> getAllTipologiaEvento();
	
	TipologiaEvento getTipologiaEventoById(int tipoloEventoID);
}
