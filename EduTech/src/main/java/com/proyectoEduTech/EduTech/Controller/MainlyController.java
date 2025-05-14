package com.proyectoEduTech.EduTech.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
public class MainlyController {
                                @GetMapping("/hola")
                                public String hola(){
                                    return "Hola Mundo";}
    
}
