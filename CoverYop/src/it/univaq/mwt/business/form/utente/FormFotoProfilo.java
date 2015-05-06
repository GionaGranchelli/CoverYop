package it.univaq.mwt.business.form.utente;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormFotoProfilo {

	private CommonsMultipartFile photoFile;

	public FormFotoProfilo() {
		super();
	}

	public FormFotoProfilo(CommonsMultipartFile photoFile) {
		super();
		this.photoFile = photoFile;
	}

	public CommonsMultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(CommonsMultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	
}
