package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.dao.ClienteDAO;

public class ControladorCliente implements IControlador<Cliente> {

	private ClienteDAO cliente;
	
	public ControladorCliente() {
		this.cliente = new ClienteDAO();
	}
	
	@Override
	public void cadastrar(Cliente o) {
		try {
			cliente.cadastrar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = cliente.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}

	public List<Cliente> listarClientePorCod(String str) {
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = cliente.listaClientePorCod(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

}
