package it.univaq.mwt.common.spring;


import it.univaq.mwt.business.BusinessException;
import it.univaq.mwt.business.SecurityService;
import it.univaq.mwt.business.model.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private SecurityService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utente user;
		try {
//			System.out.println("Sono passato di qui");
			user = service.authenticate(username);
		} catch (BusinessException e) {
			System.err.println("Errore Primo");
			throw new UsernameNotFoundException("utente non trovato");
		}

		if (user==null) {
			System.err.println("Errore Secondo");
			throw new UsernameNotFoundException("utente non trovato");
		}
		return new UserDetailsImpl(user);

	}
	

}