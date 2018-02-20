package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Equipamento;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;

public class EquipamentoDAO extends DAO<Equipamento>{
	
	EquipamentoDAO equipamento;
	
	@Override
	public void cadastrar(Equipamento o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Equipamento> listarTodos() throws Exception {
		String sql = "SELECT * FROM equipamento";
		prepare(sql);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
		}

		List<Equipamento> equipamentos = new ArrayList<>();

		while (rs.next()) {
			Equipamento equipamento = new Equipamento();

			equipamento.setCod(rs.getString("Cod"));
			equipamento.setDta_entrada(rs.getString("Data_entrada"));
			equipamento.setSetor(rs.getString("Setor"));
			equipamento.setHistorico(rs.getString("historico"));
			equipamento.setFabricante(rs.getString("Fabricante"));
			equipamento.setEstado(rs.getString("Estado"));
			equipamento.setDescricao(rs.getString("Decricao"));
			equipamento.setCod_contrato(rs.getString("Cond_contrato"));
			equipamento.setCnpj_unid_suporte(rs.getLong("Cnpj_Unid_Suporte"));
			equipamento.setCod_cliente(rs.getLong("Cod_Cliente"));
			equipamento.setData_inicio(rs.getString("Data_inicio"));

			equipamentos.add(equipamento);

		}

		return equipamentos;

	}

	@Override
	public void atualizar(Equipamento o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Equipamento o) throws Exception {
		
	}

}
