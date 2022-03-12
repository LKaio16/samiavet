package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.IOException;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ResetarSenha;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ResetarSenhaService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.UsuarioService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value="mudarSenhaBean")
@SessionScoped
public class RecuperarSenhaBean {

	private ResetarSenha recuperarSenha;
	
	
	private String codigoInserido;
	
	
	@Autowired
	private ResetarSenhaService resetarSenhaService;
	
	@Autowired
	private UsuarioService userService;
	
	private String novaSenha;
	
	private String confirmarSenha;
	
	private String senhaAtual;
	

	private String novaSenhaMudanca;
	
	
	private String confirmarSenhaMudanca;
	
	
	public ResetarSenha getRecuperarSenha() {
		return recuperarSenha;
	}




	public void setRecuperarSenha(ResetarSenha recuperarSenha) {
		this.recuperarSenha = recuperarSenha;
	}


	
	
	
	public String getCodigoInserido() {
		return codigoInserido;
	}




	public void setCodigoInserido(String codigoInserido) {
		this.codigoInserido = codigoInserido;
	}


	

	public String getNovaSenha() {
		return novaSenha;
	}




	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}




	public String getConfirmarSenha() {
		return confirmarSenha;
	}




	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}




	public String getSenhaAtual() {
		return senhaAtual;
	}




	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}




	public String getNovaSenhaMudanca() {
		return novaSenhaMudanca;
	}




	public void setNovaSenhaMudanca(String novaSenhaMudanca) {
		this.novaSenhaMudanca = novaSenhaMudanca;
	}




	public String getConfirmarSenhaMudanca() {
		return confirmarSenhaMudanca;
	}




	public void setConfirmarSenhaMudanca(String confirmarSenhaMudanca) {
		this.confirmarSenhaMudanca = confirmarSenhaMudanca;
	}




	public RecuperarSenhaBean() {
		
		this.recuperarSenha = new ResetarSenha();
	}
	
	
	
	public void enviarEmailRecuperacao() {
		
		if(this.resetarSenhaService.retornaLista().size() == 0) {

			
			Random n = new Random();
			
			this.recuperarSenha.setCodigo(n.nextInt(10000000));
			this.resetarSenhaService.cadastrarCod(this.recuperarSenha);
			
			
			
			
			String meuEmail = "tirsopottim04@gmail.com";
			String minhaSenha = "191991tirso";
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			//email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail,minhaSenha));
			email.setSSLOnConnect(true);
			
			
			try {
				
				
				email.setFrom(meuEmail);
				email.setSubject("RECUPERAÇÃO DE SENHA SAMIAVET");
				email.setMsg("CÓDIGO DE RECUPERAÇÃO DE SENHA: " + this.resetarSenhaService.retornaLista().get(0).getCodigo());

				email.addTo(meuEmail);
				
				
				email.send();
				
				JsfUtil.adicionarMensagemDeSucesso("CÓDIGO ENVIADDO COM SUCESSO!", null);
			}catch(Exception erro) {
				
				erro.printStackTrace();
			}
			
		
			
		}else {
			JsfUtil.adicionarMensagemDeSucesso("Codigo já gerado e enviado para o e-mail. Confira sua caixa de entrada ou reenvie o link", null);
			
		}
		
		
		
	}
	
	
	public void reenviarCod() {

		String meuEmail = "tirsopottim04@gmail.com";
		String minhaSenha = "191991tirso";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		//email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail,minhaSenha));
		email.setSSLOnConnect(true);
		
		
		try {
			
			
			email.setFrom(meuEmail);
			email.setSubject("RECUPERAÇÃO DE SENHA SAMIAVET");
			email.setMsg("CÓDIGO DE RECUPERAÇÃO DE SENHA: " + this.resetarSenhaService.retornaLista().get(0).getCodigo());

			email.addTo(meuEmail);
			
			
			email.send();
			
			JsfUtil.adicionarMensagemDeSucesso("CÓDIGO REENVIADDO COM SUCESSO!", null);
		}catch(Exception erro) {
			
			erro.printStackTrace();
		}
	}
	
	
	public void printar() {
		System.out.println("chamou o metodo");
	}
	
	public void excluir() {
		this.resetarSenhaService.excluir();
	}

	public void direcionarPagina()  {

		ResetarSenha nSenha =  this.resetarSenhaService.retornaLista().get(0);
			
		
		System.out.println(nSenha.getCodigo());
		
		String converterId = String.valueOf(nSenha.getCodigo());
		
		if(converterId.equals(this.codigoInserido)) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("codigo", this.recuperarSenha);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        try {
				ec.redirect(ec.getRequestContextPath() + "/seguranca/mudar.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}else {
			JsfUtil.adicionarMensagemDeErro("Codigo inserido está incorreto", null);
		}
	}
	
	
	public void recuperarSenha() throws IOException {
		if(this.confirmarSenha.equals(this.novaSenha)) {
			
			Long id = null;
			
			
			for(int cont =0; cont < this.userService.retornaLista().size(); cont++) {
				id = this.userService.retornaLista().get(cont).getId();
			}
			
			Usuario user = new Usuario();
			
			
			user.setId(id);
			user.setLogin(this.userService.retornaLista().get(0).getLogin());
			user.setSenha(this.novaSenha);
			
			this.userService.cadastrar(user);
			JsfUtil.adicionarMensagemDeSucesso("Senha alterada com sucesso!", null);
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
			this.resetarSenhaService.excluir();
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/seguranca/login.xhtml");	

		}else {
			JsfUtil.adicionarMensagemDeErro("As senhas não coincidem", null);
		}
	}
	
	
	public void AlterarSenha() {
		
		String senhaAtual = this.userService.buscaPorSenha(this.senhaAtual);
		
		
		
		
		if(senhaAtual == null) {
			JsfUtil.adicionarMensagemDeErro("A senha atual está incorreta", null);

		}
		
		else{
			
			if(this.novaSenhaMudanca.equals(confirmarSenhaMudanca)) {
				Long id = null;
				
				
				for(int cont =0; cont < this.userService.retornaLista().size(); cont++) {
					id = this.userService.retornaLista().get(cont).getId();
				}
				
				Usuario user = new Usuario();
				
				
				user.setId(id);
				user.setLogin(this.userService.retornaLista().get(0).getLogin());
				user.setSenha(this.novaSenhaMudanca);
				
				this.userService.cadastrar(user);
				JsfUtil.adicionarMensagemDeSucesso("Senha alterada com sucesso!", null);
				
				
				
				

			}else {
				JsfUtil.adicionarMensagemDeErro("As senhas não coincidem", null);
			}
			}
			
	}
}
