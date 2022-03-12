package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.SVRepository;

@Service
public class SVService {

	@Autowired
	private SVRepository svRepository;

	public SVService(SVRepository svRepository) {
		this.svRepository = svRepository;
	}


	public void salvar(ArquivosSV arquivosES) {
		this.svRepository.save(arquivosES);
	}
	
	public List<ArquivosSV> listar(){
		return this.svRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.svRepository.deleteById(id);
	}
	
	public String listarPorNome(String nome){
		List<ArquivosSV> listar =  this.svRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosSV x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	public List<ArquivosSV> buscarPorNome(String nome){
		return this.svRepository.findByNomeArquivo(nome);
	}
}
