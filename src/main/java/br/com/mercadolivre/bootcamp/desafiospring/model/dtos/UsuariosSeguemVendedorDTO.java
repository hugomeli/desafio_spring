package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

import java.util.List;

public class UsuariosSeguemVendedorDTO {

    private Long userId;
    private String userName;
    private List<UsuarioDTO> usuariosSeguidores;

    public UsuariosSeguemVendedorDTO() {
    }

    public UsuariosSeguemVendedorDTO(Long userId, String userName, List<UsuarioDTO> usuariosSeguidores) {
        this.userId = userId;
        this.userName = userName;
        this.usuariosSeguidores = usuariosSeguidores;
    }

    public static UsuariosSeguemVendedorDTO converte(Vendedor vendedor, List<Usuario> listaUsuarios){
        return new UsuariosSeguemVendedorDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                UsuarioDTO.converte(listaUsuarios)
        );
    }
}
