//package it.univaq.mwt.business.impl;
//
//import it.univaq.mwt.business.BusinessException;
//import it.univaq.mwt.business.SecurityService;
//import it.univaq.mwt.business.model.Ruoli;
//import it.univaq.mwt.business.model.Utente;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//public class JDBCSecurityService implements SecurityService {
//
//	@Override
//	public Utente authenticate(String username) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@AUTOWIRED
//	PRIVATE DATASOURCE DATASOURCE;
//
//	
//	@Override
//	public Utente authenticate(String u) throws BusinessException {
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		Utente result = null;
//		try {
//			con = dataSource.getConnection();
//			
//			st = con.prepareStatement("select * from UTENTE u where u.username = ?");
//			st.setString(1, u);
//			System.out.println(st.toString());
//			rs = st.executeQuery();
//			if (rs.next()) {
//				String username = rs.getString("USERNAME");
//				String password = rs.getString("PASSWORD");
//				String nome = rs.getString("NOME");
//				String email = rs.getString("EMAIL");
//				String telefono = rs.getString("TELEFONO");
//				String cognome = rs.getString("COGNOME");
//				
//				
//				//System.out.println(username);
//				
//			
//				
//				Set<Ruoli> roles = findRoles(u, con);
//				result = null; //new Utente(roles, username, password, nome, cognome, telefono, email);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException(e);
//		} finally {
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
//		System.out.println("result "+ result.getUsername()+result.getRuoli());
//		return result;
//	}
//
//
//
//	private Set<Ruoli> findRoles(String u, Connection con) throws BusinessException {
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		Set<Ruoli> result = new HashSet<Ruoli>();
//		try {
//			st = con.prepareStatement("select role_name from \"USER\" u inner join \"ROLES_USER\" ur inner join \"ROLES\" on \"ROLES\".OID=ur.ROLES_OID  on u.oid=ur.user_oid where u.USERNAME=?");
//			st.setString(1, u);
//			rs = st.executeQuery();
//			while (rs.next()) {
//				String roleName = rs.getString("ROLE_NAME");
//				
//				Ruoli role = new Ruoli();
//				role.setNome((roleName));
//				/*role.setDescription(description);*/
//				result.add(role);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException(e);
//		} finally {
//			if (st != null) {
//				try {
//					st.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
//		return result;
//	}
//
//	public Set<Utente> findAllUsers(){
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		Set<Utente> result = new HashSet<Utente>();
//		try {
//			con = dataSource.getConnection();
//			st = con.prepareStatement("select * from \"USER\"");
//			rs = st.executeQuery();
//			while (rs.next()) {
//				String username = rs.getString("USERNAME");
//				String password = rs.getString("PASSWORD");
//				String firstName = rs.getString("NOME");
//				String lastName = rs.getString("EMAIL");
//				String address = rs.getString("TELEFONO");
//				
//				
//				Utente u = null; //new Utente(null, null, null, username, password, firstName, address, address, address);
//				result.add(u);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException(e);
//		} finally {
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
//		
//	}
//}
