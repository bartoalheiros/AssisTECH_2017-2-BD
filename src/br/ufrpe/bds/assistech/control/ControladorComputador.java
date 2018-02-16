package br.ufrpe.bds.assistech.control;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.ufrpe.bds.assistech.model.bean.Computador;
import br.ufrpe.bds.assistech.model.dao.ComputadorDAO;

public class ControladorComputador {
	
	public boolean cadastrar(Computador pc){

		boolean r = true;
		ComputadorDAO dao = null;
		dao = ComputadorDAO.getInstance();
		if(!this.sohNumeros(pc.getCodEquipamento())) {
			JOptionPane.showMessageDialog(null, "Código equipamento só pode ter números!");
			r = false;
		}
		/*if(pc.getDataInicio().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Data inicio vazio!");
			 r = false;
		}	*/


		if(r){
			try{
				dao.create(pc);
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
		
	public void delete(Computador pc){
		ComputadorDAO dao = null;
		dao = ComputadorDAO.getInstance();

		dao.delete(pc);
	}
}
