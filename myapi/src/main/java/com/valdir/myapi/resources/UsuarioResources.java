package com.valdir.myapi.resources;

import com.valdir.myapi.domain.Usuario;
import com.valdir.myapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResources {
    @Autowired
     private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario novoUsuario = service.update(id, usuario);

        return ResponseEntity.ok().body(novoUsuario);
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
        Usuario newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
