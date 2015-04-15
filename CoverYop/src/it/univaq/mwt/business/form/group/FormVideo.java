package it.univaq.mwt.business.form.group;

public class FormVideo {
	String titolo;
	String url;
	public FormVideo(String titolo, String data) {
		super();
		this.titolo = titolo;
		this.url = data;
	}
	public FormVideo() {
		super();
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}
