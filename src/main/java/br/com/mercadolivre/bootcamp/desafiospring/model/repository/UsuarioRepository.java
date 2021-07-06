package br.com.mercadolivre.bootcamp.desafiospring.model.repository;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
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
                        "Joao Carlos",
                        new ArrayList<>()),
                new Usuario(16L,
                        "Maria Lucia",
                        new ArrayList<>()),
                new Usuario(17L,
                        "Antonio dos Santos",
                        new ArrayList<>())
        ));
    }

    public List<Usuario> getAll(){
        return listaUsuarios;
    }

    public Usuario getUsuarioById(long idUsuario){
        return this.listaUsuarios.stream()
                .filter(usuario -> usuario.getId() == (idUsuario))
                .findFirst()
                .orElse(null);
    }
}
