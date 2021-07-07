package br.com.mercadolivre.bootcamp.desafiospring.model.service;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PublicacaoService {

    private PublicacaoRepository publicacaoRepository;

    @Autowired
    public PublicacaoService(PublicacaoRepository publicacaoRepository){
        this.publicacaoRepository = publicacaoRepository;
    }

    public ResponseEntity<?> adicionaPostagem(Publicacao publicacao){
        this.publicacaoRepository.save(publicacao);
        return ResponseEntity.ok().build();
    }
}
