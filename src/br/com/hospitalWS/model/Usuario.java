package br.com.hospitalWS.model;

public class Usuario {
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getRaio_busca() {
		return Raio_busca;
	}
	public void setRaio_busca(int raio_busca) {
		Raio_busca = raio_busca;
	}
	private String Nome;
	private String Email;
    private String Senha;
    private int Id;
    private int Raio_busca;
}

