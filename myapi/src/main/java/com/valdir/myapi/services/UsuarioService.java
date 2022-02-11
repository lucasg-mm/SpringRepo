package com.valdir.myapi.services;

import com.valdir.myapi.domain.Usuario;
import com.valdir.myapi.repositories.UsuarioRepository;
import com.valdir.myapi.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion("Usuário não encontrado! Id: " + id));
    }


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario newObj = findById(id);
        newObj.setNome(usuario.getNome());
        newObj.setLogin(usuario.getLogin());
        newObj.setSenha(usuario.getSenha());
        return usuarioRepository.save(newObj);
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return usuarioRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
