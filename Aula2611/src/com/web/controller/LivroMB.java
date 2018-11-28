package com.web.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.web.model.Livro;

@RequestScoped
@ManagedBean(name = "livroMB")
public class LivroMB {
	private Livro livro;
	ArrayList<Livro> listarLivro;

	@PostConstruct
	public void init() {
		listarLivro = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			livro = new Livro();
			livro.setAutor("Autor " + i);
			livro.setDescricao("Descricao " + i);
			livro.setPreco(i);
			livro.setTitulo("Titulo " + i);

			listarLivro.add(livro);
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public ArrayList<Livro> getListarLivro() {
		return listarLivro;
	}

	public void setListarLivro(ArrayList<Livro> listarLivro) {
		this.listarLivro = listarLivro;
	}

}
