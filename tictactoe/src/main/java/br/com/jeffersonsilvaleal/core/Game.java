package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.Constants;
import br.com.jeffersonsilvaleal.tictactoe.ui.UI;

public class Game {
	//Cria o objeto tabuleiro
	Board board =  new Board();
	
	// Cria e define o número de Jogadores de acordo com o tamanho do array de Players atualmente em 2 players
	Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	
	public void play() {
		UI.printGameTitle();
		
		board.print();
		
	}
}
