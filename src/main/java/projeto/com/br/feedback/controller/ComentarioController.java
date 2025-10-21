package projeto.com.br.feedback.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.com.br.feedback.dto.ComentarioRequestDTO;
import projeto.com.br.feedback.entities.Comentario;
import projeto.com.br.feedback.service.ComentarioService;

@RestController
@RequestMapping("/sugestoes")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<Comentario> adicionarComentario(
            @PathVariable Long id,
            @Valid @RequestBody ComentarioRequestDTO dto) {

        return comentarioService.adicionarComentario(id, dto)
                .map(comentario -> ResponseEntity.status(HttpStatus.CREATED) .body(comentario))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}