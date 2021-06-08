package br.com.jeffersonsilvaleal.core;

public class Move {

	// Vari�vel para controlar a coluna
	private int i;
	
	// Vari�vel para controlar a linha
	private int j;

	
	// Construtor que recebe par�metros
	public  Move(String moveString) {
		// "2,5"
		// ["2" "5"]		
	
		String[] tokens = moveString.split(",");//Quebra a String
		this.i = Integer.parseInt(tokens[0]);// Converte String em int
		this.j = Integer.parseInt(tokens[1]);
		
		// TODO validar se a estrutura do moveString est� correta
		
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
