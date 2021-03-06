package br.com.mercadolivre.bootcamp.desafiospring.model.repository;

import br.com.mercadolivre.bootcamp.desafiospring.model.entity.Vendedor;
import br.com.mercadolivre.bootcamp.desafiospring.validations.exception.VendedorInvalidoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VendedorRepository {

    private final List<Vendedor> listaVendedores;

    VendedorRepository(){
        // Criacao de 3 vendedores
        this.listaVendedores = new ArrayList<>(Arrays.asList(
                new Vendedor(255L,
                        "godofredo",
                        new ArrayList<>()),
                new Vendedor(256L,
                        "mlucia",
                        new ArrayList<>()),
                new Vendedor(257L,
                        "adesilva",
                        new ArrayList<>())
        ));
    }

    public List<Vendedor> getAll(){
        return listaVendedores;
    }

    public Vendedor getVendedorById(long idVendedor){
        Vendedor vendedorEncontrado = this.listaVendedores.stream()
                .filter(vendedor -> vendedor.getUserId() == (idVendedor))
                .findFirst()
                .orElse(null);
        if (vendedorEncontrado != null){
            return vendedorEncontrado;
        }
        throw new VendedorInvalidoException();
    }
}
