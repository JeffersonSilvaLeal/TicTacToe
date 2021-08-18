package br.com.jeffersonsilvaleal.tictactoe.score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.jeffersonsilvaleal.core.Player;

public class FileScoreManager implements ScoreManager {

	// Constante para representar o arquivo onde irá armazenar as informações de
	// pontuação
	private static final Path SCORE_FILE = Path.of("score.txt");

	// Chave irá ser o Nome e o valor Integer
	private Map<String, Integer> scoreMap = new HashMap<>();

	public FileScoreManager() throws IOException {
		setup();
	}

	// Carrega toda a pontuação para dentro do scoreManager
	private void setup() throws IOException {

		if (!Files.exists(SCORE_FILE)) {
			Files.createFile(SCORE_FILE);
		}

		try (BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {

			String line;

			// Enquanto ouver linha com dados continua o loop
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("\\|");

				scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));
			}
		}

	}

	@Override
	public Integer getScore(Player player) {
		// Retorna o valor associado ao jogador ou nulo caso não haja o nome do jogador
		// na chave!!
		return scoreMap.get(player.getName().toUpperCase());
	}

	// Armazenar mais uma vitória no jogador passado por parametro
	@Override
	public void saveScore(Player player) throws IOException {
		//  Pontuação
		Integer score = getScore(player);

		if (score == null) {
			score = 0;
		}

		scoreMap.put(player.getName().toUpperCase(), score + 1);

		try (BufferedWriter write = Files.newBufferedWriter(SCORE_FILE)) {
			Set<Map.Entry<String, Integer>> entries = scoreMap.entrySet();
		
			for (Map.Entry<String, Integer> entry : entries) {
				String name = entry.getKey().toUpperCase();
				Integer s = entry.getValue();			
				write.write(name + "|" + s);
				write.newLine();
			}
		}
	}

}
