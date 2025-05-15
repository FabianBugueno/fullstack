package com.proyectoEduTech.EduTech.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoEduTech.EduTech.Model.Usuario;
import com.proyectoEduTech.EduTech.Service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> obtenerUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

@GetMapping("/obtenerUsuario/{correo}")
public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String correo){
    Usuario usuario = usuarioService.obtenerUsuario(correo);
    if (usuario != null) {
        return ResponseEntity.ok(usuario);
    } else {
        return ResponseEntity.notFound().build();
    }
}
    
}
    
