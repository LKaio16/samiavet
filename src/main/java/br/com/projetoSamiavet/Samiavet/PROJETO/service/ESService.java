package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ESRepository;

@Service
public class ESService {

	
	@Autowired
	private ESRepository esRepository;

	public ESService(ESRepository esRepository) {
		this.esRepository = esRepository;
	}
	
	
	public ESRepository getEsRepository() {
		return esRepository;
	}


	public void setEsRepository(ESRepository esRepository) {
		this.esRepository = esRepository;
	}


	public void salvar(ArquivosES arquivosES) {
		this.esRepository.save(arquivosES);
	}
	
	public List<ArquivosES> listar(){
		return this.esRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.esRepository.deleteById(id);
	}
	
	

	public String listarPorNome(String nome){
		List<ArquivosES> listar =  this.esRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosES x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	public List<ArquivosES> buscarPorNome(String nome){
		return this.esRepository.findByNomeArquivo(nome);
	}
}
