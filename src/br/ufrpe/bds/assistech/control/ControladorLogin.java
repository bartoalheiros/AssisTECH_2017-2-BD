package br.ufrpe.bds.assistech.control;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufrpe.bds.assistech.model.dao.LoginDAO;

public class ControladorLogin {
	private LoginDAO loginDAO;

	public ControladorLogin() {
		this.loginDAO = LoginDAO.getInstance();
	}

	public void fecharConexao() throws SQLException {
		loginDAO.closeConnection();
	}

	public void fazerLogin(String nome, String senha) throws Exception {
		loginDAO.login(nome, senha);
	}

	public Connection getConnection() {
		return loginDAO.getConnection();
	}
}
