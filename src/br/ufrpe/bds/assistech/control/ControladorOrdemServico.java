package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.OrdemServico;
import br.ufrpe.bds.assistech.model.dao.OrdemServicoDAO;

public class ControladorOrdemServico implements IControlador<OrdemServico> {

	OrdemServicoDAO ordemServico;
	
	public ControladorOrdemServico() {
		this.ordemServico = new OrdemServicoDAO();
	}
	
	@Override
	public void cadastrar(OrdemServico o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(OrdemServico o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(OrdemServico o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrdemServico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<OrdemServico> listarPorCodFatura(String str) {
		List<OrdemServico> listOrdens = new ArrayList<>();
		try {
			listOrdens = ordemServico.listarPorCodFatura(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOrdens;
	} 

}
