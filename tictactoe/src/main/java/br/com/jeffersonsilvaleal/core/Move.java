package br.com.jeffersonsilvaleal.core;

public class Move {

	// Vari�vel para controlar a coluna
	private int i;

	// Vari�vel para controlar a linha
	private int j;

	// Construtor que recebe par�metros
	// throws lan�a a exce��o para quem chamou
	public Move(String moveString) throws invalidMoveException{
		// "2,5"
		// ["2" "5"]

		try {
			String[] tokens = moveString.split(",");// Quebra a String
			this.i = Integer.parseInt(tokens[0]);// Converte String em int
			this.j = Integer.parseInt(tokens[1]);
			
			// Pega qualquer tipo de exce��o
		} catch (Exception e) {
			// Lan�a uma  exce��o
			throw new invalidMoveException("Jogada Inv�lida");
		}

	}

	// M�todos para setar(SETTERS) e retornar(GETTERS) valores
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
