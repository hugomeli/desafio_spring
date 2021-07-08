package br.com.mercadolivre.bootcamp.desafiospring.model.forms;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Produto;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PublicacaoPromoFormDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long id_post;

    @NotNull
    @JsonSerialize(as = Date.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            lenient = OptBoolean.FALSE, locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;

    @NotNull
    private Produto detail;

    @NotNull
    private int category;

    @NotNull
    private double price;

    @NotNull
    private boolean hasPromo;

    @NotNull
    private double discount;
    public PublicacaoPromoFormDTO() {
    }

    public PublicacaoPromoFormDTO(Long userId, Long id_post, Date date, Produto detail, int category,
                                  double price, boolean hasPromo, double discount) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public static Publicacao converte(PublicacaoPromoFormDTO publicacaoPromoFormDTO){
        return new Publicacao(
                publicacaoPromoFormDTO.getUserId(),
                publicacaoPromoFormDTO.getId_post(),
                publicacaoPromoFormDTO.getDate(),
                publicacaoPromoFormDTO.getDetail(),
                publicacaoPromoFormDTO.getCategory(),
                publicacaoPromoFormDTO.getPrice(),
                publicacaoPromoFormDTO.isHasPromo(),
                publicacaoPromoFormDTO.getDiscount()
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
