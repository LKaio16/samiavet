package br.com.projetoSamiavet.Samiavet.PROJETO.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ResetarSenha;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;

public class mudarSenhaAuth implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = (HttpSession) req.getSession();
		
		
		ResetarSenha novaSenha = (ResetarSenha)session.getAttribute("codigo");
		
		if(novaSenha == null) {
			
			res.sendRedirect(req.getContextPath() + "/seguranca/login.xhtml");
		}else {
			chain.doFilter(request, response);

	        }
		
	}

}
