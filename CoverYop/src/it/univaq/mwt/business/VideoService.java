package it.univaq.mwt.business;

import java.util.List;

import it.univaq.mwt.business.model.*;


public interface VideoService {
	
	public List<Video> getAllVideoByGroupId(int groupId);
	public int deleteVideo(int videoID);
	public Video getVideoById(int videoID);
	public Video updateVideo(Video v);
	public void deleteVideo(Video v);
	public Video insertVideo(Video v);
	public Video buildVideoInfo(Utente l, Video v);
}
