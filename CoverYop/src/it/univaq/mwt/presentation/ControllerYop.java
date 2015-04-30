package it.univaq.mwt.presentation;

//import it.univaq.mwt.business.model.Gruppo;


import it.univaq.mwt.common.utility.FacilityTool;
import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;


import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.RuoloService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canale;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Categoria;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.GruppoDiRiferimento;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Ruolo;
import it.univaq.mwt.business.model.Scaletta;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;
import it.univaq.mwt.common.spring.UserDetailsImpl;
import it.univaq.mwt.common.utility.ConversionUtility;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/")
public class ControllerYop {

	@Autowired 
	CanzoneService cs;
	@Autowired
	AlbumService fs;
	@Autowired
	GruppoService gs;
	@Autowired
	LocaleService ls;
	@Autowired
	EventoService es;
	@Autowired
	GruppoDiRiferimentoService gdr;
	@Autowired
	AlbumFotograficoService as;
	@Autowired
	GenereService ges;
	@Autowired
	RuoloService rs;
	@Autowired
	FotoService fotoserv;
	@Autowired
	GruppoValidator gv;
	@Autowired
	LocaleValidator lv;

	@RequestMapping("/")
	public String welcome(Model model) throws NamingException {
		//ultimi artisti
		List<Gruppo> ultimiGruppi = gs.findLastSubscribed(4);
		List<Genere> generi = ges.findAllGeneri();
		List<Canzone> ultimeSong = cs.findLastSong(4);
		List<Locale> ultimiLocali = ls.findlastSubscribed(4);
		List<AlbumFotografico> ultimeGallery = as.getLastSubscribed(4);
		model.addAttribute("gruppi", ultimiGruppi);
		model.addAttribute("generiGruppi", generi);
		model.addAttribute("song", ultimeSong);
		model.addAttribute("locali", ultimiLocali);
		model.addAttribute("gallery", ultimeGallery);
		return "common.index";
	}

	@RequestMapping("/HowitWorks")
	public String howItWorks() {
		return "common.howto";
	}

	@RequestMapping("/Login")
	public String accedi() {
		return "common.login";
	}
	
	@RequestMapping("/ContactUs")
	public String contactUs() {
		return "common.contactus";
	}

	@RequestMapping("/Signup")
	public String signUp(Model model) {
		model.addAttribute("formGruppi",  new Gruppo());
		model.addAttribute("formLocali",  new Locale());
		return "common.register";
	}
	
	@RequestMapping(value="/createGroup")
	public String createGroup( @ModelAttribute("formGruppi") Gruppo gruppo, BindingResult bindingResult, Model model) throws Exception {
		gv.validate(gruppo, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("formLocali",  new Locale());
			return "common.register";
		}
		gruppo = FacilityTool.finalizeGruppoInfo(gruppo, rs);
	    gs.createGruppo(gruppo);
		return "common.index";
	}
	
	@RequestMapping("/createLocale")
	public String createLocale(@ModelAttribute("formLocali") Locale locale, BindingResult bindingResult, Model model) throws Exception {	   
		lv.validate(locale, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("formGruppi",  new Gruppo());
			return "common.register";
		}
	    locale = FacilityTool.finalizeLocaleInfo(locale, rs);
	    ls.createLocale(locale);
	    return "common.index";
	}
	
	@RequestMapping("/Cerca")
	public String cerca(@RequestParam(value = "nome", required=false)String nome, Model model){
		List<Utente> risultati = gs.SearchUsers(nome);
		List<Gruppo> risultatoGruppi = FacilityTool.splitResultG(risultati, 1);
		List<Locale> risultatoLocali = FacilityTool.splitResultL(risultati, 2);
		model.addAttribute("gruppi",risultatoGruppi);
		model.addAttribute("locali",risultatoLocali);
		List<Evento> risultatoEventi = es.findEventoByName(nome);
		model.addAttribute("eventi",risultatoEventi);
		return "common.general_search";
	}
	
	@RequestMapping("/Groups")
	public String groupHome(@RequestParam(value = "nome", required=false)String nome,
							@RequestParam(value = "citta", required=false)String citta,
							@RequestParam(value = "genere", required=false)String genere,
							Model model) {
		List<Gruppo> gruppi = gs.customSearchGruppi(nome, citta, genere);
		model.addAttribute("gruppi", gruppi);
		List<Genere> generi = ges.findAllGeneri();
		model.addAttribute("generi",generi);
		return "group.welcome";
	}
	
	@RequestMapping("/Groups/SearchResult")
	public String groupSearch(){
		
		return null;
	}

	@RequestMapping("/Group/{id}")
	public String groupProfile(@PathVariable("id") int id, Model model){
		
		Gruppo viewGroup = gs.findGruppoById(id);
		model.addAttribute("gruppo", viewGroup);
		
		String[] title = FacilityTool.splitName(viewGroup.getNomeGruppo()); 
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_1", title[1]);
		
		List<Album> discografia = new ArrayList<Album>(viewGroup.getAlbums());
		model.addAttribute("album", discografia);
		
		List<AlbumFotografico> af = new ArrayList<AlbumFotografico>(viewGroup.getAlbumFotografico());
		model.addAttribute("album_foto", af);
		
		List<Video> videos = new ArrayList<Video>(viewGroup.getVideo());
		model.addAttribute("video", videos.get(0));
		model.addAttribute("soundcloud", videos);
		
		List<Evento> eventi = new ArrayList<Evento>(viewGroup.getEventi());
		model.addAttribute("eventi", eventi);
		
		Canale channel = viewGroup.getCanale();
		model.addAttribute("canali",channel);
		
		List<Genere> generi = new ArrayList<Genere>(viewGroup.getGeneri());
		model.addAttribute("generi", generi);
		
		List<GruppoDiRiferimento> gdr = new ArrayList<GruppoDiRiferimento>(viewGroup.getGruppi_rif());
		model.addAttribute("gruppidiriferimento", gdr);
		
		Scaletta scl = viewGroup.getScaletta();
		List<Canzone> scaletta = new ArrayList<Canzone>(scl.getCanzoni());
		model.addAttribute("scaletta", scaletta);
	 
		return "group.profile";
	 }

	@RequestMapping("/Locals")
	public String localHome(@RequestParam(value = "nome", required=false)String nome,
							@RequestParam(value = "citta", required=false)String citta,
							@RequestParam(value = "tipologia", required=false)String tipologia, Model model) {
		
		List<Locale> locali = ls.customSearchLocali(nome, citta, tipologia);
		model.addAttribute("locali", locali);
		
		List<Categoria> categorie = new ArrayList<Categoria>();
		categorie = ls.getAllCategorieByLocali(locali);
		model.addAttribute("categorie", categorie);
		return "local.welcome";
	}

	@RequestMapping("/Local/{id}")
	public String localProfile(@PathVariable("id") int id, Model model){
	
	
	Locale locale = ls.findLocaleById(id);
	String[] title = FacilityTool.splitName(locale.getNomeLocale());
	model.addAttribute("titolo_page_1", title[0]);
	model.addAttribute("titolo_page_2", title[1]);

	model.addAttribute("locale",locale);
	Set<Evento> events = new HashSet<Evento>(locale.getEventi());	
	model.addAttribute("eventi", events);
	Canale channel = locale.getCanale();
	model.addAttribute("canali",channel); 
	
	Set<Foto> slideshow;
	List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(locale.getAlbumFotografico());
	slideshow = FacilityTool.getSlider(albums);
	model.addAttribute("slideshow", slideshow);
	
	List<Video> video = new ArrayList<Video>(locale.getVideo());
	model.addAttribute("video", video);

	return "local.profile";
	}

	@RequestMapping("/Group/welcome.do")
	public String groupWelcome() {
		return "group.profile";
	}
	
	@RequestMapping("/redirect")
	 public String redirectHome() {
	 	String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
	 	return FacilityTool.getLoginRedirection(role);
	 }
	
	@RequestMapping("/inbox")
	 public String inbox() {
	 	return "list.conversation";
	 }
}