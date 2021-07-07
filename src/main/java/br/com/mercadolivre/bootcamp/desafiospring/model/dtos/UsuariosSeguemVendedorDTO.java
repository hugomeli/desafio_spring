package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

import java.util.List;

public class UsuariosSeguemVendedorDTO {

    private Long userId;
    private String userName;
    private List<UsuarioDTO> followers;

    public UsuariosSeguemVendedorDTO() {
    }

    public UsuariosSeguemVendedorDTO(Long userId, String userName, List<UsuarioDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public static UsuariosSeguemVendedorDTO converte(Vendedor vendedor, List<Usuario> listaUsuarios){
        return new UsuariosSeguemVendedorDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                UsuarioDTO.converte(listaUsuarios)
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

    public List<UsuarioDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UsuarioDTO> followers) {
        this.followers = followers;
    }
}
