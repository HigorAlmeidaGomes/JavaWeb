package TesteClasse;

import java.util.ArrayList;
import java.util.List;

import GenericoPessoa.PessoaFisica;
import GenericoPessoa.PessoaJuridica;
import Pessoas.Pessoa;

public class TestePessoa {
	public static void main(String[] args) {
		List<PessoaJuridica> juridica = new ArrayList<PessoaJuridica>();
		juridica.add(new PessoaJuridica());
		TestePessoa testepj = new TestePessoa();
		testepj.addPessoa(juridica);

		List<PessoaFisica> fisica = new ArrayList<PessoaFisica>();
		fisica.add(new PessoaFisica());
		TestePessoa testepf = new TestePessoa();
		testepf.addPessoa(fisica);
	}

	public void addPessoa(List<? extends Pessoa> PJ) {

		for (Pessoa pessoagenerica : PJ) {
			pessoagenerica.pagarImposto();
		}
	}
}
