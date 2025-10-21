package projeto.com.br.feedback.service;

import projeto.com.br.feedback.entities.Sugestao;
import projeto.com.br.feedback.repository.SugestaoRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SugestaoService {

    private final SugestaoRepository sugestaoRepository;

    public SugestaoService(SugestaoRepository sugestaorepository) {
        this.sugestaoRepository = sugestaorepository;
    }

    public Sugestao criarSugestao(String titulo, String descricao) {
        Sugestao sugestao = Sugestao.builder()
                .titulo(titulo)
                .descrição(descricao)
                .dataEnvio(LocalDateTime.now())
                .dataAtualização(LocalDateTime.now())
                .build();

        return sugestaoRepository.save(sugestao);
    }

    public List<Sugestao> listarSugestoes(String titulo) {
        return sugestaoRepository.findByTituloContainingOrderByDataAtualizacaoDesc(titulo);
    }
}
