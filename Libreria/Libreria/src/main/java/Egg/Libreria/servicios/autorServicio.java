package Egg.Libreria.servicios;

import Egg.Libreria.entidades.Autor;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.repositorios.AutorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class autorServicio {

    @Autowired
    AutorRepositorio aurep;

    public void crearAutor(String nombre, String apellido) throws MiException {

        if (nombre == null) {
            throw new MiException("el Nombre no puede ser nulo"); //
        }
        if (apellido == null) {
            throw new MiException("el Apellido no puede ser nulo"); //
        }
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setApellido(apellido);

        aurep.save(autor);
    }

    public List<Autor> listarAutores(){
   
        List<Autor> autores = aurep.findAll();
        
        return autores;
    }
    
    
    
}


