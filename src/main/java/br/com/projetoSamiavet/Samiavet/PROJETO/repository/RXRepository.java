package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;

public interface RXRepository extends JpaRepository<ArquivosRX, Long> {

	
	List<ArquivosRX> findByNomeArquivo(String nome);

}
