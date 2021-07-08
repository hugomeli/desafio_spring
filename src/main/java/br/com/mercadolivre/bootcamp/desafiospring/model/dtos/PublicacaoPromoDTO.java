package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.utils.SomeUtils;

public class PublicacaoPromoDTO {


    private Long id_post;
    private String date;
    private ProdutoDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PublicacaoPromoDTO() {
    }

    public PublicacaoPromoDTO(Long id_post, String date, ProdutoDTO detail, int category, double price,
                              boolean hasPromo, double discount) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public static PublicacaoPromoDTO converte(Publicacao publicacao){
        return new PublicacaoPromoDTO(
                publicacao.getIdPost(),
                SomeUtils.converteDataString(publicacao.getDate()),
                ProdutoDTO.converte(publicacao.getDetail()),
                publicacao.getCategory(),
                publicacao.getPrice(),
                publicacao.isHasPromo(),
                publicacao.getDiscount()
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

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
