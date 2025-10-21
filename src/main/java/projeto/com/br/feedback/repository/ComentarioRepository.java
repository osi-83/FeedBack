package projeto.com.br.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.com.br.feedback.entities.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
