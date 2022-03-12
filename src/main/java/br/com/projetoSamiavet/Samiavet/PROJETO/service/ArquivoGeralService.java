package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosGeral;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ArquivosGeralRepository;

@Service
public class ArquivoGeralService {

	@Autowired
	private ArquivosGeralRepository arquivosRepository;

	public ArquivoGeralService(ArquivosGeralRepository arquivosRepository) {
		this.arquivosRepository = arquivosRepository;
	}
	
	public void salvar(ArquivosGeral arquivo) {
		this.arquivosRepository.save(arquivo);
	}
	
	public List<ArquivosGeral> listar(){
		return this.arquivosRepository.findAll();
	}
	
	public String listarPorNome(String nome){
		List<ArquivosGeral> listar = this.arquivosRepository.findByNomeArquivo(nome);
		
		String nomeArquivo = null;
		
		for(ArquivosGeral x: listar) {
			nomeArquivo = x.getNomeArquivo();
		}
		
		return nomeArquivo;
	}
	
	
	public void deletar(Long id) {
		this.arquivosRepository.deleteById(id);
	}
}
