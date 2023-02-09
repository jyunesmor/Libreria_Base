package Egg.Libreria.controladores;

import Egg.Libreria.entidades.Autor;
import Egg.Libreria.entidades.Editorial;
import Egg.Libreria.entidades.Libro;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.servicios.autorServicio;
import Egg.Libreria.servicios.editorialServicio;
import Egg.Libreria.servicios.libroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    libroServicio ls;
    
    @Autowired
    autorServicio as;

    @Autowired
    editorialServicio es;

    
    @GetMapping("/registrar")
    public String index(ModelMap modelo) {
        
        List<Autor> autores = as.listarAutores();
        List<Editorial> editoriales = es.listarEditoriales();
        
        modelo.addAttribute("autores",autores);
        modelo.addAttribute("editoriales",editoriales);
        
        return "form_libro.html";
    }
    
    @PostMapping("/registro")  //localhost:8080/libro/regitro
    public String cargaLibro(@RequestParam String isbn,@RequestParam String titulo,@RequestParam(required = false) Integer anio, 
            @RequestParam(required = false) Integer ejemplares,@RequestParam String idAutor,@RequestParam String idEditorial, 
            ModelMap modelo) throws MiException{
       
        ls.crearLibro(isbn,titulo,anio,ejemplares,idAutor,idEditorial);
 
        return "form_libro.html";  // formulario pagina inicio
    }
    
    @GetMapping("/listar")  //localhost:8080/libro/listar
    public String listarlibros(ModelMap modelo){
        
        List<Libro> libros = ls.listarLibros();
         modelo.addAttribute("libros",libros);
        
        return "form_tabla_lib.html";
    }
    
    

}

