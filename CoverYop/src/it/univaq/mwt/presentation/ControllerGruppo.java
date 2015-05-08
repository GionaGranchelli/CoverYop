package it.univaq.mwt.presentation;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.VideoService;
import it.univaq.mwt.business.form.group.FormEvento;
import it.univaq.mwt.business.form.group.FormMusica;
import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;
import it.univaq.mwt.common.utility.FacilityTool;
import it.univaq.mwt.common.utility.SaveFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.NamingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/BackStage")
public class ControllerGruppo {

	@Autowired
	private Utente utente;
	@Autowired
	GruppoService gruppoServ;
	@Autowired
	GenereService genereServ;
	@Autowired
	GruppoDiRiferimentoService gruppiDiRiferimentoServ;
	@Autowired
	AlbumFotograficoService albumFotoServ;
	@Autowired
	VideoService videoServ;
	@Autowired
	AlbumService albumServ;
	@Autowired
	FotoService fotoServ;
	@Autowired
	CanzoneService canzoneServ;
	@Autowired
	EventoService eventoServ;
	Evento eventoDaModificare = new Evento(0);
	@Autowired
	LocaleService localeServ;
	@Autowired
	TipologiaEventoService tipologiaServ;
	@Autowired
	ConversationService conversationServ;
	@Autowired
	VideoService videoService;
	List<Locale> countryList;

	@RequestMapping("/")
	public String welcome(Model model) throws NamingException {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		model.addAttribute("gruppo", viewGroup);
		String[] title = FacilityTool.splitName(viewGroup.getNomeGruppo());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		model.addAttribute("generi", genereServ.findAllGeneri());
		model.addAttribute("generi_scelti", viewGroup.getGeneri());
		model.addAttribute("gruppirif",	gruppiDiRiferimentoServ.findAllGruppiDiRiferimento());
		model.addAttribute("gruppirif_scelti", viewGroup.getGruppi_rif());
		model.addAttribute("canali", viewGroup.getCanale());
		return "profilo.loggato";
	}

	@RequestMapping(value = "/updateGruppo", method = RequestMethod.POST)
	private String modificaGruppo(@ModelAttribute("gruppo") Gruppo gruppo,
	// BindingResult bindingResult,
			Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		gruppoServ.buildGroupInfo(viewGroup, gruppo);
		gruppoServ.update(viewGroup);
		return "redirect:/BackStage/";
	}

	@RequestMapping("/Utente")
	private String profilo(Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		model.addAttribute("utente", viewGroup);
		return "profiloUtente.loggato";
	}

	@RequestMapping(value = "/updateUtente", method = RequestMethod.POST)
	private String modificaUtente(@ModelAttribute("utente") Gruppo gruppo,
	// BindingResult bindingResult, inserire controllo e
	// validazione----successivamente provare a mergiare direttamente senza fare
	// i set
			Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		gruppoServ.buildInfoUtente(viewGroup, gruppo);
		gruppoServ.update(viewGroup);
		return "redirect:/BackStage/Utente";
	}

	@RequestMapping("/Multimedia")
	private String ModificaMultimedia(Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		model.addAttribute("gruppo", viewGroup);
		model.addAttribute("fotoProfilo", viewGroup.getFotoProfilo());
		model.addAttribute("albums", viewGroup.getAlbumFotografico());
		model.addAttribute("albumsMusic", viewGroup.getAlbums());
		model.addAttribute("videos", viewGroup.getVideo());
		model.addAttribute("formFotoProfilo", new FormFotoProfilo());
		model.addAttribute("formFoto", new FormFotoAlbum());
		model.addAttribute("AlbumMusica", new Album());
		model.addAttribute("formVideo", new Video());
		return "profiloMultimedia.loggato";
	}

	@RequestMapping("/updateMultimedia/ProfileImage")
	private String updateMultimedia(
			@ModelAttribute(value = "formFotoProfilo") FormFotoProfilo fotoProfilo,
			BindingResult bindingResult, Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		gruppoServ.buildFotoProfilo(fotoProfilo, viewGroup);
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping("/updateMultimedia/AlbumPhoto")
	private String updateAlbumPhoto(
			@ModelAttribute FormFotoAlbum formFotoAlbum, Model model) {
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
		gruppoServ.buildAlbumFoto(formFotoAlbum, g);
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping("/updateMultimedia/Video")
	private String updateVideo(@ModelAttribute Video video, Model model) {
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
		Video v = videoService.buildVideoInfo(g, video);
		videoService.insertVideo(v);
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping(value = "/deletePhoto/{id}")
	public String deletePhoto(@PathVariable int id) {
		fotoServ.deleteFotoById(id);
		albumFotoServ.removeEmptyAlbums(utente);		
		return "redirect:/BackStage/Multimedia";
	}
	
	@RequestMapping("/updateMultimedia/Music")
	private String updateMusic(@ModelAttribute Video video, Model model) {
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
//		 v = videoService.buildVideoInfo(g, video);
//		videoService.insertVideo(v);
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping(value = "/deleteSong/{id}")
	public String deleteSong(@PathVariable int id) {
		Canzone c = canzoneServ.findCanzoneById(id);
		int albumID = c.getAlbum().getId();
		System.out.println("Album ID da cancellare=" + albumID);
		Album alb = albumServ.getAllCanzoniByAlbumId(albumID);
		canzoneServ.deleteCanzone(id);
		int emptyAlbum = albumServ.emptyAlbum(alb);
		if (emptyAlbum < 1)
			albumServ.deleteAlbum(albumID);

		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping(value = "/deleteVideo/{id}")
	public String deleteVideo(@PathVariable int id) {
		videoServ.deleteVideo(id);
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping("/Tour")
	private String ModificaTour() {

		return "utente.loggato";
	}

	@RequestMapping("/Eventi")
	private String ModificaEventi(
			@ModelAttribute("formEvento") FormEvento formEvento, Model model) {

		if (this.eventoDaModificare.getId() != 0) {

			formEvento.setDataEvento(this.eventoDaModificare.getData());
			formEvento.setDescrizione(this.eventoDaModificare.getDescrizione());
			formEvento.setLocale(this.eventoDaModificare.getLocale()
					.getNomeLocale());
			formEvento.setNome(this.eventoDaModificare.getNome());
			formEvento.setOrarioFine(this.eventoDaModificare.getOrarioFine());
			formEvento.setOrarioInizio(this.eventoDaModificare
					.getOrarioInizio());
			formEvento.setPrezzo(this.eventoDaModificare.getPrezzo());
			formEvento.setTipologia_Eventi(this.eventoDaModificare
					.getTipologia_Eventi().getId());
			model.addAttribute("eventoMod", formEvento);
			model.addAttribute("idEvento", this.eventoDaModificare.getId());
		}
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gruppoServ.findGruppoById(id);

		List<Evento> events = new ArrayList<Evento>(view_group.getEventi());

		model.addAttribute("eventi", events);
		model.addAttribute("formEvento", formEvento);
		List<TipologiaEvento> tipologia = tipologiaServ.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		return "profiloEventi.loggato";
	}

	@RequestMapping(value = "/addEvento", method = RequestMethod.POST)
	private String addEvento(@ModelAttribute FormEvento formEvento, Model model) {
		// Creo Evento
		Evento ev = new Evento();
		ev.setNome(formEvento.getNome());
		// Prendo la lista dei locali cercati
		List<Locale> localiCercati = this.countryList;
		Iterator<Locale> i = localiCercati.iterator();
		while (i.hasNext()) {
			Locale l = i.next();
			// Prendo Evento scelto
			if (l.getNomeLocale().compareTo(formEvento.getLocale()) == 0) {
				// Inserisco Riferimento Locale Dentro Evento
				ev.setLocale(l);
				break;
			}

		}
		// Aggiungo desciriozne evento
		ev.setDescrizione(formEvento.getDescrizione());

		// Date date = new
		// SimpleDateFormat("dd/MM/yyyy").parse(formEvento.getDataEvento());
		// Aggiungo Data
		ev.setData(formEvento.getDataEvento());
		// Salvo Foto nel FS e dentro un Oggetto
		CommonsMultipartFile photoFileUploaded = formEvento.getLocandina();
		if (photoFileUploaded != null) {
			SaveFile sF = new SaveFile();
			Foto f = new Foto();
			try {
				f = sF.savePhoto(photoFileUploaded, utente.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Salvo oggetto Foto
			fotoServ.insertFoto(f);
			ev.setLocandina(f.getUrl());

			byte[] tempByte = photoFileUploaded.getBytes();
			ev.setLocandinaBlob(tempByte);// setto direttamente il blob nella
											// tabella
		}

		// Aggiungo Dati all'oggetto Evento
		ev.setOrarioFine(formEvento.getOrarioFine());
		ev.setOrarioInizio(formEvento.getOrarioInizio());
		ev.setPrezzo(formEvento.getPrezzo());
		TipologiaEvento tipologia_Eventi = new TipologiaEvento();
		tipologia_Eventi.setId(formEvento.getTipologia_Eventi());
		ev.setTipologia_Eventi(tipologia_Eventi);
		ev.setStatus(1);
		ev.setLuogo(ev.getLocale().getCitta());
		// Prendo Oggetto del mio Gruppo
		Gruppo g = gruppoServ.findGruppoById(utente.getId());
		// Aggiungo Evento al Gruppo
		g.addEvento(ev);
		// Persisto Oggetto con modifiche
		gruppoServ.update(g);
		return "redirect:/BackStage/Eventi";
	}

	@RequestMapping("/newEvent")
	private String nuovoEvento() {
		this.eventoDaModificare = new Evento();
		this.eventoDaModificare.setId(0);
		return "redirect:/BackStage/Eventi";
	}

	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id) {
		Evento v = eventoServ.findEventoById(id);
		this.eventoDaModificare = v;
		return "redirect:/BackStage/Eventi";
	}

	@RequestMapping(value = "/updateEvento", method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute FormEvento eventoMod,
			Model model) {

		Evento v = eventoServ.findEventoById(eventoMod.getIdEvento());
		v.setData(eventoMod.getDataEvento());
		v.setDescrizione(eventoMod.getDescrizione());
		List<Locale> localiCercati = this.countryList;
		Iterator<Locale> i = localiCercati.iterator();
		while (i.hasNext()) {
			Locale l = i.next();
			System.out.println(l.getNomeLocale());
			// Prendo Evento scelto
			if (l.getNomeLocale().compareTo(eventoMod.getLocale()) == 0) {
				// Inserisco Riferimento Locale Dentro Evento
				v.setLocale(l);
				System.out.println("Locale Scelto " + l.getNomeLocale());
				v.setLuogo(l.getIndirizzo());
				break;
			}

		}
		v.setNome(eventoMod.getNome());
		v.setOrarioFine(eventoMod.getOrarioFine());
		v.setOrarioInizio(eventoMod.getOrarioInizio());
		v.setPrezzo(eventoMod.getPrezzo());
		TipologiaEvento tipologia_Eventi = new TipologiaEvento();
		tipologia_Eventi.setId(eventoMod.getTipologia_Eventi());
		v.setTipologia_Eventi(tipologia_Eventi);
		eventoServ.updateEvent(v);
		Gruppo g = gruppoServ.findGruppoById(utente.getId());
		g.printEvents();
		System.out.println("---");
		g.updateEvento(v);
		g.printEvents();
		gruppoServ.update(g);
		return "redirect:/BackStage/newEvent";
	}

	@RequestMapping("/accettaEvento/{id}")
	private String accettaEvento(@PathVariable int id) {
		Evento v = eventoServ.findEventoById(id);
		v.setStatus(v.getStatus() + 1);
		eventoServ.updateEvent(v);
		return "redirect:/BackStage/Eventi";
	}

	@RequestMapping("/rifiutaEvento/{id}")
	private String rifiutaEvento(@PathVariable int id) {
		Evento v = eventoServ.findEventoById(id);
		Conversation c = new Conversation();
		v.setStatus(v.getStatus() - 1);
		eventoServ.updateEvent(v);
		c = utente.sendMessage(v.getLocale(), " Evento Rifiutato ",
				" Grazie, ma purtroppo devo declinare l'offerta ");
		conversationServ.createConversation(c);
		return "redirect:/BackStage/Eventi";
	}

	// Questa FUnzione Restituisce in Get, tramite Ajax la lista di tutti i
	// Locali che iniziano con "term"
	@RequestMapping(value = "/get_locals_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getCountryList(
			@RequestParam("term") String query) {

		this.countryList = new ArrayList<Locale>(
				localeServ.findLocaleByName(query));

		Iterator<Locale> i = countryList.iterator();
		List<String> listaLocali = new ArrayList<String>();
		while (i.hasNext()) {
			Locale v = i.next();
			listaLocali.add(v.getNomeLocale());
		}

		return listaLocali;
	}

}
