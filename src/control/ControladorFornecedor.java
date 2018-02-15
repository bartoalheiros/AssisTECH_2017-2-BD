package control;

import model.bean.Fornecedor;
import model.dao.FornecedorDAO;


public class ControladorFornecedor extends Controlador<Fornecedor>{

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
}
