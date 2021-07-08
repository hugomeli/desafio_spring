package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.List;

public class Vendedor extends UsuarioAbstrato implements Comparable<Vendedor>{


    private List<Usuario> listaUsuariosSeguidores;

    public Vendedor(Long userId, String userName, List<Usuario> listaUsuariosSeguidores) {
        super(userId, userName);
        this.listaUsuariosSeguidores = listaUsuariosSeguidores;
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

    @Override
    public int compareTo(Vendedor o) {
        return this.getUserName().compareTo(o.getUserName());
    }
}
