package br.com.mercadolivre.bootcamp.desafiospring.controller;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesRecentesDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PublicacaoController {

    private PublicacaoService publicacaoService;

    @Autowired
    public PublicacaoController(PublicacaoService publicacaoService){
        this.publicacaoService = publicacaoService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> cadastraPublicacao(@Valid @RequestBody PublicacaoFormDTO pubFormDTO){
        if (publicacaoService.formValido(pubFormDTO)){
            return this.publicacaoService.adicionaPostagem(PublicacaoFormDTO.converte(pubFormDTO));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicacoesRecentesDTO> getPublicacoesRecentes(@PathVariable Long userId){
        PublicacoesRecentesDTO pubRecentes = this.publicacaoService.publicacoesRecentes(userId);
        System.out.println(pubRecentes.toString());
        return ResponseEntity.ok(pubRecentes);
//        return new ResponseEntity<>(this.publicacaoService.publicacoesRecentes(userId), HttpStatus.OK);
    }
}
