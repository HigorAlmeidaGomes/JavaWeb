package com.web.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.web.framework.Pessoa;

public class PessoaDao {
	EntityManager entityManager;

	private static PessoaDao instance;

	public static PessoaDao getInstance() {
		if (instance == null) {
			instance = new PessoaDao();
		}
		return instance;
	}

	private PessoaDao() {
		entityManager = getEntiyManage();
	}

	private EntityManager getEntiyManage() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExampleJPA");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public void persist(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Pessoa getbyId(final int id) {
		return entityManager.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() {
		return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	}

	public void update(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remover(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			// Transforms the managed object;
			pessoa = entityManager.find(Pessoa.class, pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removerbyId(final int id) {
		try {
			Pessoa pessoa = getbyId(id);
			entityManager.remove(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
