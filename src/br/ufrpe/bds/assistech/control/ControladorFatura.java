package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.dao.FaturaDAO;

public class ControladorFatura implements IControlador<Fatura> {

	private FaturaDAO fatura;

	public ControladorFatura(){
		this.fatura = new FaturaDAO();
	}

	@Override
	public void cadastrar(Fatura o) {
		try {
			fatura.cadastrar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Fatura o) {
		try {
			fatura.remover(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Fatura o) {
		try {
			fatura.atualizar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Fatura> listarTodos() {
		List<Fatura> faturas = new ArrayList<>();
		try {
			faturas = fatura.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return faturas;
	}

	public List<Fatura> listarPorCodCliente(String str) {
		List<Fatura> faturas = new ArrayList<>();
		try {
			faturas = fatura.listarPorCodCliente(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return faturas;
	}

	public List<Fatura> listarPorCodigo(String str) {
		List<Fatura> faturas = new ArrayList<>();
		try {
			faturas = fatura.listarPorCodigoFatura(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return faturas;
	}

}
