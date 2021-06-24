package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.Constants;
import br.com.jeffersonsilvaleal.tictactoe.ui.UI;

public class Game {
	//Cria o objeto tabuleiro
	private Board board =  new Board();
	
	// Cria e define o número de Jogadores de acordo com o tamanho do array de Players atualmente em 2 players
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	
	
	public void play() {
		UI.printGameTitle();
		
		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
	}

	// Implementado método de criação de jogador
	private Player createPlayer(int index) {
		String name = UI.readInput("Jogador " + (index + 1) + " =>"); 
		char symbol =  Constants.SYMBOL_PLAYERS[index];
		Player player = new Player(name, board, symbol);
	
		UI.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");
		return player;
	}
}
