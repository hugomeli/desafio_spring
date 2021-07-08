package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

import br.com.mercadolivre.bootcamp.desafiospring.utils.SomeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Publicacao implements Comparable<Publicacao>{

    private Long userId;
    private Long idPost;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;
    private Produto detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Publicacao() {
    }

    public Publicacao(Long userId, Long idPost, Date date, Produto detail, int category, double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Publicacao(Long userId, Long idPost, Date date,
                      Produto detail, int category, double price, boolean hasPromo, double discount) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Produto getDetail() {
        return detail;
    }

    public void setDetail(Produto detail) {
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

    @Override
    public int compareTo(Publicacao o) {
        return this.getDate().compareTo(o.getDate());
    }
}
