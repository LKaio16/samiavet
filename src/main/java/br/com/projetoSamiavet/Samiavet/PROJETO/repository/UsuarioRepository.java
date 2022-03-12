package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
	List<Usuario> findByLogin(String login);
	List<Usuario> findBySenha(String senha);
}
