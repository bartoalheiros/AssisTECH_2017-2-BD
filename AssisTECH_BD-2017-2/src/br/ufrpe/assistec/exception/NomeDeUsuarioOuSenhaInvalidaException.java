package br.ufrpe.assistec.exception;

public class NomeDeUsuarioOuSenhaInvalidaException extends Exception {
	public NomeDeUsuarioOuSenhaInvalidaException() {
		super("Nome de Usuário ou Senha Inválidos!");
	}
}
