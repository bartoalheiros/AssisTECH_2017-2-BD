package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import service.ConnectionFactory;

public abstract class DAO {

	protected Connection con = ConnectionFactory.getConnection();
	protected PreparedStatement stmt;

	public PreparedStatement getStmt() {
		return stmt;
	}

	public Connection getCon() {
		return con;
	}

	
	/*public void preparar(String sql) throws Exception {
		con = Fachada.getInstance().getConnection();
		stmt = con.prepareStatement(sql);
	}*/
	
}
