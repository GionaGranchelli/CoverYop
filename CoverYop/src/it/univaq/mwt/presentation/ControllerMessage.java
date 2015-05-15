package it.univaq.mwt.presentation;

import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.LocaleService;
import it.univaq.mwt.business.MessageService;
import it.univaq.mwt.business.RequestGrid;
import it.univaq.mwt.business.ResponseGrid;
import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.form.utente.FormContatta;
import it.univaq.mwt.business.form.utente.FormConversation;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Gruppo;
//import it.univaq.mwt.business.model.ListForAjax;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.utility.FacilityTool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messages")
public class ControllerMessage {
	@Autowired
	private Utente utente;
	@Autowired
	UtenteService utenteService;
	@Autowired
	LocaleService localeService;
	@Autowired
	ConversationService convesationService;
	@Autowired
	GruppoService gruppoService;
	@Autowired
	MessageService messageService;
	@Autowired
	FotoService fotoService;

	@RequestMapping("/")
	public String inbox(Model model) throws NamingException {
		model.addAttribute("user", utente);
		return "list.dataTableConversation";
	}

	@RequestMapping("/findAllConversationPaginated.do")
	public @ResponseBody ResponseGrid<Conversation> findAllConversationPaginated(
			@ModelAttribute RequestGrid requestGrid) {
		ResponseGrid<Conversation> responseGrid = convesationService
				.findAllConversationPaginated(requestGrid, utente);
		return responseGrid;
	}

	@RequestMapping("/addconversation")
	public String addConversation(
			@ModelAttribute("formContatta") FormContatta conversation,
			BindingResult bindingResult, Model model) throws NamingException {
	Utente destinatario = utenteService.findUtenteById(conversation.getId());
	Utente utenteCompleto = utenteService.findUtente(utente);
	Conversation toAdd = FacilityTool.createConversation(utenteCompleto, conversation.getTitolo(), destinatario);
	Message messaggio1 = FacilityTool.createMessagePerConversation(conversation.getCorpo(), toAdd);
	destinatario.addRiceverConversation(toAdd);
	utenteService.update(destinatario);
		return "redirect:/messages/";
	}

	@RequestMapping("/addconversationLocal")
	public String addConversationLocal(
			@RequestParam("titolo") String titolo,
			@RequestParam("destinatario") String destinatario,
			@RequestParam("messaggio") String messaggio,
			Model model) throws NamingException {
		String[] parti = FacilityTool.splitConvNameGroup(destinatario);
		Locale localeDestinatario = localeService.findLocaleByCoord(parti[0], parti[1], parti[2]);
		Utente utenteCompleto = utenteService.findUtente(utente);
		Conversation toAdd = FacilityTool.createConversation(utenteCompleto, titolo, localeDestinatario);
		Message messaggio1 = FacilityTool.createMessagePerConversation(messaggio, toAdd);
		localeDestinatario.addRiceverConversation(toAdd);
		localeService.update(localeDestinatario);
		return "redirect:/messages/";
	}

	@RequestMapping("/addconversationGroup")
	public String addConversationGroup(
			@RequestParam("titolo") String titolo,
			@RequestParam("destinatario") String destinatario,
			@RequestParam("messaggio") String messaggio,
			Model model) throws NamingException {		
		String[] parti = FacilityTool.splitConvNameGroup(destinatario);
		Gruppo gruppoDestinatario = gruppoService.findGruppoByCoord(parti[0], parti[1]);
		Utente utenteCompleto = utenteService.findUtente(utente);
		Conversation toAdd = FacilityTool.createConversation(utenteCompleto, titolo, gruppoDestinatario);
		Message messaggio1 = FacilityTool.createMessagePerConversation(messaggio, toAdd);
		gruppoDestinatario.addRiceverConversation(toAdd);
		gruppoService.update(gruppoDestinatario);	
		return "redirect:/messages/";
	}

	@RequestMapping("/conversation/{id}")
	public String readConversation(@PathVariable("id") int id, Model model)
			throws NamingException {
		Conversation conversation = convesationService.findConversationById(id);
		model.addAttribute("utente", utente);
		model.addAttribute("messages", conversation.getMessage());
		model.addAttribute("conversation", conversation);
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}

	@RequestMapping("/addreply/{id}")
	public String addreply(@PathVariable("id") int id,
			@ModelAttribute("messaggio") Message messaggio,
			BindingResult bindingResult, Model model) throws NamingException {
		Conversation conversation = convesationService.findConversationById(id);
		Utente user = utenteService.findUtenteById(utente.getId());
		Message msg = FacilityTool.AddNewMessage(messaggio.gettext(), user, conversation);
		conversation = convesationService.updateConversation(conversation);
		return "redirect:/messages/conversation/" + conversation.getId();
	}

	@RequestMapping(value = "/get_locals_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getCountryList(
			@RequestParam("term") String query) {
		List<Locale> countryList = new ArrayList<Locale>(
				localeService.findLocaleByName(query));
		Iterator<Locale> i = countryList.iterator();
		List<String> listaLocali = new ArrayList<String>();
		while (i.hasNext()) {
			Locale v = i.next();
			listaLocali.add(v.getNomeLocale() + "::" + v.getIndirizzo() + "::"
					+ v.getCitta());
		}
		return listaLocali;
	}

	@RequestMapping(value = "/get_groups_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getGroupsList(
			@RequestParam("term") String query) {
		List<Gruppo> countryList = new ArrayList<Gruppo>(
				gruppoService.findGruppoByName(query));
		Iterator<Gruppo> i = countryList.iterator();
		List<String> listaGruppi = new ArrayList<String>();
		while (i.hasNext()) {
			Gruppo v = i.next();
			listaGruppi.add(v.getNomeGruppo() + "::" + v.getCitta());
		}
		return listaGruppi;
	}

}
