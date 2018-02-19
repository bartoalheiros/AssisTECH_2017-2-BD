/** 
 * @author Bartô
 * UFRPE - Banco de dados S
 *  br.ufrpe.bds.assistech.model.dao - Versao 1.0 - 2017.2
 */
package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;

public class FornecedorDAO extends DAO<Fornecedor>{


	public FornecedorDAO() {

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
		
		return fornecedores;
	}

	public List<Fornecedor> listarPorCnpj(String str) throws Exception {
		List<Fornecedor> fornecedores = new ArrayList<>();
		String sql = "SELECT * FROM fornecedor WHERE Cnpj LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;


		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null, "Erro na busca!");
		}

		while (rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCnpj(rs.getLong("Cnpj"));
			fornecedor.setRazaoSocial(rs.getString("Razao_social"));
			fornecedor.setEmail(rs.getString("Email"));
			fornecedor.setTelefone(rs.getString("Telefone"));
			fornecedores.add(fornecedor);
		}


		return fornecedores;

	}

	@Override
	public void atualizar(Fornecedor o) throws Exception {
		String sql = "UPDATE fornecedor SET `Razao_social` = ?, `Email` = ?, `Telefone` = ?  WHERE `Cnpj` = ?";
		prepare(sql);
		getStmt().setString(1, o.getRazaoSocial());
		getStmt().setString(2, o.getEmail());
		getStmt().setString(3, o.getTelefone());
		getStmt().setLong(4, o.getCnpj());
		
		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível alterar!");
			e.printStackTrace();
		}
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
		}

	}



}
