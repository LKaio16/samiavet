package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.CTRepository;

@Service
public class CTService {

	@Autowired
	private CTRepository ctRepository;

	public CTService(CTRepository ctRepository) {
		this.ctRepository = ctRepository;
	}

	public void salvar(ArquivosCT arquivosES) {
		this.ctRepository.save(arquivosES);
	}
	
	public List<ArquivosCT> listar(){
		return this.ctRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.ctRepository.deleteById(id);
	}

	public String listarPorNome(String nome){
		List<ArquivosCT> listar =  this.ctRepository.findByNomeArquivo(nome);
		String nomeArquivo = null;
		
		for(ArquivosCT x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	public List<ArquivosCT> buscarPorNome(String nome){
		return this.ctRepository.findByNomeArquivo(nome);
	}
}



