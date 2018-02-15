package control;

public abstract class Controlador<T> {
	public abstract void cadastrar(T o);
	public abstract void remover(T o);
}
