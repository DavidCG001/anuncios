package com.example.demo;

import Objetos.Persona;
import Enum.Sexo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="Huan") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @GetMapping("/nuevoAnuncio")
    public String nuevoAnuncio() {
        return "nuevoAnuncio";
    }

    @GetMapping("/anuncio")
    public String anuncio(@RequestParam(name="nombre", required=false, defaultValue="Huan") String nombre,@RequestParam(name="asunto", required=false, defaultValue="Huan") String asunto,@RequestParam(name="cuerpo", required=false, defaultValue="Huan") String cuerpo, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("asunto", asunto);
        model.addAttribute("cuerpo", cuerpo);
        return "anuncio";
    }

    @GetMapping("/enlace")
    public String enlace() {
        return "enlace";
    }

    @GetMapping("/enlaces")
    public String enlaces(@RequestParam(name="numero", required=false, defaultValue="") String numero, Model model) {
        model.addAttribute("numero", numero);
        return "enlaces";
    }

    @GetMapping("/lista")
    public String lista() {
        return "lista";
    }

    @GetMapping("/listas")
    public String listas(@RequestParam(name = "nombre", required = false) String nombre,
                         @RequestParam(name = "apellido", required = false) String apellido,
                         @RequestParam(name = "correo", required = false) String correo,
                         @RequestParam(name = "sexo", required = false) Sexo sexo,
                         HttpSession session,
                         Model model) {

        List<Persona> lista = (List<Persona>) session.getAttribute("listaPersonas");
        if (lista == null) {
            lista = new ArrayList<>(); // Lista vacía
            session.setAttribute("listaPersonas", lista);
        }

        lista.add(new Persona(nombre, apellido, sexo, correo));

        model.addAttribute("lista", lista);
        model.addAttribute("fecha", LocalDate.now());
        return "listas";
    }



}




