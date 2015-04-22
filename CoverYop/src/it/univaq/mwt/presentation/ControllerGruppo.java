package it.univaq.mwt.presentation;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.VideoService;
import it.univaq.mwt.business.form.group.FormEvento;
import it.univaq.mwt.business.form.group.FormFoto;
import it.univaq.mwt.business.form.group.FormGruppo;
import it.univaq.mwt.business.form.group.FormMultimedia;
import it.univaq.mwt.business.form.group.FormMusica;
import it.univaq.mwt.business.form.group.FormUtente;
import it.univaq.mwt.business.form.group.FormVideo;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Cachet;
import it.univaq.mwt.business.model.Canale;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.GruppoDiRiferimento;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Scaletta;
import it.univaq.mwt.business.model.ServiceMusicale;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;
import it.univaq.mwt.common.utility.SaveFile;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/BackStage")
public class ControllerGruppo {
	
	@Autowired
	private Utente utente;
	@Autowired
	GruppoService gs;
	@Autowired
	GenereService gens;
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
	@Autowired
	LocaleService localeServ;
	@Autowired
	TipologiaEventoService tipologiaServ;
	@Autowired
	GenereService genereServ;
	@Autowired
	GruppoDiRiferimentoService gruppoRifServ;
	@Autowired 
	ConversationService cs;
	//Tiene Traccia delle ricerche sui locali dentro la sezione evento
	List<Locale> countryList;
	
	@RequestMapping("/")
	public String welcome(Model model) throws NamingException {
		
		//Prendo le informazioni relativi al Gruppo
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		model.addAttribute("gruppo", view_group);
		
		if (view_group == null) return null; //Inserire Controllo migliore e 404!!
		
		//Serve per Splittare il nome del Gruppo per l'header del profilo
		String[] title = view_group.getNomeGruppo().split(" ");
		if (title.length == 2){
			model.addAttribute("titolo_page_1", title[0]);
			model.addAttribute("titolo_page_2", title[1]);
		}
		
		
		List<Genere> generi = new ArrayList<Genere>();
		generi = gens.findAllGeneri();
		model.addAttribute("generi", generi);
		model.addAttribute("generi_scelti", view_group.getGeneri());
		
		List<GruppoDiRiferimento> gruppirif = new ArrayList<GruppoDiRiferimento>();
		gruppirif = gdrs.findAllGruppiDiRiferimento();
		model.addAttribute("gruppirif", gruppirif);
		model.addAttribute("gruppirif_scelti", view_group.getGruppi_rif());
		Canale channel = new Canale();
		channel = view_group.getCanale();
		model.addAttribute("canali",channel);
		
		return "profilo.loggato";
	}
	
	@RequestMapping(value= "/updateGruppo", method = RequestMethod.POST)
	private String modificaGruppo(
			@ModelAttribute("gruppo") Gruppo gruppo,
			//BindingResult bindingResult,
			Model model){
		
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		
		view_group.setCachet(gruppo.getCachet());
		view_group.setCitta(gruppo.getCitta());
		view_group.setNomeGruppo(gruppo.getNomeGruppo());
		view_group.setBiografia(gruppo.getBiografia());
		view_group.setCanale(gruppo.getCanale());
		view_group.setService(gruppo.getService());
		view_group.setCover_Band(gruppo.getCover_Band());
		if(gruppo.getGeneri() != null){
			Set<Genere> asd = gruppo.getGeneri();
			Iterator<Genere> i = asd.iterator();
			while(i.hasNext()){
				Genere a = new Genere();
				Genere temp = new Genere();
				a = i.next();
				temp = genereServ.getGenereById(Integer.parseInt(a.getGenere()));
				view_group.addGenere(temp);
			}
		}
		if(gruppo.getGruppi_rif() != null){
			Set<GruppoDiRiferimento> rif = gruppo.getGruppi_rif();
			Iterator<GruppoDiRiferimento> j = rif.iterator();
			while(j.hasNext()){
				GruppoDiRiferimento a = new GruppoDiRiferimento();
				GruppoDiRiferimento temp = new GruppoDiRiferimento();
				a = j.next();
				temp = gruppoRifServ.getGruppiDiRiferimentoById((Integer.parseInt(a.getNome())));
				view_group.addGruppi_rif(temp);
			}
		}
		gs.update(view_group);
		
		return "redirect:/BackStage/";
		
	}
	@RequestMapping("/Utente")
	private String profilo(Model model){
		
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		
		model.addAttribute("utente", view_group);
		return "profiloUtente.loggato";
	}
	@RequestMapping(value="/updateUtente", method = RequestMethod.POST)
	private String modificaUtente(@ModelAttribute("utente") Gruppo gruppo,
			//BindingResult bindingResult,
			Model model){
		
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		
		view_group.setNome(gruppo.getNome());
		view_group.setCognome(gruppo.getCognome());
		view_group.setCitta(gruppo.getCitta());
		view_group.setIndirizzo(gruppo.getIndirizzo());
		view_group.setTelefono(gruppo.getTelefono());
		view_group.setUsername(gruppo.getUsername());
		view_group.setEmail(gruppo.getEmail());
		view_group.setPassword(gruppo.getPassword());
		
		gs.update(view_group);
		
		return "redirect:/BackStage/Utente";
	}
	@RequestMapping("/Multimedia")
	private String ModificaMultimedia(@ModelAttribute("formFotoProfilo") FormFoto formFotoProfilo,
			@ModelAttribute("formFoto") FormFoto formFoto,
			@ModelAttribute("formMusica") FormMusica formMusica,
			@ModelAttribute("formVideo") FormVideo formVideo,
			Model model){
		
		int id = utente.getId();
		
		//Prendo tutti gli album fotografici e le foto
		
		//Gruppo view_gruppo = gs.findGruppoById(id);
		Gruppo view_gruppo = new Gruppo();
		view_gruppo = gs.findGruppoByUtente(utente);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(view_gruppo.getAlbumFotografico());
		
		//Prendo tutti gli album musicali
		List<Album> albumsMusic = new ArrayList<Album>(view_gruppo.getAlbums());
		//albumsMusic = albumServ.getAllAlbumsByGroupId(id);
//
//		//Prendo tutti i Video
		List<Video> videos = new ArrayList<Video>(view_gruppo.getVideo());
//		videos = videoServ.getAllVideoByGroupId(id);
		
		Foto fotoProfilo = view_gruppo.getFotoProfilo();
		
		model.addAttribute("gruppo",view_gruppo);
		model.addAttribute("fotoProfilo",fotoProfilo);
		model.addAttribute("albums",albums);
		model.addAttribute("albumsMusic",albumsMusic);
		model.addAttribute("videos",videos);
		model.addAttribute("formFotoProfilo", formFotoProfilo);
		model.addAttribute("formFoto", formFoto);
		model.addAttribute("formMusica", formMusica);
		model.addAttribute("formVideo", formVideo);
			
		return "profiloMultimedia.loggato";
	}
	
	
	@RequestMapping("/updateMultimedia")
	private String updateMultimedia(
			@RequestParam(value = "photoFileProfilo", required=false)CommonsMultipartFile photoFileProfilo,
			@RequestParam(value = "photoFile", required=false)CommonsMultipartFile[] photoFile,
			@RequestParam(value = "musicFile", required=false)CommonsMultipartFile[] musicFile,
			@RequestParam(value = "albumTitle", required=false)String albumTitle,
			@RequestParam(value = "titolo", required=false)String titolo,
			@RequestParam(value = "url", required=false)String url
			){
		
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		
		CommonsMultipartFile photoFileProfiloUploaded = null;
		photoFileProfiloUploaded = photoFileProfilo;
		if(photoFileProfiloUploaded != null){
			SaveFile sF = new SaveFile();
			Foto f = new Foto();
			
			f = sF.savePhotoProfile(photoFileProfiloUploaded, utente.getId());
			
			if(view_group.getAlbumFotografico().isEmpty()){
				
				AlbumFotografico newAlbumFoto = new AlbumFotografico();
				
				Random m = new Random();
				int rand = m.nextInt((1000 - 10)+1);
				//f.setId(rand);
				newAlbumFoto.addFoto(f);
				newAlbumFoto.setTag("profile");
				newAlbumFoto.setTitolo("Immagini del Profilo");
				Calendar calendar = new GregorianCalendar();
				Date newDate = calendar.getTime();
				newAlbumFoto.setData(newDate);
				newAlbumFoto.setIdForFoto();
				newAlbumFoto.setLuogo(view_group.getCitta());
				view_group.addAlbumFoto(newAlbumFoto);
				view_group.setIdForAlbumFotografico();
				}
			else{
				AlbumFotografico oldAlbumFoto = new AlbumFotografico();
				oldAlbumFoto = view_group.getAlbumProfilo();
				Foto oldFoto = new Foto();
				oldFoto =  view_group.getFotoProfilo();
				oldAlbumFoto.removeFoto(oldFoto);
				fotoServ.deleteFoto(oldFoto.getId());
				view_group.getAlbumFotografico().remove(oldAlbumFoto);
				albs.removeAlbumFotografico(oldAlbumFoto.getId());
				
				AlbumFotografico newAlbumFoto = new AlbumFotografico();
				
				Random m = new Random();
				int rand = m.nextInt((1000 - 10)+1);
				f.setId(rand);
				newAlbumFoto.addFoto(f);
				newAlbumFoto.setTag("profile");
				newAlbumFoto.setTitolo("Immagini del Profilo");
				Calendar calendar = new GregorianCalendar();
				Date newDate = calendar.getTime();
				newAlbumFoto.setData(newDate);
				newAlbumFoto.setIdForFoto();
				newAlbumFoto.setLuogo(view_group.getCitta());
				
				view_group.addAlbumFoto(newAlbumFoto);  //add(newAlbumFoto);
				view_group.setIdForAlbumFotografico();
				}

		}
		
		CommonsMultipartFile[] photoFileAlbumFotograficoUploaded = null;
		photoFileAlbumFotograficoUploaded = photoFile;
		if(photoFileAlbumFotograficoUploaded != null){
			SaveFile sF = new SaveFile();
			List<Foto> f = new ArrayList<Foto>();
			
			f = sF.savePhotoAbum(photoFileAlbumFotograficoUploaded, utente.getId());
			
				AlbumFotografico newAlbumFoto = new AlbumFotografico();
				
				Random m = new Random();
				int rand = m.nextInt((1000 - 10)+1);
				for(int i=0;i<f.size();i++){
					f.get(i).setId(rand+i);
				}
				
				
				newAlbumFoto.addListFoto(f);
				newAlbumFoto.setTag("slider");
				newAlbumFoto.setTitolo("Album "+rand);
				Calendar calendar = new GregorianCalendar();
				Date newDate = calendar.getTime();
				newAlbumFoto.setData(newDate);
				newAlbumFoto.setIdForFoto();
				newAlbumFoto.setLuogo(view_group.getCitta());
				view_group.addAlbumFoto(newAlbumFoto);
				view_group.setIdForAlbumFotografico();
				
				
		}
		
		CommonsMultipartFile[] musicFileUploaded = null;
		musicFileUploaded = musicFile;
		if(musicFileUploaded != null){
			
			SaveFile sM = new SaveFile();
			List<Canzone> c = new ArrayList<Canzone>();
			c = sM.saveMusic(musicFileUploaded, utente.getId());
			Album newAlbum = new Album();
			Iterator<Canzone> i = c.iterator();
			while(i.hasNext()){
				Canzone nC = i.next();
				nC.setAlbum(newAlbum);
				newAlbum.addCanzone(nC);
			}
			//Inserisco Anno Corrente
			newAlbum.setAnno(Calendar.getInstance().get(Calendar.YEAR));
			//Aggiungo riferimento a Gruppo
			newAlbum.setGruppo(view_group);
			if(albumTitle != null){
				//Inserisco Titolo Album
				newAlbum.setNome(albumTitle);
			}else {
				newAlbum.setNome("Singolo");
			}
			view_group.addAlbum(newAlbum);
			//come scaletta di default utilizzo l'ultimo album musicale inserito
			Scaletta s = new Scaletta(100, newAlbum.getCanzoni());
			view_group.setScaletta(s);
		}
		if(titolo != null && url != null){
			Video v = new Video();
			v.setTitolo(titolo);
			v.setUrl(url);
			v.setData(new Date());
			v.setUtente(view_group);
			view_group.addVideo(v);
		}
//		videoFileUploaded = videoFile;
		

		gs.update(view_group);
		return "redirect:/BackStage/Multimedia";
	}
	@RequestMapping(value="/deletePhoto/{id}")
	public String deletePhoto(@PathVariable int id){
		fotoServ.deleteFoto(id);
		List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(); 
		albums = albs.getAllPhotoAlbumsByGroupId(utente.getId()); 
		
		Iterator<AlbumFotografico> i = albums.iterator();
		while(i.hasNext()){
			AlbumFotografico  alb =  i.next();
			int emptyAlbums = albs.emptyAlbumFotografico(alb);
			
			if (emptyAlbums < 1) {
				albs.removeAlbumFotografico(alb.getId());
			}
		}
		
		return "redirect:/BackStage/Multimedia";
	}
	
	@RequestMapping(value="/deleteSong/{id}")
	public String deleteSong(
			@PathVariable int id){
		Canzone c = canzoneServ.findCanzoneById(id);
		int albumID = c.getAlbum().getId();
		System.out.println("Album ID da cancellare=" + albumID);
		Album alb = albumServ.getAllCanzoniByAlbumId(albumID);
		canzoneServ.deleteCanzone(id);
		int emptyAlbum = albumServ.emptyAlbum(alb);
		if(emptyAlbum < 1) albumServ.deleteAlbum(albumID);
		
		return "redirect:/BackStage/Multimedia";
	}
	
	@RequestMapping(value="/deleteVideo/{id}")
	public String deleteVideo(
			@PathVariable int id){
		
		videoServ.deleteVideo(id);
		Set<Video> a = utente.getVideo();
		Iterator<Video> i = a.iterator();
		while(i.hasNext()){
			Video v = i.next();
			System.out.println("Video name" + v.getTitolo());
		}
		return "redirect:/BackStage/Multimedia";
	}
	
	@RequestMapping("/Tour")
	private String ModificaTour(){
		
		return "utente.loggato";
	}
	
	@RequestMapping("/Eventi")
	private String ModificaEventi(@ModelAttribute("formEvento") FormEvento formEvento,
			Model model){
		
		if(this.eventoDaModificare.getId() != 0){
			
			formEvento.setDataEvento(this.eventoDaModificare.getData());
			formEvento.setDescrizione(this.eventoDaModificare.getDescrizione());
			formEvento.setLocale(this.eventoDaModificare.getLocale().getNomeLocale());
			formEvento.setNome(this.eventoDaModificare.getNome());
			formEvento.setOrarioFine(this.eventoDaModificare.getOrarioFine());
			formEvento.setOrarioInizio(this.eventoDaModificare.getOrarioInizio());
			formEvento.setPrezzo(this.eventoDaModificare.getPrezzo());
			formEvento.setTipologia_Eventi(this.eventoDaModificare.getTipologia_Eventi().getId());
			model.addAttribute("eventoMod", formEvento);
			model.addAttribute("idEvento",this.eventoDaModificare.getId());
		}
		int id = utente.getId();
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		
		List<Evento> events = new ArrayList<Evento>(view_group.getEventi());
		
		model.addAttribute("eventi", events);
		model.addAttribute("formEvento", formEvento);
		List<TipologiaEvento> tipologia = tipologiaServ.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		return "profiloEventi.loggato";
	}
	@RequestMapping(value="/addEvento",
			method = RequestMethod.POST)
	private String addEvento(@ModelAttribute FormEvento formEvento, 
			Model model){
		//Creo Evento
		Evento ev = new Evento();
		ev.setNome(formEvento.getNome());
		//Prendo la lista dei locali cercati
		List<Locale> localiCercati = this.countryList;
		Iterator<Locale> i = localiCercati.iterator();
		while(i.hasNext()){
			Locale l = i.next();
			//Prendo Evento scelto
			if(l.getNomeLocale().compareTo(formEvento.getLocale()) == 0){
				//Inserisco Riferimento Locale Dentro Evento
				ev.setLocale(l);
				break;
			}
			
		}
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
		TipologiaEvento tipologia_Eventi = new TipologiaEvento();
		tipologia_Eventi.setId(formEvento.getTipologia_Eventi());
		ev.setTipologia_Eventi(tipologia_Eventi);
		ev.setStatus(10);
		ev.setLuogo(ev.getLocale().getCitta());
		//Prendo Oggetto del mio Gruppo
		Gruppo g = gs.findGruppoById(utente.getId());
		//Aggiungo Evento al Gruppo
		g.addEvento(ev);
		//Persisto Oggetto con modifiche
		gs.update(g);
		return "redirect:/BackStage/Eventi";
	}
	@RequestMapping("/newEvent")
	private String nuovoEvento(){
		this.eventoDaModificare = new Evento();
		this.eventoDaModificare.setId(0);
		return "redirect:/BackStage/Eventi";
	}
	@RequestMapping("/EventoModifica/{id}")
	private String modificaEvento(@PathVariable int id){
		Evento v = eventoServ.findEventoById(id);
		this.eventoDaModificare = v;
		return "redirect:/BackStage/Eventi";
	}
	@RequestMapping(value="/updateEvento",
			method = RequestMethod.POST)
	private String updateEvento(@ModelAttribute FormEvento eventoMod,
			Model model){
		
		Evento v = eventoServ.findEventoById(eventoMod.getIdEvento());
		v.setData(eventoMod.getDataEvento());
		v.setDescrizione(eventoMod.getDescrizione());
		List<Locale> localiCercati = this.countryList;
		Iterator<Locale> i = localiCercati.iterator();
		while(i.hasNext()){
			Locale l = i.next();
			System.out.println(l.getNomeLocale());
			//Prendo Evento scelto
			if(l.getNomeLocale().compareTo(eventoMod.getLocale()) == 0){
				//Inserisco Riferimento Locale Dentro Evento
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
		Gruppo g = gs.findGruppoById(utente.getId());
		g.printEvents();
		System.out.println("---");
		g.updateEvento(v);
		g.printEvents();
		gs.update(g);
		return "redirect:/BackStage/newEvent";
	}
	
	@RequestMapping("/accettaEvento/{id}")
	private String accettaEvento(@PathVariable int id){
		Evento v = eventoServ.findEventoById(id);
		v.setStatus(11);
		eventoServ.updateEvent(v);
		return "redirect:/BackStage/Eventi";
	}
	
	@RequestMapping("/rifiutaEvento/{id}")
	private String rifiutaEvento(@PathVariable int id){
		Evento v = eventoServ.findEventoById(id);
		Conversation c = new Conversation();
		v.setStatus(12);
		eventoServ.updateEvent(v);
		c = utente.sendMessage(v.getLocale(), " Evento Rifiutato ", " Grazie, ma purtroppo devo declinare l'offerta ");
		cs.createConversation(c);
		return "redirect:/BackStage/Eventi";
	}
	
	//Questa FUnzione Restituisce in Get, tramite Ajax la lista di tutti i Locali che iniziano con "term"
	@RequestMapping(value = "/get_locals_list", 
			method = RequestMethod.GET,
			produces="application/json")
	public @ResponseBody List<String> getCountryList(@RequestParam("term") String query) {
	
	this.countryList = new ArrayList<Locale>(localeServ.findLocaleByName(query));
	
	Iterator<Locale>i = countryList.iterator();
	List<String> listaLocali = new ArrayList<String>();
	while(i.hasNext()){
		Locale v = i.next();
		listaLocali.add(v.getNomeLocale());
	}
	
	return listaLocali;
	}

}

