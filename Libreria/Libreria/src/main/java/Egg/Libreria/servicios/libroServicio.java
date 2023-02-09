
package Egg.Libreria.servicios;

import Egg.Libreria.entidades.Autor;
import Egg.Libreria.entidades.Editorial;
import Egg.Libreria.entidades.Libro;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.repositorios.AutorRepositorio;
import Egg.Libreria.repositorios.EditorialRepositorio;
import Egg.Libreria.repositorios.LibroRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class libroServicio {
    
    @Autowired
    LibroRepositorio lirep;
    
    @Autowired
    AutorRepositorio aurep;
    
    @Autowired
    EditorialRepositorio edrep;
    
     
    public void crearLibro(String isbn,String titulo,Integer anio,Integer ejemplares,String idAutor,String idEditorial)throws MiException {
        
        validar(isbn,titulo,anio,ejemplares,idAutor,idEditorial);
        
        Optional <Libro> respLibro = lirep.findById(isbn);
        Optional <Autor> respAutor = aurep.findById(idAutor);
        Optional <Editorial> respEdi = edrep.findById(idEditorial);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        
        if (respAutor.isPresent()) {
            autor= respAutor.get();
        }
        if (respEdi.isPresent()) {
            editorial= respEdi.get();
        }
        
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjeprestados(0);
        libro.setEjerestantes(libro.getEjemplares()-libro.getEjeprestados());
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        lirep.save(libro);
        
    }
    
    public List<Libro> listarLibros(){
     
        List<Libro> libros = lirep.findAll();
  
        return libros;
    }
    
    
    
    private void validar(String isbn,String titulo,Integer anio,Integer ejemplares,String idAutor,String idEditorial) throws MiException{
      
        if(isbn == null){
            throw new MiException("el isbn no puede ser nulo"); //
        }
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("el titulo no puede ser nulo o estar vacio");
        }
        if(anio == null){
            throw new MiException("el año no puede ser nulo");
        }
        if(ejemplares == null){
            throw new MiException("ejemplares no puede ser nulo");
        }
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("el Autor no puede ser nulo o estar vacio");
        }
        
        if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("La Editorial no puede ser nula o estar vacia");
        }

    }
}
