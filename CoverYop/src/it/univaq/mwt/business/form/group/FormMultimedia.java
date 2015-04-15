package it.univaq.mwt.business.form.group;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormMultimedia {

	private CommonsMultipartFile[] photoFile;
	private CommonsMultipartFile[] musicFile;
	private List<String> videoFile;
	
	
	
	public FormMultimedia(CommonsMultipartFile[] photoFile,
			CommonsMultipartFile[] musicFile, List<String> videoFile) {
		super();
		this.photoFile = photoFile;
		this.musicFile = musicFile;
		this.videoFile = videoFile;
	}
	public FormMultimedia() {
		super();
	}
	public CommonsMultipartFile[] getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(CommonsMultipartFile[] photoFile) {
		this.photoFile = photoFile;
	}
	public CommonsMultipartFile[] getMusicFile() {
		return musicFile;
	}
	public void setMusicFile(CommonsMultipartFile[] musicFile) {
		this.musicFile = musicFile;
	}
	public List<String> getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(List<String> videoFile) {
		this.videoFile = videoFile;
	}
	
	
	
	
	
	
		
}
