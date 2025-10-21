package projeto.com.br.feedback.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import projeto.com.br.feedback.dto.ComentarioRequestDTO;
import projeto.com.br.feedback.entities.Comentario;
import projeto.com.br.feedback.entities.Sugestao;
import projeto.com.br.feedback.repository.ComentarioRepository;
import projeto.com.br.feedback.repository.SugestaoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ComentarioService {

    private final SugestaoRepository sugestaoRepository;
    private final ComentarioRepository comentarioRepository;

    public ComentarioService(SugestaoRepository sugestaoRepository, ComentarioRepository comentarioRepository) {
        this.sugestaoRepository = sugestaoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    @Transactional
    public Optional<Comentario> adicionarComentario(Long sugestaoId, ComentarioRequestDTO dto) {
        Optional<Sugestao> sugestaoOptional = sugestaoRepository.findById(sugestaoId);

        if (sugestaoOptional.isEmpty()) {
            return Optional.empty();
        }

        Sugestao sugestao = sugestaoOptional.get();

        Comentario comentario = Comentario.builder()
                .sugestao(sugestao)
                .texto(dto.getTexto())
                .dataEnvio(LocalDateTime.now())
                .build();

        sugestao.setDataAtualização(LocalDateTime.now());

        sugestaoRepository.save(sugestao); // Atualiza dataAtualizacao
        Comentario salvo = comentarioRepository.save(comentario);

        return Optional.of(salvo);
    }
}