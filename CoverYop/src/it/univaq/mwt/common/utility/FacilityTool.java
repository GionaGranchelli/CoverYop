package it.univaq.mwt.common.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import it.univaq.mwt.business.RuoloService;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Foto;
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
	public static Gruppo finalizeGruppoInfo(Gruppo user, RuoloService rs){
			
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
			Ruolo role = rs.getRuoloByName("group");
			user.setRuolo(role);
			
			return user;
			
		}
	
	public static Locale finalizeLocaleInfo(Locale user, RuoloService rs){
		
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
		
		Ruolo role = rs.getRuoloByName("local");
		user.setRuolo(role);
		
		return user;
		
	}

	public static List<Gruppo> splitResultG(List<Utente> risultati, int i) {
		List<Gruppo> risultatoGruppi = new ArrayList<Gruppo>();
		Iterator<Utente> j = risultati.iterator();
		while(j.hasNext()){
			Utente temp = j.next();
			if(temp.getRuolo().getId() == 1){
				Gruppo gruppoTemp = (Gruppo) temp;
				risultatoGruppi.add(gruppoTemp);
			}
		}
		return risultatoGruppi;
	}

	public static List<Locale> splitResultL(List<Utente> risultati, int i) {
		List<Locale> risultatoLocali = new ArrayList<Locale>();
		Iterator<Utente> j = risultati.iterator();
		while(j.hasNext()){
			Utente temp = j.next();
			if(temp.getRuolo().getId() != 1){
				Locale localeTemp = (Locale) temp;
				risultatoLocali.add(localeTemp);
			}
		}
		return risultatoLocali;
	}

	public static String getLoginRedirection(String role) {
		if (role.compareTo("[[autority=group]]") == 0){
	 		return "redirect:/BackStage/";
	 	}else{
	 		return "redirect:/Privee/";
	 	}
	}

	public static Set<Foto> getSlider(List<AlbumFotografico> albums) {
		AlbumFotografico slider;
		Set<Foto> slideshow = null;
		Iterator<AlbumFotografico> iterator = albums.iterator();
		while(iterator.hasNext()){
			AlbumFotografico albumFotografico = (AlbumFotografico) iterator.next();
			if (albumFotografico.getTag().equals("slider")){
				slider=albumFotografico;
				slideshow =  slider.getFoto();
			}
		}
		return slideshow;
	}
	public static List<String> getStringListOfGroups(List<Gruppo> countryList){
		Iterator<Gruppo> i = countryList.iterator();
		List<String> listaGruppi = new ArrayList<String>();
		while (i.hasNext()) {
			Gruppo v = i.next();
			listaGruppi.add(v.getNomeGruppo());
		}
		return listaGruppi;
		
	}
}
