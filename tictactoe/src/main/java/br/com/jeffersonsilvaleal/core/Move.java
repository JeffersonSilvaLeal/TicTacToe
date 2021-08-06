package br.com.jeffersonsilvaleal.core;

public class Move {

	// Variável para controlar a coluna
	private int i;

	// Variável para controlar a linha
	private int j;

	// Construtor que recebe parâmetros
	// throws lança a exceção para quem chamou
	public Move(String moveString) throws invalidMoveException{
		// "2,5"
		// ["2" "5"]

		try {
			String[] tokens = moveString.split(",");// Quebra a String
			this.i = Integer.parseInt(tokens[0]);// Converte String em int
			this.j = Integer.parseInt(tokens[1]);
			
			// Pega qualquer tipo de exceção
		} catch (Exception e) {
			// Lança uma  exceção
			throw new invalidMoveException("Jogada Inválida");
		}

	}

	// Métodos para setar(SETTERS) e retornar(GETTERS) valores
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
