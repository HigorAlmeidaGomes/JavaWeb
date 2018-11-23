package Arquivos;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Nio2 {
	public static void main(String[] args) {
		String fileStr = "C:\\teste.txt";
		Path path = Paths.get(fileStr);

		leitura(path);

		gravando(path);
	}

	private static void gravando(Path path) {
		try {
			List<String> inLines = Files.readAllLines(path, Charset.forName("UTF-8"));
			for (String linha : inLines) {
				System.out.println(linha);

				for (int i = 0; i < linha.length(); i++) {
					char charOut = linha.charAt(i);
					System.out.println((i + 1) + " - " + charOut);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leitura(Path path) {
		List<String> linhas = new ArrayList<String>();
		linhas.add("Wellor Word");
		linhas.add("Olá Higor");

		try {
			Files.write(path, linhas, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
