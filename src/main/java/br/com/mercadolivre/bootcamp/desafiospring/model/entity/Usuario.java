package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Long id;
    private String userName;
    private List<Vendedor> listaVendedoresSeguidos;

    public Usuario() {
    }

    public Usuario(Long id, String nome, List<Vendedor> listaVendedoresSeguidos) {
        this.id = id;
        this.userName = nome;
        this.listaVendedoresSeguidos = listaVendedoresSeguidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
