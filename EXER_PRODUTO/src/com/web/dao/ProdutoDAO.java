package com.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.web.framework.Produto;

public class ProdutoDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EXER_PRODUTO");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public List listarProduto() {
		Query queryObj = em.createQuery("select p from Produto p");
		List produtoList = queryObj.getResultList();

		if (produtoList != null && produtoList.size() > 0) {
			return produtoList;
		} else {
			return null;
		}
	}

	public boolean inserirProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.persist(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean editarProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Produto consultarProduto(int codigo) {
		try {
			return em.find(Produto.class, codigo);
		} catch (Exception e) {
			return null;
		}
	}

}
