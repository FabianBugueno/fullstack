package com.proyectoEduTech.EduTech.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoEduTech.EduTech.Model.Usuario;
import com.proyectoEduTech.EduTech.Model.Entity.UsuarioEntity;
import com.proyectoEduTech.EduTech.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public String crearUsuario(Usuario user){
        try {
            Boolean estado = usuarioRepository.existsByCorreo(user.getCorreo());
            if (estado) {
                UsuarioEntity usuarioNuevo = new UsuarioEntity();
                usuarioNuevo.setIdUsuario(user.getIdUsuario());
                usuarioNuevo.setNombre(user.getNombre());
                usuarioNuevo.setApellidos(user.getApellidos());
                usuarioNuevo.setCorreo(user.getCorreo());  
                usuarioNuevo.setContrasena(user.getContrasena());
                
                usuarioRepository.save(usuarioNuevo);
                return "Usuario creado correctamente";            
            }
            return "El correo ya existe";
        }
        catch (Exception e) {
            return "Error al crear el usuario: " + e.getMessage();
        }
    public Usuario obtenerUsuario(String correo){
        try {
            UsuarioEntity usuario = usuarioRepository.findByCorreo(correo);
            if (usuario != null) {
                Usuario user = new Usuario();
                user.setIdUsuario(usuario.getIdUsuario());
                user.setNombre(usuario.getNombre());
                user.setApellidos(usuario.getApellidos());
                user.setCorreo(usuario.getCorreo());
                user.setContrasena(usuario.getContrasena());
                return user;
            }
            return null;
        } catch (Exception e) {
            return null; 
        }
    }
}
