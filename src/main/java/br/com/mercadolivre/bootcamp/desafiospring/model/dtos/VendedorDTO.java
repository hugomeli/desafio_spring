package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

public class VendedorDTO {

    private Long userId;
    private String userName;

    public VendedorDTO() {
    }

    public VendedorDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static VendedorDTO converte(Vendedor vendedor){
        return new VendedorDTO(
                vendedor.getUserId(),
                vendedor.getUserName()
        );
    }

    public static List<VendedorDTO> converte(List<Vendedor> listaVendedores){
        return listaVendedores.stream()
                .map(VendedorDTO::converte)
                .collect(Collectors.toList());
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
}
