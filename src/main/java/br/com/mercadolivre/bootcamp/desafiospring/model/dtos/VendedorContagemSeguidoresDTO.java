package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

public class VendedorContagemSeguidoresDTO {

    private Long id;
    private String userName;
    private int quantidadeSeguidores;

    public VendedorContagemSeguidoresDTO() {
    }

    public VendedorContagemSeguidoresDTO(Long id, String userName, int quantidadeSeguidores) {
        this.id = id;
        this.userName = userName;
        this.quantidadeSeguidores = quantidadeSeguidores;
    }

    public static VendedorContagemSeguidoresDTO converte(Vendedor vendedor){
        return new VendedorContagemSeguidoresDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                vendedor.getListaUsuariosSeguidores().size()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuantidadeSeguidores() {
        return quantidadeSeguidores;
    }

    public void setQuantidadeSeguidores(int quantidadeSeguidores) {
        this.quantidadeSeguidores = quantidadeSeguidores;
    }
}
