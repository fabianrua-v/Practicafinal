package co.edu.unicesar.sistemas.p2.practica2.vista;

import co.edu.unicesar.sistemas.p2.practica2.dominio.*;
import co.edu.unicesar.sistemas.p2.practica2.datos.*;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.negocio.RegistroPublicacion;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaConsola {

    private String[] titulos = {"1. Insertar Publicacion",
        "2. Leer Publicaciones",
        "3. Buscar Publicacion",
        "4.Eliminar Publicacion",
        "0. Salir del Aplicativo"};
    private int opcion;
    private Scanner lector;
    private RegistroPublicacion registro;

    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.registro = new RegistroPublicacion();

    }

    public void ejecutarMenu() {

        do {
            this.imprimirMenu();
            this.leerOpcion();
            this.evaluarOpcion();

        } while (this.opcion != 0);
    }

    public void imprimirMenu() {
        System.out.println(" MENU DE APLICACION \n\n");
        for (String t : this.titulos) {
            System.out.println(t);
        }
    }

    public void leerOpcion() {
        boolean excepcion = true;
        do {
            try {
                System.out.print("\nSeleccione su opcion: ");
                this.opcion = this.lector.nextInt();
                excepcion = false;

            } catch (java.util.InputMismatchException ime) {
                System.out.println("La opcion debe ser valor entero, registre nuevamente");
                excepcion = true;
                this.lector.nextLine();
            }
        } while (excepcion);

    }

    public void evaluarOpcion() {

        switch (this.opcion) {
            case 1:
                this.vistaInsertar();
                break;
            case 2:
                this.vistaConsultar();
                break;
            case 3:
                this.vistaBuscar();
                break;
            case 4:
                this.vistaEliminar();
                break;
            case 0:
                System.out.println("La aplicacion a finalizado");
                break;
            default:
                System.out.println("Opcion no valida");

        }
    }
   
        
// Declaramos el Iterador e imprimimos los Elementos del ArrayList
        
    
    public void vistaInsertar() { 
      System.out.println(this.titulos[this.opcion - 1]);
     
      
        try {
             Publicacion p= new Libro(300, 2, "123", "iliada","homero", 2000, 100000);
             
            registro.adicionarPublicacion(p);
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("no se pudo agregar");
        }
        
    }

    public void vistaConsultar () {
      System.out.println(this.titulos[this.opcion - 1]);
        try {
            for (Publicacion e : this.registro.consultarPublicaciones()) {
                System.out.println(e);
                
            }
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("no se pudo encontrar");
        }

    }

    public void vistaBuscar() {
     System.out.println(this.titulos[this.opcion - 1]); 
        try {
            this.registro.buscarPublicacion("123");
        } catch (ExcepcionAccesoDatos ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
    }

    public  void vistaEliminar(){
      System.out.println(this.titulos[this.opcion - 1]);
      Scanner sc = new Scanner(System.in);
      String busqueda = sc.next();
      
        try { 
            registro.eliminarPublicacion(busqueda);
        } catch (ExcepcionAccesoDatos ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    public static void addElemento(List<Libro> lista, Libro d) {
        lista.add(d);
    }
}    
