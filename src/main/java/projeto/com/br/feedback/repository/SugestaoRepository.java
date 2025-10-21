package projeto.com.br.feedback.repository;

import projeto.com.br.feedback.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {
}
