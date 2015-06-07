package br.com.hospitalWS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hospitalWS.connectBD.ConectaMysql;
import br.com.hospitalWS.model.Usuario;


public class UsuarioDao {
	private Connection connection;
	
	public UsuarioDao() throws SQLException {
		this.connection = ConectaMysql.obtemConexao();
	}
	
	 
	  private PreparedStatement stmt  = null;
	  private ResultSet rs = null;
	  
	public boolean adiciona(Usuario user) {
		 String sql = "insert into usuario " +
		 "(id_usuario,nome_usuario,email_usuario,senha_usuario,raio_busca)" +
		 " values (null,?,?,?,?)";
		
		 try {
		 // prepared statement para inserção
		 PreparedStatement stmt = connection.prepareStatement(sql);
		 // seta os valores
		 stmt.setString(1,user.getNome());
		 stmt.setString(2,user.getEmail());
		 stmt.setString(3,user.getSenha());
		 stmt.setInt(4,user.getRaio_busca());	
		 // executa
		 stmt.executeUpdate();
		 close();
		 } catch (SQLException s) {
			 System.out.println(s.getErrorCode()+s.getMessage());
			 return false;
			 }
		 return true;
		 }
	public Usuario getUsuarioPorEmail(String Email) {
		Usuario resposta = new Usuario();
		 try {
		 PreparedStatement stmt = connection.
		 prepareStatement("select * from usuario where email_usuario=?");
		 stmt.setString(1, Email);
		 ResultSet rs = stmt.executeQuery();
		
		 if(rs.next()) {
			 
		 // criando o objeto Contato
		
			 resposta.setId(rs.getInt("id_usuario"));
			 resposta.setNome(rs.getString("nome_usuario"));
			 resposta.setEmail(rs.getString("email_usuario"));
			 resposta.setRaio_busca(rs.getInt("raio_busca"));
			 resposta.setSenha(rs.getString("senha_usuario"));
		 }
		 close();
		 
		 } catch (Exception e) {
			 return null;
			 }
		 return resposta;
		 }
	public boolean altera(Usuario user) {
		
		String sql = "update usuario set nome_usuario=?, email_usuario=?, senha_usuario=?, raio_busca=? where id_usuario=?";
		 try {
		 	 
		 PreparedStatement stmt = connection.prepareStatement(sql);
		 stmt.setString(1, user.getNome());
		 stmt.setString(2, user.getEmail());
		 stmt.setString(3, user.getSenha());
		 stmt.setInt(4, user.getRaio_busca());
		 stmt.setInt(5, user.getId());
		 stmt.executeUpdate();
		 close();
		 } catch (SQLException e) {
			 e.printStackTrace();
			 return false;
			 }
		 return true;
		 }
	 
	 public Boolean remove(Usuario user) {
		try {
		 
		 PreparedStatement stmt = connection
		 .prepareStatement("delete from usuario where id_usuario=?");
		 stmt.setInt(1, user.getId());
		 stmt.executeUpdate();
		 close();
		 } catch (Exception e) {
			 return false;
			 }
		 return true;
		 }
	 
	 public void close() {
		    try {
		      if (rs != null) {
		        rs.close();
		      }

		      if (stmt!= null) {
		    	  stmt.close();
		      }

		      if (connection != null) {
		    	  connection.close();
		      }
		    } catch (Exception e) {

		    }
		  }
	 
}

