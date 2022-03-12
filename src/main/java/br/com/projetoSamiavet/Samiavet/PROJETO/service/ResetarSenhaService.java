package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ResetarSenha;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ResetarSenhaRepository;

@Service
public class ResetarSenhaService {

	@Autowired
	private ResetarSenhaRepository resetarSenha;

	public ResetarSenhaService(ResetarSenhaRepository resetarSenha) {
		this.resetarSenha = resetarSenha;
	}
	
	public void cadastrarCod(ResetarSenha cod) {
		
		
		this.resetarSenha.save(cod);
	}
	
	public Integer retornaCod() {
		List<ResetarSenha> lista = this.resetarSenha.findAll();
		
		Integer cod = null;
		
		for(ResetarSenha x : lista) {
			cod = x.getCodigo();
		}
		
		return cod;
	}
	
	public List<ResetarSenha> retornaLista(){
		return this.resetarSenha.findAll();
	}
	
	public void excluir() {
		this.resetarSenha.deleteAll();
	}
}
