package it.univaq.mwt.presentation;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.CategoriaService;
import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.VideoService;
import it.univaq.mwt.business.form.local.FormEvento;
import it.univaq.mwt.business.form.local.FormFotoAlbum;
import it.univaq.mwt.business.form.local.FormFotoProfilo;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canale;
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
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/Privee")
public class ControllerLocale {
	@Autowired
	private Utente utente;
	@Autowired
	GruppoService gruppoService;
	@Autowired
	CategoriaService categoriaServ;
	@Autowired
	GruppoDiRiferimentoService gruppoDiRiferimentoService;
	@Autowired
	AlbumFotograficoService albumFotograficoService;
	@Autowired
	VideoService videoService;
	@Autowired
	AlbumService albumService;
	@Autowired
	FotoService fotoService;
	@Autowired
	CanzoneService canzoneService;
	@Autowired
	EventoService eventoService;
	Evento eventoDaModificare = new Evento(0);
	Set<Gruppo> groupP; // Tiene traccia dei gruppi per evento durante la
						// modifica
	List<Gruppo> countryList;
	@Autowired
	LocaleService localeService;
	@Autowired
	TipologiaEventoService tipologiaService;
	@Autowired
	ConversationService conversationService;

	@RequestMapping("/")
	public String welcome(Model model) {
		Locale viewLocal = localeService.findLocaleByUser(utente);
		model.addAttribute("locale", viewLocal);
		String[] title = FacilityTool.splitName(viewLocal.getNomeLocale());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		Canale channel = viewLocal.getCanale();
		model.addAttribute("canali", channel);
		return "local.loggato";
	}

	@RequestMapping("/updateLocale")
	private String updateLocale(@ModelAttribute("locale") Locale locale) {
		Locale viewLocale = localeService.findLocaleByUser(utente);
		localeService.buildInfoLocale(viewLocale, locale);
		localeService.update(viewLocale);
		return "redirect:/Privee/";
	}

	@RequestMapping("/Utente")
	private String utenteMod(Model model) {
		model.addAttribute("locale", utente);
		return "localeUtente.loggato";
	}

	@RequestMapping(value = "/updateUtente", method = RequestMethod.POST)
	private String updateUtente(@ModelAttribute("locale") Locale locale, Model model) {
		Locale l = localeService.findLocaleByUser(utente);
		localeService.buildInfoUtente(l, locale);
		localeService.update(l);
		return "redirect:/Privee/Utente";
	}

	@RequestMapping("/Multimedia")
	private String multimedia(Model model) {

		Locale l = localeService.findLocaleByUser(utente);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(
				l.getAlbumFotografico());
		List<Video> videos = new ArrayList<Video>(l.getVideo());

		model.addAttribute("albums", albums);
		model.addAttribute("videos", videos);

		model.addAttribute("formFotoProfilo", new FormFotoProfilo());
		model.addAttribute("formFoto", new FormFotoAlbum());
		model.addAttribute("formVideo", new Video());
		return "localeMultimedia.loggato";
	}

	@RequestMapping("/updateMultimedia/ProfileImage")
	private String updateFotoProfile(@ModelAttribute FormFotoProfilo formFotoProfilo,
			Model model) {
		Locale l = localeService.findLocaleByUser(utente);
		Foto f = new Foto();
		try {
			SaveFile.savePhotoBlobGeneral(formFotoProfilo, f, utente.getId(),
					"ProfileImage", "Immagine di Profilo");
			f = localeService.addPhotoProfile(l, f);
			fotoService.insertFoto(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/Privee/Multimedia";
	}

	@RequestMapping("/updateMultimedia/AlbumPhoto")
	private String updateAlbumPhoto(@ModelAttribute FormFotoAlbum formFotoAlbum,
			Model model) {
		Locale l = localeService.findLocaleByUser(utente);
		localeService.buildAlbumFoto(formFotoAlbum, l);
		return "redirect:/Privee/Multimedia";
	}

	@RequestMapping("/updateMultimedia/Video")
	private String updateVideo(@ModelAttribute Video video, Model model) {
		Locale l = localeService.findLocaleByUser(utente);
		Video v = videoService.buildVideoInfo(l, video);
		videoService.insertVideo(v);
		return "redirect:/Privee/Multimedia";
	}

	@RequestMapping(value = "/deleteVideo/{id}")
	public String deleteVideo(@PathVariable int id) {
		videoService.deleteVideo(id);
		return "redirect:/Privee/Multimedia";
	}

	@RequestMapping("/Eventi")
	private String eventi(Model model) {
		Locale l = localeService.findLocaleByUser(utente);
		List<Evento> eventi = new ArrayList<Evento>(l.getEventi());
		model.addAttribute("eventi", eventi);
		List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		model.addAttribute("evento", new Evento());
		model.addAttribute("locale", l);
		return "localeEventi.loggato";
	}

	@RequestMapping(value = "/updateEvento", method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute("evento") Evento evento,
								@RequestParam("nomeGruppo") String nomeGruppo,
								@RequestParam("immagine") CommonsMultipartFile immagine,
								Model model) {
		Gruppo gruppoScelto = gruppoService.findGruppoByCorrectName(nomeGruppo);
		Locale l = localeService.findLocaleByUser(utente);
		
		TipologiaEvento tipoEvento = tipologiaService.getTipologiaEventoById(evento.getTipologia_Eventi().getId());
		Evento eventoModificato = eventoService.buildEventForUpdate(evento, l,nomeGruppo,tipoEvento, immagine);
		eventoService.updateEvent(eventoModificato);
		gruppoService.update(gruppoScelto);
		return "redirect:/Privee/Eventi";
	}

	@RequestMapping(value = "/addEvento", method = RequestMethod.POST)
	private String addEvento(@ModelAttribute("evento") Evento evento,
							 @RequestParam("nomeGruppo") String nomeGruppo,
							 @RequestParam("immagine") CommonsMultipartFile immagine,
							 Model model) {
		Gruppo gruppoScelto = gruppoService.findGruppoByCorrectName(nomeGruppo);
		TipologiaEvento tipoEvento = tipologiaService.getTipologiaEventoById(evento.getTipologia_Eventi().getId());
		Locale l = localeService.findLocaleByUser(utente);
		Evento toStoreEvent = eventoService.buildEventoInfo(evento,l,gruppoScelto,tipoEvento,immagine);
		gruppoService.update(gruppoScelto);
//		eventoService.insertEvento(toStoreEvent);
		return "redirect:/Privee/Eventi";
	}

	@RequestMapping(value = "/get_groups_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getGroupsList(@RequestParam("term") String query) {

		this.countryList = new ArrayList<Gruppo>(gruppoService.findGruppoByName(query));
		Iterator<Gruppo> i = countryList.iterator();
		List<String> listaGruppi = new ArrayList<String>();
		while (i.hasNext()) {
			Gruppo v = i.next();
			listaGruppi.add(v.getNomeGruppo());
		}
		return listaGruppi;
	}

	@RequestMapping("/cancelEvent/{id}")
	public String cancelEvent(@PathVariable("id") int id) {
		Evento e = eventoService.findEventoById(id);
		e.setStatus(e.getStatus() - 10);
		eventoService.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}

	@RequestMapping("/activateEvent/{id}")
	public String activateEvent(@PathVariable("id") int id) {
		Evento e = eventoService.findEventoById(id);
		e.setStatus(e.getStatus() + 10);
		eventoService.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}

	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id, Model model) {
		Evento v = eventoService.findEventoById(id);
		model.addAttribute("evento", v);
		Locale l = localeService.findLocaleByUser(utente);
		List<Evento> eventi = new ArrayList<Evento>(l.getEventi());
		model.addAttribute("eventi", eventi);
		List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
		List<Gruppo> listaGruppi = new ArrayList<Gruppo>(v.getGruppo());
		model.addAttribute("nomeGruppo", listaGruppi.get(0).getNomeGruppo());
		model.addAttribute("tipologia", tipologia);
		model.addAttribute("locale", l);
		return "modificalocaleEventi.loggato";
	}

	@RequestMapping(value = "/deletePhoto/{id}")
	public String deletePhoto(@PathVariable int id) {
		fotoService.deleteFotoById(id);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>();
		albums = albumFotograficoService.getAllPhotoAlbumsByGroupId(utente.getId());

		Iterator<AlbumFotografico> i = albums.iterator();
		while (i.hasNext()) {
			AlbumFotografico alb = i.next();
			int emptyAlbums = albumFotograficoService.emptyAlbumFotografico(alb);

			if (emptyAlbums < 1) {
				albumFotograficoService.removeAlbumFotografico(alb.getId());
			}
		}

		return "redirect:/Privee/Multimedia";
	}
}
