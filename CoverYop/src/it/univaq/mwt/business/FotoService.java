package it.univaq.mwt.business;

import it.univaq.mwt.business.model.*;


public interface FotoService {

	public Foto getFotoById(int fotoID);
	public void deleteFoto(int fotoID);
	public Foto insertFoto(Foto f);
	public String getFotoProfiloByUtenteId(int id);
	public Foto updatePhoto(Foto foto);
	byte[] getFotoProfiloByUtenteIdBlob(int id);
}
