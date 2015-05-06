package it.univaq.mwt.common.spring;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.univaq.mwt.business.model.Ruolo;
import it.univaq.mwt.business.model.Utente;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private Utente user;
	
	public UserDetailsImpl(Utente user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		Ruolo role = user.getRuolo();
		result.add(new GrantedAuthorityImpl(role.getNome()));			
		return result;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [username=" + user.getUsername() + "]";
	}
	
	public Utente getUser() {
		return user;
	}
}
