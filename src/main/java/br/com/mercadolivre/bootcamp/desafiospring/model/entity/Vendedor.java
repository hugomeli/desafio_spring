package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.List;

public class Vendedor {

    private Long userId;
    private String userName;
    private List<Usuario> listaUsuariosSeguidores;

    public Vendedor(Long userId, String userName, List<Usuario> listaUsuariosSeguidores) {
        this.userId = userId;
        this.userName = userName;
        this.listaUsuariosSeguidores = listaUsuariosSeguidores;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
