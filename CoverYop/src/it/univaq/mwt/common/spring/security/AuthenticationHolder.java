package it.univaq.mwt.common.spring.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.spring.UserDetailsImpl;

public class AuthenticationHolder {
	
	public Utente getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetailsImpl) {
                UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
                return userDetailsImpl.getUser();
            }
        }

        return new Gruppo();
    }

}
