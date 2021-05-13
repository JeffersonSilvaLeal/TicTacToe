package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.Constants;

public class Game {
	//Cria o objeto tabuleiro
	Board board =  new Board();
	
	// Cria e define o número de Jogadores de acordo com o tamanho do array de Players atualmente em 2 players
	Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	
	public void play() {
		System.out.println("Jogando...");
	}
}
