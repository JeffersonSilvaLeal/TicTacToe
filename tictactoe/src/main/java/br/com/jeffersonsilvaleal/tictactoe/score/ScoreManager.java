package br.com.jeffersonsilvaleal.tictactoe.score;

import java.io.IOException;

import br.com.jeffersonsilvaleal.core.Player;

//Interface Define as assinaturas do metodos ou seja o que esse objeto faz
public interface ScoreManager {

	public Integer getScore(Player player);
	
	public void saveScore(Player player) throws IOException;
}
