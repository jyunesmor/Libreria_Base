package Logica.servicios;


import java.util.Date;


import java.util.Scanner;
import Logica.DAO.ControlDAO;
import Logica.entidades.Cliente;
import Logica.entidades.Prestamo;
import java.util.List;

public class prestamoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();
    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();


    public void cargarPrestamo() {
        Prestamo p = new Prestamo();
        System.out.println(" ----  Carga Prestamo del Libro  ---- ");
        System.out.println("");
        /*  Carga Libro  */
 /*  -------------------------------------------   */
        System.out.println(" Libros Disponibles para el prestamo ");
        System.out.println("");
        ls.mostrarlibros();
        System.out.println(" ¿Ingrese el Libro que sera prestado? por ID");
        Integer idl = leer.nextInt();
        p.setLibro(cd.obtenerLibro(idl));
        /* Carga Clientes */
 /*  -------------------------------------------   */
        System.out.println(" Clientes Disponibles para el prestamo ");
        System.out.println("");
        cs.mostrarClientes();
        System.out.println(" ¿Ingrese el Cliente que se llevara el Libro? por ID");
        Integer idc = leer.nextInt();
        Cliente c = cd.obtenerCliente(idc);
        p.setCliente(c);

        /*  -------------------------------------------   */
        System.out.println(" ¿Fecha del Prestamo? ");

        System.out.print("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.print("Ingrese el año; ");
        int anio = leer.nextInt();

        Date fp = new Date(anio - 1900, mes - 1, dia);
        p.setfPrestamo(fp);
        
        System.out.println(p.toString());
        cd.crearPrestamoBD(p);
    }
    
    public void devolverPrestamo() {

        System.out.println(" ----  Carga Devolucion Prestamo  ---- ");
        System.out.println("");
        /*  Mostrar Prestamos  */
 /*  -------------------------------------------   */
        System.out.println(" Los Prestamos Activos son : ");
        System.out.println("");
        mostrarPrestamos();
        System.out.println(" ¿Ingrese el Libro que sera prestado? por ID");
        Integer idl = leer.nextInt();
       
        Prestamo p = cd.obtenerPrestamo(idl);
               
        /*  -------------------------------------------   */
        System.out.println(" ¿Fecha del Prestamo? ");

        System.out.print("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.print("Ingrese el año; ");
        int anio = leer.nextInt();

        Date fp = new Date(anio - 1900, mes - 1, dia);
        p.setDevPrestamo(fp);
        
        System.out.println(p.toString());
        cd.modificarPrestamoBD(p);
    }
    
    public void mostrarPrestamos(){
        List<Prestamo> plist = cd.obtenerPrestamos();
        for (Prestamo p : plist) {
            System.out.println(p.toString());
        }
        
        
    }
    
    
}
