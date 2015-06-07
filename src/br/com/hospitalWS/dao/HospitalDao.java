package br.com.hospitalWS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.hospitalWS.connectBD.ConectaMysql;
import br.com.hospitalWS.model.PlaceDetail;



public class HospitalDao {
	private Connection connection;
	
	public HospitalDao() throws SQLException {
		this.connection = ConectaMysql.obtemConexao();
	}
	public boolean adiciona(PlaceDetail pd) {
		 String sql = "insert into hospital " +
		 "(id_hospital,nm_hospital,rt_hospital,end_hospital,lat_hospital,lng_hospital)" +
		 " values (null,?,?,?,?,?)";
		
		 try {
		 // prepared statement para inserção
		 PreparedStatement stmt = connection.prepareStatement(sql);
		 // seta os valores
		 stmt.setString(1,pd.getName());
		 stmt.setDouble(2,pd.getRatings());
		 stmt.setString(3,pd.getEnd());
		 stmt.setDouble(4,Double.valueOf(pd.getLat()));
		 stmt.setDouble(5,Double.valueOf(pd.getLon()));
		 // executa
		 stmt.executeUpdate();
		 stmt.close();
		 } catch (SQLException s) {
			 System.out.println(s.getErrorCode()+s.getMessage());
			 return false;
			 }
		 return true;
		 }
}