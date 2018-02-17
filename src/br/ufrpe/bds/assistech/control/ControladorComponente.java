package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bds.assistech.model.bean.Componente;
import br.ufrpe.bds.assistech.model.dao.ComponenteDAO;

public class ControladorComponente implements IControlador<Componente>{

	private ComponenteDAO componente;

	public ControladorComponente(){
		this.componente = new ComponenteDAO();
	}
	
	@Override
	public void cadastrar(Componente co) {
		if(co!=null){
			try {
				componente.cadastrar(co);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}

	@Override
	public void remover(Componente co) {
		try {
			if (co != null) {
				componente.remover(co);
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
	
	public List<Componente> listarTodos() {
		List<Componente> componentes = new ArrayList<>();
		try {
			componentes = componente.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return componentes;
	}
	
	public List<Componente> listarPorCod(String str) {
		List<Componente> componentes = new ArrayList<>();
		if(str!=null){
			try {
				componentes = componente.listarPorCod(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return componentes;
	}
	
	public void atualizar(Componente co) {
		try {
			componente.atualizar(co);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

