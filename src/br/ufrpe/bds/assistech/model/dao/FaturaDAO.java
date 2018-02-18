package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;

public class FaturaDAO extends DAO<Fatura> {

	public FaturaDAO() {


	}

	@Override
	public void cadastrar(Fatura o) throws Exception {
		String sql = "insert into fatura " + "(Cod,Num_parcelas,Valor_total,Status_,Cod_cliente) " +
				"values (?,?,?,?,?)";
		prepare(sql);
		getStmt().setLong(1, o.getCod());
		getStmt().setLong(2, o.getNum_parcelas());
		getStmt().setFloat(3, o.getValor_total());
		getStmt().setString(4, o.getStatus());
		getStmt().setLong(5, o.getCod_cliente());

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
	public List<Fatura> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fatura> listarPorCodCliente(String str) throws Exception {
		List<Fatura> faturas = new ArrayList<>();
		String sql = "SELECT * FROM fatura WHERE Cod_cliente LIKE ?";
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
			Fatura fatura = new Fatura();

			fatura.setCod(rs.getLong("Cod"));
			fatura.setNum_parcelas(rs.getLong("Num_parcelas"));
			fatura.setValor_total(rs.getFloat("Valor_total"));
			fatura.setStatus(rs.getString("Status_"));
			fatura.setCod_cliente(rs.getLong("Cod_cliente"));

			faturas.add(fatura);
		}


		return faturas;

	}


	@Override
	public void atualizar(Fatura o) throws Exception {
		String sql = "UPDATE fatura SET `Num_parcelas` = ?, `Valor_total` = ?, `Status_` = ?, `Cod_cliente` = ?  WHERE `Cod` = ?";
		prepare(sql);
		
		getStmt().setLong(1, o.getNum_parcelas());
		getStmt().setFloat(2, o.getValor_total());
		getStmt().setString(3, o.getStatus());
		getStmt().setLong(4, o.getCod_cliente());
		getStmt().setLong(5, o.getCod());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível alterar!");
		}

	}

	@Override
	public void remover(Fatura o) throws Exception {
		String sql = "DELETE FROM fatura WHERE Cod = ?";
		prepare(sql);
		getStmt().setLong(1, o.getCod());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível remover!");
		}

	}

	public List<Fatura> listarPorCodigoFatura(String str) throws Exception {
		List<Fatura> faturas = new ArrayList<>();
		String sql = "SELECT * FROM fatura WHERE Cod LIKE ?";
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
			Fatura fatura = new Fatura();

			fatura.setCod(rs.getLong("Cod"));
			fatura.setNum_parcelas(rs.getLong("Num_parcelas"));
			fatura.setValor_total(rs.getFloat("Valor_total"));
			fatura.setStatus(rs.getString("Status_"));
			fatura.setCod_cliente(rs.getLong("Cod_cliente"));

			faturas.add(fatura);
		}


		return faturas;
	}

}
