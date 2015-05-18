package it.univaq.mwt.presentation;

import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.FotoService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControllerImagine {
	
	@Autowired
	ServletContext servletContext;
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
	public String getLocaleImageSliderUrl(@RequestParam("id") int id) throws IOException{	
		byte[] immagine =  fotoServ.getByteFotoById(id);
		File tempFile = null;
		try {
			File path2= new java.io.File("./resour");
			String path = servletContext.getRealPath("/resources/");
			tempFile = File.createTempFile(path+"foto-temp", ".jpg",path2);
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(immagine);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempFile.getCanonicalPath();
	}
}
	