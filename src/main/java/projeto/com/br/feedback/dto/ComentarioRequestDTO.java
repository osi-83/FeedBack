package projeto.com.br.feedback.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComentarioRequestDTO {
    @NotBlank(message = "O texto do comentário é obrigatório")
    private String texto;
}
