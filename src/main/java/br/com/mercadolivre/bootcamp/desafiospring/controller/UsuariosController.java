package br.com.mercadolivre.bootcamp.desafiospring.controller;


import br.com.mercadolivre.bootcamp.desafiospring.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    private UsuarioService usuarioService;


    @Autowired
    public UsuariosController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followVendedor(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        return usuarioService.seguirVendedor(userId, userIdToFollow);
    }

}
