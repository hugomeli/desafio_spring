package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.List;

public class Usuario implements Comparable<Usuario> {

    private Long userId;
    private String userName;
    private List<Vendedor> listaVendedoresSeguidos;

    public Usuario() {
    }

    public Usuario(Long userId, String userName, List<Vendedor> listaVendedoresSeguidos) {
        this.userId = userId;
        this.userName = userName;
        this.listaVendedoresSeguidos = listaVendedoresSeguidos;
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

    public List<Vendedor> getListaVendedoresSeguidos() {
        return listaVendedoresSeguidos;
    }

    public void setListaVendedoresSeguidos(List<Vendedor> listaVendedoresSeguidos) {
        this.listaVendedoresSeguidos = listaVendedoresSeguidos;
    }

    public void adicionaVendedorSeguido(Vendedor vendedor){
        this.listaVendedoresSeguidos.add(vendedor);
    }

    @Override
    public int compareTo(Usuario o) {
        return this.getUserName().compareTo(o.getUserName());
    }
}
