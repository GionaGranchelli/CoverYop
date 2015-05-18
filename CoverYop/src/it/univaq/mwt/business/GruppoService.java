package it.univaq.mwt.business;



import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Utente;

import java.util.List;



public interface GruppoService {
	
	List<Gruppo> findAllGruppi();
	Gruppo findGruppoByUtente(Utente u);
	Gruppo findGruppoById(int id);
	Gruppo findGruppoByPosition(float lat, float lng);
	Gruppo update(Gruppo gruppo);
	Gruppo createGruppo(Gruppo gruppo);
	List<Gruppo> customSearchGruppi(String nome, String citta, String genere);
	List<Utente> SearchUsers(String nome);
	List<Utente> SearchUsers2(String nome);
	List<Gruppo> findGruppoByName(String name);
	Gruppo findGruppoByCorrectName(String name);
	List<Gruppo> findLastSubscribed(int i);
	Gruppo findGruppoByCoord(String nomeGruppo, String citta);
	void buildGroupInfo(Gruppo viewGroup, Gruppo gruppo);
	Foto addPhotoProfile(Gruppo viewGroup, Foto foto);
	void buildInfoUtente(Gruppo viewGroup, Gruppo gruppo);
	void buildAlbumFoto(FormFotoAlbum formFotoAlbum, Gruppo g);
	void buildFotoProfilo(FormFotoProfilo fotoProfilo, Gruppo g);
	void refresh(Utente utente);
	Gruppo findGruppoByUsername(String username);
}
