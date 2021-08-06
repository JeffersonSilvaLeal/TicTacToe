package br.com.jeffersonsilvaleal.tictactoe.ui;

import java.util.Scanner;

import br.com.jeffersonsilvaleal.core.invalidMoveException;

// Classe para escrever no console
public class UI {

	
	
	private static final Scanner Empty = null;

	// M�todo para escrever Texto
	public static void printText(String text){
		System.out.println(text);
	}
	
	// M�todo para escrever texto sem quebrar linha
	public static void printTextWithNoNewLine(String text) {
		System.out.print(text);
	}
	
	// M�todo para pular uma linha
	public static void printNewLine() {
		System.out.println();
	}
	
	// M�todo para escreve o nome do GAME
	public static void printGameTitle() {
		printText("=============================================");
		printText("|                JOGO DA VELHA              |");
		printText("=============================================");
		printNewLine();
	}
	
	// Escreve um texto e pede um dado ao usu�rio
	public static String readInput(String text) {
		printTextWithNoNewLine(text + " ");
		return Ler(text);
	}

	// Solicita um dado ao Usu�rio
	private static String Ler(String text) {
			Scanner ler = new Scanner(System.in);
			return ler.next();
		//	String ler1 = ler.next();
		//	return ler1;
		}
}

