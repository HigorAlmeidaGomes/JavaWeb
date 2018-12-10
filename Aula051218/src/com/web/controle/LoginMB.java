package com.web.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@RequestScoped
@ManagedBean(name = "loginMB")
public class LoginMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String enviar() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());

		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", "Erro no Login!"));
			return null;
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("logado", true);
			return "/restrito/listagemUsuarios";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
