package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ProdutosRepository;


@Service
public class ProdutosService {
	@Autowired
	private ProdutosRepository produtosRepository;

	public ProdutosRepository getProdutosRepository() {
		return produtosRepository;
	}
	
	public void salvar(Produtos produtos) {
		this.produtosRepository.save(produtos);
	}

	public List<Produtos> listarProdutosPorId(String codigoBarras){
		return this.produtosRepository.findByCodigoBarras(codigoBarras);
	}
	
	public List<Produtos> listarProdutos(){
		return this.produtosRepository.findAll();
	}
	
	public void salvarLista(List<Produtos> lista) {
		
		this.produtosRepository.saveAll(lista);
		
	}
	
	public void excluir(String codigoBarras) {
		this.produtosRepository.deleteById(codigoBarras);
	}
	
	public List<Produtos> listarProdutosPorNome(String nome){
		return this.produtosRepository.findByNome(nome);
	}
}
