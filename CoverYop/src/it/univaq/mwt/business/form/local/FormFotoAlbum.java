package it.univaq.mwt.business.form.local;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormFotoAlbum {

	private CommonsMultipartFile[] photoFile;

	public FormFotoAlbum() {
		super();
	}

	public FormFotoAlbum(CommonsMultipartFile[] photoFile) {
		super();
		this.photoFile = photoFile;
	}

	public CommonsMultipartFile[] getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(CommonsMultipartFile[] photoFile) {
		this.photoFile = photoFile;
	}
	
	
}
