package it.univaq.mwt.business;
import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.Categoria;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;

import java.util.List;


public interface LocaleService {
	
	public List<Locale> findAllLocali();
	
	public Locale findLocaleById(int localeID);
	
	public Locale findLocaleByUser(Utente u);

	public Locale createLocale(Locale locale);
	
	public List<Locale> findLocaleByName(String locale);
	
	public Locale update(Locale l);
	

	public List<Locale> customSearchLocali(String nome, String citta,
			String tipologia);
	
	public List<Categoria> getAllCategorieByLocali(List locali);

	public List<Locale> findlastSubscribed(int i);

	public Locale findLocaleByCoord(String nomeLocale, String indirizzo,
			String citta);

	void buildInfoLocale(Utente utente, Locale viewLocale, Locale locale);
	void buildInfoLocale(Locale viewLocale, Locale locale);

	void buildInfoUtente(Locale l, Locale locale);
	
	Foto addPhotoProfile(Locale l, Foto f);

	void buildAlbumFoto(FormFotoAlbum formFotoAlbum, Locale l);
	void buildAlbumFotoProfilo(FormFotoProfilo formFotoProfilo, Locale l);
}
