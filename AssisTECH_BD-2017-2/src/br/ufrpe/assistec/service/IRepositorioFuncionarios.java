/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.assistec.service;

import java.sql.SQLException;
import java.util.List;
import br.ufrpe.assistec.model.Funcionario;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public interface IRepositorioFuncionarios {
	
    //adiciona um funcionario ao banco
	public boolean cadastra(Funcionario f);
	
	public void atualiza(Funcionario f) throws SQLException;

	public List<Funcionario> busca(String nomeFuncionario);

	public List<Funcionario> lista();

}
