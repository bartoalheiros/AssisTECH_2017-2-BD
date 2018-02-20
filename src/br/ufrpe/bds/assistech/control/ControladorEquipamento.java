package br.ufrpe.bds.assistech.control;

import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Equipamento;
import br.ufrpe.bds.assistech.model.dao.EquipamentoDAO;

public class ControladorEquipamento implements IControlador{

	EquipamentoDAO equipamento;
	
	public ControladorEquipamento() {
		this.equipamento = new EquipamentoDAO();
	}
	
	@Override
	public void cadastrar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Equipamento> listarTodos() {
		List<Equipamento> equipamentos = null;
		
		try {
			equipamentos = equipamento.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipamentos;
	}

}
