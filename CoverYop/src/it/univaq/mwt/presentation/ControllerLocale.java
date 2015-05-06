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
import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
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
	Set<Gruppo> groupP; //Tiene traccia dei gruppi per evento durante la modifica
	List<Gruppo> countryList;
	@Autowired
	LocaleService localeService;
	@Autowired
	TipologiaEventoService tipologiaService;
	@Autowired 
	ConversationService conversationService;
	
	@RequestMapping("/")
	public String welcome(Model model){
		Locale viewLocal = localeService.findLocaleByUser(utente);
		model.addAttribute("locale", viewLocal);
		String[] title = FacilityTool.splitName(viewLocal.getNomeLocale());		
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);	
		Canale channel = viewLocal.getCanale();
		model.addAttribute("canali",channel);
		return "local.loggato";
	}
	@RequestMapping("/updateLocale")
	private String updateLocale(@ModelAttribute("locale") Locale locale){
		Locale viewLocale = localeService.findLocaleByUser(utente);
		localeService.buildInfoLocale(viewLocale, locale);
		localeService.update(viewLocale);
		return "redirect:/Privee/";
	}
	@RequestMapping("/Utente")
	private String utenteMod(Model model){
		model.addAttribute("locale", utente);
		return "localeUtente.loggato";
	}
	@RequestMapping(value="/updateUtente", method = RequestMethod.POST)
	private String updateUtente(@ModelAttribute("locale") Locale locale, Model model){
		Locale l = localeService.findLocaleByUser(utente);
		localeService.buildInfoUtente(l,locale);
		localeService.update(l);
		return "redirect:/Privee/Utente";
	}
	
	@RequestMapping("/Multimedia")
	private String multimedia(Model model){
		
		Locale l = localeService.findLocaleByUser(utente);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(l.getAlbumFotografico());
		List<Video> videos = new ArrayList<Video>(l.getVideo());
		
		model.addAttribute("albums",albums);
		model.addAttribute("videos",videos);
		
		model.addAttribute("formFotoProfilo", new FormFotoProfilo());
		model.addAttribute("formFoto", new FormFotoAlbum());
		model.addAttribute("formVideo", new Video());
		return "localeMultimedia.loggato";
	}
	
	@RequestMapping("/updateMultimedia/ProfileImage")
	private String updateFotoProfile(@ModelAttribute FormFotoProfilo formFotoProfilo, Model model){
		Locale l = localeService.findLocaleByUser(utente);
		Foto f = new Foto();
		try {
			SaveFile.savePhotoBlobGeneral(formFotoProfilo, f, utente.getId(),"ProfileImage", "Immagine di Profilo");
			f = localeService.addPhotoProfile(l, f);
			fotoService.insertFoto(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/Privee/Multimedia";
	}

	
	
		
	@RequestMapping("/updateMultimedia/AlbumPhoto")
	private String updateAlbumPhoto(@ModelAttribute FormFotoAlbum formFotoAlbum, Model model){
		Locale l = localeService.findLocaleByUser(utente);
		localeService.buildAlbumFoto(formFotoAlbum, l);
		return "redirect:/Privee/Multimedia";
	}
	@RequestMapping("/updateMultimedia/Video")
	private String updateVideo(@ModelAttribute Video video, Model model){
		Locale l = localeService.findLocaleByUser(utente);
		Video v = videoService.buildVideoInfo(l,video);
		videoService.insertVideo(v);
		return "redirect:/Privee/Multimedia";
	}

	@RequestMapping(value="/deleteVideo/{id}")
	public String deleteVideo(@PathVariable int id){
		videoService.deleteVideo(id);
		return "redirect:/Privee/Multimedia";
	}
	@RequestMapping("/Eventi")
	private String eventi(@ModelAttribute("formEvento") FormEvento formEvento,Model model){
		
		if(this.eventoDaModificare.getId() != 0){
			
			formEvento.setDataEvento(this.eventoDaModificare.getData());
			formEvento.setDescrizione(this.eventoDaModificare.getDescrizione());
			this.groupP = this.eventoDaModificare.getGruppo();
			List<Gruppo> g = new ArrayList<Gruppo>(this.groupP);
			formEvento.setGruppo(g.get(0).getNomeGruppo());
			formEvento.setNome(this.eventoDaModificare.getNome());
			formEvento.setOrarioFine(this.eventoDaModificare.getOrarioFine());
			formEvento.setOrarioInizio(this.eventoDaModificare.getOrarioInizio());
			formEvento.setPrezzo(this.eventoDaModificare.getPrezzo());
			formEvento.setTipologia_Eventi(this.eventoDaModificare.getTipologia_Eventi().getId());
			model.addAttribute("eventoMod", formEvento);
			model.addAttribute("idEvento",this.eventoDaModificare.getId());
		}
		
		
		
		Locale l = localeService.findLocaleByUser(utente);
		List<Evento> eventi = new ArrayList<Evento>(eventoService.findGruppoByEvent(l.getEventi()));
		model.addAttribute("eventi", eventi);
		List<TipologiaEvento> tipologia = tipologiaService.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		
		return "localeEventi.loggato";
	}
	@RequestMapping(value="/updateEvento",
			method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute FormEvento eventoMod){
		
		this.eventoDaModificare = eventoService.findEventoById(eventoMod.getIdEvento());
		
		
		this.eventoDaModificare.setData(eventoMod.getDataEvento());
		this.eventoDaModificare.setDescrizione(eventoMod.getDescrizione());
		this.eventoDaModificare.setGruppo(this.groupP);
		this.eventoDaModificare.setNome(eventoMod.getNome());
		this.eventoDaModificare.setOrarioFine(eventoMod.getOrarioFine());
		this.eventoDaModificare.setOrarioInizio(eventoMod.getOrarioInizio());
		this.eventoDaModificare.setPrezzo(eventoMod.getPrezzo());
		TipologiaEvento tipologia_Eventi = new TipologiaEvento();
		tipologia_Eventi.setId(eventoMod.getTipologia_Eventi());
		this.eventoDaModificare.setTipologia_Eventi(tipologia_Eventi);
		
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping(value="/addEvento",
			method = RequestMethod.POST)
	private String addEvento(@ModelAttribute FormEvento formEvento, 
			Model model){
		
		//Creo Evento
		Evento ev = new Evento();
		ev.setNome(formEvento.getNome());
		Locale view_local = localeService.findLocaleByUser(utente);
		//Aggiungo desciriozne evento
		ev.setDescrizione(formEvento.getDescrizione());
		
		//Date date = new SimpleDateFormat("dd/MM/yyyy").parse(formEvento.getDataEvento());
		//Aggiungo Data
		ev.setData(formEvento.getDataEvento());
		
		//Salvo Foto nel FS e dentro un Oggetto
		CommonsMultipartFile photoFileUploaded = formEvento.getLocandina();
		
		if(photoFileUploaded != null){
			SaveFile sF = new SaveFile();
			Foto f = new Foto();
			try {
				f = sF.savePhoto(photoFileUploaded, utente.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Salvo oggetto Foto
			fotoService.insertFoto(f);
			
			ev.setLocandina(f.getUrl());//setto l'url per gestire le immagini con i path
			
			byte [] tempByte = photoFileUploaded.getBytes();
			ev.setLocandinaBlob(tempByte);//setto direttamente il blob nella tabella
		}
		
		
		//Aggiungo Dati all'oggetto Evento
		ev.setOrarioFine(formEvento.getOrarioFine());
		ev.setOrarioInizio(formEvento.getOrarioInizio());
		ev.setPrezzo(formEvento.getPrezzo());
		ev.setLocale(view_local);
		TipologiaEvento tipologia_Eventi = new TipologiaEvento();
		tipologia_Eventi.setId(formEvento.getTipologia_Eventi());
		ev.setTipologia_Eventi(tipologia_Eventi);
		ev.setStatus(10);
		ev.setLuogo(ev.getLocale().getCitta());
		
		//Prendo Oggetto del Gruppo
		List<Gruppo> gruppiCercati = this.countryList;
		Iterator<Gruppo> i = gruppiCercati.iterator();
		Gruppo gruppo = new Gruppo();
		//Creo La conversazione Per fare la proposta formale di creazione di un evento
		Conversation c = new Conversation();
		c.setData(new GregorianCalendar());
		c.setMittente(view_local);
		// Status 10 = Send Proposta, stato Pending
		// Status 11 = Proposta Accettata
		// Status 12 = Proposta Rifiutata
		c.setStatus(10);
		c.setTitolo("Proposta Evento");
		while(i.hasNext()){
			gruppo = i.next();
			//Prendo Evento scelto
			if(gruppo.getNomeGruppo().compareTo(formEvento.getGruppo()) == 0){
			//Inserisco Riferimento Locale Dentro Evento
				gruppo.addEvento(ev);
				c.setDestinatario(gruppo);
				c = utente.sendMessage(gruppo,"Proposta Evento", "Ciao Voglio Proporti un Evento Chiamato" + ev.getNome());
				conversationService.createConversation(c);
				break;
			}
					
		}
		
		//Aggiungo Evento al Gruppo
		
		//Persisto Oggetto con modifiche
		gruppoService.update(gruppo);
		this.eventoDaModificare = new Evento();
		this.eventoDaModificare.setId(0);
		return "redirect:/Privee/Eventi";
	}
	
	
	
	@RequestMapping(value = "/get_groups_list", 
			method = RequestMethod.GET,
			produces="application/json")
	public @ResponseBody List<String> getGroupsList(@RequestParam("term") String query) {
	
	this.countryList = new ArrayList<Gruppo>(gruppoService.findGruppoByName(query));
	
	Iterator<Gruppo>i = countryList.iterator();
	List<String> listaGruppi = new ArrayList<String>();
	while(i.hasNext()){
		Gruppo v = i.next();
		listaGruppi.add(v.getNomeGruppo());
	}
	
	return listaGruppi;
	}
	
	@RequestMapping("/cancelEvent/{id}")
	public String cancelEvent(@PathVariable("id") int id){
		Evento e = eventoService.findEventoById(id);
		e.setStatus(e.getStatus()-10);
		eventoService.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping("/activateEvent/{id}")
	public String activateEvent(@PathVariable("id") int id){
		Evento e = eventoService.findEventoById(id);
		e.setStatus(e.getStatus()+10);
		eventoService.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id){
		Evento v = eventoService.findEventoById(id);
		this.eventoDaModificare = v;
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping(value="/deletePhoto/{id}")
	public String deletePhoto(@PathVariable int id){
		fotoService.deleteFotoById(id);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(); 
		albums = albumFotograficoService.getAllPhotoAlbumsByGroupId(utente.getId()); 
		
		Iterator<AlbumFotografico> i = albums.iterator();
		while(i.hasNext()){
			AlbumFotografico  alb =  i.next();
			int emptyAlbums = albumFotograficoService.emptyAlbumFotografico(alb);
			
			if (emptyAlbums < 1) {
				albumFotograficoService.removeAlbumFotografico(alb.getId());
			}
		}
		
		return "redirect:/Privee/Multimedia";
	}
}

