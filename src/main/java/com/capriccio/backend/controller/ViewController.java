package com.capriccio.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index.html"; // Spring buscará automáticamente en la carpeta static
    }

    @GetMapping("/cocina")
    public String cocina() {
        return "cocina.html";
    }

    @GetMapping("/tienda")
    public String mostrarTienda() {
    return "tienda"; 
    }

    
}