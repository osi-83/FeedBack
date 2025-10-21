package projeto.com.br.feedback.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class SugestaoRequestDTO {
    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message= "A descrição é obrigatória")
    private String descrição;
}
