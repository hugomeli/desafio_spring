package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.utils.SomeUtils;


public class PublicacaoDTO {

    private Long id_post;
    private String date;
    private ProdutoDTO detail;
    private int category;
    private double price;

    public PublicacaoDTO() {
    }

    public PublicacaoDTO(Long id_post, String date, ProdutoDTO detail, int category, double price) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public static PublicacaoDTO converte(Publicacao publicacao){
        return new PublicacaoDTO(
                publicacao.getIdPost(),
                SomeUtils.converteDataString(publicacao.getDate()),
                ProdutoDTO.converte(publicacao.getDetail()),
                publicacao.getCategory(),
                publicacao.getPrice()
        );
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ProdutoDTO getDetail() {
        return detail;
    }

    public void setDetail(ProdutoDTO detail) {
        this.detail = detail;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
