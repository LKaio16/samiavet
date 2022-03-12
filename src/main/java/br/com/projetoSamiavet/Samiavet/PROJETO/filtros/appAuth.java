package br.com.projetoSamiavet.Samiavet.PROJETO.filtros;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;

/**
 * Servlet Filter implementation class appAuth
 */
public class appAuth implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = (HttpSession) req.getSession();
		
		
		Usuario user = (Usuario)session.getAttribute("usuario");
		
		if(user == null) {
			
			res.sendRedirect(req.getContextPath() + "/seguranca/login.xhtml");
		}else {
			chain.doFilter(request, response);

	        }
		
	}

	

}
