package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.ui.UI;

public class Player {
	
	// Variável para armazenar nome dos jogadores
	private String name;
	
	// Tabuleiro
	private Board board;
	
	// Simbolo
	private char symbol;
	
	
	// Construtor	que recebe parâmetro
	public Player(String name, Board board, char symbol) {
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}

	// Faz um movimento, Método unico da classe por isso está com modificador private
	private Move inputMove(){
	String moveString = UI.readInput("Jogador " + name + " =>");
	return new Move(moveString);
	}
		
	// Faz um jogada
	public void play(){
		Move move = inputMove();
		board.play(this, move);
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
