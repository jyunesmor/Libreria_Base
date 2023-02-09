package Egg.Libreria.controladores;

import Egg.Libreria.entidades.Autor;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.servicios.autorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    autorServicio as;

    @GetMapping("/registrar")
    public String index() {

        return "form_autor.html";
    }

    @PostMapping("/registro") //localhost:8080/autor/registro
    public String registroAutor(@RequestParam String nombre,
            @RequestParam String apellido, ModelMap modelo) throws MiException {

        as.crearAutor(nombre,apellido);

        return "form_autor.html";
    }

    @GetMapping("/listar")  //localhost:8080/autor/listar
    public String listarautores(ModelMap modelo) {
        List<Autor> autores = as.listarAutores();
        modelo.addAttribute("autores", autores);

        return "form_tabla_aut.html";
    }

}
