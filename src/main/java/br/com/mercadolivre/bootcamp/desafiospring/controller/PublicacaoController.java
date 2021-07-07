package br.com.mercadolivre.bootcamp.desafiospring.controller;

import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<?> cadastraPublicacao(@Validated @RequestBody PublicacaoFormDTO pubFormDTO){
        return this.publicacaoService.adicionaPostagem(PublicacaoFormDTO.converte(pubFormDTO));
    }
}
