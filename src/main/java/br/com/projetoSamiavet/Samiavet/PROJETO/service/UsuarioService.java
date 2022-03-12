package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository user;

	public UsuarioService(UsuarioRepository user) {
		this.user = user;
	}
	
	
	public void cadastrar(Usuario user) {
		this.user.save(user);
	}
	
	public String buscaPorLogin(String login) {
		List<Usuario> lista = this.user.findByLogin(login);
		
		String valorLogin = null;
		
		for(Usuario user: lista) {
			valorLogin = user.getLogin();
		}
		return valorLogin;
	}
	
	public String buscaPorSenha(String senha) {
		List<Usuario> lista = this.user.findBySenha(senha);
		
		String valorSenha = null;
		
		for(Usuario user: lista) {
			valorSenha = user.getSenha();
		}
		return valorSenha;
	}
	
	public List<Usuario> retornaLista(){
		return this.user.findAll();
	}
	
	
	
	
	
	
}
