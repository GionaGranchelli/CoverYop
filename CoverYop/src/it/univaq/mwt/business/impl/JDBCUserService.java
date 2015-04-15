//package it.univaq.mwt.business.impl;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import it.univaq.mwt.business.BusinessException;
//import it.univaq.mwt.business.UserService;
//import it.univaq.mwt.business.model.Album;
//import it.univaq.mwt.business.model.Categoria;
//import it.univaq.mwt.business.model.Gruppi_Di_Riferimento;
//import it.univaq.mwt.business.model.Gruppo;
//import it.univaq.mwt.business.model.Locale;
//
//@Service
//public class JDBCUserService implements UserService {
//
//	@Autowired
//	private DataSource dataSource;
//
////------------------------------ IMPLEMENT METODI PER IL GRUPPO---------------------------------------
//	//MATTEO
//	@Override
//	public List<Gruppo> findAllGruppi() throws BusinessException {
//		List<Gruppo> result = new ArrayList<Gruppo>();
//		Connection con = null;
//		Statement st = null;
//		Statement st2 = null;
//		ResultSet rs = null;
//		ResultSet rs2 = null;
//		try {
//			con = dataSource.getConnection();
//			st = con.createStatement();
//			rs = st.executeQuery("select g.*,u.* from gruppo g, \"USER\"  u  where g.oid = u.oid");
//
//			while (rs.next()) {
//				
//				int id = rs.getInt("oid");
//				String username = rs.getString("username");
//				String password = rs.getString("password");
//				String nome = rs.getString("nome");
//				String telefono = rs.getString("telefono");
//				String email = rs.getString("email");
//				
//				String biografia = rs.getString("biografia");
//				Date data = rs.getDate("data");
//				String luogo = rs.getString("luogo");
//				boolean coverband = rs.getBoolean("coverband");
//				
//				// --------------------- LISTA DI GRUPPI DI RIFERIMENTO PER OGNI SINGOLO GRUPPO -------------------------------------------------------
//				int gruppi_di_riferimento_oid = rs.getInt("gruppi_di_riferimento_oid");
//				st2 = con.createStatement();
//				rs2 = st2.executeQuery("select grif.* from gruppi_di_riferimento grif  where grif.oid = "+gruppi_di_riferimento_oid+" ");
//				List<Gruppi_Di_Riferimento> gruppi_di_riferimento = new ArrayList<Gruppi_Di_Riferimento>();
//				String riferimento_nome = null;
//				String riferimento_genere = null;
//				while (rs2.next()){
//					riferimento_nome = rs2.getString("nome");
//					riferimento_genere = rs2.getString("genere");
//					gruppi_di_riferimento.add(new Gruppi_Di_Riferimento(gruppi_di_riferimento_oid,riferimento_nome));
//				}
//				rs2.close();
//				st2.close();
//				// --------------------- FINE LISTA DI GRUPPI DI RIFERIMENTO PER OGNI SINGOLO GRUPPO -------------------------------------------------------
//	
//				
//				int feedback_oid = rs.getInt("feedback_oid");  // da cambiare qua
//				int cachet_oid = rs.getInt("cachet_oid");   // da cambiare qua
//			    int scaletta_oid = rs.getInt("scaletta_oid"); // da cambiare qua
//			
//				Gruppo gruppo = null;
//				//new Gruppo(id,biografia,data,luogo,coverband,gruppi_di_riferimento,feedback_oid,cachet_oid,scaletta_oid);
//				gruppo.setUsername(username);
//				gruppo.setPassword(password);
//				gruppo.setNome(nome);
//				gruppo.setTelefono(telefono);
//				gruppo.setEmail(email);
//				result.add(gruppo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException(e);
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//				}
//			}
//			if (st != null) {
//				try {
//					st.close();
//				} catch (SQLException e) {
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//				}
//			}
//
//		}
//		return result;
//	}
//
//
//
//
//
//
//	@Override
//	public List<Gruppo> findGruppiByTipo(String tipologia)
//			throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//
//	@Override
//	public List<Album> findAlbumByGroup(String album) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//	//MARIO
//		public Gruppo findGruppoById(int id) throws BusinessException {
//			Connection con = null;
//			PreparedStatement st = null;
//			ResultSet rs = null;
//			Gruppo result = null;
//			try {
//				con = dataSource.getConnection();
//				//"select g.*,u.* from gruppo g, \"USER\"  u  where g.oid = u.oid"
//				st = con.prepareStatement(  "SELECT UTENTE.OID, UTENTE.NOME, UTENTE.COGNOME, UTENTE.USERNAME, UTENTE.EMAIL,"
//										  + "GRUPPO.BIOGRAFIA, GRUPPO.NOME_GRUPPO, GRUPPO.DATA, GRUPPO.LUOGO, GRUPPO.COVERBAND, GRUPPO.COVERBAND,"
//										  + " GRUPPO.SCALETTA_OID, GRUPPO.CACHET_OID, GRUPPO.FEEDBACK_OID" +
//											" FROM UTENTE, GRUPPO" +
//											" WHERE UTENTE.OID = GRUPPO.OID "+
//											" AND UTENTE.OID = ?");
//											 
//				st.setLong(1, id);
//				System.err.println(st);
//				rs = st.executeQuery();
//				if (rs.next()) {
//					int oid = rs.getInt("OID");
//					String nome = rs.getString("NOME");
//					String cognome = rs.getString("COGNOME");
//					String username = rs.getString("USERNAME");
//					String email = rs.getString("EMAIL");
//					String nome_gruppo = rs.getString("NOME_GRUPPO");
//					String biografia = rs.getString("BIOGRAFIA");
//					Date data = rs.getDate("DATA");
//					String luogo = rs.getString("LUOGO");
//					boolean coverband = rs.getBoolean("COVERBAND");
//					int scaletta_oid = rs.getInt("SCALETTA_OID");
//					int cachet_oid = rs.getInt("CACHET_OID");
//					int feedback_oid = rs.getInt("FEEDBACK_OID");
//					
//					
//					
//					Gruppo gruppo = new Gruppo();
//					gruppo.setNome(nome);
//					gruppo.setCognome(cognome);
//					gruppo.setUsername(username);
//					gruppo.setNomeGruppo(nome_gruppo);
//					gruppo.setBiografia(biografia);
//					gruppo.setData(data);
//					//gruppo.setLuogo(luogo);
//					gruppo.setCover_Band(coverband==true?1:0);
//					gruppo.setScaletta(null);
//					gruppo.setCachet(null);
//					gruppo.setFeedback(null);
//					
//					
//					
//					result = gruppo;
//				}
//			
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw new BusinessException(e);
//			} finally {
//				if (st != null) {
//					try {
//						st.close();
//					} catch (SQLException e) {
//						//DO something
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (SQLException e) {
//						//DO something
//					}
//				}
//
//			}
//			
//			return result;
//
//		}
//
//
//
//
//
//	@Override
//	public void updateGruppo(Gruppo gruppo) throws BusinessException {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//
//	@Override
//	public void deleteGruppo(Gruppo gruppo) throws BusinessException {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//
//	@Override
//	public List<Locale> findAllLocale() throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//
//	@Override
//	public Locale findLocaleById(int id) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//
//	@Override
//	public List<Locale> findLocaleByCategoria(Categoria categoria)
//			throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//
//	@Override
//	public void updateLocale(Locale locale) throws BusinessException {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//
//	@Override
//	public void deleteLocale(Locale locale) throws BusinessException {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//	//MARIO
//	public void createGruppo(Gruppo gruppo) throws BusinessException {
//		Connection con = null;
//		PreparedStatement insertUser = null;
//		PreparedStatement insertGroup1 = null;
//		String sqlUser = "insert into UTENTE(oid, username, password, email, telefono, nome,"/* contenuto_multimediale, "*/
//				+ /*canale_oid, */" cognome) values (userseq.NEXTVAL, ?, ?, ?, ?, ?, ?"/*, ?,?*/+")";
//		String sqlGruppo = "insert into GRUPPO(oid, biografia, data, luogo, coverband"/*, service_oid, gruppi_di_riferimento_oid,"*/
//				+ /* feedback_oid, cachet_oid, scaletta_oid*/") values (userseq.CURRVAL, ?, ?, ?, ?"/*, ?, ?, ?,?,?*/+")";
//		try {
//			con = dataSource.getConnection();
//			con.setAutoCommit(false);
//			insertUser =  con.prepareStatement(sqlUser);
//			insertUser.setString(1, gruppo.getUsername());
//			insertUser.setString(2, gruppo.getPassword());
//			insertUser.setString(3, gruppo.getEmail());
//			insertUser.setString(4, gruppo.getTelefono());
//			insertUser.setString(5, gruppo.getNome());
//			
//			//trattare inserimento entita riferite
//			insertUser.setString(6, gruppo.getCognome());
//			insertUser.executeUpdate();
//			//
//			
//			insertGroup1 = con.prepareStatement(sqlGruppo);
//			
//			insertGroup1.setString(1, gruppo.getBiografia());
//			insertGroup1.setDate(2, (Date) gruppo.getData());
//			//insertGroup1.setString(3, gruppo.getLuogo());
//			insertGroup1.setInt(4, gruppo.getCover_Band());
//			insertGroup1.executeUpdate();
//			con.commit();
//			
//			
//		} catch (SQLException e) {
//			if (con != null) {
//				try {
//					System.err.print("Transaction is eing rolled back");
//					e.printStackTrace();
//					System.err.println(e.getCause().toString()+e.getSQLState());
//					con.rollback();
//				} catch (SQLException excep) {
//					System.out.println("errore rollback");
//					excep.printStackTrace();
//				}
//				e.printStackTrace();
//				throw new BusinessException(e);
//			}
//		} }
//	
//	
//	
//	
//	//MARIO
//	public void createLocale(Locale locale) throws BusinessException {
//		Connection con = null;
//		PreparedStatement insertUser = null;
//		PreparedStatement insertLocal = null;
//		String sqlUser = "insert into UTENTE(oid, username, password, email, telefono, nome,"/* contenuto_multimediale, "*/
//				+ /*canale_oid, */" cognome) values (userseq.NEXTVAL, ?, ?, ?, ?, ?, ?"/*, ?,?*/+")";
//		String sqlLocale = "insert into LOCALE(oid, indirizzo, orarioapertura, orariochiusura, descrizione) values (userseq.CURRVAL, ?, ?, ?, ?)";//gli altri campi di locale sono riferimenti esterni e li trattiamo in seguito
//		try {
//			con = dataSource.getConnection();
//			con.setAutoCommit(false);
//			insertUser =  con.prepareStatement(sqlUser);
//			insertUser.setString(1, locale.getUsername());
//			insertUser.setString(2, locale.getPassword());
//			insertUser.setString(3, locale.getEmail());
//			insertUser.setString(4, locale.getTelefono());
//			insertUser.setString(5, locale.getNome());
//			
//			//trattare inserimento entita riferite
//			insertUser.setString(6, locale.getCognome());
//			insertUser.executeUpdate();
//			//
//			
//			insertLocal = con.prepareStatement(sqlLocale);
//			
//			insertLocal.setString(1, locale.getIndirizzo());
//			insertLocal.setString(2, locale.getOrarioApertura());
//			insertLocal.setString(3, locale.getOrarioChiusura());
//			insertLocal.setString(4, locale.getDescrizione());
//			insertLocal.executeUpdate();
//			con.commit();
//			
//			
//		} catch (SQLException e) {
//			if (con != null) {
//				try {
//					System.err.print("Transaction is eing rolled back");
//					e.printStackTrace();
//					System.err.println(e.getCause().toString()+e.getSQLState());
//					con.rollback();
//				} catch (SQLException excep) {
//					System.out.println("errore rollback");
//					excep.printStackTrace();
//				}
//				e.printStackTrace();
//				throw new BusinessException(e);
//			}
//		} }
//	
//	//MARIO
//	public void deleteUtente(int id) throws BusinessException {
//		
//		Connection con = null;
//		PreparedStatement deleteUser = null;
//		String sqlUser = "DELETE FROM UTENTE WHERE OID=?"; 
//		
//		try {
//			con = dataSource.getConnection();
//			con.setAutoCommit(false);
//			deleteUser = con.prepareStatement(sqlUser);
//			deleteUser.setInt(1, id);
//			deleteUser.executeUpdate();
//			con.commit();
//			
//			
//		} catch (SQLException e) {
//			if (con != null) {
//				try {
//					System.err.print("Transaction is eing rolled back");
//					e.printStackTrace();
//					System.err.println(e.getCause().toString()+e.getSQLState());
//					con.rollback();
//				} catch (SQLException excep) {
//					System.out.println("errore rollback");
//					excep.printStackTrace();
//				}
//				e.printStackTrace();
//				throw new BusinessException(e);
//			}
//		} }
//		
//		
//		
//		
//		
//		
//		
//		
//	
//
//	
//		
//	
//	}
//
//
