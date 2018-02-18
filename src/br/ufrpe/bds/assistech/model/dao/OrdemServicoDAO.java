package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.OrdemServico;

public class OrdemServicoDAO extends DAO<OrdemServico> {

	@Override
	public void cadastrar(OrdemServico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrdemServico> listarTodos() throws Exception {
		
		return null;
	}

	@Override
	public void atualizar(OrdemServico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(OrdemServico o) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<OrdemServico> listarPorCodFatura(String str) throws Exception {
		List<OrdemServico> ordensServico = new ArrayList<>();
		String sql = "SELECT * FROM ordem_servico WHERE Cod_fatura LIKE ?";
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
			OrdemServico ordemServico = new OrdemServico();

			ordemServico.setNumOS(rs.getLong("Num_Ordem_Servico"));
			
			ordensServico.add(ordemServico);
		}


		return ordensServico;
	}

}
