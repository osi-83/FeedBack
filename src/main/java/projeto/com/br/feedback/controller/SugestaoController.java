package projeto.com.br.feedback.controller;

import projeto.com.br.feedback.dto.SugestaoRequestDTO;
import projeto.com.br.feedback.entities.Sugestao;
import projeto.com.br.feedback.service.SugestaoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {

    private final SugestaoService sugestaoService;

    public SugestaoController(SugestaoService sugestaoService) {
        this.sugestaoService = sugestaoService;
    }

    @PostMapping
    public ResponseEntity<Sugestao> criarSugestao(@Valid @RequestBody SugestaoRequestDTO requestDTO) {
        Sugestao novaSugestao = sugestaoService.criarSugestao(requestDTO.getTitulo(), requestDTO.getDescrição());
        return new ResponseEntity<>(novaSugestao, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Sugestao> buscarSugestoes (@RequestParam(required = false) String titulo) {
        return sugestaoService.listarSugestoes(titulo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sugestao> buscarSugestaoPorId(@PathVariable Long id) {
        return sugestaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
