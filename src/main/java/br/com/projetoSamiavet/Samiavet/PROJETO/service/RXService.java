package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.RXRepository;

@Service
public class RXService {

	@Autowired
	private RXRepository rxRepository;

	public RXService(RXRepository rxRepository) {
		this.rxRepository = rxRepository;
	}
	
	
	public void salvar(ArquivosRX arquivosES) {
		this.rxRepository.save(arquivosES);
	}
	
	public List<ArquivosRX> listar(){
		return this.rxRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.rxRepository.deleteById(id);
	}
	
	public String listarPorNome(String nome){
		List<ArquivosRX> listar =  this.rxRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosRX x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	public List<ArquivosRX> buscarPorNome(String nome){
		return this.rxRepository.findByNomeArquivo(nome);
	}
	
}
