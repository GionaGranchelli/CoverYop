package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.TipologiaEvento;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface EventoService {

	public Evento findEventoById(int eventoID);

	public Set<Evento> findGruppoByEvent(Set<Evento> eventi);

	public List<Evento> findAllEventi();

	public Evento updateEvent(Evento v);

	public List<Evento> CustomSearchEventi(String nomeGruppo, String citta, String genere);

	public List<Evento> findEventoByName(String nome);

	public byte[] getImmagineEvento(int id);

	public Evento buildEventoInfo(Evento evento,Locale locale, Gruppo gruppo, TipologiaEvento tipoEvento,
			CommonsMultipartFile immagine);
	Evento insertEvento(Evento evento);
	Evento buildEventForUpdate(Evento evento,Locale locale,String  nomeGruppo, TipologiaEvento tipoEvento,CommonsMultipartFile immagine);

	public Evento buildEventForUpdate(Evento evento, Locale localeScelto,
			Gruppo g, TipologiaEvento tipoEvento, CommonsMultipartFile immagine);
}
