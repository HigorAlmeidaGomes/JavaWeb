package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LivroDao;
import com.web.model.Livro;

@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERIR_OU_EDITAR = "/livro.jsp";
	private static final String LISTAR_LIVROS = "/listarLivros.jsp";
	private LivroDao dao = new LivroDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			int livroId = Integer.parseInt(request.getParameter("livroId"));
			dao.removeById(livroId);
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = INSERIR_OU_EDITAR;
			int codigoLivro = Integer.parseInt(request.getParameter("livroId"));
			Livro livro = dao.consultar(codigoLivro);
			request.setAttribute("livro", livro);
		} else if (action.equalsIgnoreCase("listarLivros")) {
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else {
			forward = INSERIR_OU_EDITAR;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setPreco(request.getParameter("preco")!= null ? Double.parseDouble(request.getParameter("preco")):0);
		String codigoLivro = request.getParameter("livroCodigo");
		
		if(codigoLivro == null || codigoLivro.isEmpty()) {
			dao.inserirLivro(livro);
			request.setAttribute("livros", dao.listarTodos());
		}else {
			livro.setCodigo(Integer.parseInt(codigoLivro));
			dao.updateTitulo(livro);
			request.setAttribute("livros", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_LIVROS);
		view.forward(request, response);
	}

}
