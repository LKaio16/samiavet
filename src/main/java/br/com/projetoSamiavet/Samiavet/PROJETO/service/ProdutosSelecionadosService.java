

package br.com.projetoSamiavet.Samiavet.PROJETO.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ProdutosSelecionados;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ProdutosSelecionadosRepository;


@Service
public class ProdutosSelecionadosService {
	@Autowired
	private ProdutosSelecionadosRepository produtosSelecionadosRepository;
	
	public ProdutosSelecionadosService(ProdutosSelecionadosRepository produtosSelecionadosRepository) {
		this.produtosSelecionadosRepository = produtosSelecionadosRepository;
	}
	public ProdutosSelecionadosRepository getProdutosSelecionadosRepository() {
		return produtosSelecionadosRepository;
	}

	public void salvar(ProdutosSelecionados produtosSelecionados) {
		this.produtosSelecionadosRepository.save(produtosSelecionados);
	}
	
	public List<ProdutosSelecionados> listar(){
		return this.produtosSelecionadosRepository.findAll();
		
	}
	
	public void excluir(String codigoBarras) {
		this.produtosSelecionadosRepository.deleteById(codigoBarras);
	}
	
	}
