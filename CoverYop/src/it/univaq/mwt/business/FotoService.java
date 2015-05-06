package it.univaq.mwt.business;

import java.util.List;

import java.util.Set;
import it.univaq.mwt.business.model.*;


public interface FotoService {

	public Foto getFotoById(int fotoID);
	public void deleteFotoById(int fotoID);
	void deleteFotoByObj(Foto f);
	public Foto insertFoto(Foto f);
	public String getFotoProfiloByUtenteId(int id);
	public Foto updatePhoto(Foto foto);
	byte[] getFotoProfiloByUtenteIdBlob(int id);
	//byte[] getFotoSliderByUtenteIdBlob(int id);
	byte[] getFotoSlideShowByUtenteIdBlob(int id);
	public List<byte[]> getFotoSliderByUtenteIdBlob(int id);
	public AlbumFotografico getAlbumSliderByUserId(int id);
	public byte[] getByteFotoById(int id);
	public void insertSetFoto(Set<Foto> setFoto);
}
