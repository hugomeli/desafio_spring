package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

import java.util.List;

public class VendedoresQueUsuarioSegueDTO {

    private Long userId;
    private String userName;
    private List<VendedorDTO> followed;

    public VendedoresQueUsuarioSegueDTO() {
    }

    public VendedoresQueUsuarioSegueDTO(Long userId, String userName, List<VendedorDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public static VendedoresQueUsuarioSegueDTO converte(Usuario usuario, List<Vendedor> listaVendedores){
        return new VendedoresQueUsuarioSegueDTO(
                usuario.getUserId(),
                usuario.getUserName(),
                VendedorDTO.converte(listaVendedores)
        );
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<VendedorDTO> getFollowed() {
        return followed;
    }
}
