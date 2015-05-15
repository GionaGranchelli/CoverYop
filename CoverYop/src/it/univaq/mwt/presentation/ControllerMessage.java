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
		model.addAttribute("nuovaconv", new Conversation());
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
		int id = utente.getId();
		Conversation conv = new Conversation();
		conv.setTitolo(conversation.getTitolo());
		Utente destinatario = utenteService
				.findUtenteById(conversation.getId());
		conv.setDestinatario(destinatario);
		Utente mittente = utenteService.findUtenteById(utente.getId());
		conv.setMittente(mittente);
		conv.setData(Calendar.getInstance());
		Message msg = new Message();
		msg.settext(conversation.getCorpo());
		msg.setAutore(mittente);
		msg.setConversation(conv);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		conv.addMessage(msg);
		Conversation cv = convesationService.createConversation(conv);
		List<Conversation> cl = new ArrayList<Conversation>(
				convesationService.findAllConversationByUserId(id));
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());
		return "list.conversation";
	}

	@RequestMapping("/addconversationLocal")
	public String addConversationLocal(
			@ModelAttribute("formConversation") FormConversation conversation,
			BindingResult bindingResult, Model model) throws NamingException {
		int id = utente.getId();
		Conversation conv = new Conversation();
		conv.setTitolo(conversation.getTitolo());
		String[] parti = conversation.getDestinatario().split("::");
		String nomeLocale = parti[0];
		String indirizzo = parti[1];
		String citta = parti[2];
		Locale lc = localeService.findLocaleByCoord(nomeLocale, indirizzo,
				citta);
		conv.setDestinatario(lc);
		Utente mittente = utenteService.findUtenteById(utente.getId());
		conv.setMittente(mittente);
		conv.setData(Calendar.getInstance());
		Message msg = new Message();
		msg.settext(conversation.getCorpo());
		msg.setAutore(mittente);
		msg.setConversation(conv);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		conv.addMessage(msg);
		Conversation cv = convesationService.createConversation(conv);
		List<Conversation> cl = new ArrayList<Conversation>(
				convesationService.findAllConversationByUserId(id));
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());
		return "list.conversation";
	}

	@RequestMapping("/addconversationGroup")
	public String addConversationGroup(
			@ModelAttribute("formConversation") FormConversation conversation,
			BindingResult bindingResult, Model model) throws NamingException {
		String[] parti = FacilityTool.splitConvNameGroup(conversation
				.getDestinatario());
		Gruppo gruppoDestinatario = gruppoService.findGruppoByCoord(parti[0],
				parti[1]);
		Utente utenteCompleto = utenteService.findUtente(utente);
		Conversation toAdd = FacilityTool.createConversation(utenteCompleto,
				conversation, gruppoDestinatario);
		System.out.println("Mittente: " + toAdd.getMittente().getNome());
		Message messaggio = FacilityTool.createMessagePerConversation(
				conversation.getCorpo(), toAdd);
		gruppoDestinatario.addRiceverConversation(toAdd);
		gruppoService.update(gruppoDestinatario);
		model.addAttribute("user", utente);
		model.addAttribute("conversation", toAdd);
		model.addAttribute("nuovaconv", new Conversation());
		return "redirect:/messages/";
	}

	@RequestMapping("/conversation/{id}")
	public String readConversation(@PathVariable("id") int id, Model model)
			throws NamingException {
		Conversation conversation = convesationService.findConversationById(id);
		model.addAttribute("utente", utente);
		model.addAttribute("conversation", conversation);
		String fotoprofilo2 = null;
		if (utente.getUsername().equals(
				conversation.getMittente().getUsername())) {
			model.addAttribute("utente2", conversation.getDestinatario());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getDestinatario().getId());
			System.out.println();
		} else {
			model.addAttribute("utente2", conversation.getMittente());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getMittente().getId());
		}

		model.addAttribute("messages", conversation.getMessage());
		String fotoprofilo1 = fotoService.getFotoProfiloByUtenteId(utente
				.getId());
		model.addAttribute("fotoprofilo1", fotoprofilo1);
		model.addAttribute("fotoprofilo2", fotoprofilo2);
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}

	@RequestMapping("/addreply/{id}")
	public String addreply(@PathVariable("id") int id,
			@ModelAttribute("messaggio") Message messaggio,
			BindingResult bindingResult, Model model) throws NamingException {
		Conversation conversation = convesationService.findConversationById(id);
		Calendar cal = Calendar.getInstance();
		Utente user = utenteService.findUtenteById(utente.getId());
		Message msg = new Message();
		msg.setAutore(user);
		msg.setConversation(conversation);
		msg.setStatus(1);
		msg.setDataInvio(cal);
		msg.settext(messaggio.gettext());
		conversation.addMessage(msg);
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
