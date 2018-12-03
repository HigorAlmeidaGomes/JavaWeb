package com.web.frameworkTeste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.web.framework.Pessoa;

public class TestaPersistencia {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExampleJPA");
		EntityManager entityManager = factory.createEntityManager();

		Pessoa ps = new Pessoa();
		ps.setNome(" asdasdaw");
		ps.setCpf("12312as3");
		entityManager.getTransaction().begin();
		entityManager.persist(ps);
		entityManager.getTransaction().commit();

		@SuppressWarnings("unchecked")
		List<Pessoa> listarPessoas = entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();

		for (Pessoa pessoaLaco : listarPessoas) {
			// Implementar
			System.out.println(pessoaLaco.toString());
		}
	}

}
