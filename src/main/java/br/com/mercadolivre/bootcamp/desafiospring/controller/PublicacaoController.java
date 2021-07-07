package br.com.mercadolivre.bootcamp.desafiospring.controller;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.PublicacaoRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PublicacaoController {

    private PublicacaoService publicacaoService;

    @Autowired
    public PublicacaoController(PublicacaoService publicacaoService){
        this.publicacaoService = publicacaoService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> cadastraPublicacao(@RequestBody Publicacao publicacao){
        return publicacaoService.adicionaPostagem(publicacao);
    }
}
