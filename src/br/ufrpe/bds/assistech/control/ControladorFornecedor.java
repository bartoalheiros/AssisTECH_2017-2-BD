package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.dao.FornecedorDAO;


public class ControladorFornecedor implements IControlador<Fornecedor>{

	private FornecedorDAO fornecedor;

	public ControladorFornecedor(){
		this.fornecedor = new FornecedorDAO();
	}
	
	@Override
	public void cadastrar(Fornecedor o) {
		if(o!=null){
			try {
				fornecedor.cadastrar(o);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}

	@Override
	public void remover(Fornecedor o) {
		try {
			if (o != null) {
				fornecedor.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean sohNumeros( String s ) {  
		boolean d = true;  
		
		for ( int i = 0; i < s.length(); i++ ) { 
			// verifica se a string s contém letras. A primeira letra que houver ele sai do laço.
			if ( Character.isAlphabetic( s.charAt(i)) ) {  
				d = false;  
				break;  
			}  
		}  
		return d;  
	}
	
	public List<Fornecedor> listarTodos() {
		List<Fornecedor> fornecedores = new ArrayList<>();
		try {
			fornecedores = fornecedor.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fornecedores;
	}
	
	public List<Fornecedor> listarPorCnpj(String str) {
		List<Fornecedor> fornecedores = new ArrayList<>();
		if(str!=null){
			try {
				fornecedores = fornecedor.listarPorCnpj(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fornecedores;
	}
	
	public void atualizar(Fornecedor o) {
		try {
			fornecedor.atualizar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
