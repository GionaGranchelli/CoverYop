package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.univaq.mwt.business.GruppoDiRiferimentoService;




import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.GruppoDiRiferimento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBGruppoDiRiferimento
 */

@Service
public class EJBGruppoDiRiferimento implements GruppoDiRiferimentoService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBGruppoDiRiferimento() {
        // TODO Auto-generated constructor stub
    }

    public List<GruppoDiRiferimento> findAllGruppiDiRiferimento(){
    	Query query = em.createQuery("select gn "
				+ "from GruppoDiRiferimento gn");
		
		
	List<GruppoDiRiferimento> result = new ArrayList<GruppoDiRiferimento>();
	result = query.getResultList();
	//SYSTEM.OUT.PRINTLN(RESULT.GET(0).GETNOME());
		return result;
	
    	
    }

	@Override
	public List<String> findAllGruppiDiRiferimentoTitoli() {
		Query query = em.createQuery("select gn "
				+ "from GruppoDiRiferimento gn");
		
		
	List<GruppoDiRiferimento> result = new ArrayList<GruppoDiRiferimento>();
	result = query.getResultList();
	Iterator<GruppoDiRiferimento> i = result.iterator();
	List<String> titoli = new ArrayList<String>();
	while(i.hasNext()){
		GruppoDiRiferimento grp = i.next();
		titoli.add(grp.getNome());
	}
		return titoli;
	}

	@Override
	public GruppoDiRiferimento getGruppiDiRiferimentoById(int Id) {
		GruppoDiRiferimento a = em.find(GruppoDiRiferimento.class, Id);
		return a;
	}
}
