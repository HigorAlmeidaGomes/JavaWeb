package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ImagesView {
	private List<String> images;
	private String option;
	String msg = "";

	@PostConstruct
	public void init() {
		images = new ArrayList<String>();
		carregarXbox();
		carregarPs4();
	}

	private void carregarXbox() {
		for (int i = 1; i <= 5; i++) {
			images.add("xbox" + i + ".jpg");
		}
		msg = "Jogos Xbox ";
	}

	private void carregarPs4() {
		for (int i = 1; i <= 5; i++) {
			images.add("ps" + i + ".jpg");
		}
		msg = "Jogos PS4 ";
	}

	public List<String> getImages() {
		return images;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		String mensagem = "";
		if (option != null && !option.equals("")) {
			images = new ArrayList<String>();
			if (option.equals("Xbox One")) {
				carregarXbox();
			} else if (option.equals("PS4")) {
				carregarPs4();
			}
			mensagem = "Plataforma Selecionada com sucesso! " + msg;
		} else {
			mensagem = "Todas as Plataforma selecionada: ";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
		this.option = option;
	}
}
