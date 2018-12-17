package com.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;
import com.web.service.UsuarioService;

@ViewScoped
@ManagedBean
public class UsuarioMB {

	private final String TELA_LISTAGEM_USUARIO = "/restrito/listagemUsuarios?faces-redirect=true";
	private final String TELA_NOVO_USUARIO = "/restrito/novoUsuarios?faces-redirect=true";
	private final String EDITAR_USUARIO = "/restrito/editarUsuario?faces-redirect=true&id=";

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioListDb = new ArrayList<>();

	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String idUsuario = facesContext.getExternalContext().getRequestParameterMap().get("id");
		if (idUsuario != null) {
			this.usuario = usuarioDAO.consultarUsuario(Integer.parseInt(idUsuario));
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List getUsuarioListDb() {
		return usuarioDAO.listarUsuario();
	}

	public void excluirUsuarioDb(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}

	public String incluirUsuarioDb(Usuario usuario) {
		try {
			usuarioService.salvarUsuario(usuario);
			return TELA_LISTAGEM_USUARIO;
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o usuário já existe!", null));
			return TELA_NOVO_USUARIO;
		}

	}

	public String paginaEditar(Usuario usuario) {
		return EDITAR_USUARIO + usuario.getId();
	}

	public String editarUsuarioDb(Usuario usuario) {
		usuarioDAO.editarUsuario(usuario);
		return EDITAR_USUARIO;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
