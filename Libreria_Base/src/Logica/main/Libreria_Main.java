
package Logica.main;

import Logica.servicios.clienteServicio;
import Logica.servicios.libroServicio;
import Logica.DAO.ControlDAO;
import Logica.servicios.prestamoServicio;
import Logica.servicios.servicioMain;

public class Libreria_Main {


    public static void main(String[] args) throws Exception {

    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();
    prestamoServicio ps = new prestamoServicio();
    servicioMain sm = new servicioMain();
    
    ControlDAO cd = new ControlDAO();
    
//        ls.cargarLibro();
//        cs.cargarCliente();
//        ls.mostrarlibros();
//        ps.cargarprestamo();
//        ps.mostrarPrestamos();
//        ps.devolverPrestamo();
        sm.menuPrincipal();

    
    }
    
}
