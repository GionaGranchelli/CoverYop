package it.univaq.mwt.common.utility;


import it.univaq.mwt.business.form.utente.FormFotoAlbum;
import it.univaq.mwt.business.form.utente.FormFotoProfilo;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Locale;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public final class SaveFile {

	public final String realPath = new String("C:\\");
	
	public List<Foto> savePhotoAbum(CommonsMultipartFile[] toSaveFile, int idUser) {

		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile[] cpFile = toSaveFile;
		int tot = cpFile.length;
		//			path = new java.io.File(".").getCanonicalPath() + File.separator
//					+ idUser;
		path = realPath
				+ File.separator + idUser;
		new File(path).mkdir();
		System.out.println("Path" + path);
		List<Foto> listFoto = new ArrayList<Foto>();
		
		String pathLogico = "resources/img/profile/"+idUser;
		for (int i = 0; i < tot; i++) {
			byte dataToWrite[] = cpFile[i].getBytes();
			try {
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + File.separator
								+ cpFile[i].getOriginalFilename())));
				Foto f = new Foto();
				
				f.setUrl(pathLogico + "/"
						+ cpFile[i].getOriginalFilename());
				byte [] tempByte = cpFile[i].getBytes();
				f.setFotoBlob(tempByte);
				listFoto.add(f);
				stream.write(dataToWrite);
				stream.close();
			} catch (Exception e) {

			}
		}
		return listFoto;
	}

	public Foto savePhotoProfile(CommonsMultipartFile toSaveFile, int idUser) {
		
		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile cpFile = toSaveFile;
		Foto f = new Foto();
		path = realPath
				+ File.separator + idUser;
		new File(path).mkdir();

		byte dataToWrite[] = cpFile.getBytes();
		try {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator
							+ cpFile.getOriginalFilename())));
			String pathLogico = "resources/img/profile/"+idUser;
			f.setUrl(pathLogico + "/" + cpFile.getOriginalFilename());
			stream.write(dataToWrite);
			stream.close();
		} catch (Exception e) {

		}

		return f;
	}

	public Foto savePhoto(CommonsMultipartFile toSaveFile, int idUser) throws IOException {

		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile cpFile = toSaveFile;
		Foto f = new Foto();
		path = realPath + File.separator
				+ idUser + File.separator + "event";
		new File(path).mkdir();

		byte dataToWrite[] = cpFile.getBytes();
		try {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator
							+ cpFile.getOriginalFilename())));

			f.setUrl(path + File.separator + cpFile.getOriginalFilename());
			stream.write(dataToWrite);
			stream.close();
		} catch (Exception e) {

		}

		return f;
	}
	
	public static Foto savePhotoBlob(CommonsMultipartFile toSaveFile, int idUser) throws IOException {

		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile cpFile = toSaveFile;
		Foto f = new Foto();
		String realPath = new String("C:\\");
		path = realPath + File.separator
				+ idUser + File.separator + "event";
		new File(path).mkdir();

		byte dataToWrite[] = cpFile.getBytes();
		try {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator
							+ cpFile.getOriginalFilename())));

			f.setUrl(path + File.separator + cpFile.getOriginalFilename());
			stream.write(dataToWrite);
			stream.close();
		} catch (Exception e) {

		}

		return f;
	}
	public static void savePhotoBlobGeneral(FormFotoProfilo toSaveFile, Foto f, int idUser, String type, String title) throws IOException {

		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile cpFile = toSaveFile.getPhotoFile();
		byte dataToWrite[] = cpFile.getBytes();
		try {
			f.setUrl(title);
			f.setFotoBlob(cpFile.getBytes());
		} catch (Exception e) {
			System.err.println("Errore nel Salvataggio del BLOB");
			e.printStackTrace();
		}

		
	}
	public List<Canzone> saveMusic(CommonsMultipartFile[] toSaveFile, int idUser) {
		String path = null; // Serve a Generare il Path dove salvare le Photo
		CommonsMultipartFile[] cpFile = toSaveFile;
		int tot = cpFile.length;
		path = realPath + File.separator + idUser ;
		new File(path).mkdir();
		
		List<Canzone> listCanzone = new ArrayList<Canzone>();
		for (int i = 0; i < tot; i++) {
			byte dataToWrite[] = cpFile[i].getBytes();
			try {
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + File.separator
								+ cpFile[i].getOriginalFilename())));
				Canzone f = new Canzone();
				f.setTitolo(cpFile[i].getOriginalFilename());
				String pathLogico = "placeholders/mp3";
				f.setUrl(path + File.separator
						+ cpFile[i].getOriginalFilename());
				listCanzone.add(f);
				stream.write(dataToWrite);
				stream.close();
			} catch (Exception e) {

			}
		}
		return listCanzone;
	}
	
//	public List<Canzone> saveMusic(CommonsMultipartFile[] toSaveFile, int idUser) {
//		String path = null; // Serve a Generare il Path dove salvare le Photo
//		CommonsMultipartFile[] cpFile = toSaveFile;
//		int tot = cpFile.length;
//		try {
//			path = new java.io.File(".").getCanonicalPath() + File.separator
//					+ idUser + File.separator + "music";
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		new File(path).mkdir();
//		System.out.println("Path" + path);
//		List<Canzone> listCanzone = new ArrayList<Canzone>();
//		for (int i = 0; i < tot; i++) {
//			byte dataToWrite[] = cpFile[i].getBytes();
//			try {
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(new File(path + File.separator
//								+ cpFile[i].getOriginalFilename())));
//				Canzone f = new Canzone();
//				f.setTitolo(cpFile[i].getOriginalFilename());
//				f.setUrl(path + File.separator
//						+ cpFile[i].getOriginalFilename());
//				listCanzone.add(f);
//				stream.write(dataToWrite);
//				stream.close();
//			} catch (Exception e) {
//
//			}
//		}
//		return listCanzone;
//	}

	public void saveVideo(CommonsMultipartFile[] toSaveFile, int idUser) {
		

	}

	public static AlbumFotografico savePhotoBlobGeneral(FormFotoAlbum formFotoAlbum, Locale l,
			String albumType, String description) {
		
		CommonsMultipartFile[] tempFileUploaded = formFotoAlbum.getPhotoFile();
		int size = tempFileUploaded.length;
		int i= 0; //iterator
		AlbumFotografico tempSlider;
		if(l.getAlbumSlider() == null){
			tempSlider = new AlbumFotografico();
			tempSlider.setData(new Date());
			tempSlider.setLuogo(l.getCitta());
			tempSlider.setTag(albumType);
			tempSlider.setTitolo(description);
			tempSlider.setUtente(l);
		}else{
			tempSlider = l.getAlbumSlider();
		}
		for(i = 0; i < size; i++){
			Foto temp = new Foto();
			CommonsMultipartFile tempBytePhoto = tempFileUploaded[i];
			temp.setAlbumFotografico(tempSlider);
			temp.setFotoBlob(tempBytePhoto.getBytes());
			temp.setUrl(description);
			tempSlider.addFoto(temp);
			
		}
		return tempSlider;
	}

}
