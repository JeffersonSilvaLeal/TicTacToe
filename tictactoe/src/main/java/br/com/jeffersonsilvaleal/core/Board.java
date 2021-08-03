package br.com.jeffersonsilvaleal.core;

import br.com.jeffersonsilvaleal.tictactoe.Constants;
import br.com.jeffersonsilvaleal.tictactoe.ui.UI;

public class Board {

	// Define o tamanho do tabulero LINHA e COLUNA
	private char[][] matrix;

	// Ao criar o Objeto ele cria o array e será limpado
	public Board() {
		matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		clear();
	}

	// Limpar o tabuleiro
	public void clear() {
		// i Controla as linhas j as Colunas
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// Coloca em cada elemento um espaço em branco!!
				matrix[i][j] = ' ';
			}
		}
	}

	// Mostra o tabuleiro
	public void print() {
		// Pula uma linha
		UI.printNewLine();

		// Varre a matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				UI.printTextWithNoNewLine(String.valueOf(matrix[i][j])); // Converte char para String

				// Impede que o type seja escreto na ultima coluna
				if (j < matrix.length - 1) {
					UI.printTextWithNoNewLine(" | ");
				}
			}

			// pula uma linha
			UI.printNewLine();

			// Impede que os pontilhados seja escrito na ultima linha
			if (i < matrix.length - 1) {
				UI.printText("----------");
			}
		}
	}

	// Informa se o tabuleiro esta vazio para uma possivel jogada
	public boolean isFull() {

		// i Controla as linhas j as Colunas
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// Coloca em cada elemento um espaço em branco!!
				if (matrix[i][j] == ' ');
				{
					return false;
				}
			}
		}
		
		return true;
	}

	// Detecta se o jogador ganhou ou não
	public boolean play(Player player, Move move) {
		
		// Linha
		int i = move.getI();
		// Coluna
		int j = move.getJ();
		
		// Atribui o simbolo na posição do tabuleiro
		matrix[i][j] = player.getSymbol();
	
		// Retorna verdadeiro se achar alguma sequência
		return chechRows(player) || checkCols(player) || checkDiagona1(player) || checkDiagonal2(player);
	}

	// Checa se há um sequência, retornando True se encontrar sequência e false se não encontrar sequência
	private boolean chechRows(Player player) {
		
		/*
		 * 
		 * x | x | X
		 * 
		 */
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (checkRow(i, player)) {
				return true;
			}
		}
		
		/*
		 * 
		 * O | x | o
		 */
		return false;
	}
	
	// Itera cada Linha[0 ,1 ,2] vericando se o simbolo do player é uma sequência , retorna false se for diferente e true se houver sequência
	private boolean checkRow(int i, Player player) {
		char symbol = player.getSymbol();
		
		/*
		 * x | x | o
		 * 
		 */
		// Itera em cada coluna 'J' se encontrar um symbol diferente retorna false pois não acho uma sequência
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (matrix[i][j] != symbol ) {
				return false;
			}
		}
		
		/*
		 * x | x | X
		 * 
		 */
		
		return true;
	}
	
	// Itera cada coluna[0 ,1 ,2] vericando se o simbolo do player é uma sequência , retorna false se for diferente e true se houver sequência
	private boolean checkCol(int j, Player player) {
		char symbol = player.getSymbol();
	
		/*
		 *    | o |
		 * ----------
		 *    | o |
		 * ---------- 
		 *    | o | 
		 * 	
		 */
		// Itera sobre as linhas 'i' se encontrar um symbol diferente retorna false pois não acho uma sequência
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (matrix[i][j] != symbol) {
				return false;
			}
		}
		
		// Se achar um sequ~encia retorna true
		return true;
	}
	
	
	// Checa se há um sequência, retornando True se encontrar sequência e false se não encontrar sequência
	private boolean checkCols(Player player) {
	
		/*
		 *    | o |
		 * ----------
		 *    | x |
		 * ---------- 
		 *    | o | 
		 * 	
		 */
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (checkCol(j, player)) {
				return true;
			}
		}
		
		return false;
	}

	
	private boolean checkDiagona1(Player player) {
		char symbol = player.getSymbol();
		
		/* i    0    1   2  <= j
		 * 
		 * 0    o  |   |
		 *    -------------  
 		 * 1       | o | 
		 *    -------------
		 * 2       |   | x
		 */
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (matrix[i][i] != symbol) {
				return false;
			}
		}
			
		/*
		 * o  |   |
		 *-------------  
 		 *    | o | 
		 *-------------
		 *    |   | o
		 */
		return true;
			
	}
	
	
	private boolean checkDiagonal2(Player player) {
		char symbol = player.getSymbol();
		int lastline = Constants.BOARD_SIZE -1;
		
		/*
		 *   |   |  o
		 *-------------  
 		 *   | x | 
		 *-------------
		 * o |   | 
		 */
		for (int i = lastline, j = 0; i >- 0; i-- , j++) {
			if (matrix[i][j] != symbol) {
				return false;
			}
		}

		/*
		 *   |   |  o
		 *-------------  
 		 *   | o | 
		 *-------------
		 * o |   | 
		 */
		return true;
		
	}
}
