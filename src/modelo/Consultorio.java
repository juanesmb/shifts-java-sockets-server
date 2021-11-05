package modelo;
import ufps.util.colecciones_seed.*;

/**
 *
 * @author juan Moncada
 */
public class Consultorio 
{
    private ColaP <Persona> cola;

    public Consultorio() 
    {
        this.cola = new ColaP();
    }
    
    public Persona normalizarDatos(String mensaje) 
    {       
        String datos [] = mensaje.split(",");
        String nombre = datos[0];
        System.out.println(nombre);
        int cedula = Integer.parseInt(datos[1]);
        System.out.println(cedula);
        int edad = Integer.parseInt(datos[2]);
        System.out.println(edad);
        int numero = Integer.parseInt(datos[3]);
        System.out.println(numero);
        
        return new Persona (nombre,cedula,edad,numero);
    }

    public ColaP<Persona> getCola() {
        return cola;
    }

    public void setCola(ColaP<Persona> cola) {
        this.cola = cola;
    }
    
}