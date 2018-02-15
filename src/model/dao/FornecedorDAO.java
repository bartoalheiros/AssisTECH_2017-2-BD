package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;
import service.ConnectionFactory;

public class FornecedorDAO extends DAO<Fornecedor>{

	private static FornecedorDAO instance = null;


	public FornecedorDAO() {

	}

	public static FornecedorDAO getInstance() {
		if(instance == null) {
			instance = new FornecedorDAO();
		}

		return instance;
	}

	public void cadastrar(Fornecedor f) throws Exception{
		String sql = "insert into fornecedor " + "(Cnpj,Razao_social,Email,Telefone) " +
						"values (?,?,?,?)";
		prepare(sql);
		getStmt().setLong(1, f.getCnpj());
		getStmt().setString(2, f.getRazaoSocial());
		getStmt().setString(3, f.getEmail());
		getStmt().setString(4, f.getTelefone());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!");
		} finally {
			closeStmt();
		}
		
		
	}

	public List<Fornecedor> listarTodos() throws Exception {
		
		String sql = "SELECT * FROM fornecedor";
		prepare(sql);
		ResultSet rs = null;
		
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			closeStmt();
		}
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		while (rs.next()) {
			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setCnpj(rs.getLong("Cnpj"));
			fornecedor.setRazaoSocial(rs.getString("Razao_social"));
			fornecedor.setEmail(rs.getString("Email"));
			fornecedor.setTelefone(rs.getString("Telefone"));

			fornecedores.add(fornecedor);

		}
		
		rs.close();
		closeStmt();
		return fornecedores;
	}

	@Override
	public void atualizar(Fornecedor o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Fornecedor o) throws Exception {
		String sql = "DELETE FROM fornecedor WHERE Cnpj = ?";
		prepare(sql);
		getStmt().setLong(1, o.getCnpj());
		
		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível remover!");
		} finally {
			closeStmt();
		}
		
	}



}
