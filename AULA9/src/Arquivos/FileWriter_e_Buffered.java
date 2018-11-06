package Arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_e_Buffered {
	public static void main(String[] args) {
		try {
			File arquivo = new File("C:\\teste.txt");

			FileWriter fw = new FileWriter(arquivo);

			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Texto teste a ser escrito");
			bw.newLine();
			bw.write("Quebra de linha");
			bw.write("//  (version 1.8 : 52.0, super bit)\r\n"
					+ "public abstract class java.io.Writer implements java.lang.Appendable, java.io.Closeable, java.io.Flushable {\r\n");

			bw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println("Arquivo Não encotrado");
			e.printStackTrace();
		}
	}
}
