package com.proyectoEduTech.EduTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectoEduTech.EduTech.Model.Entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    UsuarioEntity findByCorreo(String correo);
    Boolean existsByCorreo(String correo);
    void deleteByCorreo(String correo);
}