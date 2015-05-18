package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.business.model.Video;

import java.util.List;


public interface VideoService {
	
	List<Video> getAllVideoByGroupId(int groupId);
	int deleteVideo(int videoID);
	Video getVideoById(int videoID);
	Video updateVideo(Video v);
	void deleteVideo(Video v);
	Video insertVideo(Video v);
	Video buildVideoInfo(Utente l, Video v);
}
