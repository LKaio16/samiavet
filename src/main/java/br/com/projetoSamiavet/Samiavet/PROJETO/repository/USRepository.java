package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;

public interface USRepository extends JpaRepository<ArquivosUS, Long>  {

	List<ArquivosUS> findByNomeArquivo(String nome);
}
