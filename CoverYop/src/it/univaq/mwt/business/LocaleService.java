package it.univaq.mwt.business;
import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.Categoria;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;

import java.util.List;


public interface LocaleService {
	
	List<Locale> findAllLocali();
	Locale findLocaleById(int localeID);
	Locale findLocaleByUser(Utente u);
	Locale createLocale(Locale locale);
	List<Locale> findLocaleByName(String locale);
	Locale update(Locale l);
	List<Locale> customSearchLocali(String nome, String citta, String tipologia);
	List<Categoria> getAllCategorieByLocali(List<Locale> locali);
	List<Locale> findlastSubscribed(int i);
	Locale findLocaleByCoord(String nomeLocale, String indirizzo, String citta);
	void buildInfoLocale(Utente utente, Locale viewLocale, Locale locale);
	void buildInfoLocale(Locale viewLocale, Locale locale);
	void buildInfoUtente(Locale l, Locale locale);
	Foto addPhotoProfile(Locale l, Foto f);
	void buildAlbumFoto(FormFotoAlbum formFotoAlbum, Locale l);
	void buildAlbumFotoProfilo(FormFotoProfilo formFotoProfilo, Locale l);
}
