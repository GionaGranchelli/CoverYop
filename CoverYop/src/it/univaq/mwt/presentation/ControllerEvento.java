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
import it.univaq.mwt.common.utility.FacilityTool;

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
		
		List<Evento> eventiSet = es.CustomSearchEventi(nome, tipo, luogo);
		model.addAttribute("eventi", eventiSet);
		List<TipologiaEvento> tipologia = ts.getAllTipologiaEvento();
		model.addAttribute("tipologia", tipologia);
		List<Gruppo> gruppiSet = gs.findAllGruppi();
		List<Gruppo> gruppi = new ArrayList<Gruppo>(gruppiSet);
		model.addAttribute("gruppi", gruppi);
		return "list.event";
		
	}
	
	@RequestMapping("/Events/{id}")
	public String eventProfile(@PathVariable("id") int id, Model model){
	
		Evento evento = es.findEventoById(id);
		String[] title = FacilityTool.splitName(evento.getNome());
		model.addAttribute("titolo_page_1", title[0]);
		model.addAttribute("titolo_page_2", title[1]);
		List<Gruppo> gruppi = new ArrayList<Gruppo>(evento.getGruppo());
		model.addAttribute("evento", evento);
		model.addAttribute("fotoBlob", evento.getLocandinaBlob());
		model.addAttribute("gruppi", gruppi);
		return "evento.profile";
		
	}
	
	

}
