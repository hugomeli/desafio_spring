package br.com.mercadolivre.bootcamp.desafiospring.controller;


import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.UsuariosSeguemVendedorDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedorContagemSeguidoresDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedoresQueUsuarioSegueDTO;
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

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UsuariosSeguemVendedorDTO> getFollowers(@PathVariable Long userId){
        UsuariosSeguemVendedorDTO usuariosSeguemVendedor = this.usuariosService.getSeguidoresDto(userId);
        return new ResponseEntity<>(usuariosSeguemVendedor, HttpStatus.OK);
    }

    @GetMapping("/{userID}/followed/list")
    public ResponseEntity<VendedoresQueUsuarioSegueDTO> getFollowedList(@PathVariable Long userID){
        VendedoresQueUsuarioSegueDTO vendedoresQueUsuarioSegue = this.usuariosService.getVendedoresSeguidos(userID);
        return new ResponseEntity<>(vendedoresQueUsuarioSegue, HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowVendedor(@PathVariable Long userId, @PathVariable Long userIdToUnfollow){
        return this.usuariosService.deixarDeSeguir(userId, userIdToUnfollow);
    }
}
