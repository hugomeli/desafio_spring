package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

public class VendedorContagemPubPromoDTO {

    private Long userId;
    private String userName;
    private int promoproducts_count;

    public VendedorContagemPubPromoDTO() {
    }

    public VendedorContagemPubPromoDTO(Long userId, String userName, int promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
    }

    public static VendedorContagemPubPromoDTO converte(Vendedor vendedor, int quantidadePublicacoes){
        return new VendedorContagemPubPromoDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                quantidadePublicacoes
        );
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

    public int getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(int promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }
}
