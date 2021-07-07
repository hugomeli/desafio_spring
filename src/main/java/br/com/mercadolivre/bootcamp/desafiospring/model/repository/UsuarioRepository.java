package br.com.mercadolivre.bootcamp.desafiospring.model.repository;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.UsuarioInvalidoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final List<Usuario> listaUsuarios;

    UsuarioRepository(){
        // Criacao de 3 usuarios
        this.listaUsuarios = new ArrayList<>(Arrays.asList(
                new Usuario(15L,
                        "jcarlos",
                        new ArrayList<>()),
                new Usuario(16L,
                        "mlucia",
                        new ArrayList<>()),
                new Usuario(17L,
                        "antoniosantos",
                        new ArrayList<>())
        ));
    }

    public List<Usuario> getAll(){
        return listaUsuarios;
    }

    public Usuario getUsuarioById(long idUsuario){
        Usuario usuarioEncontrado = this.listaUsuarios.stream()
                .filter(usuario -> usuario.getUserId() == (idUsuario))
                .findFirst()
                .orElse(null);
        if (usuarioEncontrado != null){
            return usuarioEncontrado;
        }
        throw new UsuarioInvalidoException();
    }
}
