package projeto.com.br.feedback.repository;

import projeto.com.br.feedback.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    List<Sugestao> findByTituloContainingOrderByDataAtualizacaoDesc(String titulo);

}
