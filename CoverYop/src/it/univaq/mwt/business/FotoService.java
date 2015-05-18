package it.univaq.mwt.business;

import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Foto;

import java.util.List;
import java.util.Set;


public interface FotoService {

	Foto getFotoById(int fotoID);
	void deleteFotoById(int fotoID);
	void deleteFotoByObj(Foto f);
	Foto insertFoto(Foto f);
	String getFotoProfiloByUtenteId(int id);
	Foto updatePhoto(Foto foto);
	byte[] getFotoProfiloByUtenteIdBlob(int id);
	//byte[] getFotoSliderByUtenteIdBlob(int id);
	byte[] getFotoSlideShowByUtenteIdBlob(int id);
	List<byte[]> getFotoSliderByUtenteIdBlob(int id);
	AlbumFotografico getAlbumSliderByUserId(int id);
	byte[] getByteFotoById(int id);
	void insertSetFoto(Set<Foto> setFoto);
}
