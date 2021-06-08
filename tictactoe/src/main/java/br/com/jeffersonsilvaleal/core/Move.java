package br.com.jeffersonsilvaleal.core;

public class Move {

	// Variável para controlar a coluna
	private int i;
	
	// Variável para controlar a linha
	private int j;

	
	// Construtor que recebe parâmetros
	public  Move(String moveString) {
		// "2,5"
		// ["2" "5"]		
	
		String[] tokens = moveString.split(",");//Quebra a String
		this.i = Integer.parseInt(tokens[0]);// Converte String em int
		this.j = Integer.parseInt(tokens[1]);
		
		// TODO validar se a estrutura do moveString está correta
		
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
