package com.web.servelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.Livros;

@WebServlet("/LivroServelt")
public class LivroServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Livros> listarLivros = new ArrayList<>();

		for (int i = 1; i < 10; i++) {

			Livros livro = new Livros();
			livro.setAutor("Autor" + i);
			livro.setDescricao("Descrição" + i);
			livro.setTitulo("Titulo" + i);

			listarLivros.add(livro);
		}
		request.setAttribute("listarLivros", listarLivros);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/CadastroLivro.jsp");
		rd.forward(request, response);

		HttpSession session = request.getSession();
		session.setAttribute("userName", "Usuário Higor Almeida Gomes");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
