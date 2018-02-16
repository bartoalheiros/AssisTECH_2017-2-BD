package br.ufrpe.bds.assistech.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.ufrpe.bds.assistech.view.Fachada;

public abstract class DAO<T> {

	protected Connection con;
	protected PreparedStatement stmt;
	
	public PreparedStatement getStmt() {
		return stmt;
	}

	public Connection getCon() {
		return con;
	}

	public void closeStmt() throws SQLException {
		stmt.close();
	}

	public void prepare(String sql) throws Exception {
		con = Fachada.getInstance().getConnection();
		stmt = con.prepareStatement(sql);
	}

	public abstract void cadastrar(T o) throws Exception;

	public abstract List<T> listarTodos() throws Exception;
	
	public abstract void atualizar(T o) throws Exception;
	
	public abstract void remover(T o) throws Exception;

	
}
