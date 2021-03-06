package br.com.mercadolivre.bootcamp.desafiospring.model.service;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.UsuariosSeguemVendedorDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.VendedoresQueUsuarioSegueDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.UsuarioRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.VendedorRepository;
import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.OrdenacaoInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


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
            if (!checaUsuarioSegueVendedor(usuarioEncontrado, vendedorEncontrado)){
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


    // Verifica se um usu??rio j?? est?? seguindo um vendedor
    public static boolean checaUsuarioSegueVendedor(Usuario usuario, Vendedor vendedorEncontrado){
        return usuario.getListaVendedoresSeguidos().stream()
                .anyMatch(vendedor -> vendedor.getUserId().equals(vendedorEncontrado.getUserId()));
    }

    public UsuariosSeguemVendedorDTO getSeguidoresDto(Long userId, String ordem){
        Vendedor vendedorEncontrado = this.vendedorRepository.getVendedorById(userId);
        List<Usuario> listaUsuarios = vendedorEncontrado.getListaUsuariosSeguidores();
        if (ordem.equals("name_asc") || ordem.equals("")){
            listaUsuarios.sort(Comparator.comparing(Usuario::getUserName));
        } else if (ordem.equals("name_desc")) {
            listaUsuarios.sort(Comparator.reverseOrder());
        } else {
            throw new OrdenacaoInvalidaException();
        }
        return UsuariosSeguemVendedorDTO.converte(vendedorEncontrado, listaUsuarios);
    }

    public VendedoresQueUsuarioSegueDTO getVendedoresSeguidos(Long userId, String ordem){
        Usuario usuarioEncontrado = this.usuarioRepository.getUsuarioById(userId);
        List<Vendedor> listaVendedores = usuarioEncontrado.getListaVendedoresSeguidos();
        if (ordem.equals("name_asc") || ordem.equals("")){
            listaVendedores.sort(Comparator.comparing(Vendedor::getUserName));
        } else if (ordem.equals("name_desc")){
            listaVendedores.sort(Comparator.reverseOrder());
        } else {
            throw new OrdenacaoInvalidaException();
        }
        return VendedoresQueUsuarioSegueDTO.converte(usuarioEncontrado, usuarioEncontrado.getListaVendedoresSeguidos());
    }

    public ResponseEntity<?> deixarDeSeguir(Long userId, Long userToUnfollowId){
        Usuario usuario = this.usuarioRepository.getUsuarioById(userId);
        Vendedor vendedor = this.vendedorRepository.getVendedorById(userToUnfollowId);
        if (usuario.getListaVendedoresSeguidos().remove(vendedor) &&(
                vendedor.getListaUsuariosSeguidores().remove(usuario))){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
