/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.servicios;

import Logica.entidades.Autor;
import java.util.List;
import java.util.Scanner;
import Logica.DAO.ControlDAO;

/**
 *
 * @author Juan
 */
public class autorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();

    public Autor cargarAutor() {
        try {
            Autor a = new Autor();
            System.out.println(" ----  Carga del Autor  ---- ");
            System.out.println("");
            System.out.println(" ¿Cual es el nombre del Autor? ");
            a.setNombre(leer.next());
            System.out.println(" ¿Autor dado de Alta? ");
            a.setAlta(leer.nextBoolean());

            cd.crearAutor(a);
            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAutor() {
        try {
            System.out.println(" ---  Modificacion Datos Autor  --- ".toUpperCase());
            System.out.println("");
            mostrarAutores();
            System.out.println("");
            System.out.println(" ¿ De cual Autor desea modificar algun Dato? con Codigo ID");
            Integer id = leer.nextInt();
            Autor a = cd.obtenerAutor(id);
            System.out.println(a.toString());
            System.out.println("");
            boolean flag = false;
            do {
                System.out.println(" -- Menu Modificacion -- ".toUpperCase());
                System.out.println(" ¿Cual dato desea actualizar? ");
                System.out.println("1. Nombre");
                System.out.println("2. Alta");
                System.out.println("3. Salir");
                Integer op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println(" ¿Ingrese el nuevo Nombre? ");
                        a.setNombre(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Alta o Baja? True or False ");
                        a.setAlta(leer.nextBoolean());
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            cd.modificarAutor(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAutor() {
        System.out.println("");
        mostrarAutores();
        System.out.println("");
        System.out.println(" ¿Cual Autor desea eliminar? por Codigo ID? ");
        Integer id = leer.nextInt();
        cd.eliminarAutor(id);
    }

    public void mostrarAutores() {
        List<Autor> liblist = cd.obtenerAutores();
        for (Autor au : liblist) {
            System.out.println(au.toString());
        }
    }

    public void consultarAutorPorNombre() {
        try {
            System.out.println(" Ingrese el Titulo del Libro que desea consultar");
            String titulo = leer.next();
            List<Autor> alist = cd.obtenerAutorPorNombre(titulo);
            for (Autor au : alist) {
                System.out.println(au.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
