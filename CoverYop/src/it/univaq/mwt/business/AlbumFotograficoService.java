package it.univaq.mwt.business;


import java.util.List;

import it.univaq.mwt.business.model.*;


public interface AlbumFotograficoService {
	
	List<AlbumFotografico> getAllPhotoAlbumsByGroupId(int groupID);
	Foto getFotoProfiloByGroupId(int groupID);
	void addPhotoAlbum(AlbumFotografico album);
	AlbumFotografico updatePhotoAlbum(AlbumFotografico album);
	AlbumFotografico insertAlbumFotografico(AlbumFotografico album);
	int emptyAlbumFotografico(AlbumFotografico album);
	void removeAlbumFotografico(int albumID);
	AlbumFotografico getAlbumFotograficoById(int albumID);
	List<AlbumFotografico> getLastSubscribed(int i);
	void removeEmptyAlbums(Utente utente);
	void fixAlbum(Utente utente);

	
}
