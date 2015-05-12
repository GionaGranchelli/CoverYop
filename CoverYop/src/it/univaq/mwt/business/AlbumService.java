package it.univaq.mwt.business;

import java.util.List;





import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.univaq.mwt.business.model.*;


public interface AlbumService {

	public Album getAllCanzoniByAlbumId(int albumId);
	
	public List<Album> getAllAlbumsByGroupId(int groupId);
	
	public void deleteAlbum(int albumID);
	
	public int emptyAlbum(Album alb);
	
	public void saveAlbumWithSong(Utente utente, Album album,
			CommonsMultipartFile[] tracce);

	public void updateAlbum(Album a);
	
}
