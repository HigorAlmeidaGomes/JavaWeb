package Hasmap;

import java.util.HashMap;
import java.util.Scanner;

public class PesquisaCPF {

	private static Scanner scanner;

	public static void main(String[] args) {
		arrayList();
	}

	public static  void arrayList() {
		HashMap<Long, String> pesquisa = new HashMap<>();
		Long codigo = null;
		String nome = null;
		for (int i = 0; i < 2; i++) {
			scanner = new Scanner(System.in);
			System.out.println("Digite o CPF ");
			codigo = scanner.nextLong();
			System.out.println("Digite o Nome ");
			scanner = new Scanner(System.in);
			nome = scanner.nextLine();
			pesquisa.put(codigo, nome);
		}
		String p = pesquisa.get(codigo).toUpperCase();
		System.out.println(p);
	}
}
