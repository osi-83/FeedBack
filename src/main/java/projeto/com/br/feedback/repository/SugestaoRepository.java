package projeto.com.br.feedback.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projeto.com.br.feedback.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    @Query("SELECT s FROM Sugestao s WHERE (:titulo IS null or NULL OR LOWER(s.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))) ORDER BY s.dataAtualização DESC")
    List<Sugestao> findByTituloContainingOrderByDataAtualizacaoDesc(@Param("titulo") String titulo);
}
