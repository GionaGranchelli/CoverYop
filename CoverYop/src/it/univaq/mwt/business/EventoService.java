package it.univaq.mwt.business;

import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.model.Evento;


public interface EventoService {

	public Evento findEventoById(int eventoID);

	public Set<Evento> findGruppoByEvent(Set<Evento> eventi);

	public Set<Evento> findAllEventi();
	
	public Evento updateEvent(Evento v);
	
	public Set<Evento> CustomSearchEventi(String nomeGruppo, String citta, String genere);
}
