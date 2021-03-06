package br.com.mercadolivre.bootcamp.desafiospring.model.entity;

public class Produto implements Comparable<Produto>{
    private Long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;


    public Produto() {
    }

    public Produto(Long productId, String productName, String type,
                   String brand, String color, String notes, int category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    @Override
    public int compareTo(Produto o) {
        return this.getProductName().compareTo(o.getProductName());
    }
}
