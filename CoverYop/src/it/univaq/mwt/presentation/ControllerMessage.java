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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		Set<Conversation> cl = utente.getConversationMitt();
		cl.addAll(utente.getConversationDest());
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());
		return "list.conversation";
	}

	@RequestMapping("/ajax")
	public String inboxAjax(Model model) throws NamingException {
		Set<Conversation> cl = utente.getConversationMitt();
		cl.addAll(utente.getConversationDest());
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());
		return "list.dataTableConversation";
	}

	@RequestMapping("/findAllConversationPaginated.do")
	public @ResponseBody ResponseGrid<Conversation> findAllConversationPaginated(@ModelAttribute RequestGrid requestGrid) {
		ResponseGrid<Conversation> responseGrid = convesationService.findAllConversationPaginated(requestGrid, utente);
		return responseGrid;
	}

	@RequestMapping("/addconversation")
	public String addConversation(
			@ModelAttribute("formContatta") FormContatta conversation,
			BindingResult bindingResult, Model model) throws NamingException {
		int id = utente.getId();
		// System.out.println(conversation.getCorpo()+conversation.getTitolo());
		Conversation conv = new Conversation();
		conv.setTitolo(conversation.getTitolo());

		Utente destinatario = utenteService.findUtenteById(conversation.getId());
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
		Locale lc = localeService.findLocaleByCoord(nomeLocale, indirizzo, citta);
		// Utente destinatario = us.findUtenteById(lc.getId());
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
		// Random rand = new Random();
		// int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
		// conv.setId(randomNum);
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

		int id = utente.getId();
		// System.out.println(conversation.getCorpo()+conversation.getTitolo());
		Conversation conv = new Conversation();
		conv.setTitolo(conversation.getTitolo());

		String[] parti = conversation.getDestinatario().split("::");
		String nomeGruppo = parti[0];
		String citta = parti[1];

		Gruppo gruppo = gruppoService.findGruppoByCoord(nomeGruppo, citta);

		// Utente destinatario = us.findUtenteById(gruppo.getId());
		conv.setDestinatario(gruppo);

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
		// Random rand = new Random();
		// int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
		// conv.setId(randomNum);
		Conversation cv = convesationService.createConversation(conv);

		List<Conversation> cl = new ArrayList<Conversation>(
				convesationService.findAllConversationByUserId(id));
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());

		return "list.conversation";
	}

	@RequestMapping("/conversation/{id}")
	public String readConversation(@PathVariable("id") int id, Model model)
			throws NamingException {

		Conversation conversation = convesationService.findConversationById(id);

		model.addAttribute("utente", utente);
		model.addAttribute("conversation", conversation);
		String fotoprofilo2 = null;
		if (utente.getUsername().equals(conversation.getMittente().getUsername())) {
			model.addAttribute("utente2", conversation.getDestinatario());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getDestinatario().getId());
			System.out.println();
		} else {
			model.addAttribute("utente2", conversation.getMittente());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getMittente().getId());
			System.out.println(fotoprofilo2);

		}

		model.addAttribute("messages", conversation.getMessage());
		String fotoprofilo1 = fotoService.getFotoProfiloByUtenteId(utente.getId());
		model.addAttribute("fotoprofilo1", fotoprofilo1);
		model.addAttribute("fotoprofilo2", fotoprofilo2);
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}

	@RequestMapping("/addreply/{id}")
	public String addreply(@PathVariable("id") int id,
			@ModelAttribute("messaggio") Message messaggio, BindingResult bindingResult,
			Model model) throws NamingException {
		Conversation conversation = convesationService.findConversationById(id);
		Calendar cal = Calendar.getInstance();
		Utente user = utenteService.findUtenteById(utente.getId());
		messaggio.setAutore(user);
		messaggio.setConversation(conversation);
		messaggio.setStatus(1);
		messaggio.setDataInvio(cal);
		conversation.addMessage(messaggio);
		conversation = convesationService.updateConversation(conversation);
		model.addAttribute("utente", utente);
		model.addAttribute("conversation", conversation);
		String fotoprofilo2 = null;
		if (utente.getUsername().equals(conversation.getMittente().getUsername())) {
			model.addAttribute("utente2", conversation.getDestinatario());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getDestinatario().getId());
		} else {
			model.addAttribute("utente2", conversation.getMittente());
			fotoprofilo2 = fotoService.getFotoProfiloByUtenteId(conversation
					.getMittente().getId());
			System.out.println(fotoprofilo2);

		}

		model.addAttribute("messages", conversation.getMessage());
		String fotoprofilo1 = fotoService.getFotoProfiloByUtenteId(utente.getId());
		model.addAttribute("fotoprofilo1", fotoprofilo1);
		model.addAttribute("fotoprofilo2", fotoprofilo2);
		// System.out.println(fotoprofilo1+"aaaaaa");
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}

	// Questa FUnzione Restituisce in Get, tramite Ajax la lista di tutti i
	// Locali che iniziano con "term"
	@RequestMapping(value = "/get_locals_list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getCountryList(@RequestParam("term") String query) {

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
	public @ResponseBody List<String> getGroupsList(@RequestParam("term") String query) {

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

	// @RequestMapping(value = "/get_groups_list_custom",
	// method = RequestMethod.GET,
	// produces="application/json")
	// public @ResponseBody List<ListForAjax>
	// getGroupsListCustom(@RequestParam("term") String query) {
	//
	// List<Gruppo>countryList = new
	// ArrayList<Gruppo>(gs.findGruppoByName(query));
	//
	// Iterator<Gruppo>i = countryList.iterator();
	// List<ListForAjax> listaGruppi = new ArrayList<ListForAjax>();
	// while(i.hasNext()){
	// Gruppo v = i.next();
	// listaGruppi.add(new ListForAjax(v.getId(), v.getNomeGruppo()));
	// }
	//
	// return listaGruppi;
	// }

	// @RequestMapping(value = "/get_groups_list",
	// method = RequestMethod.GET,
	// produces="application/json")
	// public @ResponseBody List<ListForAjax>
	// getGroupsList(@RequestParam("term") String query) {
	//
	// List<Gruppo>countryList = new
	// ArrayList<Gruppo>(gs.findGruppoByName(query));
	//
	// Iterator<Gruppo>i = countryList.iterator();
	// List<ListForAjax> listaGruppi = new ArrayList<ListForAjax>();
	// while(i.hasNext()){
	// Gruppo v = i.next();
	// listaGruppi.add(new ListForAjax(v.getId(), v.getNomeGruppo()));
	// }
	//
	// return listaGruppi;
	// }

}
