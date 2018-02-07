package control;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

public class CadastroFuncionarioControler {
	
	public boolean cadastrar(Funcionario f){
		
		boolean r = true;
		FuncionarioDAO dao = null;
		dao = FuncionarioDAO.getInstance();
		if(!this.sohNumeros(f.getMatricula())) {
			 JOptionPane.showMessageDialog(null, "Matrícula só pode ter números!");
			 r = false;
		}
		if(f.getDataInicio().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Data inicio vazio!");
			 r = false;
		}	
		
		
		if(r){
			try{
				dao.create(f);
			}catch(MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Campo ID_Jornada vazio ou não existe!");
			}
		}
		
		return r;
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
}
