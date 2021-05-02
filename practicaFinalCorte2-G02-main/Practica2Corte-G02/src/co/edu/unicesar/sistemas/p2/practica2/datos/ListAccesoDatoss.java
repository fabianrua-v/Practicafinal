/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Libro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jairo
 * Implementar metodos utilizando colecciones de datos, clase List y ArrayList
 */
public class ListAccesoDatoss implements IAccesoDatos {
    private List<Publicacion> listaPublicacion;

    public ListAccesoDatoss() {
        listaPublicacion=new ArrayList<>();
    }
        
    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        if(p==null){
            throw new ExcepcionAccesoDatos("no se puede ingresar una publicacion nula");
        }else{
            listaPublicacion.add(p);
        }
    }
    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos {
      if(listaPublicacion.size()>0){
          return listaPublicacion;
      }else{
          throw new ExcepcionAccesoDatos("lista vacia");
      }
       
    }

    @Override
    public Publicacion buscarPublicacion(String busqueda) throws ExcepcionAccesoDatos {
       if(listaPublicacion.size()==0){
           throw new ExcepcionAccesoDatos("no se encontro la consulta");
       }if(busqueda==null){
           throw new ExcepcionAccesoDatos("caracter no valido");
       }
       
       for(Publicacion publicacion: listaPublicacion){
           if (busqueda.equals(publicacion.getIsbn())){
               return publicacion;
           }
       }
       return null;
    }

    @Override
    public Publicacion eliminarPublicacion(String busqueda) throws ExcepcionAccesoDatos {
       Publicacion eliminado = null;
        System.out.println("codigo buscada: " + busqueda);

        Iterator<Publicacion> it = listaPublicacion.iterator();
        while (it.hasNext()) {
            listaPublicacion = (List<Publicacion>) it.next();
            Publicacion p = it.next();
            if (p.getIsbn().equals(busqueda)) {
                it.remove();
                eliminado = p;
                break;
            }
        }
        if(eliminado == null){
            System.out.println("Estudiante no registrado");
        }else{
            System.out.println("Resgitro eliminado: ");
            System.out.println(eliminado);
        }    
        System.out.println("----------------------------------------------------------\n");
        return null;
    }
}  
