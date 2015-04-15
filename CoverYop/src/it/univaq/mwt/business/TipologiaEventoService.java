package it.univaq.mwt.business;

import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.model.*;


public interface TipologiaEventoService {

	public List<TipologiaEvento> getAllTipologiaEvento();
	
	public TipologiaEvento getTipologiaEventoById(int tipoloEventoID);
}
