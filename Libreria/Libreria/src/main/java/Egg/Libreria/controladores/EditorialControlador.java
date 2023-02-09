
package Egg.Libreria.controladores;


import Egg.Libreria.entidades.Editorial;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.servicios.editorialServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/editorial")
public class EditorialControlador {
    
    @Autowired
    editorialServicio es;
    
    @GetMapping("/registrar")
    public String index(){
        return "form_editorial.html";
    }
    
    @PostMapping("/registro")
    public String ingresoEditorial(@RequestParam String nombre,@RequestParam String cuit,
            ModelMap modelo) throws MiException{
        
        es.crearEditorial(nombre,cuit);
                
        return "form_editorial.html";
    }
    
     @GetMapping("/listar")  //localhost:8080/editorial/listar
    public String listarautores(ModelMap modelo) {
        List<Editorial> editoriales = es.listarEditoriales();
        modelo.addAttribute("editoriales", editoriales);

        return "form_tabla_edi.html";
    }   
    
}
