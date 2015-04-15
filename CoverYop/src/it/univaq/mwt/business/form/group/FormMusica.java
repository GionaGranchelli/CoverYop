package it.univaq.mwt.business.form.group;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormMusica {
	
	private String albumTitle;
	private CommonsMultipartFile[] musicFile;

	public FormMusica() {
		super();
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public CommonsMultipartFile[] getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(CommonsMultipartFile[] musicFile) {
		this.musicFile = musicFile;
	}
	
	

}
