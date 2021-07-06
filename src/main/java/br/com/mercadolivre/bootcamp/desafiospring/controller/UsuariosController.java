package br.com.mercadolivre.bootcamp.desafiospring.controller;


import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedorContagemSeguidoresDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.model.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    private UsuariosService usuariosService;


    @Autowired
    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followVendedor(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        return usuariosService.seguirVendedor(userId, userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<VendedorContagemSeguidoresDTO> countSeguidores(@PathVariable Long userId){
        Vendedor vendedor = this.usuariosService.getVendedorRepository().getVendedorById(userId);
        return new ResponseEntity<>(VendedorContagemSeguidoresDTO.converte(vendedor), HttpStatus.OK);
    }

}
