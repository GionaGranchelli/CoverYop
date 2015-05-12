package it.univaq.mwt.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.validation.Errors;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ValidationUtility {
	
	
	
	
	public static List<String> simplifyURL(List<String> listImg){
        String nuova = null;
        ArrayList<String> prova = (ArrayList<String>) listImg;
        List<String>temp = new ArrayList<String>();
        Iterator<String> iter = prova.iterator();
        while(iter.hasNext()){
            String url;
            url = (String) iter.next();
            int size = url.length();
//            int firstSlashPos = url.indexOf('/');
            int lastSlashPos = url.lastIndexOf('/');
            if (lastSlashPos >= 0)
            {
              nuova = url.substring(lastSlashPos+1, size); //strip off the slash8
              temp.add(nuova);
            }
        }
        return temp;
    }

	public static void rejectIfMaxLength(Errors errors, String fieldName, String errorMessage, String fieldValue, int maxlength) {
		if (fieldValue != null && fieldValue.length() > maxlength) {
			Object[] args = {maxlength};
			errors.rejectValue(fieldName, errorMessage, args, "error.maxlength");
		}
	}

	public static void rejectIfNan(Errors errors, String fieldName,
			String errorMessage, String fieldValue) {
		try{
			long number = Long.parseLong(fieldValue); 
		}catch (NumberFormatException e){errors.rejectValue(fieldName, errorMessage, "error.integer");} 
	}

	public static void rejectIfMinLength(Errors errors, String fieldName, String errorMessage, String fieldValue , int minLength) {
		if (fieldValue != null && fieldValue.length() < minLength) {
			Object[] args = {minLength};
			errors.rejectValue(fieldName, errorMessage, args, "errors.minlength");
		}
	}

	public static void rejectIfAccented(Errors errors, String fieldName,String errorMessage, String fieldValue) {
		if(fieldValue.matches("(.*)[à|è|é|ì|ò|ù](.*)")) { 
			errors.rejectValue(fieldName, errorMessage, "errors.accent");
		}

	}

	public static void rejectIfNal(Errors errors, String fieldName, String errorMessage, String fieldValue) {
		
		String filePath = "C://ePubLibrary//lingue.xml";
		File lingue = new File(filePath);
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			f.setValidating(false);
			f.setNamespaceAware(false);
			dBuilder = f.newDocumentBuilder();
			
			Document doc = dBuilder.parse(lingue);
			String expression = "/lingue[l=\""+ fieldValue +"\"]";
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			NodeList XMeta;
				XPathExpression espressione = xPath.compile(expression);
				XMeta = (NodeList) espressione.evaluate(doc, XPathConstants.NODESET);
				if (XMeta.getLength()==0) {
					
					errors.rejectValue(fieldName, errorMessage, "errors.linguedisponibili");
					
				}
			
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(!(fieldValue.matches("it|en|es|fr"))) { 
//			
//			
//			errors.rejectValue(fieldName, errorMessage, "errors.linguedisponibili");
//				
//				
//			}
		
		
	}

	public static void rejectIfNoExt(Errors errors, String errorMessage, CommonsMultipartFile[] commonsMultipartFiles, String ext, String field) {
		for (int i = 0; i < commonsMultipartFiles.length; i++) {
			System.out.println(commonsMultipartFiles[i].getOriginalFilename());
			int index = commonsMultipartFiles[i].getOriginalFilename().lastIndexOf(".");
					String estensione =commonsMultipartFiles[i].getOriginalFilename().substring(index+1);
					
					System.out.println(index);
					System.out.println(estensione);
					if (!(estensione.equals(ext))) { errors.rejectValue(field,errorMessage, "errors.extension");}
		}
		
	}

	
	public static void rejectIfEmpty(Errors error, String errorMessage,
			CommonsMultipartFile[] getePubFiles, String field) {
		if(getePubFiles[0].isEmpty()){error.rejectValue(field, errorMessage, "errore");}
		
	}
	
	public static void rejectIfBadExtension(Errors error, String errorMessage,
			CommonsMultipartFile[] getePubFiles, String field){
		for (int i = 0; i < getePubFiles.length; i++) {
			
			if(!getePubFiles[i].getOriginalFilename().endsWith(".epub")){
				
				error.rejectValue(field, errorMessage, "errore");
			}
		}
		
		
	}

	public static void rejectIfNEqual(Errors errors, String field,
			String errorMessage, String password, String retypePassword) {

		if(!(password.equals(retypePassword))) errors.rejectValue(field, errorMessage, "errore");
		
	}
}
