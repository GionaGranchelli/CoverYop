package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;



import java.util.Collection;
import java.util.Set;

@Embeddable
public class Canale implements Serializable{
	
	
	
	
	private String facebook;
	
	private String youtube;
	
	private String twitter;
	
	private String soundCloud;
	
	private String instagram;
	
	private String googlePlus;
	
	private static final long serialVersionUID = 1L;
	
	public Canale() {
		super();
	}

	

	public Canale(String facebook, String youtube, String twitter,
			String soundCloud, String instagram, String googlePlus) {
		super();
		this.facebook = facebook;
		this.youtube = youtube;
		this.twitter = twitter;
		this.soundCloud = soundCloud;
		this.instagram = instagram;
		this.googlePlus = googlePlus;
	}



	public String getFacebook() {
		return facebook;
	}



	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}



	public String getYoutube() {
		return youtube;
	}



	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}



	public String getTwitter() {
		return twitter;
	}



	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}



	public String getSoundCloud() {
		return soundCloud;
	}



	public void setSoundCloud(String soundCloud) {
		this.soundCloud = soundCloud;
	}



	public String getInstagram() {
		return instagram;
	}



	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}



	public String getGooglePlus() {
		return googlePlus;
	}



	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	
}
