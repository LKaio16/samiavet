package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.FURepository;

@Service
public class FUService {

	
	@Autowired
	private FURepository fuRepository;

	public FUService(FURepository fuRepository) {
		this.fuRepository = fuRepository;
	}
	
	
	public void salvar(ArquivosFU arquivosES) {
		this.fuRepository.save(arquivosES);
	}
	
	public List<ArquivosFU> listar(){
		return this.fuRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.fuRepository.deleteById(id);
	}
	
	public String listarPorNome(String nome){
		List<ArquivosFU> listar =  this.fuRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosFU x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	public List<ArquivosFU> buscarPorNome(String nome){
		return this.fuRepository.findByNomeArquivo(nome);
	}
}
