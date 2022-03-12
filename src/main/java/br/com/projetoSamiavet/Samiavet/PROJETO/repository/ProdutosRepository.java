package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, String>  {

	List<Produtos> findByCodigoBarras(String codigoDeBarras);
	
	List<Produtos> findByNome(String nome);
	}
