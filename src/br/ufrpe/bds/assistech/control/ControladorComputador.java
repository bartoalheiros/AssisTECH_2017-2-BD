package br.ufrpe.bds.assistech.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.ufrpe.bds.assistech.model.bean.Computador;
import br.ufrpe.bds.assistech.model.dao.ComputadorDAO;

public class ControladorComputador implements IControlador<Computador>{
	
	private ComputadorDAO computador;
	
	public ControladorComputador() {
		this.computador = new ComputadorDAO();
	}
	
	public void cadastrar(Computador o){
		try {
			computador.cadastrar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void remover(Computador o){
		try {
			computador.remover(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Computador o) {
		try {
			computador.atualizar(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Computador> listarTodos() {
		List<Computador> computadores = null;
		
		try {
			computadores = computador.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return computadores;
	}

	public List<Computador> listarTodosPorCodigo(String str) {
		List<Computador> computadores = null;
		
		try {
			computadores = computador.listarPorCodigo(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return computadores;
	}
}
