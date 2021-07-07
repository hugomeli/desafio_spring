package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private Long userId;
    private String userName;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static UsuarioDTO converte(Usuario usuario){
        return new UsuarioDTO(
                usuario.getUserId(),
                usuario.getUserName()
        );
    }

    public static List<UsuarioDTO> converte(List<Usuario> listaUsuario){
        return listaUsuario.stream()
                .map(UsuarioDTO::converte)
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
