package br.com.mercadolivre.bootcamp.desafiospring.model.forms;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Produto;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PublicacaoFormDTO {

    private Long userId;
    private Long id_post;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
            , locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;

    private Produto detail;
    private int category;
    private double price;

    public PublicacaoFormDTO() {
    }

    public PublicacaoFormDTO(Long userId, Long id_post, Date date, Produto detail, int category, double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public static Publicacao converte(PublicacaoFormDTO publicacaoFormDTO){
        return new Publicacao(
                publicacaoFormDTO.getUserId(),
                publicacaoFormDTO.getId_post(),
                publicacaoFormDTO.getDate(),
                publicacaoFormDTO.getDetail(),
                publicacaoFormDTO.getCategory(),
                publicacaoFormDTO.getPrice()
        );
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
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
}
