package br.com.mercadolivre.bootcamp.desafiospring.model.service;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.UsuariosSeguemVendedorDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.UsuarioRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsuariosService {

    private UsuarioRepository usuarioRepository;
    private VendedorRepository vendedorRepository;

    @Autowired
    public UsuariosService(UsuarioRepository usuarioRepository,
                           VendedorRepository vendedorRepository){
        this.usuarioRepository = usuarioRepository;
        this.vendedorRepository = vendedorRepository;
    }

    public ResponseEntity<?> seguirVendedor(Long userId, Long userIdToFollow){
        Usuario usuarioEncontrado = this.usuarioRepository.getUsuarioById(userId);
        Vendedor vendedorEncontrado = this.vendedorRepository.getVendedorById(userIdToFollow);
        if (usuarioEncontrado != null && vendedorEncontrado != null){
            if (checaUsuarioSegueVendedor(usuarioEncontrado, vendedorEncontrado)){
                usuarioEncontrado.adicionaVendedorSeguido(vendedorEncontrado);
                vendedorEncontrado.adicionaUsuarioSeguidor(usuarioEncontrado);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public VendedorRepository getVendedorRepository(){
        return vendedorRepository;
    }

    public static boolean checaUsuarioSegueVendedor(Usuario usuario, Vendedor vendedorEncontrado){
        return usuario.getListaVendedoresSeguidos().stream()
                .noneMatch(vendedor -> vendedor.getUserId().equals(vendedorEncontrado.getUserId()));
    }

    public UsuariosSeguemVendedorDTO getSeguidoresDto(Long userId){
        Vendedor vendedorEncontrado = this.vendedorRepository.getVendedorById(userId);
        return UsuariosSeguemVendedorDTO.converte(vendedorEncontrado, vendedorEncontrado.getListaUsuariosSeguidores());
    }
}
