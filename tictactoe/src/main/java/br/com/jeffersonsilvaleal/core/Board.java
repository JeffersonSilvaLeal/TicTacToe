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
					UI.printTextWithNoNewLine("       | ");
				}
			}

			// pula uma linha
			UI.printNewLine();

			// Impede que os pontilhados seja escrito na ultima linha
			if (i < matrix.length - 1) {
				UI.printText("--------------------------------");
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

	// Faz uma jogada indicando o jogado e o movimento
	public boolean play(Player player, Move move) {
		
		// Linha
		int i = move.getI();
		// Coluna
		int j = move.getJ();
		
		// Atribui o simbolo na posição do tabuleiro
		matrix[i][j] = player.getSymbol();
		
		//TODO Checar se o jogador Ganhou
		return false;
	}

}
