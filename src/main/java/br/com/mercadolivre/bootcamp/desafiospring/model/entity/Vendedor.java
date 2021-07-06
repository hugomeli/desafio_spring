package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {

    private Long id;
    private String nome;
    private List<Usuario> listaUsuariosSeguidores;

    public Vendedor(Long id, String nome, List<Usuario> listaUsuariosSeguidores) {
        this.id = id;
        this.nome = nome;
        this.listaUsuariosSeguidores = listaUsuariosSeguidores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getListaUsuariosSeguidores() {
        return listaUsuariosSeguidores;
    }

    public void setListaUsuariosSeguidores(List<Usuario> listaUsuariosSeguidores) {
        this.listaUsuariosSeguidores = listaUsuariosSeguidores;
    }

    public void adicionaUsuarioSeguidor(Usuario usuario) {
        this.listaUsuariosSeguidores.add(usuario);
    }
}
