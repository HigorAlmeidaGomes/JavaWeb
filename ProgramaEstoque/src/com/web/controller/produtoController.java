package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.dao.ProdutoDAO;
import com.web.model.Produto;

/**
 * Servlet implementation class produtoController
 */
@WebServlet("/produtoController")
public class produtoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERIR_EDITAR = "/cadastrarProdutos.jsp";
	private static final String TELA_LISTAGEM = "/listarProdutos.jsp";
	private ProdutoDAO dao = new ProdutoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String aciton = request.getParameter("action");
		String buscarProduto = request.getParameter("buscarProduto");

		if (aciton != null && aciton.equals("listaTodos")) {
			List<Produto> produto = dao.listarTodos();
			request.setAttribute("produtos", produto);
			forward = TELA_LISTAGEM;
		} else if (aciton != null && aciton.equals("consultarProduto")) {
			List<Produto> listarProduto = dao.consultar(buscarProduto);
			request.setAttribute("produto", listarProduto);
			forward = TELA_LISTAGEM;
		} else if (aciton != null && aciton.equalsIgnoreCase("editar")) {
			forward = INSERIR_EDITAR;
			int codigoProduto = Integer.parseInt(request.getParameter("produtoId"));

			Produto produto = dao.consultar(codigoProduto);

			request.setAttribute("produto", produto);

		} else if (aciton != null && aciton.equals("buscarProduto")) {
			List<Produto> produto = dao.consultar(buscarProduto);
			request.setAttribute("produtos", produto);
			forward = TELA_LISTAGEM;

		} else {
			forward = INSERIR_EDITAR;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Produto produto = new Produto();
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setQuantidade(Double.parseDouble(request.getParameter("quantidade")));
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		String codigoProduto = request.getParameter("produtoCodigo");

		if (codigoProduto == null || codigoProduto.isEmpty()) {
			dao.inserirProduto(produto);
			request.setAttribute("produtos", dao.listarTodos());

		} else {
			produto.setCodigo(Integer.parseInt(codigoProduto));
			dao.updateProduto(produto);
			request.setAttribute("produtos", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(TELA_LISTAGEM);
		view.forward(request, response);
	}

}
