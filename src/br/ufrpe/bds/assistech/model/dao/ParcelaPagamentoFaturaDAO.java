package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.ParcelaPagamentoFatura;

public class ParcelaPagamentoFaturaDAO extends DAO<ParcelaPagamentoFatura> {

	@Override
	public void cadastrar(ParcelaPagamentoFatura o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParcelaPagamentoFatura> listarTodos() throws Exception {
		return null;
	}

	@Override
	public void atualizar(ParcelaPagamentoFatura o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(ParcelaPagamentoFatura o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<ParcelaPagamentoFatura> listarTodosPorCodFatura(String str) throws Exception {
		String sql = "SELECT * FROM parcela_pagto_fatura WHERE Cod_fatura LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
		}

		List<ParcelaPagamentoFatura> parcelasPagamento = new ArrayList<>();

		while (rs.next()) {
			ParcelaPagamentoFatura parcelaPagamento = new ParcelaPagamentoFatura();

			parcelaPagamento.setSeqParcelaPgto(rs.getLong("Seq_parcela_pagto_fatura"));
			parcelaPagamento.setCodFatura(rs.getLong("Cod_fatura"));
			parcelaPagamento.setDtaPagto(rs.getString("Data_pagamento"));
			parcelaPagamento.setDtaParcela(rs.getString("Data_parcela"));
			parcelaPagamento.setJuros(rs.getFloat("Juros"));
			parcelaPagamento.setValorTotal(rs.getFloat("Valor_total"));
			parcelaPagamento.setValorPgtoParcela(rs.getFloat("Valor_pg_parcela"));

			parcelasPagamento.add(parcelaPagamento);

		}

		
		return parcelasPagamento;
	}

}
