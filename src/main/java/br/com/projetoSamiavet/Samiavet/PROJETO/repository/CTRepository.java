package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;

public interface CTRepository extends JpaRepository<ArquivosCT, Long>  {

	
	List<ArquivosCT> findByNomeArquivo(String nome);

}
