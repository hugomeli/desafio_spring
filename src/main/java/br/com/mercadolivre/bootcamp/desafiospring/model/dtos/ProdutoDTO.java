package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Produto;

public class ProdutoDTO {
    private Long product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long product_id, String productName, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public static ProdutoDTO converte(Produto produto){
        return new ProdutoDTO(
                produto.getProductId(),
                produto.getProductName(),
                produto.getType(),
                produto.getBrand(),
                produto.getColor(),
                produto.getNotes()
        );
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
