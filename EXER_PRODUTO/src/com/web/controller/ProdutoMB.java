package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.web.dao.ProdutoDAO;
import com.web.framework.Produto;

@ViewScoped
@ManagedBean
public class ProdutoMB {
	Produto produto = new Produto();
	ProdutoDAO dao = new ProdutoDAO();
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EXER_PRODUTO");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	private List<Produto> listarProduto = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String codigoProduto = facesContext.getExternalContext().getRequestParameterMap().get("codigo");
		if (codigoProduto != null) {
			this.produto = dao.consultarProduto(Integer.parseInt(codigoProduto));
		}
	}

	public String incluirProduto(Produto produto) {
		if (!dao.inserirProduto(produto)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o Produto já existe!", null));
			return "novoProduto?faces-redirect=true";
		}
		return "listarProduto?faces-redirect=true";
	}

	public String editarProdutoDb(Produto produto) {
		dao.editarProduto(produto);
		return "/listagemUsuarios";
	}

	public String paginaEditar(Produto produto) {
		return "/editarProduto?faces-redirect=true&codigo=" + produto.getCodigo();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produtos) {
		this.produto = produtos;
	}

	public ProdutoDAO getDao() {
		return dao;
	}

	public void setDao(ProdutoDAO dao) {
		this.dao = dao;
	}

	public List<Produto> getListarProduto() {
		return dao.listarProduto();
	}

	public void setListarProduto(List<Produto> listarProduto) {
		this.listarProduto = listarProduto;
	}

}
