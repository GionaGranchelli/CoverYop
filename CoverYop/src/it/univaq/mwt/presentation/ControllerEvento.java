package it.univaq.mwt.presentation;

import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canale;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.GruppoDiRiferimento;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Scaletta;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.business.model.Video;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class ControllerEvento {
	
	@Autowired
	EventoService es;
	@Autowired
	TipologiaEventoService ts;
	@Autowired
	GruppoService gs;
	
	
	
	@RequestMapping("/Events")
	public String welcome(
			@RequestParam(value = "nome", required=false)String nome,
			@RequestParam(value = "tipologia", required=false)String tipo,
			@RequestParam(value = "luogo", required=false)String luogo,
			Model model) throws NamingException {
		
		Set<Evento> eventiSet = new HashSet<Evento>();
		
		if ( (nome!=null) || (tipo!=null) || (luogo!=null) )  {
			
		    
			eventiSet = es.CustomSearchEventi(nome, tipo, luogo);
			
			}

		else {
			
			
			eventiSet =  es.findAllEventi();
		}
		
		
		List<Evento> eventi = new ArrayList<Evento>(eventiSet);
		model.addAttribute("eventi", eventi);
		
		List<TipologiaEvento> tipologia = ts.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		
		Set<Gruppo> gruppiSet = gs.findAllGruppi();
		List<Gruppo> gruppi = new ArrayList<Gruppo>(gruppiSet);
		model.addAttribute("gruppi", gruppi);
		
		return "list.event";
		
	}
	
	@RequestMapping("/Events/{id}")
	public String eventProfile(@PathVariable("id") int id, Model model){
	
		Evento evento = new Evento();
		evento = es.findEventoById(id);
		if (evento == null) return null; //Inserire Controllo migliore e 404!!
		String[] title = evento.getNome().split(" ");
		if (title.length == 2){
			model.addAttribute("titolo_page_1", title[0]);
			model.addAttribute("titolo_page_2", title[1]);
		}
		List<Gruppo> gruppi = new ArrayList<Gruppo>(evento.getGruppo());
		model.addAttribute("evento", evento);
		System.out.println("MATTEO "+ evento.getLocandinaBlob());
		model.addAttribute("fotoBlob", evento.getLocandinaBlob());
		model.addAttribute("gruppi", gruppi);
		
		
		return "evento.profile";
		
	}
	
	
	
//	@RequestMapping("/Events/{id}")
//	public String eventProfile(@PathVariable("id") int id, Model model){
//	
//	Evento evento = new Evento();
//	evento = es.findEventoById(id);
//	
//	if (evento == null) return null; //Inserire Controllo migliore e 404!!
//	
//	String[] title = locale.getNomeLocale().split(" ");
//	if (title.length == 2){
//		model.addAttribute("titolo_page_1", title[0]);
//		model.addAttribute("titolo_page_2", title[1]);
//	}
//	model.addAttribute("locale",locale);
////	
//	Set<Evento> events = new HashSet<Evento>(locale.getEventi());
////	for (Iterator iterator = events.iterator(); iterator.hasNext();) {
////		Evento evento = (Evento) iterator.next();
////		Set<Gruppo> grup=evento.getGruppo();
////		System.out.println();
////	}
//	
//	//Set<Evento> eventi = es.findGruppoByEvent(events);
//	//Set<Evento> eventi = locale.getEventi();
//	//List<Gruppo> groups = new ArrayList<Gruppo>
//	//events = es.findGruppoByEvent(events);
//	
//	model.addAttribute("eventi", events);
//	Canale channel = new Canale();
//	channel = locale.getCanale();
//	model.addAttribute("canali",channel); 
//	//model.addAttribute("soundcloud", soundcloud);
//	
//	Set<Foto> slideshow = new HashSet<Foto>();
//	
//	
//	List<AlbumFotografico> albums = new ArrayList<AlbumFotografico>(locale.getAlbumFotografico());
//	AlbumFotografico slider = null;
//	Foto back = null;
//	for (Iterator iterator = albums.iterator(); iterator.hasNext();) {
//		AlbumFotografico albumFotografico = (AlbumFotografico) iterator.next();
//		if (albumFotografico.getTag().equals("slideshow")){
//			slider=albumFotografico;
//			slideshow =  slider.getFoto();
//			model.addAttribute("slideshow", slideshow);
//		}
//		if (albumFotografico.getTag().equals("background")){
//			List<Foto> foto = new ArrayList<Foto>(albumFotografico.getFoto());
//			back = foto.get(0);
//			model.addAttribute("back", back);
//		}
//		
//		
//	}
//	
//	 List<Video> video = new ArrayList<Video>(locale.getVideo());
//	 model.addAttribute("video", video);
////	
////	model.addAttribute("slideshow", albumFoto.get(0).getFoto());
//	// model.addAttribute("back", slide2);
//	// model.addAttribute("canali", channel);
//	//
//		return "local.profile";
//	}

}
