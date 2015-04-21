package it.univaq.mwt.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.CategoriaService;
import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.VideoService;
import it.univaq.mwt.business.form.group.FormFoto;
import it.univaq.mwt.business.form.group.FormMusica;
import it.univaq.mwt.business.form.group.FormVideo;
import it.univaq.mwt.business.form.local.FormEvento;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canale;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Categoria;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;
import it.univaq.mwt.common.utility.SaveFile;

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
	GruppoService gs;
	@Autowired
	CategoriaService categoriaServ;
	@Autowired
	GruppoDiRiferimentoService gdrs;
	@Autowired
	AlbumFotograficoService albs;
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
	Set<Gruppo> groupP; //Tiene traccia dei gruppi per evento durante la modifica
	List<Gruppo> countryList;
	@Autowired
	LocaleService localeServ;
	@Autowired
	TipologiaEventoService tipologiaServ;
	@Autowired 
	ConversationService cs;
	
	@RequestMapping("/")
	public String welcome(Model model){
		
		Locale view_local = localeServ.findLocaleByUser(utente);
		model.addAttribute("locale", view_local);
		
		
		
		Canale channel = new Canale();
		channel = view_local.getCanale();
		model.addAttribute("canali",channel);
		 
		return "local.loggato";
	}
	@RequestMapping("/updateLocale")
	private String updateLocale(@ModelAttribute Locale locale){
		
		localeServ.update(locale);
		return "redirect:/Privee/";
	}
	@RequestMapping("/Utente")
	private String utenteMod(Model model){
		Locale view_local = localeServ.findLocaleByUser(utente);
		model.addAttribute("locale", view_local);
		
		return "localeUtente.loggato";
	}
	@RequestMapping(value="/updateUtente", method = RequestMethod.POST)
	private String updateUtente(@ModelAttribute Locale locale, Model model){
		
		Locale l = localeServ.findLocaleByUser(utente);
		l.setNome(locale.getNome());
		l.setCitta(locale.getCitta());
		l.setTelefono(locale.getTelefono());
		l.setUsername(locale.getUsername());
		l.setEmail(locale.getEmail());
		l.setPassword(locale.getPassword());
		localeServ.update(l);
		return "redirect:/Privee/Utente";
	}
	
	@RequestMapping("/Multimedia")
	private String multimedia(@ModelAttribute("formFotoProfilo") FormFoto formFotoProfilo,
//			@ModelAttribute("formMusica") FormMusica formMusica,
			@ModelAttribute("formVideo") FormVideo formVideo,
			Model model){
		
		Locale l = new Locale();
		l = localeServ.findLocaleByUser(utente);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(l.getAlbumFotografico());
		
		List<Video> videos = new ArrayList<Video>(l.getVideo());
		
		
		
		model.addAttribute("albums",albums);
//		model.addAttribute("albumsMusic",null);
		model.addAttribute("videos",videos);//matteo
		model.addAttribute("formFotoProfilo", formFotoProfilo);
//		model.addAttribute("formMusica", formMusica);
		model.addAttribute("formVideo", formVideo);
		return "localeMultimedia.loggato";
	}
	
	
	@RequestMapping("/updateMultimedia")
	private String updateMultimedia(
			@RequestParam(value = "photoFileProfilo", required=false)CommonsMultipartFile photoFileProfilo,
			//@RequestParam(value = "photoFile", required=false)CommonsMultipartFile[] photoFile,
			//@RequestParam(value = "albumTitle", required=false)String albumTitle,
			@RequestParam(value = "titolo", required=false)String titolo,
			@RequestParam(value = "url", required=false)String url
			){
		
		
		int id = utente.getId();
		Locale view_local = new Locale();
		view_local = localeServ.findLocaleById(id); 
		
		
		
		CommonsMultipartFile photoFileProfiloUploaded = null;
		photoFileProfiloUploaded = photoFileProfilo;
		if(photoFileProfiloUploaded != null){
			SaveFile sF = new SaveFile();
			Foto f = new Foto();
			System.out.println("nome file:"+photoFileProfiloUploaded.getOriginalFilename());
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			f = sF.savePhotoProfile(photoFileProfiloUploaded, utente.getId());
			
			System.out.println("photoFileProfiloUploaded "+photoFileProfiloUploaded.getOriginalFilename());
			
			if(view_local.getAlbumFotografico().isEmpty()){
				System.out.println("ALBUM NON ESISTE");
				
				AlbumFotografico newAlbumFoto = new AlbumFotografico();
				
				Random m = new Random();
				int rand = m.nextInt((1000 - 10)+1);
				//f.setId(rand);
				newAlbumFoto.addFoto(f);
				newAlbumFoto.setTag("profile");
				newAlbumFoto.setTitolo("Immagini del Profilo Locale");
				Calendar calendar = new GregorianCalendar();
				Date newDate = calendar.getTime();
				newAlbumFoto.setData(newDate);
				newAlbumFoto.setIdForFoto();
				newAlbumFoto.setLuogo(view_local.getCitta());
				view_local.addAlbumFoto(newAlbumFoto);
				view_local.setIdForAlbumFotografico();
				}
			else{
				System.out.println("ALBUM  ESISTE");
				AlbumFotografico oldAlbumFoto = new AlbumFotografico();
				oldAlbumFoto = view_local.getAlbumProfilo();
				Foto oldFoto = new Foto();
				oldFoto =  view_local.getFotoProfilo();
				oldAlbumFoto.removeFoto(oldFoto);
				fotoServ.deleteFoto(oldFoto.getId());
				view_local.getAlbumFotografico().remove(oldAlbumFoto);
				albs.removeAlbumFotografico(oldAlbumFoto.getId());
				
				AlbumFotografico newAlbumFoto = new AlbumFotografico();
				
				Random m = new Random();
				int rand = m.nextInt((1000 - 10)+1);
				//f.setId(rand);
				newAlbumFoto.addFoto(f);
				newAlbumFoto.setTag("profile");
				newAlbumFoto.setTitolo("Immagini del Profilo Locale");
				Calendar calendar = new GregorianCalendar();
				Date newDate = calendar.getTime();
				newAlbumFoto.setData(newDate);
				newAlbumFoto.setIdForFoto();
				newAlbumFoto.setLuogo(view_local.getCitta());
				
				view_local.addAlbumFoto(newAlbumFoto);  //add(newAlbumFoto);
				view_local.setIdForAlbumFotografico();
				}

		}
		if(titolo != null && url != null){
			Video v = new Video();
			v.setTitolo(titolo);
			v.setUrl(url);
			v.setData(new Date());
			v.setUtente(view_local);
			view_local.addVideo(v);
		}
//		videoFileUploaded = videoFile;
		
		localeServ.update(view_local);
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
		
		
		
		Locale l = localeServ.findLocaleByUser(utente);
		List<Evento> eventi = new ArrayList<Evento>(eventoServ.findGruppoByEvent(l.getEventi()));
		model.addAttribute("eventi", eventi);
		List<TipologiaEvento> tipologia = tipologiaServ.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		
		return "localeEventi.loggato";
	}
	@RequestMapping(value="/updateEvento",
			method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute FormEvento eventoMod){
		
		this.eventoDaModificare = eventoServ.findEventoById(eventoMod.getIdEvento());
		
		
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
		Locale view_local = localeServ.findLocaleByUser(utente);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Salvo oggetto Foto
			fotoServ.insertFoto(f);
			ev.setLocandina(f.getUrl());
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
				cs.createConversation(c);
				break;
			}
					
		}
		
		//Aggiungo Evento al Gruppo
		
		//Persisto Oggetto con modifiche
		gs.update(gruppo);
		this.eventoDaModificare = new Evento();
		this.eventoDaModificare.setId(0);
		return "redirect:/Privee/Eventi";
	}
	
	
	
	@RequestMapping(value = "/get_groups_list", 
			method = RequestMethod.GET,
			produces="application/json")
	public @ResponseBody List<String> getGroupsList(@RequestParam("term") String query) {
	
	this.countryList = new ArrayList<Gruppo>(gs.findGruppoByName(query));
	
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
		Evento e = eventoServ.findEventoById(id);
		e.setStatus(10);
		eventoServ.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping("/activateEvent/{id}")
	public String activateEvent(@PathVariable("id") int id){
		Evento e = eventoServ.findEventoById(id);
		e.setStatus(11);
		eventoServ.updateEvent(e);
		return "redirect:/Privee/Eventi";
	}
	
	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id){
		Evento v = eventoServ.findEventoById(id);
		this.eventoDaModificare = v;
		return "redirect:/Privee/Eventi";
	}
}

