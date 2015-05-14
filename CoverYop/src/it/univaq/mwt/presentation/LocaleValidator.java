package it.univaq.mwt.presentation;

import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.ValidationUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LocaleValidator implements Validator { 

	
	@Autowired
	UtenteService us;
	
	@Override
	public boolean supports(Class<?> klass) {
		// TODO Auto-generated method stub
		return Locale.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		
		Locale locale = (Locale) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "errors.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeLocale", "errors.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioApertura", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioChiusura", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "citta", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "errors.required");
	
		ValidationUtility.rejectIfAccented(errors, "nome", "errors.accented", locale.getNome());
		ValidationUtility.rejectIfAccented(errors, "cognome", "errors.accented", locale.getCognome());
		ValidationUtility.rejectIfNotAUsername(errors, "username", "errors.validusername", locale.getUsername());
		ValidationUtility.rejectIfMaxLength(errors, "nome", "errors.maxlength", locale.getNome(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "cognome", "errors.maxlength", locale.getCognome(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "username", "errors.maxlength", locale.getUsername(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "nomeLocale", "errors.maxlength", locale.getNomeLocale(), 50);
		ValidationUtility.rejectIfMaxLength(errors, "nome", "errors.maxlength", locale.getPassword(), 50);
		ValidationUtility.rejectIfNEqual(errors, "retypePassword", "errors.passdiverse", locale.getPassword(), locale.getRetypePassword());
		ValidationUtility.rejectIfNotAvaibleUsername(errors, "username", "errors.username", locale.getUsername(), us.findUtenteByUsername(locale.getUsername()));
		ValidationUtility.rejectIfHasSpecialChar(errors, "nome", "errors.caratteri", locale.getNome());
		ValidationUtility.rejectIfHasSpecialChar(errors, "cognome", "errors.caratteri", locale.getCognome());
		ValidationUtility.rejectINAMail(errors, "email", "errors.mail", locale.getEmail());
	
	}

	
	
	
	
}
