package it.univaq.mwt.business;


import it.univaq.mwt.business.model.Canzone;

import java.util.List;


public interface CanzoneService {
	Canzone findCanzoneById(int canzoniID);
	List<Canzone> findAllCanzoni();
	void deleteCanzone(int canzoneID);
	List<Canzone> findLastSong(int i);
	
}


