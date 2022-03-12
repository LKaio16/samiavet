package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.IOException;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.UsuarioService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@ManagedBean(value="user")
@SessionScoped
public class LoginController {

	private Usuario user;
	
	@Autowired
	private UsuarioService userService;
	
	
	
	
	
	public UsuarioService getUserService() {
		return userService;
	}

	public void setUserService(UsuarioService userService) {
		this.userService = userService;
	}

	public Usuario getLogar() {
		return user;
	}

	public void setLogar(Usuario logar) {
		this.user = logar;
	}

	public LoginController() {
		
		this.user = new Usuario();
		
		
	}
	
	@PostConstruct
	public void carregar() {
	
	}
	public void  Logar() throws IOException  {
		
		
		
		
		String valorLogin = this.userService.buscaPorLogin(this.user.getLogin());
		
		String valorSenha = this.userService.buscaPorSenha(this.user.getSenha());
		
		
		if(valorLogin == null || valorSenha == null) {
        	JsfUtil.adicionarMensagemDeErro("Usuario e/ou senha incorreta", null);

		}else if(this.user.getSenha().equals(valorSenha)&&this.user.getLogin().equals(valorLogin)) {
			
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", this.user);
			
		   ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		   ec.redirect(ec.getRequestContextPath() + "/pages/cadastro.xhtml");	
		}
		
		
		
		
		
		
	}
	
	public void Sair() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/seguranca/login.xhtml");	
	}
	
	
	
}
