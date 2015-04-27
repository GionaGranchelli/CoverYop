package it.univaq.mwt.presentation;

//import it.univaq.mwt.business.model.Gruppo;



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
	GruppoValidator gv;
	@Autowired
	LocaleValidator lv;
//	@Autowired @Qualifier("CanzoniService") @EJB
//	private CanzoniService canzoniService;
	// @Autowired ServiceProxy sp;
	// @Autowired persistenceService ps;
	// @Autowired
	// JDBCSecurityService jdbcSS;
	// @Autowired
	// JDBCUserService jdbcUS;
	// private Gruppo view_group;

	@RequestMapping("/")
	public String welcome(Model model) throws NamingException {
		
		//ultimi artisti
		
		List ultimiGruppi = gs.findLastSubscribed(4);
		List generi = ges.findAllGeneri();
		List<Canzone> ultimeSong = cs.findLastSong(4);
		
		
		List ultimiLocali = ls.findlastSubscribed(4);
		List ultimeGallery = as.getLastSubscribed(4);
		
		
		
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
	//Set<GruppoDiRiferimento> gruppiDiRiferimento = new HashSet<GruppoDiRiferimento>(gdr.findAllGruppiDiRiferimento());
	//model.addAttribute("gruppiDiRif",  gruppiDiRiferimento);

		return "common.register";
	}
	
	@RequestMapping(value="/createGroup")
	public String createGroup( @ModelAttribute("formGruppi") Gruppo gruppo, BindingResult bindingResult, Model model) throws Exception {
	
	//Random rand = new Random();
	//int randomNum = rand.nextInt((1000 - 10) + 1) + 10;//CI DEVO METTERE LA SEQUENZA
	//gruppo.setId(randomNum); //QUA DEVO SETTARE LA SEQUENZA AL POSTO DELL'ID
	
	gv.validate(gruppo, bindingResult);
	
	if (bindingResult.hasErrors()) {
		model.addAttribute("formLocali",  new Locale());
		return "common.register";
	}
		
	String address = gruppo.getCitta()+" "+gruppo.getIndirizzo();
	
	
	String latLongs[] = ConversionUtility.getLatLongPositions(address);
	float lat = Float.parseFloat(latLongs[0]);
	float lng = Float.parseFloat(latLongs[1]);
	gruppo.setLat(lat);
	gruppo.setLng(lng);
	Ruolo role = rs.getRuoloByName("group");
	gruppo.setRuolo(role);
	//String password = ConversionUtility.passwordToMd5(gruppo.getPassword());
	//gruppo.setPassword(password);
    Gruppo gpr= gs.createGruppo(gruppo);
    
		return "common.index";//poi si cambia
	}
	
	@RequestMapping("/createLocale")
	public String createLocale(@ModelAttribute("formLocali") Locale locale, BindingResult bindingResult, Model model) throws Exception {
		Locale lcl = new Locale();
	   
		lv.validate(locale, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formGruppi",  new Gruppo());
			return "common.register";
		}

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    //int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
	    //locale.setId(randomNum);
	    
	    String address = locale.getCitta()+" "+locale.getIndirizzo();
		
		
		String latLongs[] = ConversionUtility.getLatLongPositions(address);
		float lat = Float.parseFloat(latLongs[0]);
		float lng = Float.parseFloat(latLongs[1]);
		locale.setLat(lat);
		locale.setLng(lng);
		Ruolo role = rs.getRuoloByName("local");
		//String password = ConversionUtility.passwordToMd5(locale.getPassword());
		//locale.setPassword(password); da completare
		locale.setRuolo(role);
	    lcl=ls.createLocale(locale);
	   
			return "common.index";//poi si cambia
		}
	
	@RequestMapping("/Cerca")
	public String cerca(@RequestParam(value = "nome", required=false)String nome, Model model){
		List<Gruppo> risultatoGruppi = new ArrayList<Gruppo>();
		List<Locale> risultatoLocali = new ArrayList<Locale>();
		List<Utente> risultati = gs.SearchUsers(nome);
		Iterator<Utente> i = risultati.iterator();
		while(i.hasNext()){
			Utente temp = i.next();
			if(temp.getRuolo().getId() == 1){
				Gruppo gruppoTemp = (Gruppo) temp;
				risultatoGruppi.add(gruppoTemp);
			}else{
				Locale localeTemp = (Locale) temp;
				risultatoLocali.add(localeTemp);
			}
		}
		model.addAttribute("gruppi",risultatoGruppi);
		model.addAttribute("locali",risultatoLocali);
		List<Evento> risultatoEventi = new ArrayList<Evento>();
		risultatoEventi = es.findEventoByName(nome);
		model.addAttribute("eventi",risultatoEventi);
		return "common.general_search";
	}
	@RequestMapping("/Groups")
	public String groupHome(@RequestParam(value = "nome", required=false)String nome,
							@RequestParam(value = "citta", required=false)String citta,
							@RequestParam(value = "genere", required=false)String genere,
			Model model) {
		
		Set<Gruppo> gruppiSet = new HashSet<Gruppo>();
		
		if ( (nome!=null) || (citta!=null) || (genere!=null) )  {
			
		    
			gruppiSet = gs.CustomSearchGruppi(nome, citta, genere);
			
			}

		else {
			
			
			gruppiSet = gs.findAllGruppi();
		}
		
		
	 
		List<Gruppo> gruppi = new ArrayList<Gruppo>(gruppiSet);
		model.addAttribute("gruppi", gruppi);
		
		List<Genere> generi = new ArrayList<Genere>();
		generi = ges.findAllGeneri();
		
		model.addAttribute("generi",generi);
		
		return "group.welcome";
	}
	


	@RequestMapping("/Group/{id}")
	public String groupProfile(@PathVariable("id") int id, Model model){
		
		Gruppo view_group = new Gruppo();
		view_group = gs.findGruppoById(id);
		if (view_group == null) return null; //Inserire Controllo migliore e 404!!
		String[] title = view_group.getNomeGruppo().split(" ");
		if (title.length == 2){
			model.addAttribute("titolo_page_1", title[0]);
			model.addAttribute("titolo_page_2", title[1]);
		}
	 List<Album> discografia = new ArrayList<Album>(view_group.getAlbums());
	 List<AlbumFotografico> af = new ArrayList<AlbumFotografico>(view_group.getAlbumFotografico());
		
	 model.addAttribute("gruppo", view_group);
	 model.addAttribute("album", discografia);
	 model.addAttribute("album_foto", af);
	 
	 List<Foto> foto_profilo = new ArrayList<Foto>(af.get(0).getFoto());
	 model.addAttribute("foto_profilo", foto_profilo.get(0));
	 
	 List<Video> videos = new ArrayList<Video>(view_group.getVideo());
	 model.addAttribute("video", videos.get(0));
	 
	 List<Evento> eventi = new ArrayList<Evento>(view_group.getEventi());
	 model.addAttribute("eventi", eventi);
	 
	 Canale channel = new Canale();
	 channel = view_group.getCanale();
	 model.addAttribute("canali",channel);
	 model.addAttribute("soundcloud", videos);
	 
	 List<Genere> generi = new ArrayList<Genere>(view_group.getGeneri());
	 
	 model.addAttribute("generi", generi);
	 
	 List<GruppoDiRiferimento> gdr = new ArrayList<GruppoDiRiferimento>(view_group.getGruppi_rif());
	 model.addAttribute("gruppidiriferimento", gdr);
	 
	 Scaletta scl = new Scaletta();
	 scl = view_group.getScaletta();
	 
	 List<Canzone> scaletta = new ArrayList<Canzone>(scl.getCanzoni()); //
	 model.addAttribute("scaletta", scaletta);
	 return "group.profile";
	 }

	@RequestMapping("/Locals")
	public String localHome(@RequestParam(value = "nome", required=false)String nome,
							@RequestParam(value = "citta", required=false)String citta,
							@RequestParam(value = "tipologia", required=false)String tipologia, Model model) {
		Set<Locale> localiSet = new HashSet<Locale>();
		
		
		
if ( (nome!=null) || (citta!=null) || (tipologia!=null) )  {
			
		    
			localiSet = ls.customSearchLocali(nome, citta, tipologia);
			
			}

		else {
			
			
			localiSet = ls.findAllLocali(); 
		}
		
		List<Locale> locali = new ArrayList<Locale>(localiSet);
		model.addAttribute("locali", locali);
		
		List<Categoria> categorie = new ArrayList<Categoria>();
		categorie = ls.getAllCategorieByLocali(locali);
		model.addAttribute("categorie", categorie);
		
		
		return "local.welcome";
	}

	@RequestMapping("/Local/{id}")
	public String localProfile(@PathVariable("id") int id, Model model){
	
	
	Locale locale = new Locale();
	locale = ls.findLocaleById(id);
	if (locale == null) return null; //Inserire Controllo migliore e 404!!
	String[] title = locale.getNomeLocale().split(" ");
	if (title.length == 2){
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
	}
	model.addAttribute("locale",locale);
//	
	Set<Evento> events = new HashSet<Evento>(locale.getEventi());
//	for (Iterator iterator = events.iterator(); iterator.hasNext();) {
//		Evento evento = (Evento) iterator.next();
//		Set<Gruppo> grup=evento.getGruppo();
//		System.out.println();
//	}
	
	//Set<Evento> eventi = es.findGruppoByEvent(events);
	//Set<Evento> eventi = locale.getEventi();
	//List<Gruppo> groups = new ArrayList<Gruppo>
	//events = es.findGruppoByEvent(events);
	
	model.addAttribute("eventi", events);
	Canale channel = new Canale();
	channel = locale.getCanale();
	model.addAttribute("canali",channel); 
	//model.addAttribute("soundcloud", soundcloud);
	
	Set<Foto> slideshow = new HashSet<Foto>();
	
	
	List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(locale.getAlbumFotografico());
	AlbumFotografico slider = null;
	Foto back = null;
	for (Iterator iterator = albums.iterator(); iterator.hasNext();) {
		AlbumFotografico albumFotografico = (AlbumFotografico) iterator.next();
		if (albumFotografico.getTag().equals("slideshow")){
			slider=albumFotografico;
			slideshow =  slider.getFoto();
			model.addAttribute("slideshow", slideshow);
		}
		if (albumFotografico.getTag().equals("profile")){
			List<Foto> foto = new ArrayList<Foto>(albumFotografico.getFoto());
			back = foto.get(0);
			model.addAttribute("back", back);
		}
		
		
	}
	
	 List<Video> video = new ArrayList<Video>(locale.getVideo());
	 model.addAttribute("video", video);
//	
//	model.addAttribute("slideshow", albumFoto.get(0).getFoto());
	// model.addAttribute("back", slide2);
	// model.addAttribute("canali", channel);
	//
		return "local.profile";
	}

	@RequestMapping("/Group/welcome.do")
	public String groupWelcome() {
		return "group.profile";
	}
	
	@RequestMapping("/redirect")
	 public String redirectHome() {
	 	
	 	String role = new String();
	 	role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
	 	
	 	if (role.compareTo("[[autority=group]]") == 0){
	 		return "redirect:/BackStage/";
	 	}else{
	 		return "redirect:/Privee/";
	 	}
		
	 }
	
	@RequestMapping("/inbox")
	 public String inbox() {
	 	
	 	
	 	
		return "list.conversation";
	 }
	
	
//	@RequestMapping("/createGroup.do")
//	public String createGroup(@ModelAttribute Gruppo gruppo,
//			BindingResult bindingResult, Model model) {
//		// jdbcUS.createGruppo(gruppo);
//		return "common.conferma";
//	}
	//
	// @RequestMapping("/Event/{id}")
	// public String eventDetail(@PathVariable("id") int id, Model model) {
	//
	//
	// SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yy");
	// Date w1 = new Date(2014,11,10);
	// String dw1= d1.format(w1);
	// Tipologia_Eventi te = new Tipologia_Eventi("Rock","Concerto Live");
	// Set<Tipologia_Eventi> ste = new HashSet<Tipologia_Eventi>(1);
	// ste.add(te);
	// Locale locale = new Locale();
	// locale.setEmail("locale@yop.it");
	// Set<String> contatti = new HashSet<String>(2);
	// contatti.add("08595951");
	// contatti.add("393 3939585");
	// locale.setContatti(contatti);
	// locale.setNomeLocale("Lost Dogs Cafè");
	// locale.setIndirizzo("Viale Matrino 1, Città Sant'Angelo PE");
	// Gruppo fes = new Gruppo();
	// fes.setNomeGruppo("Furious & Escort");
	// Foto wallpaper = new Foto(1,"resources/img/events/10/wall.jpg");
	// Evento ev2 = new
	// Evento(10,locale,fes,ste,"2014/11/5","22:00:00","04:00","Rock&Roll in Compagnia di Furious&Escort",locale.getIndirizzo(),0,wallpaper.getUrl(),"Evento Bellissimo fu");
	//
	//
	// model.addAttribute("evento", ev2);
	// model.addAttribute("wall", wallpaper);
	// return "event.single";
	// }}
	//
	//
}