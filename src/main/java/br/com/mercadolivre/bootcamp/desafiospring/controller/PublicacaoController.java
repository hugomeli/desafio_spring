package br.com.mercadolivre.bootcamp.desafiospring.controller;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesRecentesDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoPromoFormDTO;
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
    public ResponseEntity<PublicacoesRecentesDTO> getPublicacoesRecentes(@PathVariable Long userId,
                                                                         @RequestParam(defaultValue = "") String order){
        PublicacoesRecentesDTO pubRecentes = this.publicacaoService.publicacoesRecentes(userId, order);
        return new ResponseEntity<>(pubRecentes, HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<?> cadastraPublicacaoPromocional(@Valid @RequestBody PublicacaoPromoFormDTO pubPromoDTO){
        if (publicacaoService.formPromoValido(pubPromoDTO)){
            return this.publicacaoService.adicionaPostagem(PublicacaoPromoFormDTO.converte(pubPromoDTO));
        }
        return ResponseEntity.badRequest().build();
    }
}
