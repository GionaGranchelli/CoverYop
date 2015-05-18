package it.univaq.mwt.business;

import java.util.List;





import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.univaq.mwt.business.model.*;


public interface AlbumService {

	Album getAllCanzoniByAlbumId(int albumId);
	List<Album> getAllAlbumsByGroupId(int groupId);
	void deleteAlbum(int albumID);
	int emptyAlbum(Album alb);
	void saveAlbumWithSong(Utente utente, Album album, CommonsMultipartFile[] tracce);
	void updateAlbum(Album a);
	
}
