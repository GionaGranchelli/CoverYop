package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.List;

import it.univaq.mwt.business.CategoriaService;




import it.univaq.mwt.business.model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBCategoria
 */

@Service
public class EJBCategoria implements CategoriaService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;

	
    public EJBCategoria() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public List<Categoria> findAllCategory() {
		Query query = em.createQuery("select cat from Categoria cat");
		List<Categoria> result = new ArrayList<Categoria>(query.getResultList());
		return result;
	}

}
