package it.univaq.mwt.presentation;

import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.ValidationUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class GruppoValidator implements Validator {
	
	@Autowired
	UtenteService us;
	
	@Override
	public boolean supports(Class<?> klass) {
		// TODO Auto-generated method stub
		return Gruppo.class.isAssignableFrom(klass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		Gruppo gruppo = (Gruppo) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "errors.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeGruppo", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "citta", "errors.required");
		
		
		
		
		
		ValidationUtility.rejectIfAccented(errors, "nome", "errors.accented", gruppo.getNome());
		ValidationUtility.rejectIfAccented(errors, "cognome", "errors.accented", gruppo.getCognome());
		ValidationUtility.rejectIfNotAUsername(errors, "username", "errors.validusername", gruppo.getUsername());
		ValidationUtility.rejectIfMaxLength(errors, "nome", "errors.maxlength", gruppo.getNome(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "cognome", "errors.maxlength", gruppo.getCognome(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "username", "errors.maxlength", gruppo.getUsername(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "nomeGruppo", "errors.maxlength", gruppo.getNomeGruppo(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "nome", "errors.maxlength", gruppo.getPassword(), 50);
		ValidationUtility.rejectIfNEqual(errors, "retypePassword", "errors.passdiverse", gruppo.getPassword(), gruppo.getRetypePassword());
		ValidationUtility.rejectIfNotAvaibleUsername(errors, "username", "errors.username", gruppo.getUsername(), us.findUtenteByUsername(gruppo.getUsername()));
		ValidationUtility.rejectIfHasSpecialChar(errors, "nome", "errors.caratteri", gruppo.getNome());
		ValidationUtility.rejectIfHasSpecialChar(errors, "cognome", "errors.caratteri", gruppo.getCognome());
		ValidationUtility.rejectINAMail(errors, "email", "errors.mail", gruppo.getEmail());
	}




}
