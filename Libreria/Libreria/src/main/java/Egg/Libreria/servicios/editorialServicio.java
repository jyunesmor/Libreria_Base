package Egg.Libreria.servicios;

import Egg.Libreria.entidades.Editorial;
import Egg.Libreria.expecciones.MiException;
import Egg.Libreria.repositorios.EditorialRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class editorialServicio {

    @Autowired
    EditorialRepositorio edrep;

    @Transactional
    public void crearEditorial(String nombre, String cuit) throws MiException {

        if (nombre == null) {
            throw new MiException("el Nombre no puede ser nulo"); //
        }
        if (cuit == null) {
            throw new MiException("el CUIT no puede ser nulo"); //
        }
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setCuit(cuit);

        edrep.save(editorial);
    }

    public List<Editorial> listarEditoriales() {

        List<Editorial> editoriales = edrep.findAll();

        return editoriales;
    }

}
