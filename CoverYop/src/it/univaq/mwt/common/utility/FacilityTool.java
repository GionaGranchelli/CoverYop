package it.univaq.mwt.common.utility;

import org.springframework.beans.factory.annotation.Autowired;

import it.univaq.mwt.business.RuoloService;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Ruolo;
import it.univaq.mwt.business.model.Utente;

public final class FacilityTool {

	
	public static String[] splitName(String nome){
		String[] title = nome.split(" ");
		return title;
	}
	
	public static Utente finalizeUserInfo(Utente user, String tipo, RuoloService rs){
		
		String address = user.getCitta()+", "+user.getIndirizzo();
		String latLongs[];
		try {
			latLongs = ConversionUtility.getLatLongPositions(address);
			float lat = Float.parseFloat(latLongs[0]);
			float lng = Float.parseFloat(latLongs[1]);
			user.setLat(lat);
			user.setLng(lng);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Ruolo role = rs.getRuoloByName(tipo);
		user.setRuolo(role);
		
		return user;
		
	}
}
