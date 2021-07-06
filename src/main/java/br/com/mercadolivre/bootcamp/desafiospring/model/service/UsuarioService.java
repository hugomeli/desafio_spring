package br.com.mercadolivre.bootcamp.desafiospring.model.service;

import br.com.mercadolivre.bootcamp.desafiospring.model.repository.UsuarioRepository;
import br.com.mercadolivre.bootcamp.desafiospring.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private VendedorRepository vendedorRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                             VendedorRepository vendedorRepository){
        this.usuarioRepository = usuarioRepository;
        this.vendedorRepository = vendedorRepository;
    }

    public ResponseEntity<?> seguirVendedor(Long userId, Long userIdToFollow){
        return ResponseEntity.ok().build();
    }
}
