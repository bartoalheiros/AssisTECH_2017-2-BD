package control;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.LoginDAO;

public class ControladorLogin {
	private LoginDAO login_dao;

	public ControladorLogin() {
		this.login_dao = new LoginDAO();
	}

	public void fecharConexao() throws SQLException {
		login_dao.closeConnection();
	}

	public void fazerLogin(String nome, String senha) throws Exception {
		login_dao.login(nome, senha);
	}

	public Connection getConnection() {
		return login_dao.getConnection();
	}
}
