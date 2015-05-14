package it.univaq.mwt.presentation;

import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.common.ValidationUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EventoValidator implements Validator {
	
	@Autowired
	UtenteService us;
	
	@Override
	public boolean supports(Class<?> klass) {
		// TODO Auto-generated method stub
		return Evento.class.isAssignableFrom(klass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		Evento evento = (Evento) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogo", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioInizio", "errors.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioFine", "errors.required");

		
		
		
		
		//ValidationUtility.rejectIfAccented(errors, "nome", "errors.accented", evento.getNome());
	
		ValidationUtility.rejectIfMaxLength(errors, "nome", "errors.maxlength", evento.getNome(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "luogo", "errors.maxlength", evento.getLuogo(), 50);
		
		
		
		
		ValidationUtility.rejectIfNaFloat(errors, "prezzo", "errors.invalid", evento.getPrezzo());
		
		
		ValidationUtility.rejectIfHasSpecialChar(errors, "nome", "errors.caratteri", evento.getNome());
		
		
	}
}