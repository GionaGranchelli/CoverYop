package it.univaq.mwt.business.form.group;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormFoto {
	
	private CommonsMultipartFile photoFileProfilo;
	

	private CommonsMultipartFile[] photoFile;
	

	public FormFoto(CommonsMultipartFile[] photoFile) {
		super();
		this.photoFile = photoFile;
	}

	public FormFoto() {
		super();
	}

	public FormFoto(CommonsMultipartFile photoFileProfilo,
			CommonsMultipartFile[] photoFile) {
		super();
		this.photoFileProfilo = photoFileProfilo;
		this.photoFile = photoFile;
	}

	public CommonsMultipartFile[] getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(CommonsMultipartFile[] photoFile) {
		this.photoFile = photoFile;
	}
	

	public CommonsMultipartFile getPhotoFileProfilo() {
		return photoFileProfilo;
	}

	public void setPhotoFileProfilo(CommonsMultipartFile photoFileProfilo) {
		this.photoFileProfilo = photoFileProfilo;
	}
}
