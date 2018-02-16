package br.ufrpe.bds.assistech.control;

public interface IControlador<T> {
	void cadastrar(T o);
	void remover(T o);
}
