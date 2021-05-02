package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.*;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.List;

public interface IAccesoDatos {
    
    void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos;
    List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos;
    Publicacion buscarPublicacion( String busqueda)throws ExcepcionAccesoDatos;
    Publicacion eliminarPublicacion(String busqueda)throws ExcepcionAccesoDatos;
    
}
