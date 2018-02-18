package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;

public class ClienteDAO extends DAO<Cliente> {
	
	public ClienteDAO() {

	}
	
	@Override
	public void cadastrar(Cliente o) throws Exception {
		String sql = "insert into cliente " + "(Cod,Prioridade,Endereco,Estado,Email,Fone) " +
				"values (?,?,?,?,?,?)";
		prepare(sql);
		getStmt().setLong(1, o.getCod());
		getStmt().setString(2, o.getPrioridade());
		getStmt().setString(3, o.getEndereco());
		getStmt().setString(4, o.getEstado());
		getStmt().setString(5, o.getEmail());
		getStmt().setString(6, o.getFone());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!");
		}
		
	}

	@Override
	public List<Cliente> listarTodos() throws Exception {
		String sql = "SELECT * FROM cliente";
		prepare(sql);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
		}

		List<Cliente> clientes = new ArrayList<>();

		while (rs.next()) {
			Cliente cliente = new Cliente();

			cliente.setCod(rs.getLong("Cod"));
			cliente.setPrioridade(rs.getString("Prioridade"));
			cliente.setEndereco(rs.getString("Endereco"));
			cliente.setEstado(rs.getString("Estado"));
			cliente.setEmail(rs.getString("Email"));
			cliente.setFone(rs.getString("Fone"));

			clientes.add(cliente);

		}

		
		return clientes;
	}

	@Override
	public void atualizar(Cliente o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Cliente o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Cliente> listaClientePorCod(String str) throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente WHERE Cod LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			ex.printStackTrace();
		}

		while (rs.next()) {
			Cliente cliente = new Cliente();

			cliente.setCod(rs.getLong("Cod"));
			cliente.setPrioridade(rs.getString("Prioridade"));
			cliente.setEndereco(rs.getString("Endereco"));
			cliente.setEstado(rs.getString("Estado"));
			cliente.setEmail(rs.getString("Email"));
			cliente.setFone(rs.getString("Fone"));

			clientes.add(cliente);

		}

		return clientes;
	}

}
