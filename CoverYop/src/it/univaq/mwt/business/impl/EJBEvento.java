package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import it.univaq.mwt.business.EventoService;




import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBEvento
 */

@Service
public class EJBEvento implements EventoService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	 

	
    public EJBEvento() {
        // TODO Auto-generated constructor stub
    }
    
    
//    @Override
//	public Evento findEventoById(int eventoID) {
//		
//		Query query = em.createQuery("select ev "
//				+ "from Evento ev, Gruppo gr "
//				+ "where ev.id =:eventoID");
//		query.setParameter("eventoID", eventoID);
//		
//	
//		Evento result = (Evento) query.getSingleResult();
//		return result;
//		
//		
//	}
    @Override
    public Set<Evento> findGruppoByEvent(Set<Evento> eventi){
    	
    	Set<Evento> result = new HashSet<Evento>();
    	
    	for (Iterator iterator = eventi.iterator(); iterator.hasNext();) {
    	 Set<Gruppo> gruppi = new HashSet<Gruppo>();
    	 Evento evento = (Evento) iterator.next();
    	 Query query =null;
		 query = em.createQuery("select  gr "
					+ "from Evento ev, Gruppo gr  "
					+ "where ev.id =:eventoID");
		 query.setParameter("eventoID", evento.getId());
		 List<Gruppo> lista =new ArrayList<Gruppo>();	
		 lista = (List<Gruppo>) query.getResultList();
			
		 for (Iterator iterator2 = lista.iterator(); iterator2.hasNext();) {
			Gruppo gruppo = (Gruppo) iterator2.next();
			gruppi.add(gruppo);
		 }
		 evento.setGruppo(gruppi);
		 System.out.println();
		 result.add(evento);
		}
    	
		return result;
    	

    }


	@Override
	public Set<Evento> findAllEventi() {
		em.clear();
		Query query = em.createQuery("select e "
				+ "from Evento e, Gruppo g, Tour t, TipologiaEvento te where e.status > 10");
				//+ " where e.id =: g.id"); 
		
		List<Evento> resultList = (List<Evento>) query.getResultList();
		Set <Evento> result =  new HashSet<Evento>(resultList);
		em.getEntityManagerFactory().getCache().evictAll();
		return result;
	}
    
	@Override
	public Evento findEventoById(int id) {
		
		em.clear();
		Query query = em.createQuery("select e "
				+ "from Evento e, Gruppo g, Tour t, TipologiaEvento te "
				+ "where e.id =:id");
		query.setParameter("id", id);
		
	
		Evento result = (Evento) query.getSingleResult();
		em.getEntityManagerFactory().getCache().evictAll();
		return result;
		
	}


	@Transactional
	public Evento updateEvent(Evento v) {
		// TODO Auto-generated method stub
		Evento ev = em.merge(v);
		em.flush();
		return ev;
	}
	
	@Override
	public Set<Evento> CustomSearchEventi(String nomeEvento,String tipologiaEvento, String luogo ) { 
	String queryString = null;
		
	Query query = null;
	if (!(nomeEvento.isEmpty()) && !(luogo.isEmpty()) && !(tipologiaEvento.isEmpty())){
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.luogo) LIKE :luogo AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento;
			String luogoLow = luogo.toLowerCase();
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("luogo", "%" + luogoLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		}else if (!(nomeEvento.isEmpty()) && !(luogo.isEmpty())){
			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.luogo) LIKE :luogo";
			query = em.createQuery(queryString);			
			String nomeLow = nomeEvento;
			String luogoLow = luogo.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("luogo", "%" + luogoLow + "%");
		}else if (!(luogo.isEmpty()) && !(tipologiaEvento.isEmpty())){
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.luogo) LIKE :luogo AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String luogoLow = luogo.toLowerCase();
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("luogo", "%" + luogoLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		}else if (!(nomeEvento.isEmpty()) && !(tipologiaEvento.isEmpty())){
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento;
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		}else if(!(nomeEvento.isEmpty())){
			
			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento.toLowerCase();
			query.setParameter("nomeE", "%"+nomeLow+"%");
			
		}else if ( !(luogo.isEmpty())){
			
			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.luogo) LIKE :luogo";
			query = em.createQuery(queryString);
			String luogoLow = luogo.toLowerCase();
			query.setParameter("luogo", "%" + luogoLow + "%");
		}else if ( !(tipologiaEvento.isEmpty())){
			
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		}	
		
		List<Evento> lista = (List<Evento>) query.getResultList();
		Set<Evento> result = new HashSet<Evento>(lista);
		

		return result;
	}
	
	

//    
//    @Override
//    public Set<Evento> findGruppoByEvent(List<Evento> eventi){
//    	
//    	Set<Evento> result = new HashSet<Evento>();
//    	//Set<Gruppo> gruppi = new HashSet<Gruppo>();
//    	for (Iterator iterator = eventi.iterator(); iterator.hasNext();) {
//			Evento evento = (Evento) iterator.next();
//			evento.getGruppo();
//			result.add(evento);
//			System.out.println();
//		//List<Gruppo> lista = (List<Gruppo>) query.getResultList();
//		
////		for (Iterator iterator2 = lista.iterator(); iterator2.hasNext();) {
////			Gruppo gruppo = (Gruppo) iterator2.next();
////			gruppi.add(gruppo);
////		}
//			//gruppi = (Set<Gruppo>) query.getResultList();
////			evento.setGruppo(gruppi);
////			result.add(evento);
//		}
//		return result;
//    	
//    	
//    }
    
//  @Override
//  public List<Evento> findGruppoByEvent(List<Evento> eventi){
//	  
//	  List<Evento> result = new ArrayList<Evento>();
//	 
//	  for (Iterator iterator = eventi.iterator(); iterator.hasNext();) {
//		Evento evento = (Evento) iterator.next();
//		 Set<Gruppo> gruppi = new HashSet<Gruppo>();
//		gruppi = findGruppo(evento);
//		evento.setGruppo(gruppi);
//		
//	}
//	  
//	  
//	  
//	return result;
//  
//  
//  
//  }
//
//
//private Set<Gruppo> findGruppo(Evento evento) {
//	Set<Gruppo> result= new HashSet<Gruppo>();
//	result= evento.getGruppo();
//	return result;
//}
  


}
