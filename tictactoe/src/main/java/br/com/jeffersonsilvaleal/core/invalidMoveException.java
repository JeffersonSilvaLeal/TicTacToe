package br.com.jeffersonsilvaleal.core;

// Mostra ao copilador para n�o gerar warning
@SuppressWarnings("serial")
public class invalidMoveException extends Exception {
	
	// Mostra um msg como parametro
	public invalidMoveException(String message) {
		super(message);
		
	}
}
