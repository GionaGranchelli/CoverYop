package it.univaq.mwt.presentation;

import java.util.List;

import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControllerImagine {
	
	
	@Autowired
	EventoService eventoServ;
	@Autowired
	FotoService fotoServ;
	
	@ResponseBody
	@RequestMapping(value="/Event/image.html", params= "id" ,method = RequestMethod.GET)
	///Event/image.html?id=${evento.id}
	//public byte[] getEventoImage(@PathVariable("id") int id){
		public byte[] getEventoImage(@RequestParam("id") int id){	
	
		byte[] immagine =  eventoServ.getImmagineEvento(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/Group/image.html", params= "id" ,method = RequestMethod.GET)
	///Event/image.html?id=${evento.id}
	//public byte[] getEventoImage(@PathVariable("id") int id){
		public byte[] getGruppoImage(@RequestParam("id") int id){	
	
		byte[] immagine =  fotoServ.getFotoProfiloByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/GroupSlide/image.html", params= "id" ,method = RequestMethod.GET)
	///Event/image.html?id=${evento.id}
	//public byte[] getEventoImage(@PathVariable("id") int id){
		public byte[] getGruppoImageSlider(@RequestParam("id") int id){	
	
		byte[] immagine =  fotoServ.getFotoSlideShowByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/Local/image.html", params= "id" ,method = RequestMethod.GET)
	///Event/image.html?id=${evento.id}
	//public byte[] getEventoImage(@PathVariable("id") int id){
		public byte[] getLocaleImage(@RequestParam("id") int id){	
		
		
	
		byte[] immagine =  fotoServ.getFotoProfiloByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/LocalSlide/image.html", params= "id" ,method = RequestMethod.GET)
	///Event/image.html?id=${evento.id}
	//public byte[] getEventoImage(@PathVariable("id") int id){
		public byte[] getLocaleImageSlider(@RequestParam("id") int id){	
	
		byte[] immagine =  fotoServ.getByteFotoById(id);
		return immagine;
	}
	
	
	
	

}
	