package com.web.frameworkTeste;

import java.util.List;

import com.web.framework.Pessoa;
import com.web.framework.dao.PessoaDao;

public class TestePessoa {
	static PessoaDao pessoaDao = PessoaDao.getInstance();

	public static void main(String[] args) {
		// incluirPessoa();
		// listarTodasPessoas();
		// alterarPessoa();
		removerPessoa();

	}

	private static void listarTodasPessoas() {
		List<Pessoa> listarTodos = pessoaDao.findAll();
		for (Pessoa pessoa : listarTodos) {
			System.out.println(pessoa);
		}
	}

	private static void alterarPessoa() {
		Pessoa alterarPessoa = pessoaDao.getbyId(2);
		alterarPessoa.setNome("CARLA");
		pessoaDao.update(alterarPessoa);

	}

	public static void incluirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Higor Almeida Gomes ");
		pessoa.setCpf("034556466");

		pessoaDao.persist(pessoa);
	}

	public static void removerPessoa() {
		pessoaDao.removerbyId(2);

	}

}
