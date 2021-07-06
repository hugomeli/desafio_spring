package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.List;

public class Vendedor {

    private Long id;
    private String userName;
    private List<Usuario> listaUsuariosSeguidores;

    public Vendedor(Long id, String userName, List<Usuario> listaUsuariosSeguidores) {
        this.id = id;
        this.userName = userName;
        this.listaUsuariosSeguidores = listaUsuariosSeguidores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
