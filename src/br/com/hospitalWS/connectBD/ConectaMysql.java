package br.com.hospitalWS.connectBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMysql {

	private static final String URL ="jdbc:mysql://127.0.0.1:3306/hospital";
	private static final String USER ="root";
	private static final String SENHA ="root";
	 
	public static Connection obtemConexao() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL,USER,SENHA);
	}
}
