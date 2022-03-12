package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.USRepository;

@Service
public class USService {

	@Autowired
	private USRepository usRepository;

	public USService(USRepository usRepository) {
		this.usRepository = usRepository;
	}
	

	public void salvar(ArquivosUS arquivosES) {
		this.usRepository.save(arquivosES);
	}
	
	public List<ArquivosUS> listar(){
		return this.usRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.usRepository.deleteById(id);
	}
	
	public String listarPorNome(String nome){
		List<ArquivosUS> listar =  this.usRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosUS x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	public List<ArquivosUS> buscarPorNome(String nome){
		return this.usRepository.findByNomeArquivo(nome);
	}
	
	
}
