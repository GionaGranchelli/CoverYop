package it.univaq.mwt.business;



import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.model.*;



public interface GruppoService {
	
	public List<Gruppo> findAllGruppi();
	
	public Gruppo findGruppoByUtente(Utente u);
	
	public Gruppo findGruppoById(int id);
	
	public Gruppo findGruppoByPosition(float lat, float lng);
	
	public Gruppo update(Gruppo gruppo);

	public Gruppo createGruppo(Gruppo gruppo);

	public List<Gruppo> customSearchGruppi(String nome, String citta, String genere);
	
	public List<Utente> SearchUsers(String nome);
	
	public List<Utente> SearchUsers2(String nome);
	
	public List<Gruppo> findGruppoByName(String name);

	public List<Gruppo> findLastSubscribed(int i);

	public Gruppo findGruppoByCoord(String nomeGruppo, String citta);


	
	
}
