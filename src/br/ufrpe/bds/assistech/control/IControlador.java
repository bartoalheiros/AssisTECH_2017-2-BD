package br.ufrpe.bds.assistech.control;

import java.util.List;

public interface IControlador<T> {
	void cadastrar(T o);
	void remover(T o);
	void atualizar(T o);
	List<T> listarTodos();
}
