package it.univaq.mwt.presentation;

import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.ValidationUtility;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class GruppoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> klass) {
		// TODO Auto-generated method stub
		return Gruppo.class.isAssignableFrom(klass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		Gruppo gruppo = (Gruppo) target;
		/*Il "name" è associato alla proprietà
		 * error.requiered è nel file id internazionalizzazione*/
		//controllo campi obbligatori
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "errors.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeGruppo", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "biografia", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "citta", "errors.required");

		ValidationUtility.rejectIfNEqual(errors, "retypePassword", "errors.passdiverse", gruppo.getPassword(), gruppo.getRetypePassword());
		
		
		
		
	}


}
