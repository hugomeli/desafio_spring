package br.com.mercadolivre.bootcamp.desafiospring.model.dtos;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

public class PublicacoesPromoDTO {

    private Long userId;
    private String userName;
    private List<PublicacaoPromoDTO> posts;

    public PublicacoesPromoDTO() {
    }

    public PublicacoesPromoDTO(Long userId, String userName, List<PublicacaoPromoDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public static PublicacoesPromoDTO converteListPubPromo(Vendedor vendedor, List<PublicacaoPromoDTO> publicacoesPromoDTO){
        return new PublicacoesPromoDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                publicacoesPromoDTO

        );
    }

    public static PublicacoesPromoDTO converteListPub(Vendedor vendedor, List<Publicacao> publicacoes){
        return new PublicacoesPromoDTO(
                vendedor.getUserId(),
                vendedor.getUserName(),
                publicacoes.stream().map(PublicacaoPromoDTO::converte)
                .collect(Collectors.toList())
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

    public List<PublicacaoPromoDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PublicacaoPromoDTO> posts) {
        this.posts = posts;
    }
}
