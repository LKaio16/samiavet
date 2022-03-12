package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosImagens;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ImagensRepository;

@Service
public class ArquivosImagensService {

	@Autowired
	private ImagensRepository imagensRepository;

	public ArquivosImagensService(ImagensRepository imagensRepository) {
		this.imagensRepository = imagensRepository;
	}

	public void salvar(ArquivosImagens arquivosES) {
		this.imagensRepository.save(arquivosES);
	}
	
	public List<ArquivosImagens> listar(){
		return this.imagensRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		this.imagensRepository.deleteById(id);
	}

	public String listarPorNome(String nome){
		List<ArquivosImagens> listar =  this.imagensRepository.findByNomeImagem(nome);
		String nomeImagem = null;
		
		for(ArquivosImagens x: listar) {
			nomeImagem = x.getNomeImagem();
		}
		
		return nomeImagem;
	}
	
	public List<ArquivosImagens> buscarPorNome(String nome){
		return this.imagensRepository.findByNomeImagem(nome);
	}
}



