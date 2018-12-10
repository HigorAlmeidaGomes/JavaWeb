package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		// Recuperar o atributo logado da sesão
		boolean logado = false;
		if (session.getAttribute("logado") != null) {
			logado = (boolean) session.getAttribute("logado");
		}
		if (!logado) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			// Redirecionando o usuario imediato
			// para a página de login.xhtml
			((HttpServletResponse) response).sendRedirect(contextPath + "/login/loginUsuario.xhtml");
		} else {
			// caso ele esteja logado
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
