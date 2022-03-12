package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosGeral;

public interface ArquivosGeralRepository extends JpaRepository<ArquivosGeral, Long>  {

	
	List<ArquivosGeral> findByNomeArquivo(String nome);
}
