package br.com.jeffersonsilvaleal.tictactoe.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

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

	// metodo para Inicializar
	private void setup() throws IOException {

		if (!Files.exists(SCORE_FILE)) {
			Files.createFile(SCORE_FILE);
		}

		try (BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {

			String line;
			
			// Enquanto ouver linha com dados continua o loop
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("\\|,");
			
				scoreMap.put(tokens[0],Integer.parseInt(tokens[1]));
			}
		}

	}

	@Override
	public Integer getScore(Player player) {
		return null;
	}

	@Override
	public void saveScore(Player player) {

	}

}
