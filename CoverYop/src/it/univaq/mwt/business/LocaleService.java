package it.univaq.mwt.business;
import java.util.List;
import java.util.Set;












import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.univaq.mwt.business.form.local.FormFotoAlbum;
import it.univaq.mwt.business.model.*;


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

	public void buildAlbumFoto(FormFotoAlbum formFotoAlbum, Locale l);

}
