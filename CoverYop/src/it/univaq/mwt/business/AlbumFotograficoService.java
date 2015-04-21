package it.univaq.mwt.business;


import java.util.List;

import it.univaq.mwt.business.model.*;


public interface AlbumFotograficoService {
	
	public List<AlbumFotografico> getAllPhotoAlbumsByGroupId(int groupID);
	public Foto getFotoProfiloByGroupId(int groupID);
	public void addPhotoAlbum(AlbumFotografico album);
	public AlbumFotografico updatePhotoAlbum(AlbumFotografico album);
	public AlbumFotografico insertAlbumFotografico(AlbumFotografico album);
	public int emptyAlbumFotografico(AlbumFotografico album);
	public void removeAlbumFotografico(int albumID);
	public AlbumFotografico getAlbumFotograficoById(int albumID);
	public List getLastSubscribed(int i);
	
}
