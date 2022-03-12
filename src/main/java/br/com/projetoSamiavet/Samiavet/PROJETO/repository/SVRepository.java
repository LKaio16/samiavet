package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;

public interface SVRepository extends JpaRepository<ArquivosSV, Long> {

	
	List<ArquivosSV> findByNomeArquivo(String nome);

}
