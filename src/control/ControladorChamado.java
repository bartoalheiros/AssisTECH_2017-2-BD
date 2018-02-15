package control;

import javax.swing.JOptionPane;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import model.bean.Chamado;
import model.dao.ChamadoDAO;

public class ControladorChamado {
	
	public boolean cadastrar(Chamado c){
		
		boolean r = true;
		ChamadoDAO dao = null;
		dao = ChamadoDAO.getInstance();
		if(!this.sohNumeros(c.getSequencial())) {
			 JOptionPane.showMessageDialog(null, "Sequencial só pode ter números!");
			 r = false;
		}
		if(c.getDataAbertura().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Data abertura vazio!");
			 r = false;
		}	
		
		
		if(r){
			try{
				dao.create(c);
			}catch(MySQLIntegrityConstraintViolationException e){
				JOptionPane.showMessageDialog(null, "Campo ID_atendimento vazio ou não existe!");
			}
		}
		
		return r;
	}
	
	private boolean sohNumeros(Long sequencial) {
		// TODO Auto-generated method stub
		return false;
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
	
	public void delete(Chamado c){
		ChamadoDAO dao = null;
		dao = ChamadoDAO.getInstance();
		
		dao.delete(c);
	}
}
