package br.com.mercadolivre.bootcamp.desafiospring.controller;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesPromoDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesRecentesDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedorContagemPubPromoDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedorContagemSeguidoresDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoPromoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.PublicacaoService;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class PublicacaoController {

    private PublicacaoService publicacaoService;
    private UsuariosService usuariosService;

    @Autowired
    public PublicacaoController(PublicacaoService publicacaoService,
                                UsuariosService usuariosService){
        this.publicacaoService = publicacaoService;
        this.usuariosService = usuariosService;
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

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<VendedorContagemPubPromoDTO> countPubPromo(@PathVariable Long userId){
        Vendedor vendedor = this.usuariosService.getVendedorRepository().getVendedorById(userId);
        return new ResponseEntity<>(
                VendedorContagemPubPromoDTO.converte(
                        vendedor,
                        this.publicacaoService.getNumeroPublicacoesByVendedor(vendedor))
                , HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PublicacoesPromoDTO> getPubPromoByVendedor(@PathVariable Long userId){
        Vendedor vendedor = this.usuariosService.getVendedorRepository().getVendedorById(userId);
        return new ResponseEntity<>(
                PublicacoesPromoDTO.converteListPub(
                        vendedor,
                        publicacaoService.publicacoesPromoByVendedor(vendedor)
                ),
                HttpStatus.OK
        );
    }
}
