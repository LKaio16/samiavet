package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;

public interface FURepository extends JpaRepository<ArquivosFU, Long>  {

	
	List<ArquivosFU> findByNomeArquivo(String nome);

}
