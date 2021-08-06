package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.Constants;
import br.com.jeffersonsilvaleal.tictactoe.score.ScoreManager;
import br.com.jeffersonsilvaleal.tictactoe.ui.UI;

public class Game {
	//Cria o objeto tabuleiro
	private Board board =  new Board();
	
	// Cria e define o n�mero de Jogadores de acordo com o tamanho do array de Players atualmente em 2 players
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	
	private int currentPlayerIndex = -1;
	
	private ScoreManager scoreManager;
	
	
	
	public void play() {
		
		scoreManager = createScoreManager();
		
		UI.printGameTitle();
		
		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
		
		// Controla o loop do jogo
		boolean gameEnded = false;
		// Mostra o pr�ximo jogador
		Player currentPlayer = nextPlayer();
		//Placar 
		Player winner = null;
		
		// O jogo fica em loop at� quando ouver uma sequ�ncia ou dar Velha
		while(!gameEnded) {
			// Imprime o tabuleiro!
			UI.printText("               ");
			board.print();
			
			UI.printText("               ");
			UI.printText("Jogadas possiveis");
			UI.printText("               ");
			UI.printText("0,0|0,1|0,2");
			UI.printText("-----------");
			UI.printText("1,0|1,1|1,2");
			UI.printText("-----------");
			UI.printText("2,0|2,1|2,2");
			UI.printText("               ");
			UI.printText("Fa�a sua jogada");
			UI.printText("               ");
			
			// Jogador atual faz a sua jogada
			boolean sequenceFound;
			
			try {
				sequenceFound = currentPlayer.play();
				
			} catch(Exception e) {
				UI.printText("ERRO: " + e.getMessage());
				continue;// Volta para o teste do loop
			}
			
			// se ouver uma sequ�ncia seta o jogador atual como vencedor
			if (sequenceFound) {
				gameEnded = true;
				winner = currentPlayer;
			
			// Se der Velha termina o game
			} else if (board.isFull()) {
				gameEnded = true;
			
			// Se ouver jogadas a fazer alterna o jogador 	
			} else {
				currentPlayer = nextPlayer();
			}
			
			
		}
		
		if (winner == null) {
			UI.printText("Jogo terminou empatado");
		
		} else {
			UI.printText("O jogador '" + winner.getName() + "' venceu o jogo");
			
			// Adiciona pontua��o ao jogador que ganhou
			scoreManager.saveScore(winner);
		}
		
		UI.printText("               ");
		board.print();
		UI.printText("               ");
		UI.printText("FIM DO GAME!!");
	}

	// Implementado m�todo de cria��o de jogador
	private Player createPlayer(int index) {
		String name = UI.readInput("Player " + (index + 1) + " =>"); 
		char symbol =  Constants.SYMBOL_PLAYERS[index];
		Player player = new Player(name, board, symbol);
		
		// Consulta se o jogador tem pontua��o!!
		Integer score = scoreManager.getScore(player);
		
		// Se o score n�o for nulo mostra a pontua��o do jogador atual
		if (score != null) {
			UI.printText("O jogador" + player.getName() + " j� possui " + "vit�ria(s)");
		}
	
		UI.printText("O jogador '" + name + "' vai usar o s�mbolo '" + symbol + "'");
		return player;
	}
	
	private Player nextPlayer() {
		
		/* sempre que index do jogador for maior ou igual que array de player  retorna a 0, alternando sempre os jogadores
		currentPlayerIndex++;
		
		if (currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
		}
		 */
		
		// Outro m�todo mais perfomatico pega a posi��o do jogador e divide por o tamanho do array do playes e retorna o resto, alternando sempre os jogadores
		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		
		return players[currentPlayerIndex];
	}
	
	private ScoreManager createScoreManager() {
		//TODO retorna tipo correto
		return null;
	}
}
