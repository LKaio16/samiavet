package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;

public interface ESRepository extends JpaRepository<ArquivosES, Long>  {

	
	List<ArquivosES> findByNomeArquivo(String nome);

}
