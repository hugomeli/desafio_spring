package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;


import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;

import java.util.List;

public class PublicacoesRecentesDTO {

    private Long userId;
    private List<PublicacaoDTO> posts;

    public PublicacoesRecentesDTO() {
    }

    public PublicacoesRecentesDTO(Long userId, List<PublicacaoDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PublicacaoDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PublicacaoDTO> posts) {
        this.posts = posts;
    }

    public static PublicacoesRecentesDTO converte(Long userId, List<Publicacao> publicacoes){
        return new PublicacoesRecentesDTO(
                userId,
                PublicacaoDTO.converte(publicacoes)
        );
    }
}
