package br.com.mercadolivre.bootcamp.desafiospring.model.service;

import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesPromoDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.dtos.PublicacoesRecentesDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Produto;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Publicacao;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Usuario;
import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.forms.PublicacaoPromoFormDTO;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.PublicacaoRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.UsuarioRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.VendedorRepository;
import br.com.mercadolivre.bootcamp.desafiospring.utils.SomeUtils;
import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.OrdenacaoInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacaoService {

    private PublicacaoRepository publicacaoRepository;
    private VendedorRepository vendedorRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PublicacaoService(PublicacaoRepository publicacaoRepository,
                             VendedorRepository vendedorRepository,
                             UsuarioRepository usuarioRepository){
        this.publicacaoRepository = publicacaoRepository;
        this.vendedorRepository = vendedorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<?> adicionaPostagem(Publicacao publicacao){
        if (!publicacaoJaExiste(publicacao)){
            this.publicacaoRepository.save(publicacao);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public boolean formValido(PublicacaoFormDTO publicacaoFormDTO){
        return produtoValido(publicacaoFormDTO.getDetail()) &&
                (vendedorExiste(publicacaoFormDTO.getUserId()));
    }

    public boolean produtoValido(Produto produto){
        return (produto.getProductId() >= 0) &&
                (produto.getProductName() != null) &&
                (produto.getType() != null) &&
                (produto.getBrand() != null) &&
                (produto.getColor() != null) &&
                (produto.getNotes() != null);
    }

    public boolean vendedorExiste(Long userId){
        return vendedorRepository.getVendedorById(userId) != null;
    }

    public boolean publicacaoJaExiste(Publicacao publicacaoProcurada){
        return publicacaoRepository.getAll()
                .stream()
                .anyMatch(publicacao -> publicacao.getIdPost().equals(publicacaoProcurada.getIdPost()));
    }

    public PublicacoesRecentesDTO publicacoesRecentes(Long userId, String ordem){
        Usuario usuario = this.usuarioRepository.getUsuarioById(userId);
        Date filtrarData = SomeUtils.getDataDuasSemanasAtras(new Date());

        List<Publicacao> publicacoesVendedores = this.publicacaoRepository.encontrarPorIdVendedorOrdemData(
                usuario.getListaVendedoresSeguidos(), filtrarData);
        if (ordem.equals("") || (ordem.equals("date_desc"))){
            publicacoesVendedores.sort(Comparator.reverseOrder());
        } else if (ordem.equals("date_asc")){
            publicacoesVendedores.sort(Comparator.comparing(Publicacao::getDate));
        } else{
            throw new OrdenacaoInvalidaException();
        }
        return PublicacoesRecentesDTO.converte(userId, publicacoesVendedores);
    }

    public boolean formPromoValido(PublicacaoPromoFormDTO pubPromoDTO) {
        return produtoValido(pubPromoDTO.getDetail()) &&
                (vendedorExiste(pubPromoDTO.getUserId()) &&
                        pubPromoDTO.getDiscount() > 0 &&
                        pubPromoDTO.isHasPromo());
    }

    public List<Publicacao> publicacoesPromoByVendedor(Vendedor vendedor){
        return this.publicacaoRepository.getAll().stream()
                .filter(vendedorAnalisado -> vendedorAnalisado.getUserId().equals(vendedor.getUserId()))
                .filter(Publicacao::isHasPromo)
                .collect(Collectors.toList());
    }

    public int getNumeroPublicacoesByVendedor(Vendedor vendedor){
        return publicacoesPromoByVendedor(vendedor).size();
    }

    public PublicacoesPromoDTO getPublicacoesPromoDoVendedor(Vendedor vendedor, String ordem){
        List<Publicacao> publicacoesPromo = publicacoesPromoByVendedor(vendedor);
        if (ordem.equals("name_asc")){
            publicacoesPromo.sort(Comparator.comparing(Publicacao::getDetail));
        } else if (ordem.equals("name_desc")){
            publicacoesPromo.sort(Comparator.comparing(Publicacao::getDetail).reversed());
        } else{
            throw new OrdenacaoInvalidaException();
        }
        return PublicacoesPromoDTO.converteListPub(vendedor, publicacoesPromo);
    }
}
