package it.univaq.mwt.presentation;

import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public byte[] getEventoImage(@RequestParam("id") int id){	
		byte[] immagine =  eventoServ.getImmagineEvento(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/Group/image.html", params= "id" ,method = RequestMethod.GET)
	public byte[] getGruppoImage(@RequestParam("id") int id){	
		byte[] immagine =  fotoServ.getFotoProfiloByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/GroupSlide/image.html", params= "id" ,method = RequestMethod.GET)
	public byte[] getGruppoImageSlider(@RequestParam("id") int id){	
		byte[] immagine =  fotoServ.getFotoSlideShowByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/Local/image.html", params= "id" ,method = RequestMethod.GET)
	public byte[] getLocaleImage(@RequestParam("id") int id){	
		byte[] immagine =  fotoServ.getFotoProfiloByUtenteIdBlob(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/LocalSlide/image.html", params= "id" ,method = RequestMethod.GET)
	public byte[] getLocaleImageSlider(@RequestParam("id") int id){	
		byte[] immagine =  fotoServ.getByteFotoById(id);
		return immagine;
	}
	
	@ResponseBody
	@RequestMapping(value="/LocalSlide/imageUrl.html", params= "id" ,method = RequestMethod.GET)
	public byte[] getLocaleImageSliderUrl(@RequestParam("id") int id){	
		byte[] immagine =  fotoServ.getByteFotoById(id);
		File temp = null;
		try {
			temp = File.createTempFile("temp-file-name", ".jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
	