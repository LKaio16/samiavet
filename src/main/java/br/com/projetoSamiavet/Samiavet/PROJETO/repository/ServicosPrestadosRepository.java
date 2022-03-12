package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ServicosPrestados;

@Repository
public interface ServicosPrestadosRepository extends JpaRepository<ServicosPrestados, Long>{

	
	
}
