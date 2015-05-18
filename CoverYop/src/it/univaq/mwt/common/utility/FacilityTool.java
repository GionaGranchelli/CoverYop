package it.univaq.mwt.common.utility;

import it.univaq.mwt.business.RuoloService;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Ruolo;
import it.univaq.mwt.business.model.Utente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

public final class FacilityTool {

	public static String[] splitName(String nome) {
		String[] array = new String[2];
		String[] title = nome.split(" ");
		if (title.length != 2) {
			int lunghezza = nome.length();
			int mezzaLung = lunghezza / 2;
			array[0] = nome.substring(0, mezzaLung);
			array[1] = nome.substring(mezzaLung, lunghezza);
			return array;
		}
		return title;
	}

	public static Utente finalizeUserInfo(Utente user, String tipo, RuoloService rs) {

		String address = user.getCitta() + ", " + user.getIndirizzo();
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

	public static Gruppo finalizeGruppoInfo(Gruppo user, RuoloService rs) {

		String address = user.getCitta() + ", " + user.getIndirizzo();
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

	public static Locale finalizeLocaleInfo(Locale user, RuoloService rs) {

		String address = user.getCitta() + ", " + user.getIndirizzo();
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
		while (j.hasNext()) {
			Utente temp = j.next();
			if (temp.getRuolo().getId() == 1) {
				Gruppo gruppoTemp = (Gruppo) temp;
				risultatoGruppi.add(gruppoTemp);
			}
		}
		return risultatoGruppi;
	}

	public static List<Locale> splitResultL(List<Utente> risultati, int i) {
		List<Locale> risultatoLocali = new ArrayList<Locale>();
		Iterator<Utente> j = risultati.iterator();
		while (j.hasNext()) {
			Utente temp = j.next();
			if (temp.getRuolo().getId() != 1) {
				Locale localeTemp = (Locale) temp;
				risultatoLocali.add(localeTemp);
			}
		}
		return risultatoLocali;
	}

	public static String getLoginRedirection(String role) {
		if (role.compareTo("[[autority=group]]") == 0) {
			return "redirect:/BackStage/";
		} else {
			return "redirect:/Privee/";
		}
	}

	public static Set<Foto> getSlider(List<AlbumFotografico> albums) {
		AlbumFotografico slider;
		Set<Foto> slideshow = null;
		Iterator<AlbumFotografico> iterator = albums.iterator();
		while (iterator.hasNext()) {
			AlbumFotografico albumFotografico = (AlbumFotografico) iterator.next();
			if (albumFotografico.getTag().equals("slider")) {
				slider = albumFotografico;
				slideshow = slider.getFoto();
			}
		}
		return slideshow;
	}

	public static List<String> getStringListOfGroups(List<Gruppo> countryList) {
		Iterator<Gruppo> i = countryList.iterator();
		List<String> listaGruppi = new ArrayList<String>();
		while (i.hasNext()) {
			Gruppo v = i.next();
			listaGruppi.add(v.getNomeGruppo());
		}
		return listaGruppi;

	}

	public static String[] splitResultBySeparator(String nome) {
		String[] parti = nome.split("::");
		return parti;
	}

	// Solo con nuove conversazioni
	public static Conversation createConversation(Utente mittente, String titolo,
			Utente gruppoDestinatario) {

		Conversation conv = new Conversation();
		conv.setTitolo(titolo);
		conv.setMittente(mittente);
		conv.setDestinatario(gruppoDestinatario);
		conv.setData(Calendar.getInstance());
		conv.setStatus(1);

		return conv;
	}

	public static Message createMessagePerConversation(String corpo, Conversation conv) {

		Message msg = new Message();
		msg.settext(corpo);
		msg.setAutore(conv.getMittente());
		msg.setConversation(conv);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		List<Message> messaggi = new ArrayList<Message>();
		messaggi.add(msg);
		conv.setMessage(messaggi);
		return msg;
	}

	public static String[] splitConvNameGroup(String destinatario) {
		String[] parti = destinatario.split("::");

		return parti;
	}

	public static byte[] getDefaultImage(ServletContext servletContext) {

		String fullPath = servletContext
				.getRealPath("/resources/placeholders/artist01.jpg");
		File imgPath = new File(fullPath);
		byte fileContent[] = null;
		FileInputStream fin = null;
		try {
			// create FileInputStream object
			fin = new FileInputStream(imgPath);

			fileContent = new byte[(int) imgPath.length()];

			// Reads up to certain bytes of data from this input stream into an
			// array of bytes.
			fin.read(fileContent);
			// create string from byte array

		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading file " + ioe);
		} finally {
			// close the streams using close method
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error while closing stream: " + ioe);
			}
		}
		return fileContent;
	}

	public static Message AddNewMessage(String gettext, Utente user,
			Conversation conversation) {
		Message msg = new Message();
		msg.settext(gettext);
		msg.setAutore(user);
		msg.setConversation(conversation);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		conversation.addMessage(msg);
		return msg;
	}
}
