package com.web.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServelt")
public class HelloServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String profissao = req.getParameter("profissao");
		String salario = req.getParameter("salario");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head><title>Hello Servelet</title></head>" + "<body>" + "<h1>Olá " + nome
				+ " Sua Profissao é " + profissao + " o seu salario é " + salario + " Reais</h1>" + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
