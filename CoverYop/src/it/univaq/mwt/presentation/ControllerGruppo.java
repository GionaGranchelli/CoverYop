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
import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;
import it.univaq.mwt.common.utility.FacilityTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	@Autowired
	LocaleService localeServ;
	@Autowired
	TipologiaEventoService tipologiaServ;
	@Autowired
	ConversationService conversationServ;
	@Autowired
	VideoService videoService;
	@Autowired
	TipologiaEventoService tipologiaService;
	List<Locale> countryList;
	@Autowired
	EventoValidator eventoValidator;
	
	

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
		String[] title = FacilityTool.splitName(viewGroup.getNomeGruppo());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		model.addAttribute("utente", viewGroup);
		return "profiloUtente.loggato";
	}

	@RequestMapping(value = "/updateUtente", method = RequestMethod.POST)
	private String modificaUtente(@ModelAttribute("utente") Gruppo gruppo,	Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		gruppoServ.buildInfoUtente(viewGroup, gruppo);
		gruppoServ.update(viewGroup);
		return "redirect:/BackStage/Utente";
	}

	@RequestMapping("/Multimedia")
	private String ModificaMultimedia(Model model) {
		Gruppo viewGroup = gruppoServ.findGruppoByUtente(utente);
		String[] title = FacilityTool.splitName(viewGroup.getNomeGruppo());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		model.addAttribute("gruppo", viewGroup);
		model.addAttribute("albums", viewGroup.getAlbumSlider());
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
	private String updateMusic(@ModelAttribute Album album,  @RequestParam("musicFile") CommonsMultipartFile[] tracce,
			BindingResult bindingResult, Model model) {
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
		albumServ.saveAlbumWithSong(utente, album, tracce);
		gruppoServ.update(gruppoServ.findGruppoByUtente(utente));
		return "redirect:/BackStage/Multimedia";
	}

	@RequestMapping(value = "/deleteSong/{id}")
	public String deleteSong(@PathVariable int id) {
	canzoneServ.deleteCanzone(id);
		return "redirect:/BackStage/Multimedia";
	}
	
	@RequestMapping(value = "/deleteAlbum/{id}")
	public String deleteAlbum(@PathVariable int id) {
	albumServ.deleteAlbum(id);
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
	private String eventi(Model model) {
		Gruppo gruppo = gruppoServ.findGruppoByUtente(utente);
		String[] title = FacilityTool.splitName(gruppo.getNomeGruppo());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		Set<Evento> eventi =  gruppo.getEventi();
		List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
		model.addAttribute("eventi", eventi);
		model.addAttribute("tipologia", tipologia);
		model.addAttribute("evento", new Evento());
		model.addAttribute("gruppo", gruppo);
		return "gruppoEventi.loggato";
	}
	
	@RequestMapping(value = "/addEvento", method = RequestMethod.POST)
	private String addEvento(@ModelAttribute("evento") Evento evento,
							 @RequestParam("nomeLocale") String nomeLocale,
							 @RequestParam("immagine") CommonsMultipartFile immagine,
							 BindingResult bindingResult,
							 Model model) {
		eventoValidator.validate(evento, bindingResult);
		if (bindingResult.hasErrors()) {
			Gruppo gruppo = gruppoServ.findGruppoByUtente(utente);
			Set<Evento> eventi =  gruppo.getEventi();
			List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
			model.addAttribute("eventi", eventi);
			model.addAttribute("tipologia", tipologia);
			model.addAttribute("gruppo", gruppo);
			return "gruppoEventi.loggato";
		}
		String[] ragioneSociale = FacilityTool.splitResultBySeparator(nomeLocale);
		Locale localeScelto = localeServ.findLocaleByCoord(ragioneSociale[0], ragioneSociale[1], ragioneSociale[2]);
		TipologiaEvento tipoEvento = tipologiaService.getTipologiaEventoById(evento.getTipologia_Eventi().getId());
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
		eventoServ.buildEventoInfo(evento,localeScelto,g,tipoEvento,immagine);
		gruppoServ.update(g);
		return "redirect:/BackStage/Eventi";
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
		c = utente.sendMessage(v.getLocale(), " Evento Rifiutato ",	" Grazie, ma purtroppo devo declinare l'offerta ");
		conversationServ.createConversation(c);
		return "redirect:/BackStage/Eventi";
	}

	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id, Model model) {
		Evento v = eventoServ.findEventoById(id);
		Locale l = localeServ.findLocaleByUser(utente);
		List<Evento> eventi = new ArrayList<Evento>(l.getEventi());
		List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
		List<Gruppo> listaGruppi = new ArrayList<Gruppo>(v.getGruppo());
		model.addAttribute("evento", v);
		model.addAttribute("eventi", eventi);
		model.addAttribute("nomeGruppo", listaGruppi.get(0).getNomeGruppo());
		model.addAttribute("tipologia", tipologia);
		model.addAttribute("locale", l);
		return "modificaGruppoEventi.loggato";
		
	}

	@RequestMapping(value = "/updateEvento", method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute("evento") Evento evento,
								@RequestParam("nomeLocale") String nomeLocale,
								@RequestParam("immagine") CommonsMultipartFile immagine,
								Model model) {
		
		String[] ragioneSociale = FacilityTool.splitResultBySeparator(nomeLocale);
		Locale localeScelto = localeServ.findLocaleByCoord(ragioneSociale[0], ragioneSociale[1], ragioneSociale[2]);
		TipologiaEvento tipoEvento = tipologiaService.getTipologiaEventoById(evento.getTipologia_Eventi().getId());
		Gruppo g = gruppoServ.findGruppoByUtente(utente);
		Evento eventoModificato = eventoServ.buildEventForUpdate(evento, localeScelto, g, tipoEvento, immagine);
		eventoServ.updateEvent(eventoModificato);
		gruppoServ.update(g);
		return "redirect:/BackStage/Eventi";
	}



	@RequestMapping(value = "/get_locals_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getCountryList(
			@RequestParam("term") String query) {

		List<Locale>countryList = new ArrayList<Locale>(
				localeServ.findLocaleByName(query));
		Iterator<Locale> i = countryList.iterator();
		List<String> listaLocali = new ArrayList<String>();
		while (i.hasNext()) {
			Locale v = i.next();
			listaLocali.add(v.getNomeLocale() + "::" + v.getIndirizzo() + "::"
					+ v.getCitta());
		}
		return listaLocali;
	}

}
