package br.com.mercadolivre.bootcamp.desafiospring.model.repository;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Publicacao> encontrarPorIdVendedor(Long userId, Date comparadorData){
        return this.listaPublicacoes.stream()
                .filter(publicacao -> publicacao.getUserId().equals(userId))
                .filter(publicacao -> publicacao.getDate().after(comparadorData))
                .collect(Collectors.toList());
    }

    public List<Publicacao> encontrarPorIdVendedorOrdemData(List<Vendedor> vendedores, Date dataLimite){
        Comparator<Date> comparadorData = Comparator.reverseOrder();

        List<Publicacao> publicacoesvendedores = new ArrayList<>();
        vendedores.forEach(vendedor -> publicacoesvendedores.addAll(
                this.encontrarPorIdVendedor(vendedor.getUserId(), dataLimite)));

        publicacoesvendedores.sort((publicacao1, publicacao2) -> comparadorData.
                compare(publicacao1.getDate(), publicacao2.getDate()));

        return publicacoesvendedores;
    }
}
