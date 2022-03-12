package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long>  {

	List<Vendas> findByIdVenda(Long id);
	
	@Query("SELECT produtos From Vendas")
	List<Produtos> retornaProdutos();

}
