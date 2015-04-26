package it.univaq.mwt.business.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.AccessType.FIELD;

@Entity

@Access(PROPERTY)
public class Foto implements Serializable{
	
	
	private int id;
	
	private String url;
	
	
	private AlbumFotografico albumFotografico;
	
	private byte[] fotoBlob; 

	private static final long serialVersionUID = 1L;
	
	public Foto() {
		super();
	}

	public Foto(int id, String url, AlbumFotografico albumFotografico) {
		super();
		this.id = id;
		this.url = url;
		this.albumFotografico = albumFotografico;
	}
	
	public Foto(String url, AlbumFotografico albumFotografico) {
		super();
		this.url = url;
		this.albumFotografico = albumFotografico;
	}

	public Foto(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	
	public Foto(String url) {
		super();
		this.url = url;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="FotoSeq")
    @SequenceGenerator(name="FotoSeq",sequenceName="FOTO_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne (fetch = EAGER)
	@JoinColumn(name="albumFotograficoId", referencedColumnName="id")
	public AlbumFotografico getAlbumFotografico() {
		return albumFotografico;
	}

	public void setAlbumFotografico(AlbumFotografico albumFotografico) {
		this.albumFotografico = albumFotografico;
	}

	@Lob
	public byte[] getFotoBlob() {
		return fotoBlob;
	}

	public void setFotoBlob(byte[] fotoBlob) {
		this.fotoBlob = fotoBlob;
	}

	
}
