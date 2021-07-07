package br.com.mercadolivre.bootcamp.desafiospring.model.repository;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublicacaoRepository {

    private final List<Publicacao> listaPublicacoes;

    public PublicacaoRepository(){
        listaPublicacoes = new ArrayList<>();
    }

    public void save(Publicacao publicacao){
        listaPublicacoes.add(publicacao);
    }

    public List<Publicacao> getAll(){
        return listaPublicacoes;
    }

    public List<Publicacao> encontrarPorIdVendedor(Long userId){
        List<Publicacao> publicacoesDoVendedor = new ArrayList<>();
        for (Publicacao publicacao:
             this.listaPublicacoes) {
            if (publicacao.getUserId().equals(userId)){
                publicacoesDoVendedor.add(publicacao);
            }
        }
        return publicacoesDoVendedor;
    }
}
