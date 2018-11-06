package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class filereader {

	public static void main(String[] args) throws IOException {
		try {
			File arquivo = new File("C:\\teste.txt");

			FileReader fr = new FileReader(arquivo);

			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Não encontrado");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro Ao ler o arquivo");
			e.printStackTrace();
		}
	}

}
