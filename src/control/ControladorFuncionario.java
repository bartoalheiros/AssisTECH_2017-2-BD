package control;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

public class ControladorFuncionario extends Controlador<Funcionario>{
	
	private FuncionarioDAO func_dao;
	
	public ControladorFuncionario() {
		this.func_dao = new FuncionarioDAO();
	}
	
	public void cadastrar(Funcionario f){
		
		//To DO essas exceções precisam ser tratadas na tela.
		
		/*if(!this.sohNumeros(f.getMatricula())) {
			 JOptionPane.showMessageDialog(null, "Matrícula só pode ter números!");
			 r = false;
		}
		if(f.getDataInicio().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Data inicio vazio!");
			 r = false;
		}*/	
		
		try{
			func_dao.cadastrar(f);
		}catch(MySQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(null, "Campo ID_Jornada vazio ou não existe!");
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
	
	public void remover(Funcionario f){
		try {
			if (f != null) {
				func_dao.remover(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
