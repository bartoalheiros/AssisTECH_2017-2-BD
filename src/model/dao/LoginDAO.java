package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import service.ConnectionFactory;

public class LoginDAO {
	private final String URL = "jdbc:mysql://localhost:3306/assistech";
	@SuppressWarnings("unused")
	private String nome;
	@SuppressWarnings("unused")
	private String senha;
	private Connection con;
	private static LoginDAO instance = null;

	//para garantir que a classe login terá uma única instância
	public static LoginDAO getInstance() {
		if(instance == null) {
			instance = new LoginDAO();
		}

		return instance;
	}
	

	public void closeConnection() throws SQLException {
		con.close();
	}

	public void login(String nome, String senha) throws Exception {
		setNome(nome);
		setSenha(senha);
		con = ConnectionFactory.getConnection(URL, nome, senha);
		con.setAutoCommit(false);
	}

	public Connection getConnection() {
		return this.con;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}
}
