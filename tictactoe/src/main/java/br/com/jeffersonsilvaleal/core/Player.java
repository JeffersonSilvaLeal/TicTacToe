package br.com.jeffersonsilvaleal.core;

public class Player {
	
	// Variável para armazenar nome dos jogadores
	private String name;
	
	// Tabuleiro
	private Board board;
	
	// Simbolo
	private char symbol;
	
	// Faz um movimento
	public Move inputMove(){
		return null;
	}
	
	// Faz um jogada
	public void play(){
		
	}

	// Métodos para setar(SETTERS) e retornar(GETTERS) valores
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	
	
}
