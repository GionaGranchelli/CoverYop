package it.univaq.mwt.common.utility;

import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;



public class ConversionUtility {
	
	public static String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }

	public static String passwordToMd5(String password) {
		String original = password;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("algoritmo inesistente");
			return "";
		}
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		String result = sb.toString();
		return result;
	}
	public static String addPercentSuffix(String s) {
		if (s == null || "".equals(s)) {
			return "%";
		}
		return s + "%";
	}
	
	
//
//	public static long string2long(String s) {
//		if (s == null || s.isEmpty()) {
//			return 0;
//		}
//		return Long.parseLong(s);
//
//	}
//	
//	public static int string2int(String s) {
//		if (s == null || s.isEmpty()) {
//			return 0;
//		}
//		return Integer.parseInt(s);
//	}
//	
//	
//
//	public static RequestGrid getRequestGrid(HttpServletRequest req) {
//		Long iDisplayStart = string2long(req.getParameter("iDisplayStart"));
//		Long iDisplayLength = string2long(req.getParameter("iDisplayLength"));
//		String sEcho = req.getParameter("sEcho");
//		String sSearch = req.getParameter("sSearch");
//		String sortCol = req.getParameter("sortCol");
//		String sortDir = req.getParameter("sortDir");
//
//		RequestGrid requestGrid = new RequestGrid();
//		requestGrid.setiDisplayStart(iDisplayStart);
//		requestGrid.setiDisplayLength(iDisplayLength);
//		requestGrid.setsEcho(sEcho);
//		requestGrid.setsSearch(sSearch);
//		requestGrid.setSortCol(sortCol);
//		requestGrid.setSortDir(sortDir);
//
//		return requestGrid;
//
//	}
//
//	public static String addPercentSuffix(String s) {
//		if (s == null || "".equals(s)) {
//			return "%";
//		}
//		return s + "%";
//	}
}
