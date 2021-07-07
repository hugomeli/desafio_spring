package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.List;

public class Usuario {

    private Long userId;
    private String userName;
    private List<Vendedor> listaVendedoresSeguidos;

    public Usuario() {
    }

    public Usuario(Long userId, String nome, List<Vendedor> listaVendedoresSeguidos) {
        this.userId = userId;
        this.userName = nome;
        this.listaVendedoresSeguidos = listaVendedoresSeguidos;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return userName;
    }

    public void setNome(String nome) {
        this.userName = nome;
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
}
