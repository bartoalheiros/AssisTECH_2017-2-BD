package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufrpe.bds.assistech.model.bean.Funcionario;
import br.ufrpe.bds.assistech.model.dao.FuncionarioDAO;

public class ControladorFuncionario implements IControlador<Funcionario>{
	
	private FuncionarioDAO funcionario;
	
	public ControladorFuncionario() {
		this.funcionario = new FuncionarioDAO();
	}
	
	public void cadastrar(Funcionario f){

		try{
			funcionario.cadastrar(f);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Campo ID_Jornada vazio ou não existe!");
			e.printStackTrace();
		}

		
	}
	
	public void remover(Funcionario f){
		try {
			if (f != null) {
				funcionario.remover(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Funcionario f) {
		try {
			funcionario.atualizar(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	public List<Funcionario> listarTodos(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			funcionarios = funcionario.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionarios;
	} 
	
	public List<Funcionario> listarPorMatricula(String str) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			funcionarios = funcionario.listarPorMatricula(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionarios;
	}
}
