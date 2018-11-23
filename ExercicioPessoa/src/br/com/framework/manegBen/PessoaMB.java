package br.com.framework.manegBen;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.framework.model.Pessoa;

@RequestScoped
@ManagedBean(name = "pessoaMB")
public class PessoaMB {

	private Pessoa pessoa;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		System.out.println("Classe Pessoa MB");
		pessoa.setNome("CAROL");
		pessoa.setIdade(27);
		pessoa.setSexo("F");
		System.out.println("Entrou na Classe init ");
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
