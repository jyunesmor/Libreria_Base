/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.main;

import Logica.servicios.clienteServicio;
import Logica.servicios.libroServicio;
import Logica.servicios.prestamoServicio;
import Logica.DAO.ControlDAO;
import Logica.entidades.Prestamo;
//import logica.servicio.autorServicio;
//import logica.servicio.clienteServicio;
//import logica.servicio.editorialServicio;

//import logica.servicio.prestamoServicio;

/**
 *
 * @author home
 */
public class Libreria_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//    editorialServicio es = new editorialServicio();
//    autorServicio as = new autorServicio();
    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();


    ControlDAO cd = new ControlDAO();
    
//        ls.cargarLibro();
        cs.cargarCliente();

    
    
    
    }
    
}
