//package it.univaq.mwt.business.impl;
//
//import it.univaq.mwt.business.BusinessException;
//import it.univaq.mwt.business.model.Evento;
//import it.univaq.mwt.business.model.Gruppo;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//@Service
//public class JDBCdataService {
//	
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	public Evento findEventoById(int id) throws BusinessException {
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		Evento result = null;
//		try {
//			con = dataSource.getConnection();
//			//"select g.*,u.* from gruppo g, \"USER\"  u  where g.oid = u.oid"
//			st = con.prepareStatement("SELECT * FROM EVENTO WHERE OID=?");
//										 
//			st.setInt(1, id);
//			rs = st.executeQuery();
//			if (rs.next()) {
//				String data = rs.getString("DATA");				
//				String orarioInizio = rs.getString("ORARIOINIZIO");
//				String orarioFine = rs.getString("ORARIOFINE");
//				String nome = rs.getString("NOME");
//				String luogo = rs.getString("LUOGO");
//				float prezzo = rs.getFloat("PREZZO");
//				String locandina = rs.getString("LUOGO");
//				String descrizione = rs.getString("DESCRIZIONE");
//				
//				
//				
//				
//				Evento evento = new Evento();
//				evento.setData(data);
//				evento.setOrarioInizio(orarioInizio);
//				evento.setOrarioFine(orarioFine);
//				evento.setNome(nome);
//				evento.setLuogo(luogo);
//				evento.setPrezzo(prezzo);
//				evento.setLocandina(locandina);
//				evento.setDescrizione(descrizione);
//				
//				
//				
//				result = evento;
//			}
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException(e);
//		} finally {
//			if (st != null) {
//				try {
//					st.close();
//				} catch (SQLException e) {
//					//DO something
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					//DO something
//				}
//			}
//
//		}
//		
//		return result;
//
//	}
//		
//	
//	}
//
//	
//	
//	
//
