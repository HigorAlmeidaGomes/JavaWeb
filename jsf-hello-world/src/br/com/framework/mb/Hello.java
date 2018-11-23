package br.com.framework.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "helloMapeamento")
public class Hello {
	private String message;
	private String message2;
	private String nomeCompleto;

	@PostConstruct
	public void init() {
		System.out.println("Método init() execultando na inicialização devida a notação @PostConstruct");
		nomeCompleto = "Higor Almeida Gomes";
		message = "Hello world JSF! 444";
		message2 = "Hello world JSF! 555";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
