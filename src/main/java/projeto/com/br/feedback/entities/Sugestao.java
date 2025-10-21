package projeto.com.br.feedback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sugestao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descrição;

    private LocalDateTime dataEnvio;

    private LocalDateTime dataAtualização;

    @OneToMany(mappedBy = "sugestao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("dataEnvio DESC")
    private List<Comentario> comentarios;
}
