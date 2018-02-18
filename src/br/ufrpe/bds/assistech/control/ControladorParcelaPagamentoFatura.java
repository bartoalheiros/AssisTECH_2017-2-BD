package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.ParcelaPagamentoFatura;
import br.ufrpe.bds.assistech.model.dao.ParcelaPagamentoFaturaDAO;

public class ControladorParcelaPagamentoFatura implements IControlador<ParcelaPagamentoFatura> {

	private ParcelaPagamentoFaturaDAO parcelaPagamento;
	
	public ControladorParcelaPagamentoFatura() {
		this.parcelaPagamento = new ParcelaPagamentoFaturaDAO();
	}
	
	@Override
	public void cadastrar(ParcelaPagamentoFatura o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(ParcelaPagamentoFatura o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(ParcelaPagamentoFatura o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParcelaPagamentoFatura> listarTodos() {
		return null;
	}
	
	public List<ParcelaPagamentoFatura> listarParcelasPgtoPorCodFatura(String str) {
		List<ParcelaPagamentoFatura> parcelasPagamentoFatura = new ArrayList<>();
		try {
			parcelasPagamentoFatura = parcelaPagamento.listarTodosPorCodFatura(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parcelasPagamentoFatura;
	}

}
