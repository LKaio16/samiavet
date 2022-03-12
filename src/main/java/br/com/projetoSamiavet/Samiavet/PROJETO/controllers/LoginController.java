package br.com.projetoSamiavet.Samiavet.PROJETO.controllers;

import javax.servlet.http.HttpSession;

import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;

@Controller
public class LoginController {

	
	
	@PostMapping("/efetuarLogin")
	public ModelAndView efetuarLogin(Usuario user, HttpSession session) {
	if (user.getLogin().equals("admin")&&user.getSenha().equals("1234")) {
		session.setAttribute("usuarioLogado", user);
		return new ModelAndView("index.html");
	}else {
		return new ModelAndView("erroUpload.xhtml");
	}
	}
	
	@PostMapping("/logout")
	public ModelAndView fazerLogout(HttpSession session) {
	
		
		session.invalidate();
		return new ModelAndView("testando.html");

		
	}

	
	
	
}
