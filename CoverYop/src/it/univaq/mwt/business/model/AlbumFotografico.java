package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Access(PROPERTY)
public class AlbumFotografico implements Serializable {
	
	private int id;
	
	private String titolo;
	
	private Date data;
	
	private String tag;
	
	private String luogo;
	
	@JsonBackReference
	private Utente utente;
	
	@JsonManagedReference
	private Set<Foto> foto = new HashSet<Foto>();
	
	private static final long serialVersionUID = 1L;

	public AlbumFotografico() {
		super();
	}

	public AlbumFotografico(int id, String titolo, Date data, String tag,
			String luogo,Utente utente, Set<Foto> foto) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.utente = utente;
		this.foto = foto;
	}

	public AlbumFotografico(String titolo, Date data, String tag,
			String luogo,Utente utente, Set<Foto> foto) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.utente = utente;
		this.foto = foto;
	}
	
	public AlbumFotografico(int id, String titolo, Date data, String tag,String luogo,Set<Foto> foto) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
	}
	
	public AlbumFotografico( String titolo, Date data, String tag,String luogo,Set<Foto> foto) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="AlbFotSeq")
    @SequenceGenerator(name="AlbFotSeq",sequenceName="ALBUMFOTOGRAFICO_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Temporal(DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@ManyToOne (fetch = LAZY,cascade={PERSIST, REFRESH}) 
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@OneToMany (fetch = EAGER, mappedBy="albumFotografico",cascade= CascadeType.ALL)
	public Set<Foto> getFoto() {
		return foto;
	}

	public void setFoto(Set<Foto> foto) {
		this.foto = foto;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public void addFoto(Foto f){
		foto.add(f);
	}
	public void removeFoto(Foto f){
		foto.remove(f);
	}

	public void addListFoto(List<Foto> f){
		foto.addAll(f);
	}
	
	public void setIdForFoto(){
		
		Iterator<Foto> i = foto.iterator();
		while(i.hasNext()){
			i.next().setAlbumFotografico(this);
		}
		
	}
	
}
