package it.univaq.mwt.business;
import java.util.List;
import java.util.Set;







import it.univaq.mwt.business.model.*;


public interface LocaleService {
	
	public Set<Locale> findAllLocali();
	
	public Locale findLocaleById(int localeID);
	
	public Locale findLocaleByUser(Utente u);

	public Locale createLocale(Locale locale);
	
	public List<Locale> findLocaleByName(String locale);
	
	public Locale update(Locale l);
	

	public Set<Locale> customSearchLocali(String nome, String citta,
			String tipologia);
	
	public List<Categoria> getAllCategorieByLocali(List locali);

	public List findlastSubscribed(int i);

	public Locale findLocaleByCoord(String nomeLocale, String indirizzo,
			String citta);

}
