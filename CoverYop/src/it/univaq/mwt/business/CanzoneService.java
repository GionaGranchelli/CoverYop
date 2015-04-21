package it.univaq.mwt.business;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.model.Canzone;



import it.univaq.mwt.business.model.*;


public interface CanzoneService {
	public Canzone findCanzoneById(int canzoniID);
	public List<Canzone> findAllCanzoni();
	public void deleteCanzone(int canzoneID);
	public List findLastSong(int i);
	
}


