package Generics;

import java.util.ArrayList;
import java.util.List;

import Animal.Felino;

public class ColecaoBichoFelino {

	public static void main(String[] args) {
		List<Leao> animais = new ArrayList<Leao>();
		animais.add(new Leao());
		ColecaoBichoFelino colecao = new ColecaoBichoFelino();
		colecao.addAnimal(animais);

		List<Gato> gato = new ArrayList<Gato>();
		gato.add(new Gato());
		colecao.addAnimal(gato);
	}
	
	public void addAnimal(List<? extends Felino> animais) {
		for (Felino bicho : animais) {
			bicho.fazerRuido();
		}
	}
}
